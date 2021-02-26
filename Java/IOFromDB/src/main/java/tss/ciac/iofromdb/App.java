/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tss.ciac.iofromdb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author tss
 */
public class App {

    private static final String DB_URL = "jdbc:mariadb://localhost:3306/parlamento"; // protocollo:sottoprotocollo://localhost:3306/nomeDb
    private static final String DB_USR = "tss";
    private static final String DB_PWD = "ghiglieno";
    private static final String SQL_QUERY_INSERT = "INSERT INTO `parlamento`.`argomenti` (`argomento`, `testo`, `macroargomento`, `fonti`) VALUES (?, ?, ?, ?)";
    private static final String SQL_QUERY_SELECT = "select `argomenti`.`argomento` AS `Argomento`,`commenti`.`datacommento` AS `Data Commento`,avg(`commenti`.`rating`) AS `Media Valutazioni` from (`argomenti` join `commenti` on(`commenti`.`idargomento` = `argomenti`.`idargomento`)) group by `argomenti`.`argomento` order by 'Argomento',`commenti`.`datacommento`,'Media Valutazioni'";

    public static void main(String[] args) {
        // try with resources
        try (
                Connection cn = DriverManager
                        .getConnection(App.DB_URL, App.DB_USR, App.DB_PWD); // stabilisco la connessione al db
                
                /* Aggiunge row in db parlamento tab argomenti */
                /* per cambiare funzione sostituire il commendo da multiriga riga con quello riga
                PreparedStatement insert = cn.prepareStatement(SQL_QUERY_INSERT);) {
                    try {
                        cn.setAutoCommit(false);
                        String testo = "Sed consectetur tempor elit a sodales. In hac habitasse platea dictumst. Maecenas fringilla nunc id nulla congue, ut molestie nisi ultricies. Duis at tempor ante. Duis malesuada porttitor semper. Etiam non ultrices lectus, nec dapibus nulla. Nunc pulvinar consequat nulla, eu ultrices odio bibendum eget. Praesent porttitor, augue nec vehicula viverra, elit sem hendrerit mi, auctor blandit nunc dolor id tellus. Maecenas dapibus metus eu aliquet pulvinar. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Cras aliquam posuere tincidunt. Fusce mi dolor, tincidunt ut congue sit amet, elementum eget purus.\n\nEtiam eleifend lorem purus, hendrerit bibendum orci imperdiet id. Ut ac purus ut ipsum sodales tempor. Duis quis urna nunc. Donec augue ante, finibus sed nunc ac, auctor fermentum lectus. Nulla egestas lacus sem, in gravida justo volutpat vel. Suspendisse justo orci, ornare quis nulla sit amet, pellentesque tincidunt velit. Suspendisse lobortis consectetur hendrerit. Donec commodo blandit urna volutpat varius. Suspendisse ut lorem pulvinar, varius mauris in, aliquam augue. Ut tristique scelerisque dictum.";
                        insert.setString(1, "Gestione Rifiuti"); // scrive nel primo punto interrogativo
                        insert.setString(2, testo); // scrive nel secondo
                        insert.setString(3, "Ambiente");
                        insert.setString(4, "https://www.lipsum.com/feed/html");
                        insert.executeUpdate(); // executeUpdate() esegue l'update (query che modifica il db) e ritorna il numero di righe aggiunte o modificate
                        cn.commit();

                    } catch (SQLException e) {
                        cn.rollback();
                        System.err.println(e.getMessage());
                    }
                */
                /*-------------------------------------------------------------------------*/
                /* Legge row in db parlamento tab utenti */
                // per cambiare funzione sostituire il commendo da riga con quello multiriga
                Statement cmd = cn.createStatement(); // creo uno statement (comando) della connessione (uso Statement quando non ho parti variabili altrimenti PreparedStatement)
                ResultSet rs = cmd.executeQuery(SQL_QUERY_SELECT);) { // executeQuery() esegue la query (non modifica il db) e ritorna un risultato ResultSet

                    System.out.println("----------------Media valutazioni-------------------");
                    while (rs.next()) {
                        System.out.println(rs.getString("Argomento") + " , "
                                + rs.getDate("Data Commento")
                                + " , " + rs.getFloat("Media Valutazioni"));
                    }
                //    
                } catch (SQLException e) {
                    System.err.println(e.getMessage());
                }

    }
    
    public static void stampaRisultato(ResultSet result) throws SQLException{
        ResultSetMetaData meta = result.getMetaData();
        int ncol = meta.getColumnCount();
        while(result.next()){
            for (int i = 0; i < ncol; i++) {
                if(meta.getColumnName(i).equals("java.lang.String")){
                    System.out.println(result.getString(i));
                }
                if(i<ncol){
                    System.out.print(" - ");
                }
            }
        }
    }
}
