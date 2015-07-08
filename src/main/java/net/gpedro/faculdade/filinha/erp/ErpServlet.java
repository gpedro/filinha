package net.gpedro.faculdade.filinha.erp;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinServlet;

@WebServlet(value = { "/erp/*" }, asyncSupported = true)
@VaadinServletConfiguration(productionMode = false, ui = ErpUI.class)
public class ErpServlet extends VaadinServlet {
	private static final long serialVersionUID = -3628430886620936811L;
}
