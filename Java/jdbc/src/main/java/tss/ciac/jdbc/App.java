/*
I db non sono mai collegati direttamente a internet ma sono collegati ad un server tramite una connessione privata (porta 3306 sempre chiusa)
Questo perchè non si può lasciare scoperta le stringhe utente e password non criptate sulla rete
Per accedere al db ci sono quindi 2 metodologie:
1. usare ssh (tool di linux) per collegarsi al server (tramite chiave privata/pubblica) il quale si collegherà al db
2. installare sul server un'applicazione che usa la porta standard per internet, la 8086,
   in questo modo si ha un'interfaccia grafica data dall'applicazione.
   L'utente si collegherè quindi all'applicazione e solo questa, dal server, al db
 */
package tss.ciac.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author tss
 */
public class App {

    
    private static final String DB_URL = "jdbc:mariadb://localhost:3306/classicmodels";
    private static final String DB_USR = "tss";
    private static final String DB_PWD = "ghiglieno";
    private static final String SQL_QUERY = "select customerName, city, state from customers where state like 'NY'";
    
    public static void main(String[] args) {
        // try with resources
        try (
                Connection cn = DriverManager
                        .getConnection(App.DB_URL, App.DB_USR, App.DB_PWD);
                Statement cmd = cn.createStatement();
                ResultSet rs = cmd.executeQuery(App.SQL_QUERY);
                PreparedStatement insert = cn.prepareStatement("INSERT INTO `classicmodels`.`productlines` (`productLine`, `textDescription`) VALUES (?, ?)");
                
               
            )   {
                    //ResultSetMetaData md = rs.getMetaData(); per ricavare info dal db
                    try {
                        cn.setAutoCommit(false);
                        for(int i = 0;i<5;i++){
                            String key = "prova" + i;
                            insert.setString(1, key); // scrive nel primo punto interrogativo
                            insert.setString(2, "prova insert"); // scrive nel secondo
                            insert.executeUpdate();
                            //cmd.executeUpdate("insert into productlines (productLine,textDescription ) values ('" + key + "', 'prova insert')");
                            //cmd.executeUpdate("delete from productlines where productLine = '" + key + "'");
                        }
                        cn.commit();
                        
                    } catch (SQLException e) {
                        cn.rollback();
                        System.out.println(e.getMessage());
                    }

                    while (rs.next()) {
                        System.out.println(String.format("nome: %s , citta: %s, stato: %s",
                                rs.getString("customerName"), rs.getString("city"), rs.getString("state")));
                    }
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }

    }

}

/* 
    usando un try with resources viene tutto chiuso in automatico
    rs.close();
    cmd.close();
    cn.close();
 */
