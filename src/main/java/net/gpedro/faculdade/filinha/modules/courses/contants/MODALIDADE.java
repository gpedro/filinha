package net.gpedro.faculdade.filinha.modules.courses.contants;

import lombok.Getter;

public enum MODALIDADE {

    GRADUACAO("Graduação"),
    POS_GRADUACAO("Pós Graduação"),
    MESTRADO("Mestrado"),
    TECNOLOGO("Tecnólogo");

    @Getter
    private String nome;

    private MODALIDADE(String nome) {
        this.nome = nome;
    }

}
