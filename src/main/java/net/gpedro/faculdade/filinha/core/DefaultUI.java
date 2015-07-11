package net.gpedro.faculdade.filinha.core;

import net.gpedro.faculdade.filinha.core.pages.PageNotFound;

import com.vaadin.annotations.Title;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

@Title("Página não encontrada")
@SuppressWarnings("serial")
public class DefaultUI extends UI {

    @Override
    protected void init(VaadinRequest request) {
        setContent(new PageNotFound());
    }

}
