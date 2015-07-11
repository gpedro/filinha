package net.gpedro.faculdade.filinha.visitante;

import net.gpedro.faculdade.filinha.visitante.views.SelectCourse;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.UI;

@Theme("mytheme")
@Title("Solicitação de Atendimento")
public class ClientUI extends UI {

    private static final long serialVersionUID = 6828240587704957332L;

    @Override
    protected void init(VaadinRequest request) {
        setContent(new SelectCourse());
    }

}
