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
abstract class Veicolo {
    private int posizione = -1;
    private final String marca;
    private final int cilindrata;
    private final int anno;
    abstract String info();

    public Veicolo(String marca,int anno, int cilindrata) {
        this.marca = marca;
        this.anno = anno;
        this.cilindrata = cilindrata;
    }

    public String getMarca() {
        return marca;
    }

    public int getCilindrata() {
        return cilindrata;
    }

    public int getAnno() {
        return anno;
    }

    public int getPosizione() {
        return posizione;
    }

    public void setPosizione(int posizione) {
        this.posizione = posizione;
    }
    
    
}
