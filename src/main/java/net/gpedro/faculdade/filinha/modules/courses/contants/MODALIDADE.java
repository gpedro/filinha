package net.gpedro.faculdade.filinha.modules.courses.contants;

import lombok.Getter;
import net.gpedro.faculdade.filinha.core.abstracts.AbstractConstant;

public enum MODALIDADE implements AbstractConstant {

    GRADUACAO("Graduação"),
    POS_GRADUACAO("Pós Graduação"),
    MESTRADO("Mestrado"),
    TECNOLOGO("Tecnólogo");

    @Getter
    String description;
    
    MODALIDADE(String description) {
        this.description = description;
    }

    @Override
    public AbstractConstant findByDescription(String description) {
        for (AbstractConstant value: values()) {
            if (value.getDescription() == description) {
                return value;
            }
        }
        
        return null;
    }

}
