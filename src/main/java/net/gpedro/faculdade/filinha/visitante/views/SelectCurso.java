package net.gpedro.faculdade.filinha.visitante.views;

import net.gpedro.faculdade.filinha.shared.components.ComboCourses;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class SelectCurso extends HorizontalLayout implements View {

	public SelectCurso() {
	
		VerticalLayout layout = new VerticalLayout();
		
		ComboCourses courses = new ComboCourses("Selecione o curso: ");
		courses.setWidth(100, Unit.PERCENTAGE);
		
	}
	
	@Override
	public void enter(ViewChangeEvent event) {
		
	}

}
