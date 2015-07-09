package net.gpedro.faculdade.filinha.core;

import net.gpedro.faculdade.filinha.core.pages.PageNotFound;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

@SuppressWarnings("serial")
public class DefaultUI extends UI {

    @Override
    protected void init(VaadinRequest request) {
	setContent(new PageNotFound());
    }

}
