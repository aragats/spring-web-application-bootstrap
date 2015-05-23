package ru.aragats.sdm.business.task;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.aragats.sdm.business.Constants;
import ru.aragats.sdm.persistence.dao.SomeDAO;
import ru.aragats.sdm.persistence.po.SomePO;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * The background task. Go to MyApplicationContextAware if you want to tun this task,
 * Created by Aragats.Amirkhanyan on 06.02.2015.
 */
@Component
public class SomeStreamTask implements Runnable {

    final static Logger logger = Logger.getLogger(SomeStreamTask.class);

    @Autowired
    private SomeDAO someDAO;



    @Override
    public void run() {

        /** Set up your blocking queues: Be sure to size these properly based on expected TPS of your stream */
        BlockingQueue<String> msgQueue = new LinkedBlockingQueue<String>(Constants.INT_100000);

        // connect to some stream and put new message to msgQueue; Look example with Twitter stream.
        // on a different thread, or multiple different threads....
        while (true) {
            try {
                String msg = msgQueue.take();
                handle(msg);
            } catch (InterruptedException e) {
                logger.error("Error reading twitter from stream", e);
            }
        }

    }

    //TODO put place into coordinates place.
    private void handle(String msg) {
        // You can use gson to parse string to some class.
//        Twitter twitter = this.gson.fromJson(msg, Twitter.class);
        //Convert  twitter to somePO.
        SomePO somePO = new SomePO();
        this.someDAO.getSomeRepository().save(somePO);

    }

}
