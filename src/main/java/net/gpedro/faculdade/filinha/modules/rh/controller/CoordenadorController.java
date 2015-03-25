package net.gpedro.faculdade.filinha.modules.rh.controller;

import java.io.UnsupportedEncodingException;

import net.gpedro.faculdade.filinha.core.abstracts.AbstractController;
import net.gpedro.faculdade.filinha.core.components.misc.Alert;
import net.gpedro.faculdade.filinha.core.misc.CryptoUtil;
import net.gpedro.faculdade.filinha.modules.rh.model.Coordenador;

import org.mongodb.morphia.query.Query;

public class CoordenadorController extends AbstractController<Coordenador> {

    public CoordenadorController() {
        super(Coordenador.class);
    }

    public boolean authenticate(String login, String senha) {

        Integer cpf = Integer.valueOf(login);

        if(cpf <= 0) {
            Alert.showError("Usuário ou senha incorretos!", null);
        }
        
        try {
            Query<Coordenador> q = find();
            q.field("cpf").equal(cpf);
            q.field("hash").equal(CryptoUtil.toSha1(senha));

            Coordenador entity = q.get();

            if (entity == null) {
                return false;
            } else {
                switch (entity.getStatus()) {
                    case 0:
                        Alert.showWarn(
                                "Este usuário foi inativado, favor entrar em contato.",
                                null);
                    break;

                    case 1:
                        Alert.showSuccess("Olá " + entity.getNome(), null);
                        return true;

                    case 2:
                        Alert.showWarn("Olá " + entity.getNome(),
                                "Detectamos que seu endereço de email não é válido, favor corrigir!");
                        return true;

                    default:
                        Alert.showError("Usuário ou senha incorretos!", null);
                    break;

                }

                return false;
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return false;
    }
}