package net.gpedro.faculdade.filinha.client.views;

import net.gpedro.faculdade.filinha.core.components.button.Button;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class SelectView extends HorizontalLayout implements View {

    public SelectView() {
        // creating layout
        VerticalLayout layout = new VerticalLayout();

        // configuring size
        setSizeFull();
        layout.setWidthUndefined();

        Button souAluno = new Button("Sou Aluno");
        Button souVisitante = new Button("Sou Visitante");

        Label select = new Label("SELECIONE");

        layout.addComponents(select, souAluno, souVisitante);

        layout.setComponentAlignment(select, Alignment.MIDDLE_CENTER);
        layout.setComponentAlignment(souAluno, Alignment.MIDDLE_CENTER);
        layout.setComponentAlignment(souVisitante, Alignment.MIDDLE_CENTER);

        layout.setSpacing(true);
        layout.setMargin(true);
        
        addComponent(layout);
    }

    @Override
    public void enter(ViewChangeEvent event) {

    }

}
