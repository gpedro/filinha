package net.gpedro.faculdade.filinha.core.abstracts;

import lombok.Getter;
import net.gpedro.faculdade.filinha.core.persistence.DatabaseSingleton;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.Query;

public abstract class AbstractController<T extends AbstractModel> {

    private Class<T> entityClass;
    @Getter
    private Datastore ds = null;

    public AbstractController(Class<T> entityClass) {
        this.entityClass = entityClass;

        Morphia morphia = new Morphia();
        morphia.map(entityClass);
        mapEntity(morphia);

        ds = morphia
                .createDatastore(DatabaseSingleton.getInstance(), "filinha");
    }

    protected void mapEntity(Morphia morphia) {
    }

    public Query<T> find() {
        return ds.find(entityClass);
    }

    @SuppressWarnings("unchecked")
    public void batchSave(T... entities) {
        ds.save(entities);
    }

    public void save(T entity) {
        ds.save(entity);
    }

    public void remove(T entity) {
        ds.delete(entity);
    }

    public void findAndDelete(Query<T> query) {
        ds.findAndDelete(query);
    }

    public void merge(T entity) {
        ds.merge(entity);
    }
}
