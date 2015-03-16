package net.gpedro.faculdade.filinha.modules.rh.view;

import net.gpedro.faculdade.filinha.core.abstracts.AbstractViewList;
import net.gpedro.faculdade.filinha.modules.rh.model.Coordenador;
import net.gpedro.faculdade.filinha.modules.rh.controller.CoordenadorController;

@SuppressWarnings("serial")
public class CoordenadorViewList extends AbstractViewList<Coordenador> {

	public CoordenadorViewList() {
		super(Coordenador.class);

		controller = new CoordenadorController();

		super.build();
	}

}
