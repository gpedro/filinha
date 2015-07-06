package net.gpedro.faculdade.filinha.visitante.views;

import net.gpedro.faculdade.filinha.core.components.button.Button;
import net.gpedro.faculdade.filinha.core.components.input.InputCpf;
import net.gpedro.faculdade.filinha.visitante.ClientUI;

import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class AgendaView extends VerticalLayout {

	public AgendaView() {
		setWidth(100, Unit.PERCENTAGE);
		setMargin(true);
		setSpacing(true);

		InputCpf inputCpf = new InputCpf();
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
