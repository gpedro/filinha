package net.gpedro.faculdade.filinha.visitante.views;

import lombok.Setter;
import net.gpedro.faculdade.filinha.core.components.button.Button;
import net.gpedro.faculdade.filinha.core.components.input.InputCpf;
import net.gpedro.faculdade.filinha.core.components.misc.Alert;
import net.gpedro.faculdade.filinha.shared.courses.model.Course;
import net.gpedro.faculdade.filinha.shared.rh.controller.AlunoController;
import net.gpedro.faculdade.filinha.shared.rh.model.Aluno;
import net.gpedro.faculdade.filinha.shared.rh.model.Coordenador;
import net.gpedro.faculdade.filinha.visitante.ClientUI;

import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.themes.ValoTheme;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class AgendaView extends VerticalLayout {

    @Setter
    private Coordenador coordenador;

    @Setter
    private Course curso;

    private InputCpf inputCpf;
    private AlunoController c;

    public AgendaView() {

	c = new AlunoController();

	setWidth(100, Unit.PERCENTAGE);
	setMargin(true);
	setSpacing(true);

	inputCpf = new InputCpf("Digite seu CPF");
	inputCpf.setSizeFull();
	inputCpf.focus();

	Button continuar = new Button("Continuar");
	continuar.setStyleName(ValoTheme.BUTTON_PRIMARY);
	continuar.setSizeFull();
	continuar.setClickShortcut(KeyCode.ENTER);
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
		} else if (!inputCpf.isValid()) {
		    Alert.showWarn("Atenção", "O CPF digitado é inválido");
		} else {
		    // Simulando busca no ERP da Faculdade
		    Aluno aluno = c.findByCpf(cpf);
		    if (aluno != null) {
			ClientUI.getCurrent().setContent(
				new ConfirmaView(coordenador, curso, aluno));
		    } else {
			Alert.showError("Atenção", "CPF não encontrado.", 2000);
		    }
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
