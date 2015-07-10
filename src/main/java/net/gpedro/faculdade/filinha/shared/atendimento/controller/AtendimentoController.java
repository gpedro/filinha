package net.gpedro.faculdade.filinha.shared.atendimento.controller;

import java.util.List;

import net.gpedro.faculdade.filinha.core.abstracts.AbstractController;
import net.gpedro.faculdade.filinha.core.util.Session;
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

    public Integer getIncrement() {
        Query<Atendimento> q = findOne();
        q.order("-id");

        Atendimento a = q.get();

        return (a != null) ? Integer.valueOf(a.getSenha()) : 1;
    }

    public String getProximaSenha() {
        return getSenhaAtual(SITUACAO_ATENDIMENTO.AGUARDANDO_CHAMADA);
    }

    public Integer getCountAgendados() {
        return countSenha(SITUACAO_ATENDIMENTO.AGUARDANDO_CHAMADA);
    }

    public String getSenhaAtual() {
        return getSenhaAtual(SITUACAO_ATENDIMENTO.EM_ATENDIMENTO);
    }

    public Atendimento getEntitySenhaAtual(SITUACAO_ATENDIMENTO status) {
        Query<Atendimento> q = findOne();
        q.field("situacao").equal(status);
        q.field("atendente.cpf").equal(Session.getUsuario().getCpf());
        q.order("id");

        return q.get();
    }

    public List<Atendimento> getAtendimentos(SITUACAO_ATENDIMENTO status) {
        Query<Atendimento> q = find();
        q.field("situacao").equal(status);
        q.field("atendente.cpf").equal(Session.getUsuario().getCpf());
        q.order("id");

        return q.asList();
    }

    private String getSenhaAtual(SITUACAO_ATENDIMENTO status) {
        Atendimento a = getEntitySenhaAtual(status);

        return (a != null) ? a.getSenha() : null;
    }

    private Integer countSenha(SITUACAO_ATENDIMENTO status) {
        Query<Atendimento> q = find();
        q.field("situacao").equal(status);
        q.field("atendente.cpf").equal(Session.getUsuario().getCpf());

        return Long.valueOf(q.countAll()).intValue();
    }
}
