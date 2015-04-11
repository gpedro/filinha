package net.gpedro.faculdade.filinha.modules.courses.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import net.gpedro.faculdade.filinha.core.abstracts.AbstractModel;
import net.gpedro.faculdade.filinha.core.annotations.VadinhoColumn;
import net.gpedro.faculdade.filinha.modules.courses.contants.MODALIDADE;

import org.mongodb.morphia.annotations.Entity;

@Data
@EqualsAndHashCode(callSuper = false)
@ToString
@Entity(value = "course", noClassnameStored = true)
public class Course extends AbstractModel {

    /**
     * Nome do Curso
     */
    @VadinhoColumn(label = "Curso")
    private String nome;

    /**
     * Semestres
     */
    private Integer semestre;

    /**
     * Tecnologo / Bacharelado
     */
    @VadinhoColumn
    private MODALIDADE modalidade;

    /**
     * Turnos do Curso. Ex: Matutino, Vespertino, Integral, Noturno
    @VadinhoColumn(label = "Turnos")
    private TURNOS turno;
     */

    /**
     * Ativo/Inativo
     */
    @VadinhoColumn(label = "Situação", truth = "Ativo", falsey = "Inativo")
    private Boolean ativo = false;

}
