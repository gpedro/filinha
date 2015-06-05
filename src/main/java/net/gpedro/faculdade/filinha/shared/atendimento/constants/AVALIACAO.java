package net.gpedro.faculdade.filinha.shared.atendimento.constants;

import lombok.Getter;
import net.gpedro.faculdade.filinha.core.abstracts.AbstractConstant;

public enum AVALIACAO implements AbstractConstant {
	OTIMO("Ótimo"), BOM("Bom"), RUIM("Ruim");

	@Getter
	private String description;

	AVALIACAO(String description) {
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
