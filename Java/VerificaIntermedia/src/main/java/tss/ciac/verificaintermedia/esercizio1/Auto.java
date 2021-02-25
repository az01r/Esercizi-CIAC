/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tss.ciac.verificaintermedia.esercizio1;

enum Alimentazione {
    DIESEL,
    BENZINA,
    ELETTRICA,
    IBRIDA
}

/**
 *
 * @author Paolo
 */
public class Auto extends Veicolo {

    private final int nPorte;
    private final Alimentazione alimentazione;

    public Auto(int nPorte, Alimentazione alimentazione, String marca, int anno, int cilindrata) {
        super(marca, anno, cilindrata);
        this.nPorte = nPorte;
        this.alimentazione = alimentazione;
    }

    public int getnPorte() {
        return nPorte;
    }

    public Alimentazione getAlimentazione() {
        return alimentazione;
    }
    
    @Override
    String info() {
        return "Marca: " + this.getMarca() + "\nAnno: " + this.getAnno() + "\nCilindrata: " + this.getCilindrata() +  "\nNumero porte: " + nPorte+ "\nAlimentazione: "+alimentazione + "Parcheggio: " + this.getPosizione() + "\n";
    }
}
