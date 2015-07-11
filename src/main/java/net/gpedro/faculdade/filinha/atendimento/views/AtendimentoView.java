package net.gpedro.faculdade.filinha.atendimento.views;

import net.gpedro.faculdade.filinha.atendimento.AtendimentoUI;
import net.gpedro.faculdade.filinha.atendimento.components.AvaliacaoPopup;
import net.gpedro.faculdade.filinha.atendimento.components.LogoutPopup;
import net.gpedro.faculdade.filinha.core.components.button.Button;
import net.gpedro.faculdade.filinha.core.components.misc.Alert;
import net.gpedro.faculdade.filinha.core.util.Session;
import net.gpedro.faculdade.filinha.shared.atendimento.constants.SITUACAO_ATENDIMENTO;
import net.gpedro.faculdade.filinha.shared.atendimento.controller.AtendimentoController;
import net.gpedro.faculdade.filinha.shared.atendimento.model.Atendimento;
import net.gpedro.faculdade.filinha.shared.atendimento.views.EditarAtendimento;
import net.gpedro.faculdade.filinha.shared.rh.model.Coordenador;

import org.vaadin.teemu.VaadinIcons;

import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window.CloseEvent;
import com.vaadin.ui.Window.CloseListener;
import com.vaadin.ui.themes.ValoTheme;

@SuppressWarnings("serial")
public class AtendimentoView extends VerticalLayout {

    private Atendimento           at;
    private VerticalLayout        perfilCol3;
    private EditarAtendimento     ea;
    private AtendimentoController ac;

    public AtendimentoView(Atendimento at) {
        if (at == null) {
            AtendimentoUI.getCurrent().setContent(new DashboardView());
            return;
        } else {
            at.setSituacao(SITUACAO_ATENDIMENTO.EM_ATENDIMENTO);
            new AtendimentoController().save(at);
        }

        this.at = at;

        setMargin(true);
        setSpacing(true);

        Coordenador c = (Coordenador) Session.getAttribute("usuario");

        // ---------

        ac = new AtendimentoController();

        // ---------

        VerticalLayout perfilCol1 = new VerticalLayout();
        perfilCol1.setSpacing(true);
        perfilCol1.setSizeUndefined();

        ThemeResource img = new ThemeResource("img/noImage.png");
        Image fotinha = new Image();
        fotinha.setSource(img);
        fotinha.setHeight(150, Unit.PIXELS);
        fotinha.setWidth(150, Unit.PIXELS);

        Label status = c.getSituacao().getComponent();
        status.setSizeUndefined();
        perfilCol1.addComponents(fotinha, status);
        perfilCol1.setComponentAlignment(status, Alignment.MIDDLE_CENTER);

        // ---------

        VerticalLayout perfilCol2 = new VerticalLayout();
        perfilCol2.setSpacing(true);
        perfilCol2.setSizeUndefined();

        Label nome = new Label(c.getNome());
        Label cursos = new Label(c.getCursosString());

        perfilCol2.addComponents(nome, cursos);

        // ---------

        perfilCol3 = new VerticalLayout();
        perfilCol3.setSpacing(true);
        perfilCol3.setWidth(100, Unit.PERCENTAGE);

        geraColuna3();

        // ---------

        HorizontalLayout perfil = new HorizontalLayout();
        perfil.setSpacing(true);
        perfil.addComponents(perfilCol1, perfilCol2);
        perfil.setComponentAlignment(perfilCol2, Alignment.MIDDLE_LEFT);

        // ---------

        GridLayout header = new GridLayout(5, 1);
        header.setSpacing(true);
        header.setWidth(100, Unit.PERCENTAGE);
        header.setColumnExpandRatio(0, 2);
        header.setColumnExpandRatio(1, 3);
        header.addComponents(perfil, perfilCol3);

        // ---------

        addComponents(header, geraFormulario());
    }

    private VerticalLayout geraFormulario() {
        ea = new EditarAtendimento(at);
        VerticalLayout form = new VerticalLayout();
        form.setSpacing(true);
        form.addComponent(ea);

        Button btnFinaliza = new Button("Finalizar Atendimento");
        btnFinaliza.addClickListener(finalizar());
        form.addComponent(btnFinaliza);
        form.setComponentAlignment(btnFinaliza, Alignment.MIDDLE_CENTER);

        return form;
    }

