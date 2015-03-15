package net.gpedro.faculdade.filinha.modules.rh.model;

import java.util.List;

import net.gpedro.faculdade.filinha.modules.courses.model.Course;
import net.gpedro.faculdade.filinha.modules.rh.abstracts.Pessoa;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Reference;

@Entity(value = "professor", noClassnameStored = true)
public class Professor extends Pessoa {

    @Reference
    private List<Course> courses;

}
