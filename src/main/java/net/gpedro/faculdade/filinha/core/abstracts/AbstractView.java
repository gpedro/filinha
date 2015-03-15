package net.gpedro.faculdade.filinha.core.abstracts;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.CustomComponent;

public abstract class AbstractView extends CustomComponent implements View {

    private static final long serialVersionUID = 1L;

    protected String TITLE = "";

    public abstract void build();

    @Override
    public void enter(ViewChangeEvent event) {
        build();
    }

}
