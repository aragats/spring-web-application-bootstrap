package ru.aragats.example.business.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import ru.aragats.example.persistence.config.PersistenceConfig;

/**
 * Created by Aragats.Amirkhanyan on 06.02.2015.
 */
//Spring config file.
@Configuration
@ComponentScan(basePackages = {"ru.aragats.example.business.logic", "ru.aragats.example.business.context"})
@Import({PersistenceConfig.class, ControllerConfig.class})
public class BusinessConfig {

//    @Bean
//    public PostSL postSL() {
//        PostSL postSL = new PostSL();
////        postSL.setPostDAO(new SomeDAO(PM.getMorphia(), PM.getMongo(), PM.getDatabaseName()));
//        return postSL;
//    }

}
