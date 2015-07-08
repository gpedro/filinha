package net.gpedro.faculdade.filinha.atendimento;

import net.gpedro.faculdade.filinha.visitante.ClientUI;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinServlet;

@VaadinServletConfiguration(productionMode = false, ui = ClientUI.class)
public class AtendimentoServlet extends VaadinServlet {

	private static final long serialVersionUID = 3735059767375181771L;

}
