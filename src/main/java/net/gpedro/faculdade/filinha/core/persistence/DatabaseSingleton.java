package net.gpedro.faculdade.filinha.core.persistence;

import lombok.Getter;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

public class DatabaseSingleton {

    private static MongoClient client          = null;
    @Getter
    private static String      currentDatabase = null;

    public static MongoClient getInstance() {
        if (client == null) {
            String mongoEnv = System.getenv("MONGOLAB_URI");
            MongoClientURI uri;
            if (mongoEnv != null) {
                uri = new MongoClientURI(mongoEnv);
            } else {
                uri = new MongoClientURI("mongodb://localhost:27017/filinha");
            }
            client = new MongoClient(uri);
            currentDatabase = uri.getDatabase();
        }

        return client;
    }

}
