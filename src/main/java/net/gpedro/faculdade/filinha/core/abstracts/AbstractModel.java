package net.gpedro.faculdade.filinha.core.abstracts;

import java.util.Date;

import lombok.Getter;
import net.gpedro.faculdade.filinha.core.annotations.VadinhoColumn;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.PostPersist;
import org.mongodb.morphia.annotations.PreSave;

import com.mongodb.DBObject;

public abstract class AbstractModel {

    @Id
    @Getter
    @VadinhoColumn(label = "Cod.", readOnly = true)
    protected ObjectId id;

    @Getter
    protected Date dtCriacao;

    @Getter
    protected Date dtEdicao;

    @PostPersist
    private void addCreatedDate(DBObject obj) {
        obj.put("dtCriacao", new Date());
    }

    @PreSave
    private void addUpdateDate(DBObject obj) {
        obj.put("dtEdicao", new Date());
    }
}
