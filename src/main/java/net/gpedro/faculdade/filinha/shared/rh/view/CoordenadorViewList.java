package net.gpedro.faculdade.filinha.shared.rh.view;

import net.gpedro.faculdade.filinha.core.abstracts.AbstractViewList;
import net.gpedro.faculdade.filinha.core.annotations.VadinhoMenu;
import net.gpedro.faculdade.filinha.shared.rh.controller.CoordenadorController;
import net.gpedro.faculdade.filinha.shared.rh.model.Coordenador;

@SuppressWarnings("serial")
@VadinhoMenu(label = "Coordenadores", route = "coordenadores-list")
public class CoordenadorViewList extends AbstractViewList<Coordenador> {

    public CoordenadorViewList() {
        super(Coordenador.class);

        controller = new CoordenadorController();

        super.build();
    }

}
