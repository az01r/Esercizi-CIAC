/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esercizio4;

import esercizio3.*;

/**
 *
 * @author alfonso
 */
public class Lavorazione {
    
    public static enum Tipo{
        TAGLIANDO, SOSTITUZIONE_CANDELA, ALTRO
    } 
    
    private final Tipo tipo;
    
    private final float costo;

    public Lavorazione(Tipo tipo, float costo) {
        this.tipo = tipo;
        this.costo = costo;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public float getCosto() {
        return costo;
    }

    
    @Override
    public String toString() {
        return "Lavorazione{" + "tipo=" + tipo + ", costo=" + costo + '}';
    }
    
    
}
