package net.gpedro.faculdade.filinha.shared.atendimento.constants;

import lombok.Getter;
import net.gpedro.faculdade.filinha.core.abstracts.AbstractConstant;

public enum SITUACAO_ATENDIMENTO implements AbstractConstant {
	DISPONIVEL("Disponivel"), EM_ATENDIMENTO("Em Atendimento"), AUSENTE(
			"Ausente"), INDISPONIVEL("Indisponível");

	@Getter
	private String description;

	SITUACAO_ATENDIMENTO(String description) {
		this.description = description;
	}

	@Override
	public AbstractConstant findByDescription(String description) {
		for (AbstractConstant value : values()) {
			if (value.getDescription() == description) {
				return value;
			}
		}

		return null;
	}

}
