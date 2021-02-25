/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esercizio1;

/**
 *
 * @author alfonso
 */
public class Auto extends Veicolo {
    
    public static enum Alimentazione{
        BENZINA,DIESEL
    }
    
    private final int porte;
    private final Alimentazione alimentazione;

    public Auto(int porte, Alimentazione alimentazione, String marca, int anno, int cilindrata) {
        super(marca, anno, cilindrata);
        this.porte = porte;
        this.alimentazione = alimentazione;
    }

    public int getPorte() {
        return porte;
    }

    public Alimentazione getAlimentazione() {
        return alimentazione;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + "Auto{" + "porte=" + porte + ", alimentazione=" + alimentazione + '}';
    }
    
    
    
}
