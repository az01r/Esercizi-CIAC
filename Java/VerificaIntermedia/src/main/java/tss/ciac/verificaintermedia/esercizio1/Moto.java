/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tss.ciac.verificaintermedia.esercizio1;

enum Tempi {
    DUE,
    QUATTRO
}

/**
 *
 * @author Paolo
 */
public class Moto extends Veicolo {

    private final Tempi tempi;

    public Moto(Tempi tempi, String marca, int anno, int cilindrata) {
        super(marca, anno, cilindrata);
        this.tempi = tempi;
    }

    public Tempi getTempi() {
        return tempi;
    }

    @Override
    String info() {
        return "Marca: " + this.getMarca() + "\nAnno: " + this.getAnno() + "\nCilindrata: " + this.getCilindrata() + "\nTempi: " + tempi + "Parcheggio: " + this.getPosizione() + "\n";
    }
}
