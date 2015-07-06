package net.gpedro.faculdade.filinha.visitante.visitante;

import java.util.List;

import net.gpedro.faculdade.filinha.core.components.button.Button;
import net.gpedro.faculdade.filinha.core.components.misc.Alert;
import net.gpedro.faculdade.filinha.shared.components.ComboCourses;
import net.gpedro.faculdade.filinha.shared.courses.model.Course;
import net.gpedro.faculdade.filinha.shared.rh.controller.CoordenadorController;
import net.gpedro.faculdade.filinha.shared.rh.model.Coordenador;
import net.gpedro.faculdade.filinha.visitante.ClientUI;
import net.gpedro.faculdade.filinha.visitante.views.CoordenadoresPopup;

import com.vaadin.data.util.BeanItem;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Label;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window.CloseEvent;
import com.vaadin.ui.Window.CloseListener;

@SuppressWarnings("serial")
public class VisitanteView extends VerticalLayout implements View {

	private ComboCourses cursos;
	private CoordenadorController coordenadorController;
	
	public VisitanteView() {
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
					BeanItem<Course> course = (BeanItem<Course>) cursos.getItem(cursos.getValue());
					Course curso = course.getBean();
					List<Coordenador> listCoordenadores = coordenadorController.findByCourse(curso);
					
					if (listCoordenadores == null || listCoordenadores.size() == 0) {
						Alert.showError("Nenhum Coordenador encontrado.", null);
						return;
					}
					
					if (listCoordenadores.size() == 1) {
						Coordenador selecionado = listCoordenadores.get(0);
						gerarSenha(selecionado);
						return;
					}
					if (listCoordenadores.size() > 1) {
						final CoordenadoresPopup c = new CoordenadoresPopup(listCoordenadores);
						ClientUI.getCurrent().addWindow(c);
						c.addCloseListener(new CloseListener() {
							
							@Override
							public void windowClose(CloseEvent e) {
								Coordenador selecionado = c.getCoordenadorSelecionado();
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
			System.out.println(selecionado);
		}
	}
	@Override
	public void enter(ViewChangeEvent event) {
		
	}

}
