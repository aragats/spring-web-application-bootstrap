package ru.aragats.sdm.server.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import ru.aragats.sdm.business.config.BusinessConfig;
import ru.aragats.sdm.business.config.TaskConfig;

/**
 * Spring application config.
 * Created by Aragats.Amirkhanyan on 05.02.2015.
 */
//Application config file, which load config files from other modules.
@Configuration
//TODO to enable Scheduling and  Async.
//@EnableAsync
//@EnableScheduling
//@EnableAutoConfiguration
//@ComponentScan
@Import({BusinessConfig.class, TaskConfig.class})
public class AppConfig {


    //TODO this method is used when there is not @Component annotation above the SomeBean. @Component invoke default constructor.
//    @Bean
//    public SomeBean someBean() {
//        return new SomeBean();
//    }


    //ConcurrentTaskExecutor alternative
    @Bean
    public ThreadPoolTaskExecutor threadPoolTaskExecutor() {
        ThreadPoolTaskExecutor pool = new ThreadPoolTaskExecutor();
        pool.setCorePoolSize(5);
        pool.setMaxPoolSize(10);
        pool.setWaitForTasksToCompleteOnShutdown(true);
//        pool.execute();
        return pool;
    }
//
//    @Bean
//    public ThreadPoolExecutorFactoryBean threadPoolExecutorFactoryBean() {
//        ThreadPoolExecutorFactoryBean factory = new ThreadPoolExecutorFactoryBean();
//        factory.setCorePoolSize(50);
//        factory.setMaxPoolSize(200);
//        factory.setQueueCapacity(5000);
//        //inject it
////        threadPoolExecutorFactoryBean().getObject()
//        return factory;
//    }

//    @Bean
//    public ch.ralscha.extdirectspring.controller.Configuration configuration() throws Exception {
//        ch.ralscha.extdirectspring.controller.Configuration config = new ch.ralscha.extdirectspring.controller.Configuration();
//        config.setBatchedMethodsExecutionPolicy(BatchedMethodsExecutionPolicy.CONCURRENT);
//        config.setBatchedMethodsExecutorService(threadPoolExecutorFactoryBean().getObject());
//        return config;
//    }
}
