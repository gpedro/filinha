package net.gpedro.faculdade.filinha.shared.rh.abstracts;

import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import net.gpedro.faculdade.filinha.core.abstracts.AbstractModel;
import net.gpedro.faculdade.filinha.core.annotations.VadinhoColumn;

@Data
@ToString
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
	private Integer cpf;

	/**
	 * Endereço de Email
	 */
	@VadinhoColumn
	private String email;
	
	/**
	 * Data de Nascimento
	 */
	@VadinhoColumn(label = "Data de Nascimento", dateFormat = "dd/MM/YYYY")
	private Date dtNasc = new Date();

}
