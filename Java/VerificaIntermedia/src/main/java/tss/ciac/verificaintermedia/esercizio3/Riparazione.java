/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tss.ciac.verificaintermedia.esercizio3;

/**
 *
 * @author Paolo
 */
public class Riparazione {

    private String riparazione = "";
    private final float costo;

    public String getRiparazione() {
        return riparazione;
    }

    public float getCosto() {
        return costo;
    }
    
    public Riparazione(String riparazione, float costo) {
        this.riparazione = riparazione;
        this.costo = costo;
    }

    
}
