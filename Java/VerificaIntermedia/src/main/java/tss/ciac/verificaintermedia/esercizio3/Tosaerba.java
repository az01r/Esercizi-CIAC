/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tss.ciac.verificaintermedia.esercizio3;

import java.util.ArrayList;

/**
 *
 * @author Paolo
 */
public class Tosaerba implements Riparabile {

    private final int numeroOrdine;
    private final int nRuote;
    private float costoTotaleRiparazioni = 0;
    private final Marca marca;
    private ArrayList<Riparazione> riparazioni = new ArrayList<Riparazione>();

    private void calcolaCostoTotaleRiparazioni() {
        costoTotaleRiparazioni = 0;
        for (Riparazione r : riparazioni) {
            costoTotaleRiparazioni += r.getCosto();
        }
    }

    public Tosaerba(int numeroOrdine, int nRuote, Marca marca) {
        this.numeroOrdine = numeroOrdine;
        this.nRuote = nRuote;
        this.marca = marca;
    }

    @Override
    public int getNumeroOrdine() {
        return numeroOrdine;
    }

    public int getnRuote() {
        return nRuote;
    }

    @Override
    public float getCostoTotaleRiparazioni() {
        calcolaCostoTotaleRiparazioni();
        return costoTotaleRiparazioni;
    }

    @Override
    public Marca getMarca() {
        return marca;
    }

    @Override
    public ArrayList<Riparazione> getRiparazioni() {
        return riparazioni;
    }

    @Override
    public void addRiparazione(Riparazione r) {
        riparazioni.add(r);
    }

    @Override
    public void remRiparazione(int i) {
        riparazioni.remove(i);
    }
}
