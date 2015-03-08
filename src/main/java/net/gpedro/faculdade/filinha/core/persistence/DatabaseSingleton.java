package net.gpedro.faculdade.filinha.core.persistence;

import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.MongoClient;

public class DatabaseSingleton {

    private static MongoClient client = null;

    private static MongoClient getClient() {
        if (client == null) {
            try {
                client = new MongoClient("localhost", 27017);
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
        }

        return client;
    }

    public static DB getInstance() {
        return getClient().getDB("filinha");
    }

}
