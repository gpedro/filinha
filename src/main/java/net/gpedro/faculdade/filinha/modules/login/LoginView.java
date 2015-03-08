package net.gpedro.faculdade.filinha.modules.login;

import net.gpedro.faculdade.filinha.core.components.button.Button;
import net.gpedro.faculdade.filinha.core.components.input.InputPassword;
import net.gpedro.faculdade.filinha.core.components.input.InputText;
import net.gpedro.faculdade.filinha.core.components.misc.Alert;

import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.VerticalLayout;

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
    private InputText user;
    private InputPassword pass;

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
        user = new InputText("Usuário");
        pass = new InputPassword("Senha");
        login = new Button("Entrar");

        // Adding Settings to Components
        user.setRequired(true);
        pass.setRequired(true);

        // Setupping listeners & actions
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
                    Alert.showSuccess("Validação passou!", null);
                } else {
                    Alert.showWarn("Usuário ou senha incorretos!", null);
                    pass.setValue("");
                }
            }
        };
    }
}
