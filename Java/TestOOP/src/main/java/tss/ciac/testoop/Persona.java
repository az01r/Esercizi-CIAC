/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tss.ciac.testoop;

/**
 *
 * @author Paolo
 */
public class Persona {
    private String nominativo;
    private String email;

    public Persona() {
    }

    public Persona(String nominativo) {
        this.nominativo = nominativo;
    }

    public String getNominativo() {
        return nominativo;
    }

    public String getEmail() {
        return email;
    }

    public void setNominativo(String nominativo) {
        this.nominativo = nominativo;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
