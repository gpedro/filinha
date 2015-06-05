package net.gpedro.faculdade.filinha.shared.rh.view;

import net.gpedro.faculdade.filinha.core.abstracts.AbstractViewList;
import net.gpedro.faculdade.filinha.core.annotations.VadinhoMenu;
import net.gpedro.faculdade.filinha.shared.rh.controller.AlunoController;
import net.gpedro.faculdade.filinha.shared.rh.model.Aluno;

@SuppressWarnings("serial")
@VadinhoMenu(label = "Alunos", route = "alunos-list")
public class AlunoViewList extends AbstractViewList<Aluno> {

	public AlunoViewList() {
		super(Aluno.class);

		controller = new AlunoController();

		super.build();
	}

}
