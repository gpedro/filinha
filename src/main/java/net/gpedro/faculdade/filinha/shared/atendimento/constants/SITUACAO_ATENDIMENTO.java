package net.gpedro.faculdade.filinha.shared.atendimento.constants;

import lombok.Getter;
import net.gpedro.faculdade.filinha.core.abstracts.AbstractConstant;

public enum SITUACAO_ATENDIMENTO implements AbstractConstant {

    AGUARDANDO_CHAMADA("Aguardando Atendimento"), EM_ATENDIMENTO(
            "Em Atendimento"), ATENDIDO("Atendido");

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

    public boolean isAguardandoChamada() {
        return this == AGUARDANDO_CHAMADA;
    }

    public boolean isEmAtendimento() {
        return this == EM_ATENDIMENTO;
    }

    public boolean isAtendido() {
        return this == ATENDIDO;
    }
}
