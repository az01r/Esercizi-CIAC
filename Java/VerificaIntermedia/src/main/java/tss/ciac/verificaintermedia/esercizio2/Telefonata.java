/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tss.ciac.verificaintermedia.esercizio2;

/**
 *
 * @author Paolo
 */
public class Telefonata {
    private final int durata;
    private final String numeroDestinatario;
    
    public Telefonata(String numeroDestinatario,int durata){
        this.numeroDestinatario=numeroDestinatario;
        this.durata=durata;
    }

    public int getDurata() {
        return durata;
    }

    public String getNumeroDestinatario() {
        return numeroDestinatario;
    }
    
    
}
