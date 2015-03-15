package net.gpedro.faculdade.filinha.modules.courses.view;

import net.gpedro.faculdade.filinha.core.abstracts.AbstractViewList;
import net.gpedro.faculdade.filinha.modules.courses.controller.CourseController;
import net.gpedro.faculdade.filinha.modules.courses.model.Course;

public class CourseList extends AbstractViewList<Course> {

    private static final long serialVersionUID = 1L;

    public CourseList() {
        super(Course.class);
        controller = new CourseController();
    }

}
