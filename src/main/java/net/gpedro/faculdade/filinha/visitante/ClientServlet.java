package net.gpedro.faculdade.filinha.visitante;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinServlet;

@WebServlet(value = { "/client/*" }, asyncSupported = true)
@VaadinServletConfiguration(productionMode = false, ui = ClientUI.class)
public class ClientServlet extends VaadinServlet {

	private static final long serialVersionUID = 6980789745691698982L;

}
