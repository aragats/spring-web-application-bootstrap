package ru.aragats.example.persistence.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import ru.aragats.example.persistence.po.SomePO;

/**
 * Created by Aragats.Amirkhanyan on 10.02.2015.
 */

//Not obligatory ??
//@Repository
public interface SomeRepository extends MongoRepository<SomePO, String> {

    //You can specify interfaces fore repository without writing source code of implementation.
    // And it would work. Please look at the spring repository documentation.

//    Long countByText(String timestamp);

//    @Query(fields="{ 'user' : 1}")
//    List<Post> findAll();
}