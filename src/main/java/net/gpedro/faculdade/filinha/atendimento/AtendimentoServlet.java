package net.gpedro.faculdade.filinha.atendimento;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinServlet;

@WebServlet(value = { "/atendimento/*" }, asyncSupported = true)
@VaadinServletConfiguration(productionMode = false, ui = AtendimentoUI.class)
public class AtendimentoServlet extends VaadinServlet {

	private static final long serialVersionUID = 3735059767375181771L;

}
