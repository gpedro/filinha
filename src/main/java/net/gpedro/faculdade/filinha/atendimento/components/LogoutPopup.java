package net.gpedro.faculdade.filinha.atendimento.components;

import net.gpedro.faculdade.filinha.core.components.misc.Head;
import net.gpedro.faculdade.filinha.core.util.Session;

import com.vaadin.server.Page;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.themes.ValoTheme;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

import elemental.events.KeyboardEvent.KeyCode;

@SuppressWarnings("serial")
public class LogoutPopup extends Window {

    public LogoutPopup() {
	setCaption("Deseja sair?");
	
	setModal(true);	
	setDraggable(false);
	setResizable(false);

	Label desc = new Label("Você deseja realmente sair do sistema?");
	desc.addStyleName(ValoTheme.LABEL_H3);
	Label hr = Head.HR.toComponent(null);
	HorizontalLayout botoes = new HorizontalLayout();
	Button sair, cancelar;
	sair = new Button("Sim");
	cancelar = new Button("Não");
	
	sair.addClickListener(new ClickListener() {
	    
	    @Override
	    public void buttonClick(ClickEvent event) {
		Session.logout();
		Page.getCurrent().reload();
	    }
	});
	
	cancelar.addClickListener(new ClickListener() {
	    
	    @Override
	    public void buttonClick(ClickEvent event) {
		LogoutPopup.this.close();
	    }
	});
	
	botoes.setSpacing(true);
	botoes.addComponents(sair, cancelar);
	
	sair.setClickShortcut(KeyCode.ENTER);
	cancelar.setClickShortcut(KeyCode.ESC);
	
	VerticalLayout layout = new VerticalLayout(desc, hr, botoes);
	layout.setMargin(true);
	layout.setSpacing(true);
	
	layout.setComponentAlignment(botoes, Alignment.MIDDLE_CENTER);

	setContent(layout);
    }
    
}
