package ru.aragats.example.persistence.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import ru.aragats.example.persistence.dao.PM;
import ru.aragats.example.persistence.dao.SomeDAO;

/**
 * Spring config to init dao classes.
 * Created by Aragats.Amirkhanyan on 06.02.2015.
 */
@Configuration
@EnableAutoConfiguration
@Import({SpringMongoConfig.class})
@ComponentScan(basePackages = {"ru.aragats.example.persistence.dao"})
public class PersistenceConfig {

    @Bean
    public SomeDAO postDAO() {
        return new SomeDAO(PM.getMorphia(), PM.getMongo(), PM.getDatabaseName());
    }

}
