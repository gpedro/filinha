package net.gpedro.faculdade.filinha.modules.courses.contants;

import lombok.Getter;

public enum TURNOS {

    MATUTINO("Matutino"),
    VESPERTINO("Vespertino"),
    NOTURNO("Nortuno"),
    INTEGRAL("Integral");

    @Getter
    private String nome;

    private TURNOS(String nome) {
        this.nome = nome;
    }
}
