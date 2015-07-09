package net.gpedro.faculdade.filinha.atendimento.components;

import net.gpedro.faculdade.filinha.core.abstracts.AbstractViewList;
import net.gpedro.faculdade.filinha.shared.atendimento.constants.SITUACAO_ATENDIMENTO;
import net.gpedro.faculdade.filinha.shared.atendimento.controller.AtendimentoController;
import net.gpedro.faculdade.filinha.shared.atendimento.model.Atendimento;

@SuppressWarnings("serial")
public class AlunosAtendimento extends AbstractViewList<Atendimento> {

    public AlunosAtendimento() {
	this(null);
    }

    public AlunosAtendimento(SITUACAO_ATENDIMENTO status) {
	super(Atendimento.class);
	setMargin(true);

	controller = new AtendimentoController();

	query = controller.find();

	if (status != null) {
	    query.field("situacao").equals(status);
	}

	super.build();
	getTabela().setCaption(null);
    }

    @Override
    protected void configuraColunaDefault() throws IllegalAccessException {
	getTabela().setVisibleColumns("senha", "solicitante.cpf",
		"solicitante.nome");
	getTabela().setColumnHeaders("Senha", "CPF", "Aluno");
    }

    @Override
    protected void configuraColunaGerada() {
	getContainer().addNestedContainerProperty("solicitante.cpf");
	getContainer().addNestedContainerProperty("solicitante.nome");
    }

    public void reload() {
	super.reload();
    }

}
