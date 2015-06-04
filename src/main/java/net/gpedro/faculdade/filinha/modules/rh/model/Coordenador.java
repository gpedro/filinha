package net.gpedro.faculdade.filinha.modules.rh.model;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import net.gpedro.faculdade.filinha.core.annotations.VadinhoColumn;
import net.gpedro.faculdade.filinha.core.misc.CryptoUtil;
import net.gpedro.faculdade.filinha.modules.courses.model.Course;
import net.gpedro.faculdade.filinha.modules.rh.abstracts.Pessoa;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.PrePersist;
import org.mongodb.morphia.annotations.PreSave;
import org.mongodb.morphia.annotations.Reference;
import org.mongodb.morphia.annotations.Transient;

import com.mongodb.DBObject;

@Entity(value = "coordenador", noClassnameStored = true)
public class Coordenador extends Pessoa {

	@Getter
	@Reference
	@VadinhoColumn(list = false)
	private List<Course> cursos;

	/**
	 * 1: Ativo ou 0: Inativo
	 */
	@Getter
	@Setter
	private Integer status = 0;

	/**
	 * Senha de Login
	 */
	@Getter
	@Setter
	@Transient
	private String senha = "";

	/**
	 * Hash da Senha
	 */
	@Setter
	private String hash;

	public Coordenador() {
		cursos = new ArrayList<Course>();
	}

	@PrePersist
	@PreSave
	private void toHash(DBObject obj) {
		if (!String.valueOf(obj.get("senha")).isEmpty()) {
			try {
				obj.put("hash", CryptoUtil.toSha1(senha));
			} catch (UnsupportedEncodingException e) {
				throw new IllegalArgumentException(e.getMessage());
			}
		}
	}

}
