/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.javafxjpa.business;

import it.tss.javafxjpa.gui.Messages;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.scene.control.Alert;

/**
 *
 * @author alfonso
 */
public class DbManager {

    public static void check() {
        try (
            Connection cn = DriverManager.getConnection(url(), usr(),pwd());) {
            Statement cmd = cn.createStatement();
            cmd.executeUpdate("create database if not exists " + dbname() + " character set UTF8");
            System.out.println("configuration ok...");
        } catch (SQLException e) {
            Messages.showMessage("DBError", "Impossibile connettersi al DB. Verificare la configurazione", Alert.AlertType.ERROR);
        }

    }

    public static String url() {
        return new StringBuilder("jdbc:")
                .append(PropertiesCache.getInstance().getProperty("db.type"))
                .append("://")
                .append(PropertiesCache.getInstance().getProperty("db.server"))
                .append(":")
                .append(PropertiesCache.getInstance().getProperty("db.port"))
                .toString();
    }

    public static String urlWithDb() {
        return new StringBuilder(url())
                .append("/")
                .append(dbname())
                .toString();
    }
    
    public static String usr() {
        return PropertiesCache.getInstance().getProperty("db.usr");
    }
    
    public static String pwd() {
        return PropertiesCache.getInstance().getProperty("db.pwd");
    }
    
    public static String dbname() {
        return PropertiesCache.getInstance().getProperty("db.name");
    }
    
    public static String driver(){
        switch(PropertiesCache.getInstance().getProperty("db.type")){
            case "mariadb":
                return "org.mariadb.jdbc.Driver";
            case "mysql":
                return "org.mariadb.jdbc.Driver";
             default:
                 return "";
        }
    }
    
    public static String dialect(){
        switch(PropertiesCache.getInstance().getProperty("db.type")){
            case "mariadb":
                return "org.hibernate.dialect.MariaDB103Dialect";
            case "mysql":
                return "org.hibernate.dialect.MySQL8Dialect";
             default:
                 return "";
        }
    }
    
    
}
