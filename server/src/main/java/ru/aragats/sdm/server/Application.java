package ru.aragats.sdm.server;

import com.mongodb.ServerAddress;
import org.apache.log4j.Logger;
import org.mongodb.morphia.Datastore;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import ru.aragats.sdm.persistence.Constants;
import ru.aragats.sdm.persistence.dao.PM;
import ru.aragats.sdm.persistence.po.SomePO;
import ru.aragats.sdm.server.config.AppConfig;

import java.net.UnknownHostException;
import java.util.Arrays;


/**
 * Created by Aragats.Amirkhanyan on 05.02.2015.
 */
@Configuration
@Import(AppConfig.class)
//@Component
@EnableAutoConfiguration
@ComponentScan
public class Application extends SpringBootServletInitializer {

    //    @Autowired
//    private ApplicationContext appContext;
//
    final static Logger logger = Logger.getLogger(Application.class);
    private static Class<Application> applicationClass = Application.class;


//    @Autowired
//    private static ThreadPoolTaskExecutor taskExecutor;

//    private ExecutorService execService;


//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//        // Customize the application or call application.sources(...) to add sources
//        // Since our example is itself a @Configuration class we actually don't
//        // need to override this method.
//        return application;
//    }


    public static void main(String[] args) throws UnknownHostException {
        System.out.println("MAIN");
        logger.debug("Test Message- main");
        init();
        ConfigurableApplicationContext context = SpringApplication.run(applicationClass, args);
//        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
//        start();
//        context.getBean(PostSL.class)
//        context.getBean(ThreadPoolTaskExecutor.class).execute(context.getBean(TwitterStreamTask.class));

//        Test test = context.getBean(Test.class);
//        test.test();
    }


    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        // Customize the application or call application.sources(...) to add sources
        // Since our example is itself a @Configuration class we actually don't
        // need to override this method.
        System.out.println("CONFIGURE");
        logger.debug("Test Message");
        try {
            init();
        } catch (UnknownHostException ex) {
            logger.debug("Can't start app", ex);
        }
        return application.sources(applicationClass);
    }


//
//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//        return application.sources(applicationClass);
//    }


    //TODO Morphia class mapping.
    public static void init() throws UnknownHostException {
        PM.configure(Arrays.asList(new ServerAddress(Constants.DB_HOST, Constants.DB_PORT)), null, Constants.DB_NAME);
        PM.getMorphia().map(SomePO.class);

        Datastore datastore = PM.getMorphia().createDatastore(PM.getMongo(), PM.getDatabaseName());
        datastore.ensureIndexes();
    }


}
