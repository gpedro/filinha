package net.gpedro.faculdade.filinha.coordenador;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinServlet;

@WebServlet(value = { "/restrict/*" }, asyncSupported = true)
@VaadinServletConfiguration(productionMode = false, ui = RestrictUI.class)
public class RestrictServlet extends VaadinServlet {
	private static final long serialVersionUID = -3628430886620936811L;
}
