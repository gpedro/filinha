package filinha;

import java.util.ArrayList;
import java.util.List;

import net.gpedro.faculdade.filinha.shared.courses.contants.MODALIDADE;
import net.gpedro.faculdade.filinha.shared.courses.controller.CourseController;
import net.gpedro.faculdade.filinha.shared.courses.model.Course;
import net.gpedro.faculdade.filinha.shared.rh.controller.AlunoController;
import net.gpedro.faculdade.filinha.shared.rh.controller.CoordenadorController;
import net.gpedro.faculdade.filinha.shared.rh.model.Aluno;
import net.gpedro.faculdade.filinha.shared.rh.model.Coordenador;

import org.junit.Test;

/**
 * Populate Courses, Alunos & Coordenador using Fake Data generated using
 * http://www.json-generator.com/
 * 
 * @author gpedro
 *
 */
public class TestPopulateMongo {

    @Test
    public void populateAll() {
        populateCourses();
        populateAlunos();
        populateCoordenador();
    }

    public void populateCourses() {
        List<Course> cl = new ArrayList<Course>();
        CourseController ctrl = new CourseController();
        Course c;

        c = new Course();
        c.setNome("Agronomia");
        c.setSemestre(5);
        c.setModalidade(MODALIDADE.GRADUACAO);
        c.setAtivo(true);
        cl.add(c);

        c = new Course();
        c.setNome("Medicina Veterinária");
        c.setSemestre(5);
        c.setModalidade(MODALIDADE.GRADUACAO);
        c.setAtivo(true);
        cl.add(c);

        c = new Course();
        c.setNome("Ciência da Computação");
        c.setSemestre(4);
        c.setModalidade(MODALIDADE.GRADUACAO);
        c.setAtivo(true);
        cl.add(c);

        c = new Course();
        c.setNome("Sistemas de Informação");
        c.setSemestre(4);
        c.setModalidade(MODALIDADE.GRADUACAO);
        c.setAtivo(true);
        cl.add(c);

        c = new Course();
        c.setNome("Psicologia");
        c.setSemestre(5);
        c.setModalidade(MODALIDADE.GRADUACAO);
        c.setAtivo(true);
        cl.add(c);

        c = new Course();
        c.setNome("Teologia");
        c.setSemestre(4);
        c.setModalidade(MODALIDADE.GRADUACAO);
        c.setAtivo(true);
        cl.add(c);

        c = new Course();
        c.setNome("Biomedicina");
        c.setSemestre(4);
        c.setModalidade(MODALIDADE.GRADUACAO);
        c.setAtivo(true);
        cl.add(c);

        c = new Course();
        c.setNome("Educação Física");
        c.setSemestre(4);
        c.setModalidade(MODALIDADE.GRADUACAO);
        c.setAtivo(true);
        cl.add(c);

        c = new Course();
        c.setNome("Enfermagem");
        c.setSemestre(5);
        c.setModalidade(MODALIDADE.GRADUACAO);
        c.setAtivo(true);
        cl.add(c);

        c = new Course();
        c.setNome("Farmácia");
        c.setSemestre(5);
        c.setModalidade(MODALIDADE.GRADUACAO);
        c.setAtivo(true);
        cl.add(c);

        c = new Course();
        c.setNome("Fisioterapia");
        c.setSemestre(5);
        c.setModalidade(MODALIDADE.GRADUACAO);
        c.setAtivo(true);
        cl.add(c);

        c = new Course();
        c.setNome("Nutrição");
        c.setSemestre(4);
        c.setModalidade(MODALIDADE.GRADUACAO);
        c.setAtivo(true);
        cl.add(c);

        c = new Course();
        c.setNome("Administração");
        c.setSemestre(4);
        c.setModalidade(MODALIDADE.GRADUACAO);
        c.setAtivo(true);
        cl.add(c);

        c = new Course();
        c.setNome("Direito");
        c.setSemestre(5);
        c.setModalidade(MODALIDADE.GRADUACAO);
        c.setAtivo(true);
        cl.add(c);

        c = new Course();
        c.setNome("Estética e Cosmética");
        c.setSemestre(3);
        c.setModalidade(MODALIDADE.TECNOLOGO);
        c.setAtivo(true);
        cl.add(c);

        c = new Course();
        c.setNome("Gastronomia");
        c.setSemestre(2);
        c.setModalidade(MODALIDADE.TECNOLOGO);
        c.setAtivo(true);
        cl.add(c);

        c = new Course();
        c.setNome("Logística");
        c.setSemestre(2);
        c.setModalidade(MODALIDADE.TECNOLOGO);
        c.setAtivo(true);
        cl.add(c);

        ctrl.batchSave(cl.toArray(new Course[] {}));
    }

