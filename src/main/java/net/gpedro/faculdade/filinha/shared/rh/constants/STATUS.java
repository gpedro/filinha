package net.gpedro.faculdade.filinha.shared.rh.constants;

import lombok.Getter;
import net.gpedro.faculdade.filinha.core.abstracts.AbstractConstant;

public enum STATUS implements AbstractConstant {
	DISPONIVEL("Disponível"), EM_ATENDIMENTO("Em Atendimento"), AUSENTE(
			"Ausente"), INDISPONIVEL("Indisponível");

	@Getter
	private String description;

	STATUS(String description) {
		this.description = description;
	}

	public boolean isDisponivel() {
		return this == STATUS.DISPONIVEL;
	}

	public boolean isEmAtendimento() {
		return this == STATUS.EM_ATENDIMENTO;
	}

	public boolean isAusente() {
		return this == STATUS.AUSENTE;
	}

	public boolean isIndisponivel() {
		return this == STATUS.INDISPONIVEL;
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
