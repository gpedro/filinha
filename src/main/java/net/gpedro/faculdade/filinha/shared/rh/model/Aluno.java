package net.gpedro.faculdade.filinha.shared.rh.model;

import lombok.ToString;
import net.gpedro.faculdade.filinha.shared.rh.abstracts.Pessoa;

import org.mongodb.morphia.annotations.Entity;

@ToString
@Entity(value = "student", noClassnameStored = true)
public class Aluno extends Pessoa {

}
