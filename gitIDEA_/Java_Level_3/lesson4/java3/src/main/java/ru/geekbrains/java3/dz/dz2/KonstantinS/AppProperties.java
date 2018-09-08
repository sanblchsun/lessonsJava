package ru.geekbrains.java3.dz.dz2.KonstantinS;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 *
 * @author frair
 */
public class AppProperties {

    synchronized public static String readProperties(String propertyName) {
        Properties prop = new Properties();
        InputStream input = null;

        try {

            input = new FileInputStream("resources/dz2.properties");
            // load a properties file
            prop.load(input);
            // get the property value and print it out
            return prop.getProperty(propertyName);

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
        return null;
    }
}