    private AvaliacaoPopup avaliacao;

    private ClickListener finalizar() {
        return new ClickListener() {

            @Override
            public void buttonClick(ClickEvent event) {
                if (avaliacao == null) {
                    avaliacao = new AvaliacaoPopup();
                    avaliacao.addCloseListener(new CloseListener() {
                        
                        @Override
                        public void windowClose(CloseEvent e) {
                            if (ea != null) {
                                Atendimento a = ea.getBean()
                                        .getItemDataSource().getBean();
                                a.setAvaliacao(avaliacao.getAvaliacao());
                                a.setSituacao(SITUACAO_ATENDIMENTO.ATENDIDO);

                                ac.save(a);
                                
                                AtendimentoUI.getCurrent().setContent(new DashboardView());
                            }
                        }
                    });
                }

                if (ea != null && !ea.isValid()) {
                    Alert.showError("Atenção", "Preencha os campos obrigatórios.");
                }

                if (ea.isValid()) {
                    if (!avaliacao.isAttached()) {
                        AtendimentoUI.getCurrent().addWindow(avaliacao);
                    }
                }

            }
        };
    }

    private void geraColuna3() {

        Button sair = new Button("Sair");
        sair.addClickListener(new ClickListener() {

            @Override
            public void buttonClick(ClickEvent event) {
                LogoutPopup sairPopup = new LogoutPopup();
                if (!sairPopup.isAttached()) {
                    UI.getCurrent().addWindow(sairPopup);
                }
            }
        });

        perfilCol3.addComponent(sair);
        perfilCol3.setComponentAlignment(sair, Alignment.MIDDLE_RIGHT);

        // ---------

        Panel senhaPanel = new Panel();
        senhaPanel.setCaption("Senha");
        Label senhaAtual = new Label(at.getSenha());
        senhaAtual.setSizeUndefined();
        senhaAtual.setStyleName(ValoTheme.LABEL_H2);
        VerticalLayout senhaLayout = new VerticalLayout(senhaAtual);
        senhaLayout.setComponentAlignment(senhaAtual, Alignment.MIDDLE_CENTER);
        senhaPanel.setContent(senhaLayout);
        senhaPanel.setSizeFull();

        Button btnInicio, btnRepetir, btnChamar;

        btnInicio = new Button("Inicio");
        btnInicio.setSizeFull();
        btnInicio.setIcon(VaadinIcons.HOME);
        btnInicio.addClickListener(inicio());

        btnRepetir = new Button("Repetir");
        btnRepetir.setSizeFull();
        btnRepetir.setIcon(VaadinIcons.REFRESH);
        btnRepetir.addClickListener(repetir());

        btnChamar = new Button("Próximo");
        btnChamar.setSizeFull();
        btnChamar.setIcon(VaadinIcons.ANGLE_DOUBLE_RIGHT);
        btnChamar.addClickListener(chamar());

        HorizontalLayout group = new HorizontalLayout();
        group.setSpacing(true);
        group.setWidth(100, Unit.PERCENTAGE);
        group.addComponents(btnInicio, btnRepetir, btnChamar);

        VerticalLayout perfilLayout = new VerticalLayout(senhaPanel, group);
        perfilLayout.setSpacing(true);
        perfilLayout.setWidth(100, Unit.PERCENTAGE);

        perfilCol3.addComponents(perfilLayout);
    }

    private ClickListener repetir() {
        return new ClickListener() {

            @Override
            public void buttonClick(ClickEvent event) {
                // integra com o display
            }
        };
    }

    private ClickListener inicio() {
        return new ClickListener() {

            @Override
            public void buttonClick(ClickEvent event) {
                AtendimentoUI.getCurrent().setContent(new DashboardView());
            }
        };
    }

    private ClickListener chamar() {
        return new ClickListener() {

            @Override
            public void buttonClick(ClickEvent event) {
            }
        };
    }

}
