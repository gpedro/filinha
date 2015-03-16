package net.gpedro.faculdade.filinha.modules.rh.view;

import net.gpedro.faculdade.filinha.core.abstracts.AbstractViewList;
import net.gpedro.faculdade.filinha.modules.rh.controller.AlunoController;
import net.gpedro.faculdade.filinha.modules.rh.model.Aluno;

@SuppressWarnings("serial")
public class AlunoViewList extends AbstractViewList<Aluno> {

	public AlunoViewList() {
		super(Aluno.class);

		controller = new AlunoController();

		super.build();
	}

}
