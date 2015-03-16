package filinha;

import java.util.ArrayList;
import java.util.List;

import net.gpedro.faculdade.filinha.modules.courses.controller.CourseController;
import net.gpedro.faculdade.filinha.modules.courses.model.Course;

import org.junit.Test;

public class TestPopulateMongo {

    @Test
    public void populateCourses() {
        List<Course> batchList = new ArrayList<Course>();
        CourseController ctrl = new CourseController();
        Course c;

        c = new Course();
        c.setNome("Agronomia");
        c.setTurno("Matutino", "Noturno");
        c.setSemestre(5);
        c.setModalidade("Bacharelado");
        batchList.add(c);

        c = new Course();
        c.setNome("Medicina Veterinária");
        c.setTurno("Integral");
        c.setSemestre(5);
        c.setModalidade("Bacharelado");
        batchList.add(c);

        c = new Course();
        c.setNome("Ciência da Computação");
        c.setTurno("Noturno");
        c.setSemestre(4);
        c.setModalidade("Bacharelado");
        batchList.add(c);

        c = new Course();
        c.setNome("Sistemas de Informação");
        c.setTurno("Noturno");
        c.setSemestre(4);
        c.setModalidade("Bacharelado");
        batchList.add(c);

        c = new Course();
        c.setNome("Psicologia");
        c.setTurno("Matutino", "Noturno");
        c.setSemestre(5);
        c.setModalidade("Bacharelado");
        batchList.add(c);

        c = new Course();
        c.setNome("Teologia");
        c.setTurno("Noturno");
        c.setSemestre(4);
        c.setModalidade("Bacharelado");
        batchList.add(c);

        c = new Course();
        c.setNome("Biomedicina");
        c.setTurno("Matutino", "Noturno");
        c.setSemestre(4);
        c.setModalidade("Bacharelado");
        batchList.add(c);

        c = new Course();
        c.setNome("Educação Física");
        c.setTurno("Matutino", "Noturno");
        c.setSemestre(4);
        c.setModalidade("Bacharelado");
        batchList.add(c);

        c = new Course();
        c.setNome("Enfermagem");
        c.setTurno("Matutino", "Noturno");
        c.setSemestre(5);
        c.setModalidade("Bacharelado");
        batchList.add(c);

        c = new Course();
        c.setNome("Farmácia");
        c.setTurno("Noturno");
        c.setSemestre(5);
        c.setModalidade("Bacharelado");
        batchList.add(c);

        c = new Course();
        c.setNome("Fisioterapia");
        c.setTurno("Matutino");
        c.setSemestre(5);
        c.setModalidade("Bacharelado");
        batchList.add(c);

        c = new Course();
        c.setNome("Nutrição");
        c.setTurno("Matutino", "Noturno");
        c.setSemestre(4);
        c.setModalidade("Bacharelado");
        batchList.add(c);

        c = new Course();
        c.setNome("Administração");
        c.setTurno("Noturno");
        c.setSemestre(4);
        c.setModalidade("Bacharelado");
        batchList.add(c);

        c = new Course();
        c.setNome("Direito");
        c.setTurno("Matutino/Noturno");
        c.setSemestre(5);
        c.setModalidade("Bacharelado");
        batchList.add(c);

        c = new Course();
        c.setNome("Estética e Cosmética");
        c.setTurno("Matutino", "Noturno");
        c.setSemestre(3);
        c.setModalidade("Tecnológico");
        batchList.add(c);

        c = new Course();
        c.setNome("Gastronomia");
        c.setTurno("Matutino", "Noturno");
        c.setSemestre(2);
        c.setModalidade("Tecnológico");
        batchList.add(c);

        c = new Course();
        c.setNome("Logística");
        c.setTurno("Noturno");
        c.setSemestre(2);
        c.setModalidade("Tecnológico");
        batchList.add(c);
        
        ctrl.batchSave(batchList.toArray(new Course[] {}));
    }
}
