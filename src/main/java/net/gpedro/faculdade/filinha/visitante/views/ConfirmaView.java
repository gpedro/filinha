package net.gpedro.faculdade.filinha.visitante.views;

import java.util.Date;

import lombok.Getter;
import net.gpedro.faculdade.filinha.core.components.button.Button;
import net.gpedro.faculdade.filinha.core.components.input.InputText;
import net.gpedro.faculdade.filinha.core.components.misc.Head;
import net.gpedro.faculdade.filinha.shared.atendimento.controller.AtendimentoController;
import net.gpedro.faculdade.filinha.shared.atendimento.model.Atendimento;
import net.gpedro.faculdade.filinha.shared.courses.model.Course;
import net.gpedro.faculdade.filinha.shared.rh.model.Aluno;
import net.gpedro.faculdade.filinha.shared.rh.model.Coordenador;
import net.gpedro.faculdade.filinha.visitante.ClientUI;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.themes.ValoTheme;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class ConfirmaView extends VerticalLayout implements View {

    @Getter
    private Coordenador coordenador;
    @Getter
    private Course curso;
    @Getter
    private Aluno aluno;
    
    AtendimentoController c;

    public ConfirmaView(Coordenador coordenador, Course curso, Aluno aluno) {
	this.aluno = aluno;
	this.curso = curso;
	this.coordenador = coordenador;
	c = new AtendimentoController();

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

	Button continuar, retornar, cancelar;

	continuar = new Button("Emitir Senha");
	continuar.setStyleName(ValoTheme.BUTTON_PRIMARY);
	continuar.setSizeFull();
	continuar.addClickListener(continuar());

	retornar = new Button("Retornar");
	retornar.setSizeFull();
	retornar.addClickListener(retornar());

	cancelar = new Button("Cancelar");
	cancelar.setSizeFull();
	cancelar.addClickListener(cancelar());

	GridLayout botoes = new GridLayout(3, 1);
	botoes.setSpacing(true);
	botoes.setSizeFull();
	botoes.addComponents(retornar, cancelar, continuar);

	// ----------

	addComponent(Head.H3.toComponent("Dados do Solicitante"));
	addComponents(cpf, nome, telefone);
	addComponent(Head.H3.toComponent("Dados do Solicitado"));
	addComponents(professor, materia);
	addComponent(Head.HR.toComponent(null));
	addComponent(botoes);
    }

    private Button.ClickListener continuar() {
	return new ClickListener() {

	    @Override
	    public void buttonClick(ClickEvent event) {
		Atendimento a = new Atendimento();
		a.setAtendente(coordenador);
		a.setSolicitante(aluno);
		a.setData(new Date());
		a.geraSenha();
		
		c.save(a);
		
		SenhaPopup p = new SenhaPopup(a.getSenha());
		
		if (!p.isAttached()) {
		    ClientUI.getCurrent().addWindow(p);
		}
	    }
	};
    }

    private Button.ClickListener retornar() {
	return new ClickListener() {

	    @Override
	    public void buttonClick(ClickEvent event) {
		AgendaView ag = new AgendaView();
		ag.setCurso(curso);
		ag.setCoordenador(coordenador);
		ClientUI.getCurrent().setContent(ag);
	    }
	};
    }

    private ClickListener cancelar() {
	return new ClickListener() {

	    @Override
	    public void buttonClick(ClickEvent event) {
		ClientUI.getCurrent().setContent(new SelectCourse());
	    }
	};
    }

    @Override
    public void enter(ViewChangeEvent event) {
    }

}
