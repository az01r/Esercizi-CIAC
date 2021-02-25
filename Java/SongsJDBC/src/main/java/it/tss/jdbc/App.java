/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author tss
 */
public class App {
    public static void main(String[] args) throws SQLException {
        Connection cn = DriverManager
                .getConnection("jdbc:mariadb://localhost:3306/songs","tss","ghiglieno");
        
        System.out.println("connessione ok.....");
        
        System.out.println("----------- nuova canzone ---------------------");
        Scanner sc = new Scanner(System.in);
        
        System.out.println("dimmi il titolo");
        String titolo = sc.nextLine();
        
        System.out.println("dimmi l'artista");
        String artista = sc.nextLine();
        
        System.out.println("dimmi l'album");
        String album = sc.nextLine();
        
        
        Statement cmd = cn.createStatement();
        
        /*
        //Query statica 
        String insertSongSQLOld = "INSERT INTO song (title, artist, album) "
                 + "VALUES ('image', 'john lennon', 'image')";
        
        //Query dinamica ottenuta tramite concatenazione di stringhe
        String insertSongSQL = "INSERT INTO song (title, artist, album) VALUES ('" +
                titolo + "', '" + 
                artista + "', '" +
                album + "')";
        
        cmd.executeUpdate(insertSongSQL);
        */
        
        PreparedStatement pcmd = cn.prepareStatement("INSERT INTO song (title, artist, album) "
                + "VALUES (?, ?, ?)");
        
        pcmd.setString(1, titolo);
        pcmd.setString(2, artista);
        pcmd.setString(3, album);

        pcmd.executeUpdate();
        
        ResultSet rs = cmd.executeQuery("select * from song order by artist");
        
        System.out.println("-------------- elenco song ---------------------");
        System.out.println("");
        while(rs.next()){
            System.out.println(rs.getInt("id") + "," 
                    + rs.getString("title")
                    + "," + rs.getString("artist"));
        }
        
        rs.close();
        
        
        System.out.println("-------------------- ricerca per artista ----------");
        
        System.out.println("scrivi cosa vuoi ricercare");
        
        String search = sc.nextLine();
                
        pcmd = cn.prepareStatement("select * from song where artist like ?");
        pcmd.setString(1, "%" + search + "%");
        rs = pcmd.executeQuery();
        System.out.println("------------ risultato ricerca ------------------");
        while(rs.next()){
            System.out.println(rs.getInt("id") + "," 
                    + rs.getString("title")
                    + "," + rs.getString("artist"));
        }
        
        rs.close();
        //Chiudo la connessione
        cn.close();
    }
}
