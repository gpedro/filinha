package net.gpedro.faculdade.filinha.coordenador;

import com.vaadin.annotations.Theme;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

@Theme("mytheme")
public class RestrictUI extends UI {

	private static final long serialVersionUID = -6694003490235764129L;

	@Override
	protected void init(VaadinRequest request) {
		setContent(new ApplicationLayout());
	}

}
