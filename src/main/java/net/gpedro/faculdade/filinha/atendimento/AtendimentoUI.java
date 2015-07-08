package net.gpedro.faculdade.filinha.atendimento;

import net.gpedro.faculdade.filinha.shared.login.view.LoginView;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

@Theme("mytheme")
public class AtendimentoUI extends UI {

    private static final long serialVersionUID = 1243945553082426942L;

    @Override
    protected void init(VaadinRequest request) {
	setContent(new LoginView());
    }

}
