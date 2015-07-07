package net.gpedro.faculdade.filinha.visitante.views;

import lombok.Setter;
import net.gpedro.faculdade.filinha.core.components.button.Button;
import net.gpedro.faculdade.filinha.core.components.input.InputCpf;
import net.gpedro.faculdade.filinha.core.components.misc.Alert;
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

	private InputCpf inputCpf;

	public AgendaView() {
		setWidth(100, Unit.PERCENTAGE);
		setMargin(true);
		setSpacing(true);

		inputCpf = new InputCpf("Digite seu CPF");
		inputCpf.setSizeFull();

		Button continuar = new Button("Continuar");
		continuar.setSizeFull();
		continuar.addClickListener(continuar());

		Button voltar = new Button("Voltar");
		voltar.setSizeFull();
		voltar.addClickListener(voltar());

		addComponents(inputCpf, continuar, voltar);
	}

	private ClickListener continuar() {
		return new ClickListener() {

			@Override
			public void buttonClick(ClickEvent event) {
				String cpf = inputCpf.getValue();
				if (cpf == null) {
					Alert.showWarn("Atenção", "Preencha o campo CPF");
					return;
				} else if (inputCpf.isValid()){
					System.out.println(cpf);
				}
			}
		};
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
