package net.gpedro.faculdade.filinha.modules.rh.abstracts;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import net.gpedro.faculdade.filinha.core.abstracts.AbstractModel;
import net.gpedro.faculdade.filinha.core.misc.CryptoUtil;

import org.mongodb.morphia.annotations.PrePersist;
import org.mongodb.morphia.annotations.PreSave;
import org.mongodb.morphia.annotations.Transient;

import com.mongodb.DBObject;

@Data
@ToString
@EqualsAndHashCode(of = { "cpf", "dtNasc" }, callSuper = false)
public abstract class Pessoa extends AbstractModel {

    /**
     * Nome da Pessoa
     */
    private String name;

    /**
     * CPF da Pessoa
     */
    private String cpf;

    /**
     * Endereço de Email
     */
    private String email;

    /**
     * Data de Nascimento
     */
    private Date dtNasc;

    /**
     * 1: Ativo ou 0: Inativo
     */
    private Integer status = 0;

    /**
     * Senha de Login
     */
    @Transient
    private String senha = "";

    /**
     * Hash da Senha
     */
    private String hash;

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
