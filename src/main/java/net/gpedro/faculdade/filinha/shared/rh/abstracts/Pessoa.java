package net.gpedro.faculdade.filinha.shared.rh.abstracts;

import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.gpedro.faculdade.filinha.core.abstracts.AbstractModel;
import net.gpedro.faculdade.filinha.core.annotations.VadinhoColumn;

@Data
@EqualsAndHashCode(of = { "cpf", "dtNasc" }, callSuper = false)
public abstract class Pessoa extends AbstractModel {

    /**
     * Nome da Pessoa
     */
    @VadinhoColumn
    private String nome;

    /**
     * CPF da Pessoa
     */
    @VadinhoColumn
    private String cpf;

    /**
     * Endereço de Email
     */
    @VadinhoColumn
    private String email;

    /**
     * Telefome Principal
     */
    @VadinhoColumn
    private String telefone;

    /**
     * Data de Nascimento
     */
    @VadinhoColumn(label = "Data de Nascimento", dateFormat = "dd/MM/YYYY")
    private Date dtNasc = new Date();

}
