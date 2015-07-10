package net.gpedro.faculdade.filinha.shared.atendimento.model;

import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import net.gpedro.faculdade.filinha.core.abstracts.AbstractModel;
import net.gpedro.faculdade.filinha.core.annotations.VadinhoColumn;
import net.gpedro.faculdade.filinha.shared.atendimento.constants.AVALIACAO;
import net.gpedro.faculdade.filinha.shared.atendimento.constants.CLASSIFICACAO;
import net.gpedro.faculdade.filinha.shared.atendimento.constants.SITUACAO_ATENDIMENTO;
import net.gpedro.faculdade.filinha.shared.atendimento.controller.AtendimentoController;
import net.gpedro.faculdade.filinha.shared.rh.model.Aluno;
import net.gpedro.faculdade.filinha.shared.rh.model.Coordenador;

import org.mongodb.morphia.annotations.Entity;

@Data
@EqualsAndHashCode(callSuper = false)
@ToString
@Entity(value = "atendimento", noClassnameStored = true)
public class Atendimento extends AbstractModel {

    @VadinhoColumn
    private Coordenador          atendente;

    @VadinhoColumn
    private Aluno                solicitante;

    @VadinhoColumn
    private Date                 data;

    @VadinhoColumn(create = false, edit = false)
    private AVALIACAO            avaliacao;

    @VadinhoColumn(create = false, edit = false)
    private SITUACAO_ATENDIMENTO situacao = SITUACAO_ATENDIMENTO.AGUARDANDO_CHAMADA;

    @VadinhoColumn(create = false, edit = false)
    private CLASSIFICACAO        classificacao;

    @VadinhoColumn(create = false, edit = false)
    private String               senha;

    @VadinhoColumn(create = true, edit = false)
    private String               observacoes;

    @VadinhoColumn(create = false, edit = true)
    private String               notasInternas;

    public String geraSenha() {
        AtendimentoController ac = new AtendimentoController();
        Integer lastSenha = ac.getIncrement();

        senha = String.format("%03d", lastSenha + 1);
        return senha;
    }
}
