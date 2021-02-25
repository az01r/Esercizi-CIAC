/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tss.ciac.esempiochat;

/**
 *
 * @author tss
 */
public class User {

    private String userName;
    private String password;
    private String nome;
    private String cognome;
    private String email;
    
    
    /**
     * costruttore di User
     * 
     * @param userName
     * @param password
     * @param nome
     * @param cognome
     * @param email 
     */
    public User(String userName, String password, String nome, String cognome, String email) {
        this.userName = userName;
        this.password = password;
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
    }
    
    /**
     * costruttore di User
     * 
     * @param userName
     * @param password 
     */
    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
        this.nome = "Non inserito";
        this.cognome = "Non inserito";
        this.email = "Non inserita";
    }

    // getter & setter
    // non ci sono il get di password e il set di userName
    public String getUserName() {
        return userName;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String password) {
        this.password = password;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 
     * @return String info user 
     */
    public String infoUser(){
        String tx = "Username: "+userName+"\nNome: "+nome+"\nCognome: "+cognome+"\nEmail: "+email+"\n";
        return tx;
    }
    
    public String infoUserCSW(){
        String tx = userName+";"+nome+";"+cognome+";"+email+"\n";
        return tx;
    }
}
