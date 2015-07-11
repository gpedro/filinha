package net.gpedro.faculdade.filinha.erp;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

@Theme("mytheme")
@Title("Simulação de ERP")
public class ErpUI extends UI {

    private static final long serialVersionUID = -6694003490235764129L;

    @Override
    protected void init(VaadinRequest request) {
        setContent(new ApplicationLayout());
    }

}
