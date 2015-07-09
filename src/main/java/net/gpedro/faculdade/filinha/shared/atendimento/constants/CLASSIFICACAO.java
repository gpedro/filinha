package net.gpedro.faculdade.filinha.shared.atendimento.constants;

import lombok.Getter;
import net.gpedro.faculdade.filinha.core.abstracts.AbstractConstant;

public enum CLASSIFICACAO implements AbstractConstant {

    ATENDIDO("Atendido"),
    NAO_COMPERECEU("Não Compareceu");
    
    @Getter
    private String description;
    
    CLASSIFICACAO(String description) {
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
