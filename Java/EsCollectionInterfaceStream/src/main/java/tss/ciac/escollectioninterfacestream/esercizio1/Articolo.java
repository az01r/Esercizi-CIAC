/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tss.ciac.escollectioninterfacestream.esercizio1;

/**
 *
 * @author Paolo
 */
public interface Articolo {
    String getNome();
    double getPrezzo();
    /**
     * 
     * @return descrizione (nome e prezzo) dell'articolo
     */
    @Override
    String toString();
}
