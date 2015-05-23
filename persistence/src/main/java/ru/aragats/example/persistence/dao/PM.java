package ru.aragats.example.persistence.dao;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ServerAddress;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import java.util.List;

/**
 * Persistence Manager. Morphia
 * Created by Aragats.Amirkhanyan on 23.01.2015.
 */
public class PM {

    private static Morphia morphia;
    private static MongoClient mongo;
    private static String databaseName;

    public static synchronized void configure(List<ServerAddress> seeds, MongoClientOptions options, String dbName) {
        morphia = new Morphia();
        if (seeds != null && options != null) {
            mongo = new MongoClient(seeds, options);
        } else if (seeds != null) {
            mongo = new MongoClient(seeds);
        }
        databaseName = dbName;

    }

    public static MongoClient getMongo() {
        return mongo;
    }

    public static Morphia getMorphia() {
        return morphia;
    }

    public static String getDatabaseName() {
        return databaseName;
    }

}
