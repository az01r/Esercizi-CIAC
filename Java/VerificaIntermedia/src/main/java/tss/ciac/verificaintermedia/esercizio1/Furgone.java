/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tss.ciac.verificaintermedia.esercizio1;

/**
 *
 * @author Paolo
 */
public class Furgone extends Veicolo {

    private final int capienza;

    public Furgone(int capienza, String marca, int anno, int cilindrata) {
        super(marca, anno, cilindrata);
        this.capienza = capienza;
    }

    public int getCapienza() {
        return capienza;
    }

    @Override
    String info() {
        return "Marca: " + this.getMarca() + "\nAnno: " + this.getAnno() + "\nCilindrata: " + this.getCilindrata() +  "\nCapienza: "+capienza + "Parcheggio: " + this.getPosizione() + "\n";
    }
}
