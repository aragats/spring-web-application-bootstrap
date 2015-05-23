package ru.aragats.example.business;

import com.mongodb.ServerAddress;
import org.mongodb.morphia.Datastore;
import ru.aragats.example.persistence.Constants;
import ru.aragats.example.persistence.dao.PM;
import ru.aragats.example.persistence.po.SomePO;

import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * The basis test class with static init method to init Morphia (MongoDB)
 * Created by aragats on 19/05/15.
 */
public class BasisTest {


    //TODO Morphia class mapping.
    public static void init() throws UnknownHostException {
        PM.configure(Arrays.asList(new ServerAddress(Constants.DB_HOST, Constants.DB_PORT)), null, Constants.DB_NAME);
        PM.getMorphia().map(SomePO.class);

        Datastore datastore = PM.getMorphia().createDatastore(PM.getMongo(), PM.getDatabaseName());
        datastore.ensureIndexes();
    }


}
