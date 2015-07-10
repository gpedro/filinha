package net.gpedro.faculdade.filinha.core.pages;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class Unauthorized extends VerticalLayout implements View {

    public Unauthorized() {
        this.setMargin(true);
        this.addComponent(new Label("Acesso não autorizado."));
    }

    @Override
    public void enter(ViewChangeEvent event) {
    }
}
