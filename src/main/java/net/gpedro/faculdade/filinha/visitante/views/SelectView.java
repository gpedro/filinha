package net.gpedro.faculdade.filinha.visitante.views;

import net.gpedro.faculdade.filinha.core.components.button.Button;
import net.gpedro.faculdade.filinha.visitante.ClientUI;
import net.gpedro.faculdade.filinha.visitante.aluno.AlunoView;
import net.gpedro.faculdade.filinha.visitante.visitante.VisitanteView;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class SelectView extends HorizontalLayout implements View {

	public SelectView() {
		// creating layout
		VerticalLayout layout = new VerticalLayout();

		// configuring size
		setWidth(100, Unit.PERCENTAGE);
		layout.setSizeFull();

		Button souAluno = new Button("Sou Aluno");
		souAluno.setSizeFull();
		souAluno.addClickListener(goToView(new AlunoView()));

		Button souVisitante = new Button("Sou Visitante");
		souVisitante.setSizeFull();
		souVisitante.addClickListener(goToView(new VisitanteView()));

		Label select = new Label("SELECIONE");
		select.setSizeUndefined();

		layout.addComponents(select, souAluno, souVisitante);

		layout.setComponentAlignment(select, Alignment.MIDDLE_CENTER);
		layout.setComponentAlignment(souAluno, Alignment.MIDDLE_CENTER);
		layout.setComponentAlignment(souVisitante, Alignment.MIDDLE_CENTER);

		layout.setSpacing(true);
		layout.setMargin(true);

		addComponent(layout);
	}

	private ClickListener goToView(final Component view) {
		return new ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				ClientUI.getCurrent().setContent(view);
			}
		};
	}

	@Override
	public void enter(ViewChangeEvent event) {

	}

}
