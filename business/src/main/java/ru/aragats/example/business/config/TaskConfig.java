package ru.aragats.example.business.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Aragats.Amirkhanyan on 09.02.2015.
 */
@Configuration
@ComponentScan(basePackages = "ru.aragats.example.business.task")
public class TaskConfig {

//    public TwitterStreamTask twitterStreamTask() {
//        TwitterStreamTask  twitterStreamTask = new TwitterStreamTask();
//        return twitterStreamTask;
//    }
}
