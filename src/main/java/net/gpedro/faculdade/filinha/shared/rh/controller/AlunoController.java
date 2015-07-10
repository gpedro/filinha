package net.gpedro.faculdade.filinha.shared.rh.controller;

import net.gpedro.faculdade.filinha.core.abstracts.AbstractController;
import net.gpedro.faculdade.filinha.shared.rh.model.Aluno;

import org.mongodb.morphia.query.Query;

public class AlunoController extends AbstractController<Aluno> {

    public AlunoController() {
        super(Aluno.class);
    }

    public Aluno findByCpf(String cpf) {
        Query<Aluno> q = find();
        q.field("cpf").equal(cpf);

        return q.get();
    }
}
