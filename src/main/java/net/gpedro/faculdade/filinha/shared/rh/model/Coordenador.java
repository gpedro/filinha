package net.gpedro.faculdade.filinha.shared.rh.model;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.gpedro.faculdade.filinha.core.annotations.VadinhoColumn;
import net.gpedro.faculdade.filinha.core.misc.CryptoUtil;
import net.gpedro.faculdade.filinha.shared.courses.model.Course;
import net.gpedro.faculdade.filinha.shared.rh.abstracts.Pessoa;
import net.gpedro.faculdade.filinha.shared.rh.constants.STATUS;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.PrePersist;
import org.mongodb.morphia.annotations.PreSave;
import org.mongodb.morphia.annotations.Reference;
import org.mongodb.morphia.annotations.Transient;

import com.mongodb.DBObject;

@ToString
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
	 * Situação do Coordenador
	 */
	@Getter
	@Setter
	private STATUS situacao = STATUS.INDISPONIVEL;
	
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
