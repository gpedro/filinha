package net.gpedro.faculdade.filinha.core.abstracts;

import lombok.Getter;
import net.gpedro.faculdade.filinha.core.annotations.VadinhoColumn;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Id;

public abstract class AbstractModel {

    @Id
    @Getter
    @VadinhoColumn(label="Cod.")
    protected ObjectId id;
    
}
