package net.gpedro.faculdade.filinha.core.abstracts;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

public abstract class AbstractUI extends UI {

    private static final long serialVersionUID = 1L;

    public abstract void build();

    protected void init(VaadinRequest request) {
        build();
    }
}
