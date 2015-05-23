package ru.aragats.example.business.logic;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ru.aragats.example.business.BasisTest;
import ru.aragats.example.business.config.BusinessConfig;
import ru.aragats.example.business.context.SomeContext;
import ru.aragats.example.business.converter.SomePoToDtoConverter;
import ru.aragats.example.persistence.dao.SomeDAO;

import java.net.UnknownHostException;

/**
 * The example of test class with initialization Spring context.
 */
@RunWith(SpringJUnit4ClassRunner.class)
// ApplicationContext will be loaded from the static inner ContextConfiguration class
//@ContextConfiguration(loader=AnnotationConfigContextLoader.class)
@SpringApplicationConfiguration(classes = BusinessConfig.class)

public class SampleSLTest extends BasisTest {

    @Autowired
    private SampleSL postSL;
    @Autowired
    private SomeDAO someDAO;
    @Autowired
    private SomePoToDtoConverter converter;
    @Autowired
    private SomeContext context;

    @BeforeClass
    //static . so it would run before spring context
    static public void beforeClass() throws UnknownHostException {
        // do intialization here
        init();

    }

    @Test
    public void testMethod() {
        System.out.println("Test Method");
        // you can write your test here.
        // spring context is loaded here.
    }
}

