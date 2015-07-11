package net.gpedro.faculdade.filinha.atendimento.views;

import net.gpedro.faculdade.filinha.core.components.button.Button;
import net.gpedro.faculdade.filinha.core.components.input.InputCpf;
import net.gpedro.faculdade.filinha.core.components.input.InputPassword;
import net.gpedro.faculdade.filinha.core.components.misc.Alert;
import net.gpedro.faculdade.filinha.core.util.Session;
import net.gpedro.faculdade.filinha.shared.rh.constants.STATUS;
import net.gpedro.faculdade.filinha.shared.rh.controller.CoordenadorController;
import net.gpedro.faculdade.filinha.shared.rh.model.Coordenador;

import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.server.Page;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.themes.ValoTheme;

/**
 * Classe responsável pela interface e interação da página de login
 *
 */
public class LoginView extends VerticalLayout {

    private static final long serialVersionUID = 1L;

    /*
     * Eles precisam ser estar no escopo da classe para poder validar os valores
     * no triggerLogin()
     */
    private InputCpf          user;
    private InputPassword     pass;

    private CoordenadorController cc = new CoordenadorController();
    
    public LoginView() {
        build();
    }

    /* Building Front-End */
    public void build() {

        // 100%x100%
        setSizeFull();

        // Setupping variables
        Button login;

        // Initialize variables
        user = new InputCpf("Usuário");
        pass = new InputPassword("Senha");
        login = new Button("Entrar");

        // Adding Settings to Components
        user.setRequired(true);
        pass.setRequired(true);

        // Setupping listeners & actions
        login.setWidth(100, Unit.PERCENTAGE);
        login.setStyleName(ValoTheme.BUTTON_PRIMARY);
        login.addClickListener(triggerLogin());
        login.setClickShortcut(KeyCode.ENTER);

        // Building Interface
        VerticalLayout form = new VerticalLayout();
        form.setSpacing(true);
        form.addComponents(user, pass, login);

        VerticalLayout layout = new VerticalLayout();
        layout.setSizeUndefined();
        layout.addComponent(form);
        layout.setComponentAlignment(form, Alignment.MIDDLE_CENTER);

        addComponent(layout);
        setComponentAlignment(layout, Alignment.MIDDLE_CENTER);
    }

    /* Actions */
    @SuppressWarnings("serial")
    public ClickListener triggerLogin() {
        return new ClickListener() {

            @Override
            public void buttonClick(ClickEvent event) {
                if (user.isValid() && pass.isValid()) {
                    Coordenador coordenador = new CoordenadorController()
                            .authenticate(user.getValue(), pass.getValue());
                    boolean exists = coordenador != null;

                    if (!exists) {
                        pass.setValue("");
                    } else {
                        coordenador.setSituacao(STATUS.DISPONIVEL);
                        cc.save(coordenador);
                        
                        Session.setAttribute("logado", true);
                        Session.setAttribute("usuario", coordenador);
                        
                        Page.getCurrent().reload();
                    }
                } else {
                    Alert.showWarn("Preencha os campos", null);
                    pass.setValue("");
                }
            }
        };
    }
}
