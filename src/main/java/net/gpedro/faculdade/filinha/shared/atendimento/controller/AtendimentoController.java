package net.gpedro.faculdade.filinha.shared.atendimento.controller;

import java.util.List;

import net.gpedro.faculdade.filinha.core.abstracts.AbstractController;
import net.gpedro.faculdade.filinha.shared.atendimento.constants.SITUACAO_ATENDIMENTO;
import net.gpedro.faculdade.filinha.shared.atendimento.model.Atendimento;

import org.mongodb.morphia.query.Query;

public class AtendimentoController extends AbstractController<Atendimento> {

    public AtendimentoController() {
	super(Atendimento.class);
    }

    public List<Atendimento> getBySituacao(SITUACAO_ATENDIMENTO situacao) {
	Query<Atendimento> q = find();
	q.field("situacao").equals(situacao);
	
	return q.asList();
    }
}
