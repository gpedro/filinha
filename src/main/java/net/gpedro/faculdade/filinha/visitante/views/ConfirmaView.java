package net.gpedro.faculdade.filinha.visitante.views;

import lombok.Getter;
import net.gpedro.faculdade.filinha.core.components.input.InputText;
import net.gpedro.faculdade.filinha.core.components.misc.Head;
import net.gpedro.faculdade.filinha.shared.courses.model.Course;
import net.gpedro.faculdade.filinha.shared.rh.model.Aluno;
import net.gpedro.faculdade.filinha.shared.rh.model.Coordenador;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class ConfirmaView extends VerticalLayout implements View {

	@Getter
	private Coordenador coordenador;
	@Getter
	private Course curso;
	@Getter
	private Aluno aluno;

	public ConfirmaView(Coordenador coordenador, Course curso, Aluno aluno) {
		this.aluno = aluno;
		this.curso = curso;
		this.coordenador = coordenador;

		setSpacing(true);
		setMargin(true);

		InputText cpf, nome, telefone, professor, materia;

        cpf = new InputText("CPF");
        cpf.setValue(aluno.getCpf());
        cpf.setEnabled(false);
        cpf.setSizeFull();

        nome = new InputText("Nome");
        nome.setValue(aluno.getNome());
        nome.setEnabled(false);
        nome.setSizeFull();

        telefone = new InputText("Telefone");
        telefone.setValue(aluno.getTelefone());
        telefone.setEnabled(false);
        telefone.setSizeFull();

        // ----------

        professor = new InputText("Professor");
        professor.setValue(coordenador.getNome());
        professor.setEnabled(false);
        professor.setSizeFull();

        materia = new InputText("Curso");
        materia.setValue(curso.getNome());
        materia.setEnabled(false);
        materia.setSizeFull();

        // ----------

        addComponent(Head.H3.toComponent("Dados do Solicitante"));
		addComponents(cpf, nome, telefone);
        addComponent(Head.H3.toComponent("Dados do Solicitado"));
		addComponents(professor, materia);
		addComponent(Head.HR.toComponent(null));
	}

	@Override
	public void enter(ViewChangeEvent event) {
	}

}
