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

    public static void check() throws SQLException {
            Connection cn = DriverManager.getConnection(urlDefault());
            Statement cmd = cn.createStatement();
            cmd.executeUpdate("create database if not exists " + dbname() + " character set UTF8");
            System.out.println("configuration ok...");
    }

    public static String urlDefault() {
        return new StringBuilder("jdbc:")
                .append(PropertiesCache.getInstance().getProperty("db.type").trim())
                .append("://")
                .append(PropertiesCache.getInstance().getProperty("db.server").trim())
                .append(":")
                .append(PropertiesCache.getInstance().getProperty("db.port").trim())
                .append("/mysql")
                .append(urlParams())
                .toString();
    }

    public static String urlWithDb() {
        return new StringBuilder("jdbc:")
                .append(PropertiesCache.getInstance().getProperty("db.type").trim())
                .append("://")
                .append(PropertiesCache.getInstance().getProperty("db.server").trim())
                .append(":")
                .append(PropertiesCache.getInstance().getProperty("db.port").trim())
                .append("/")
                .append(dbname())
                .append(urlParams())
                .toString();
    }

    public static String urlParams() {
        return new StringBuilder()
                .append("?user=").append(usr())
                .append("&password=").append(pwd())
                .append(options().isEmpty() ? "" : options())
                .toString();
    }

    public static String usr() {
        return PropertiesCache.getInstance().getProperty("db.usr").trim();
    }

    public static String pwd() {
        return PropertiesCache.getInstance().getProperty("db.pwd").trim();
    }

    public static String dbname() {
        return PropertiesCache.getInstance().getProperty("db.name").trim();
    }

    public static String driver() {
        switch (PropertiesCache.getInstance().getProperty("db.type").trim()) {
            case "mariadb":
                return "org.mariadb.jdbc.Driver";
            case "mysql":
                return "com.mysql.jdbc.Driver"; //per la 8..  com.mysql.cj.jdbc.Driver
            default:
                return "";
        }
    }

    public static String dialect() {
        switch (PropertiesCache.getInstance().getProperty("db.type").trim()) {
            case "mariadb":
                return "org.hibernate.dialect.MariaDB103Dialect";
            case "mysql":
                return "org.hibernate.dialect.MySQL8Dialect";
            default:
                return "";
        }
    }

    public static String options() {
        return PropertiesCache.getInstance().getProperty("db.options").trim();
    }

}
