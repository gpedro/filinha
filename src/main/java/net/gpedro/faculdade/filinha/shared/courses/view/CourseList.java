package net.gpedro.faculdade.filinha.shared.courses.view;

import net.gpedro.faculdade.filinha.core.abstracts.AbstractViewList;
import net.gpedro.faculdade.filinha.core.annotations.VadinhoMenu;
import net.gpedro.faculdade.filinha.shared.courses.controller.CourseController;
import net.gpedro.faculdade.filinha.shared.courses.model.Course;

@VadinhoMenu(label = "Cursos", route = "cursos-list")
public class CourseList extends AbstractViewList<Course> {

    private static final long serialVersionUID = 1L;

    public CourseList() {
	super(Course.class);

	controller = new CourseController();

	super.build();
    }

}
