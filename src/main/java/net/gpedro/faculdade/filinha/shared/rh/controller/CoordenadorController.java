package net.gpedro.faculdade.filinha.shared.rh.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import net.gpedro.faculdade.filinha.core.abstracts.AbstractController;
import net.gpedro.faculdade.filinha.core.components.misc.Alert;
import net.gpedro.faculdade.filinha.core.misc.CryptoUtil;
import net.gpedro.faculdade.filinha.shared.courses.model.Course;
import net.gpedro.faculdade.filinha.shared.rh.model.Coordenador;

import org.mongodb.morphia.query.Query;

public class CoordenadorController extends AbstractController<Coordenador> {

	public CoordenadorController() {
		super(Coordenador.class);
	}

	public Coordenador authenticate(String login, String senha) {

		try {
			Query<Coordenador> q = find();
			q.field("cpf").equal(login);
			q.field("hash").equal(CryptoUtil.toSha1(senha));

			Coordenador entity = q.get();

			if (entity == null) {
				Alert.showError("Usuário ou senha incorretos!", null, 2000);
				return null;
			} else {
				switch (entity.getStatus()) {
				case 0:
					Alert.showWarn(
							"Este usuário foi inativado, favor entrar em contato.",
							null);
					break;

				case 1:
					Alert.showSuccess("Olá " + entity.getNome(), null);
					return entity;

				case 2:
					Alert.showWarn("Olá " + entity.getNome(),
							"Detectamos que seu endereço de email não é válido, favor corrigir!");
					return entity;

				default:
					Alert.showError("Usuário ou senha incorretos!", null, 2000);
					break;

				}

				return null;
			}
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<Coordenador> findByCourse(Course curso){
		Query<Coordenador> q = find();
		q.field("cursos").hasThisElement(curso);
		
		return q.asList();
	}
}