package net.gpedro.faculdade.filinha.atendimento;

import javax.servlet.annotation.WebServlet;

import net.gpedro.faculdade.filinha.visitante.ClientUI;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinServlet;

@WebServlet(value = { "/atendimento/*" }, asyncSupported = true)
@VaadinServletConfiguration(productionMode = false, ui = ClientUI.class)
public class AtendimentoServlet extends VaadinServlet {

	private static final long serialVersionUID = 3735059767375181771L;

}
