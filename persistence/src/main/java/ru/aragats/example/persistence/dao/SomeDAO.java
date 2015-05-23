package ru.aragats.example.persistence.dao;

import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.dao.BasicDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import ru.aragats.example.persistence.po.SomePO;
import ru.aragats.example.persistence.Constants;
import ru.aragats.example.persistence.repository.SomeRepository;

import java.util.List;

/**
 * Morphia DAO. Include spring mongo componets.
 * Created by Aragats.Amirkhanyan on 27.01.2015.
 */
public class SomeDAO extends BasicDAO<SomePO, String> {
    //Spring mongo repository
    @Autowired
    private SomeRepository someRepository;
    //Spring mongoTemplate
    @Autowired
    private MongoTemplate mongoTemplate;

    //Morphia datastore.
    private Datastore ds;

    public SomeDAO(Morphia morphia, MongoClient mongo, String databaseName) {
        super(mongo, morphia, databaseName);
        //Morphia
        this.ds = PM.getMorphia().createDatastore(PM.getMongo(), PM.getDatabaseName());

    }

    public List<SomePO> someMethod(long longParam, String stringParam, boolean booleanParam) {
        Query query = new Query(Criteria.where("_id").is(stringParam));
        query.fields().include("_id");
        //some code
        return mongoTemplate.find(query, SomePO.class);
    }

    public SomeRepository getSomeRepository() {
        return this.someRepository;
    }

    public MongoTemplate getMongoTemplate() {
        return this.mongoTemplate;
    }

    //This query use 2d_sphere. Morphia ds used.
    public List<SomePO> someMethod2(String stringParam) {
        return this.ds.find(SomePO.class).field(Constants.ID_COLUMN).contains(stringParam).retrievedFields(true, Constants.CREATED_DATE).asList();
    }


}