package net.gpedro.faculdade.filinha.modules.courses.view;

import net.gpedro.faculdade.filinha.core.abstracts.AbstractView;
import net.gpedro.faculdade.filinha.core.annotations.VadinhoMenu;
import net.gpedro.faculdade.filinha.modules.courses.controller.CourseController;
import net.gpedro.faculdade.filinha.modules.courses.model.Course;

@SuppressWarnings("serial")
@VadinhoMenu(label = "Ver Cursos", route = "cursos-view")
public class CourseView extends AbstractView<Course> {

	public CourseView() {
		super(Course.class);

		controller = new CourseController();

		super.build();
	}

}
