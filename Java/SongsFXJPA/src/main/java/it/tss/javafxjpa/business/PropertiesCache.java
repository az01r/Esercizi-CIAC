/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.javafxjpa.business;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Properties;
import java.util.Set;

/**
 *
 * @author alfonso
 */
public class PropertiesCache {

    private final Properties configProp = new Properties();

    private PropertiesCache() {
        //Private constructor to restrict new instances
        InputStream in = this.getClass().getResourceAsStream("application.properties");
        System.out.println("Reading all properties from the file");
        try {
            configProp.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Bill Pugh Solution for singleton pattern
    private static class LazyHolder {

        private static final PropertiesCache INSTANCE = new PropertiesCache();
    }

    public static PropertiesCache getInstance() {
        return LazyHolder.INSTANCE;
    }

    public String getProperty(String key) {
        return configProp.getProperty(key);
    }

    public Set<String> getAllPropertyNames() {
        return configProp.stringPropertyNames();
    }

    public boolean containsKey(String key) {
        return configProp.containsKey(key);
    }

    public void setProperty(String key, String value) {
        configProp.setProperty(key, value);
    }

    public void flush() throws FileNotFoundException, IOException, URISyntaxException {
        System.out.println("flush..");
        URL resourceUrl = this.getClass().getResource("application.properties");
        File file = new File(resourceUrl.toURI());
        try (OutputStream outputstream = new FileOutputStream(file);) {
            configProp.store(outputstream, "File Updated");
        }
    }
}
