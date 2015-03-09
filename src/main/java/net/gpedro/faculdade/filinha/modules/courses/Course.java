package net.gpedro.faculdade.filinha.modules.courses;

import net.gpedro.faculdade.filinha.core.abstracts.AbstractModel;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity("course")
public class Course extends AbstractModel {

    /**
     * ID do Curso
     */
    @Id
    ObjectId id;

    /**
     * Nome do Curso
     */
    String name;

    /**
     * Semestres
     */
    Integer semestres;
}
