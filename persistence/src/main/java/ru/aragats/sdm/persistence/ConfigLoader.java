package ru.aragats.sdm.persistence;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Draft of the config loader to load config from properties files.
 * Created by Aragats.Amirkhanyan on 05.02.2015.
 */
public class ConfigLoader {

    public static void load() throws FileNotFoundException {
        Properties prop = new Properties();
        InputStream input = null;

        try {

            input = new FileInputStream("db.properties");

            // load a properties file
            prop.load(input);

            // get the property value and print it out
            System.out.println(prop.getProperty(Constants.DB_HOST_KEY));
            System.out.println(prop.getProperty(Constants.DB_PORT_KEY));
            System.out.println(prop.getProperty(Constants.DB_NAME_KEY));

        } catch (IOException ex) {
            //TODO delete
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    //TODO delete
                    e.printStackTrace();
                }
            }
        }
    }

}
