package net.gpedro.faculdade.filinha.visitante.views;

import java.util.List;

import lombok.Getter;
import net.gpedro.faculdade.filinha.core.components.button.Button;
import net.gpedro.faculdade.filinha.core.components.misc.Alert;
import net.gpedro.faculdade.filinha.shared.components.ComboCourses;
import net.gpedro.faculdade.filinha.shared.courses.model.Course;
import net.gpedro.faculdade.filinha.shared.rh.constants.STATUS;
import net.gpedro.faculdade.filinha.shared.rh.controller.CoordenadorController;
import net.gpedro.faculdade.filinha.shared.rh.model.Coordenador;
import net.gpedro.faculdade.filinha.visitante.ClientUI;

import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window.CloseEvent;
import com.vaadin.ui.Window.CloseListener;

@SuppressWarnings("serial")
public class SelectCourse extends VerticalLayout {

	@Getter
	private ComboCourses cursos;

	@Getter
	private Coordenador selecionado;
	
	private CoordenadorController coordenadorController;


	public SelectCourse() {
		coordenadorController = new CoordenadorController();

		setWidth(100, Unit.PERCENTAGE);
		setMargin(true);
		setSpacing(true);

		Label titulo = new Label("Selecione um curso");
		cursos = new ComboCourses("Cursos");
		cursos.setSizeFull();

		Button continuar = new Button("Próximo");
		continuar.setSizeFull();
		continuar.addClickListener(proximo());

		addComponents(titulo, cursos, continuar);
	}


	@SuppressWarnings("unchecked")
	private ClickListener proximo() {
		return new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				if (cursos.getValue() != null) {
					BeanItem<Course> course = (BeanItem<Course>) cursos
							.getItem(cursos.getValue());
					Course curso = course.getBean();
					List<Coordenador> listCoordenadores = coordenadorController
							.findByCourse(curso);

					if (listCoordenadores == null
							|| listCoordenadores.size() == 0) {
						Alert.showError("Nenhum Coordenador encontrado.", null,
								2000);
						return;
					}

					if (listCoordenadores.size() == 1) {
						Coordenador selecionado = listCoordenadores.get(0);
						gerarSenha(selecionado);
						return;
					}
					if (listCoordenadores.size() > 1) {
						final CoordenadoresPopup c = new CoordenadoresPopup(
								listCoordenadores);
						ClientUI.getCurrent().addWindow(c);
						c.addCloseListener(new CloseListener() {

							@Override
							public void windowClose(CloseEvent e) {
								Coordenador selecionado = c
										.getCoordenadorSelecionado();
								gerarSenha(selecionado);
							}

						});
					}
				} else {
					Alert.showWarn("Selecione um Curso.", null);
				}
			}
		};
	}

	private void gerarSenha(Coordenador selecionado) {
		if (selecionado != null) {
			this.selecionado = selecionado;
			
			STATUS situacao = selecionado.getSituacao();
			if (situacao.isAusente() || situacao.isIndisponivel()) {
				Alert.showError("Atenção:", "O Coordenador está <i><b>"
						+ situacao.getDescription().toLowerCase()
						+ "</b></i> no momento.", true, 2000);
				return;
			}
		}
	}
}
