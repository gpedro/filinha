package net.gpedro.faculdade.filinha.core.abstracts;

import net.gpedro.faculdade.filinha.core.persistence.DatabaseSingleton;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.Query;

public abstract class AbstractController<T extends AbstractModel> {

    private Class<T> entityClass;
    protected Datastore ds = null;

    public AbstractController(Class<T> entityClass) {
        this.entityClass = entityClass;

        Morphia morphia = new Morphia();
        morphia.map(entityClass);
        mapEntity(morphia);
        
        ds = morphia.createDatastore(DatabaseSingleton.getInstance(), "filinha");
    }
    
    protected void mapEntity(Morphia morphia) {
        
    }

    protected Query<T> find() {
        return ds.find(entityClass);
    }

}
