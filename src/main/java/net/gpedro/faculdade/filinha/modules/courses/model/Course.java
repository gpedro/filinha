package net.gpedro.faculdade.filinha.modules.courses.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import net.gpedro.faculdade.filinha.core.abstracts.AbstractModel;
import net.gpedro.faculdade.filinha.core.annotations.VadinhoColumn;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Data
@EqualsAndHashCode(callSuper = false)
@Entity("course")
public class Course extends AbstractModel {

    /**
     * ID do Curso
     */
    @Id
    private ObjectId id;

    /**
     * Nome do Curso
     */
    @VadinhoColumn
    private String name;

    /**
     * Semestres
     */
    @VadinhoColumn
    private Integer semestres;

    /**
     * Ativo/Inativo
     */
    @VadinhoColumn
    private Boolean ativo;
}
