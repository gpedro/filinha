package net.gpedro.faculdade.filinha.atendimento;

import net.gpedro.faculdade.filinha.atendimento.views.DashboardView;
import net.gpedro.faculdade.filinha.atendimento.views.LoginView;
import net.gpedro.faculdade.filinha.core.util.Session;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

@Theme("mytheme")
public class AtendimentoUI extends UI {

    private static final long serialVersionUID = 1243945553082426942L;

    @Override
    protected void init(VaadinRequest request) {
	if (Session.isLogado()) {
	    setContent(new DashboardView());
	} else {
	    setContent(new LoginView());
	}
    }

}
