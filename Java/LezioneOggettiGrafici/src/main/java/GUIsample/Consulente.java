
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUIsample;

/**
 *
 * @author tss
 */
public class Consulente {
    private String nome;
    private String cognome;
    private float costo;

    public Consulente(String nome, String cognome, float costo) {
        this.nome = nome;
        this.cognome = cognome;
        this.costo = costo;
    }

    public Consulente() {
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public float getCosto() {
        return costo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setCosto(float costo) {
        this.costo = costo;
    }
    
    public String infoHtml(){
        String tx="<html>";
        tx+="Nome: <b>"+nome+"</b><br>";
        tx+="Cognome: <b>"+cognome+"</b><br>";
        tx+="Costo: <b>"+costo+"</b></html>";
        return tx;
    }
    
}
