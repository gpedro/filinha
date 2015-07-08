package net.gpedro.faculdade.filinha.atendimento.views;

import net.gpedro.faculdade.filinha.core.components.button.Button;
import net.gpedro.faculdade.filinha.core.util.Session;
import net.gpedro.faculdade.filinha.shared.rh.model.Coordenador;

import com.vaadin.server.ThemeResource;
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
	
	HorizontalLayout c1 = new HorizontalLayout();
	
	
	ThemeResource img = new ThemeResource("img/noImage.jpg");
	Image fotinha = new Image(c.getNome(), img);
	fotinha.setHeight(200, Unit.PIXELS);
	fotinha.setWidth(200, Unit.PIXELS);
	

	VerticalLayout l1 = new VerticalLayout();
	
	Label nome = new Label(c.getNome());
	Label cursos = new Label(c.getCursosString());
	l1.addComponents(nome, cursos);

	c1.addComponents(fotinha, l1);
	
	// ---------

	HorizontalLayout c2 = new HorizontalLayout();
	
	// ---------
	
	GridLayout header = new GridLayout(2, 1);
	header.addComponents(c1, c2);
	
	Button sair = new Button("Sair");
	sair.setSizeFull();
	sair.addClickListener(new ClickListener() {
	    
	    @Override
	    public void buttonClick(ClickEvent event) {
		Session.logout();
	    }
	});
	
	addComponents(header, sair);
    }
    
}
