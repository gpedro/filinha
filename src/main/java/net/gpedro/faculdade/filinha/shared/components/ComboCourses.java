package net.gpedro.faculdade.filinha.shared.components;

import java.util.List;

import net.gpedro.faculdade.filinha.shared.courses.controller.CourseController;
import net.gpedro.faculdade.filinha.shared.courses.model.Course;

import org.bson.types.ObjectId;

import com.vaadin.data.util.BeanContainer;
import com.vaadin.ui.ComboBox;

@SuppressWarnings("serial")
public class ComboCourses extends ComboBox {

    public ComboCourses(String caption) {
	super(caption);

	CourseController controller = new CourseController();
	List<Course> courses = controller.getCoursesAtivos();

	setItemCaptionPropertyId("nome");
	BeanContainer<ObjectId, Course> container = new BeanContainer<ObjectId, Course>(
		Course.class);
	container.setBeanIdProperty("id");
	container.addAll(courses);

	setContainerDataSource(container);
    }

}