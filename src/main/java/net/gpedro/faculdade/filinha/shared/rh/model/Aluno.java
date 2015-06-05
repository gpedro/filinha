package net.gpedro.faculdade.filinha.shared.rh.model;

import net.gpedro.faculdade.filinha.shared.rh.abstracts.Pessoa;

import org.mongodb.morphia.annotations.Entity;

@Entity(value = "student", noClassnameStored = true)
public class Aluno extends Pessoa {

}
