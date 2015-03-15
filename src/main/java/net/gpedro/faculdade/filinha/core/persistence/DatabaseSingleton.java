package net.gpedro.faculdade.filinha.core.persistence;

import java.net.UnknownHostException;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;

public class DatabaseSingleton {

    private static MongoClient client = null;

    public static MongoClient getInstance() {
        if (client == null) {
            try {
                String mongoEnv = System.getenv("MONGO_URI");
                if (mongoEnv != null) {
                    client = new MongoClient(new MongoClientURI(mongoEnv));
                } else {
                    client = new MongoClient("localhost", 27017);
                }
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
        }

        return client;
    }

}
