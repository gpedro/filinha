package net.gpedro.faculdade.filinha.shared.atendimento.views;

import java.util.Arrays;

import lombok.Getter;
import net.gpedro.faculdade.filinha.core.components.misc.Alert;
import net.gpedro.faculdade.filinha.shared.atendimento.constants.CLASSIFICACAO;
import net.gpedro.faculdade.filinha.shared.atendimento.model.Atendimento;
import net.gpedro.faculdade.filinha.shared.rh.model.Aluno;

import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class EditarAtendimento extends VerticalLayout {

    @Getter
    private BeanFieldGroup<Atendimento> bean;
    
    private TextArea descricao;
    private ComboBox status;
    
    public boolean isValid() {
        return status.isValid() && descricao.isValid();
    }

    public EditarAtendimento(Atendimento entity) {
        if (entity == null) {
            Alert.showError("Atenção",
                    "Não foi possível editar este atendimento", 5000);
            return;
        }

        bean = new BeanFieldGroup<Atendimento>(Atendimento.class);
        bean.setItemDataSource(entity);

        // ---------
        TextField senha = bean.buildAndBind("Senha", "senha", TextField.class);
        senha.setEnabled(false);
        senha.setSizeFull();
        
        // ---------

        Aluno a = entity.getSolicitante();
        TextField alunoCpf, alunoNome;
        
        alunoCpf = new TextField("CPF");
        alunoCpf.setEnabled(false);
        alunoCpf.setValue(a.getCpf());
        alunoCpf.setSizeFull();
        
        alunoNome = new TextField("Nome");
        alunoNome.setEnabled(false);
        alunoNome.setValue(a.getNome());
        alunoNome.setSizeFull();
        
        // ---------
        
       descricao = bean.buildAndBind("Observação", "observacoes", TextArea.class);
        descricao.setNullRepresentation("");
        descricao.setSizeFull();
        
        // ---------
        
        BeanItemContainer<CLASSIFICACAO> bc = new BeanItemContainer<CLASSIFICACAO>(
                CLASSIFICACAO.class);
        bc.addAll(Arrays.asList(CLASSIFICACAO.values()));
        
        status = bean.buildAndBind("Classificação", "classificacao", ComboBox.class);
        status.setRequired(true);
        status.setContainerDataSource(bc);
        status.setSizeFull();
        status.setItemCaptionPropertyId("description");
        
        // ---------
        
        addComponents(senha, alunoCpf, alunoNome, descricao, status);
    }
}
