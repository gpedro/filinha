package net.gpedro.faculdade.filinha.atendimento.components;

import java.util.ArrayList;

import net.gpedro.faculdade.filinha.core.abstracts.AbstractViewList;
import net.gpedro.faculdade.filinha.core.util.Session;
import net.gpedro.faculdade.filinha.shared.atendimento.constants.SITUACAO_ATENDIMENTO;
import net.gpedro.faculdade.filinha.shared.atendimento.controller.AtendimentoController;
import net.gpedro.faculdade.filinha.shared.atendimento.model.Atendimento;

import org.mongodb.morphia.query.Query;

@SuppressWarnings("serial")
public class AlunosAtendimento extends AbstractViewList<Atendimento> {

    // private boolean isAlunosAgendados = false;
    private boolean isAlunosAtendidos = false;
    private boolean isTodosAgendados = false;

    public AlunosAtendimento() {
	this(null);
    }

    public AlunosAtendimento(SITUACAO_ATENDIMENTO status) {
	super(Atendimento.class);
	setMargin(true);

	controller = new AtendimentoController();
	Query<Atendimento> qb = controller.find();
	if (status != null) {
	    // isAlunosAgendados = status.isAguardandoChamada();
	    isAlunosAtendidos = status.isAtendido();
	    qb.field("situacao").equal(status);
	    qb.field("atendente.cpf").equal(Session.getUsuario().getCpf());
	} else {
	    isTodosAgendados = true;
	}

	query = qb;

	super.build();
	getTabela().setCaption(null);
    }

    @Override
    protected void configuraColunaDefault() throws IllegalAccessException {
	ArrayList<String> visibles = new ArrayList<String>();
	ArrayList<String> headers = new ArrayList<String>();

	visibles.add("senha");
	visibles.add("solicitante.cpf");
	visibles.add("solicitante.nome");

	headers.add("Senha");
	headers.add("CPF");
	headers.add("Aluno");

	if (isAlunosAtendidos) {
	    visibles.add("observacoes");
	    headers.add("Observações");

	    visibles.add("classificacao");
	    headers.add("Classificação");
	}

	if (isTodosAgendados) {
	    visibles.add("situacao");
	    headers.add("Status");
	}

	getTabela().setVisibleColumns(visibles.toArray());
	getTabela().setColumnHeaders(headers.toArray(new String[0]));
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
