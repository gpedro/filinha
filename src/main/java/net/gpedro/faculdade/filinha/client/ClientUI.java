package net.gpedro.faculdade.filinha.client;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

@Theme("mytheme")
public class ClientUI extends UI {

    private static final long serialVersionUID = 6828240587704957332L;

    @Override
    protected void init(VaadinRequest request) {
        setContent(new AlunoSenhaView());
    }

}
