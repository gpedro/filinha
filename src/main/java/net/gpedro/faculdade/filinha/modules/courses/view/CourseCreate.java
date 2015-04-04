package net.gpedro.faculdade.filinha.modules.courses.view;

import net.gpedro.faculdade.filinha.core.abstracts.AbstractCreate;
import net.gpedro.faculdade.filinha.modules.courses.controller.CourseController;
import net.gpedro.faculdade.filinha.modules.courses.model.Course;

import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;

@SuppressWarnings("serial")
public class CourseCreate extends AbstractCreate<Course> {

    public CourseCreate() {
        super(Course.class);

        controller = new CourseController();

        super.build();
    }

    @Override
    public void enter(ViewChangeEvent event) {
    }

}
