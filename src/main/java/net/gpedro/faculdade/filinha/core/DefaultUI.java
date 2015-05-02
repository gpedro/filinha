package net.gpedro.faculdade.filinha.core;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class DefaultUI extends UI {

    @Override
    protected void init(VaadinRequest request) {
        setContent(new VerticalLayout());
    }

}
