package net.gpedro.faculdade.filinha.core.pages;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class PageNotFound extends VerticalLayout implements View {

	public PageNotFound() {
		this.setMargin(true);
		this.addComponent(new Label("Página não encontrada"));
	}

	@Override
	public void enter(ViewChangeEvent event) {
	}

}
