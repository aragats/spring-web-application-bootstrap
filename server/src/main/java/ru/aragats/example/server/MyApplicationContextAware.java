package ru.aragats.example.server;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import ru.aragats.example.business.context.SomeContext;

/**
 * Created by Aragats.Amirkhanyan on 02.03.2015.
 */
//TODO On Application loaded.
@Component
public class MyApplicationContextAware implements ApplicationContextAware {

    // This method is invoked when context is loaded. So here you can load cache (context) or run some background thread
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        applicationContext.getBean(SomeContext.class).initContext();
        //Uncomment line to execute thread.
//        applicationContext.getBean(ThreadPoolTaskExecutor.class).execute(applicationContext.getBean(TwitterStreamTask.class));

    }
}
