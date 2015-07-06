package net.gpedro.faculdade.filinha.visitante.views;

import lombok.Setter;
import net.gpedro.faculdade.filinha.core.components.button.Button;
import net.gpedro.faculdade.filinha.core.components.input.InputCpf;
import net.gpedro.faculdade.filinha.shared.courses.model.Course;
import net.gpedro.faculdade.filinha.shared.rh.model.Coordenador;
import net.gpedro.faculdade.filinha.visitante.ClientUI;

import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class AgendaView extends VerticalLayout {
	
	@Setter
	private Coordenador coordenador;
	
	@Setter
	private Course curso;
	
	public AgendaView() {
		setWidth(100, Unit.PERCENTAGE);
		setMargin(true);
		setSpacing(true);

		InputCpf inputCpf = new InputCpf("Digite seu CPF");
		inputCpf.setSizeFull();

		Button voltar = new Button("Voltar");
		voltar.setSizeFull();
		voltar.addClickListener(voltar());

		addComponents(inputCpf, voltar);
	}

	private ClickListener voltar() {
		return new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				ClientUI.getCurrent().setContent(new SelectCourse());
			}
		};
	}

}
