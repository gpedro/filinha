package net.gpedro.faculdade.filinha.shared.courses.contants;

import lombok.Getter;

public enum TURNOS {

    MATUTINO("Matutino"), VESPERTINO("Vespertino"), NOTURNO("Noturno"), INTEGRAL(
            "Integral");

    @Getter
    private String nome;

    private TURNOS(String nome) {
        this.nome = nome;
    }
}
