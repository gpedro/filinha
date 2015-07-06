package net.gpedro.faculdade.filinha.core;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinServlet;

@WebServlet(value = { "/", "/VAADIN/*" }, asyncSupported = true)
@VaadinServletConfiguration(productionMode = false, ui = DefaultUI.class)
public class DefaultServlet extends VaadinServlet {
	private static final long serialVersionUID = -7206564441446994799L;
}
