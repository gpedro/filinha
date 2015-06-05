package net.gpedro.faculdade.filinha.shared.courses.controller;

import java.util.List;

import net.gpedro.faculdade.filinha.core.abstracts.AbstractController;
import net.gpedro.faculdade.filinha.shared.courses.model.Course;

import org.mongodb.morphia.query.Query;

public class CourseController extends AbstractController<Course> {

	public CourseController() {
		super(Course.class);
	}

	/**
	 * Busca todos os cursos
	 * 
	 * @return List<Course> lista dos cursos
	 */
	public List<Course> getCourses() {
		return getCourseByStatus(-1);
	}

	/**
	 * Busca todos os cursos inativos
	 * 
	 * @return List<Course> lista dos cursos
	 */
	public List<Course> getCoursesInativos() {
		return getCourseByStatus(0);
	}

	/**
	 * Busca todos os cursos ativos
	 * 
	 * @return List<Course> lista dos cursos
	 */
	public List<Course> getCoursesAtivos() {
		return getCourseByStatus(1);
	}

	/**
	 * Busca todos os cursos com o status parametro
	 * 
	 * @param status
	 *            Status do curso
	 * @return List<Course> lista dos cursos
	 */
	public List<Course> getCourseByStatus(int status) {
		Query<Course> q = find();
		if (status != -1) {
			q.field("status").equal(status);
		}

		return q.asList();
	}
}
