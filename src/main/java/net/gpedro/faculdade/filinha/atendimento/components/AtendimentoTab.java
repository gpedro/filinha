package net.gpedro.faculdade.filinha.atendimento.components;

import net.gpedro.faculdade.filinha.shared.atendimento.constants.SITUACAO_ATENDIMENTO;

import com.vaadin.ui.TabSheet;
import com.vaadin.ui.TabSheet.SelectedTabChangeEvent;
import com.vaadin.ui.TabSheet.SelectedTabChangeListener;
import com.vaadin.ui.themes.ValoTheme;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class AtendimentoTab extends VerticalLayout {

    private TabSheet abas;

    private AlunosAtendimento alunosAgendados;
    private AlunosAtendimento alunosAtendidos;
    private AlunosAtendimento alunosAll;

    public AtendimentoTab() {

	alunosAgendados = new AlunosAtendimento(
		SITUACAO_ATENDIMENTO.AGUARDANDO_CHAMADA);
	alunosAtendidos = new AlunosAtendimento(SITUACAO_ATENDIMENTO.ATENDIDO);
	alunosAll = new AlunosAtendimento();

	abas = new TabSheet();
	abas.setStyleName(ValoTheme.TABSHEET_FRAMED);
	abas.addTab(alunosAgendados, "Alunos Agendados");
	abas.addTab(alunosAtendidos, "Alunos Atendidos");
	abas.addTab(alunosAll, "Todos os Alunos Agendados");
	abas.addSelectedTabChangeListener(recarregaAba());

	addComponent(abas);
    }

    private SelectedTabChangeListener recarregaAba() {
	return new SelectedTabChangeListener() {

	    @Override
	    public void selectedTabChange(SelectedTabChangeEvent event) {
		((AlunosAtendimento) event.getTabSheet().getSelectedTab())
			.reload();
	    }
	};
    }
}