    public void populateAlunos() {
        Aluno a;
        List<Aluno> alunos = new ArrayList<Aluno>();
        AlunoController c = new AlunoController();

        a = new Aluno();
        a.setCpf(725092396);
        a.setNome("Christensen Patterson");
        a.setEmail("christensenpatterson@zilladyne.com");
        alunos.add(a);

        a = new Aluno();
        a.setCpf(610886648);
        a.setNome("Lacey Boyer");
        a.setEmail("laceyboyer@zilladyne.com");
        alunos.add(a);

        a = new Aluno();
        a.setCpf(809844350);
        a.setNome("Benjamin Hamilton");
        a.setEmail("benjaminhamilton@zilladyne.com");
        alunos.add(a);

        a = new Aluno();
        a.setCpf(888652796);
        a.setNome("Penny Winters");
        a.setEmail("pennywinters@zilladyne.com");
        alunos.add(a);

        a = new Aluno();
        a.setCpf(412554468);
        a.setNome("Rosemarie Boyle");
        a.setEmail("rosemarieboyle@zilladyne.com");
        alunos.add(a);

        a = new Aluno();
        a.setCpf(773221520);
        a.setNome("Eva Edwards");
        a.setEmail("evaedwards@zilladyne.com");
        alunos.add(a);

        a = new Aluno();
        a.setCpf(687874073);
        a.setNome("Alice Short");
        a.setEmail("aliceshort@zilladyne.com");
        alunos.add(a);

        a = new Aluno();
        a.setCpf(154313373);
        a.setNome("Myers York");
        a.setEmail("myersyork@zilladyne.com");
        alunos.add(a);

        a = new Aluno();
        a.setCpf(660507910);
        a.setNome("Knight Jensen");
        a.setEmail("knightjensen@zilladyne.com");
        alunos.add(a);

        a = new Aluno();
        a.setCpf(340864653);
        a.setNome("Frankie Dejesus");
        a.setEmail("frankiedejesus@zilladyne.com");
        alunos.add(a);

        a = new Aluno();
        a.setCpf(876582360);
        a.setNome("Robinson Sharpe");
        a.setEmail("robinsonsharpe@zilladyne.com");
        alunos.add(a);

        a = new Aluno();
        a.setCpf(444851834);
        a.setNome("Wells Howell");
        a.setEmail("wellshowell@zilladyne.com");
        alunos.add(a);

        a = new Aluno();
        a.setCpf(946518708);
        a.setNome("Adela Shannon");
        a.setEmail("adelashannon@zilladyne.com");
        alunos.add(a);

        a = new Aluno();
        a.setCpf(879997171);
        a.setNome("Castro Lara");
        a.setEmail("castrolara@zilladyne.com");
        alunos.add(a);

        a = new Aluno();
        a.setCpf(558514821);
        a.setNome("Stella Rosario");
        a.setEmail("stellarosario@zilladyne.com");
        alunos.add(a);

        a = new Aluno();
        a.setCpf(598414834);
        a.setNome("Andrea May");
        a.setEmail("andreamay@zilladyne.com");
        alunos.add(a);

        a = new Aluno();
        a.setCpf(613373928);
        a.setNome("Grant Delaney");
        a.setEmail("grantdelaney@zilladyne.com");
        alunos.add(a);

        a = new Aluno();
        a.setCpf(960950870);
        a.setNome("Kramer Joyce");
        a.setEmail("kramerjoyce@zilladyne.com");
        alunos.add(a);

        c.batchSave(alunos.toArray(new Aluno[] {}));
    }

    public void populateCoordenador() {
        Coordenador c;
        List<Coordenador> cs = new ArrayList<Coordenador>();
        List<Course> courses;
        CourseController cc = new CourseController();
        courses = cc.find().asList();
        int i = 0;
        CoordenadorController ct = new CoordenadorController();

        Course q = courses.get(i++);
        
        c = new Coordenador();
        c.setCpf(817462127);
        c.setNome("Amalia Stanley");
        c.setEmail("amaliastanley@digiprint.com");
        c.setSenha("amalia");
        c.setStatus(1);
        c.getCursos().add(courses.get(i++));
        c.getCursos().add(courses.get(i++));
        cs.add(c);

        c = new Coordenador();
        c.setCpf(820447747);
        c.setNome("Melendez Dejesus");
        c.setEmail("melendezdejesus@digiprint.com");
        c.setSenha("melendez");
        c.setStatus(1);
        c.getCursos().add(courses.get(i++));
        cs.add(c);

        c = new Coordenador();
        c.setCpf(880490974);
        c.setNome("Glass Evans");
        c.setEmail("glassevans@digiprint.com");
        c.setSenha("glass");
        c.setStatus(1);
        c.getCursos().add(q);
        cs.add(c);

        c = new Coordenador();
        c.setCpf(909048230);
        c.setNome("Molly Galloway");
        c.setEmail("mollygalloway@digiprint.com");
        c.setSenha("molly");
        c.setStatus(1);
        c.getCursos().add(q);
        cs.add(c);

        c = new Coordenador();
        c.setCpf(499787256);
        c.setNome("Vasquez Sanford");
        c.setEmail("vasquezsanford@digiprint.com");
        c.setSenha("vasquez");
        c.setStatus(1);
        c.getCursos().add(courses.get(i++));
        c.getCursos().add(courses.get(i++));
        cs.add(c);

        ct.batchSave(cs.toArray(new Coordenador[] {}));
    }
}
