package net.gpedro.faculdade.filinha.atendimento.views;

import net.gpedro.faculdade.filinha.atendimento.components.AtendimentoTab;
import net.gpedro.faculdade.filinha.core.components.button.Button;
import net.gpedro.faculdade.filinha.core.util.Session;
import net.gpedro.faculdade.filinha.shared.rh.model.Coordenador;

import com.vaadin.server.ThemeResource;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Image;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class DashboardView extends VerticalLayout {

    public DashboardView() {
	setMargin(true);
	setSpacing(true);

	Coordenador c = (Coordenador) Session.getAttribute("usuario");

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

	VerticalLayout perfilCol3 = new VerticalLayout();

	Button sair = new Button("Sair");
	sair.addClickListener(new ClickListener() {

	    @Override
	    public void buttonClick(ClickEvent event) {
		Session.logout();
	    }
	});

	perfilCol3.addComponent(sair);
	perfilCol3.setWidth(100, Unit.PERCENTAGE);
	perfilCol3.setComponentAlignment(sair, Alignment.MIDDLE_RIGHT);

	// ---------

	HorizontalLayout perfil = new HorizontalLayout();
	perfil.setSpacing(true);
	perfil.addComponents(perfilCol1, perfilCol2);
	perfil.setComponentAlignment(perfilCol2, Alignment.MIDDLE_LEFT);

	// ---------

	GridLayout header = new GridLayout(4, 1);
	header.setSpacing(true);
	header.setWidth(100, Unit.PERCENTAGE);
	header.setColumnExpandRatio(0, 3);
	header.setColumnExpandRatio(1, 1);
	header.addComponents(perfil, perfilCol3);

	// ---------

	addComponents(header, new AtendimentoTab());
    }

}
