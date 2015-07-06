package net.gpedro.faculdade.filinha.shared.rh.constants;

import lombok.Getter;
import net.gpedro.faculdade.filinha.core.abstracts.AbstractConstant;

public enum STATUS implements AbstractConstant {
	DISPONIVEL("Disponivel"),
	EM_ATENDIMENTO("Em Atendimento"),
	EM_REUNIAO("Em Reunião"),
	AUSENTE("Ausente"),
	INDISPONIVEL("Indisponível");

	@Getter
	private String description;

	STATUS(String description) {
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
