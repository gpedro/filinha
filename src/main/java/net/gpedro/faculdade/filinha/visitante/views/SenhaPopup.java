package net.gpedro.faculdade.filinha.visitante.views;

import net.gpedro.faculdade.filinha.core.components.button.Button;
import net.gpedro.faculdade.filinha.core.components.misc.Head;
import net.gpedro.faculdade.filinha.visitante.ClientUI;

import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

import elemental.events.KeyboardEvent.KeyCode;

@SuppressWarnings("serial")
public class SenhaPopup extends Window {

    public SenhaPopup(String senha) {

	setCaption("Senha Gerada");
	setModal(true);
	setResizable(false);
	setClosable(true);
	setDraggable(false);

	setCloseShortcut(KeyCode.ESC);
	setCloseShortcut(KeyCode.ENTER);
	addCloseListener(new CloseListener() {

	    @Override
	    public void windowClose(CloseEvent e) {
		ClientUI.getCurrent().setContent(new SelectCourse());
	    }
	});

	VerticalLayout layout = new VerticalLayout();
	layout.setMargin(true);
	layout.setSpacing(true);

	Label titulo = Head.H3.toComponent("Senha gerada com sucesso!");
	Label pass = new Label(
		"<div style=\"font-size:2em;text-align:center;margin-bottom:30px;\"><strong>"
			+ senha + "</strong></div>", ContentMode.HTML);
	pass.addStyleName("huehue");

	Button fechar = new Button("Fechar");
	fechar.setSizeFull();
	fechar.addClickListener(new ClickListener() {

	    @Override
	    public void buttonClick(ClickEvent event) {
		SenhaPopup.this.close();
	    }
	});

	layout.addComponents(titulo, pass, fechar);
	layout.setComponentAlignment(titulo, Alignment.MIDDLE_CENTER);
	layout.setComponentAlignment(pass, Alignment.MIDDLE_CENTER);

	setContent(layout);

    }
}
