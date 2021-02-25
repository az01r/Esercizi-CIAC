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
public class App {
    public static void main(String[] args) {
        Officina o = new Officina(10);
        Motozappa m = o.creaMotozappa(2, Marca.FIAT);
        Decespugliatore d = o.creaDecespugliatore(true, Marca.FIAT);
        Tosaerba t = o.creaTosaerba(4, Marca.JOHNDEER);
        m.addRiparazione(new Riparazione("Cambio candela", 10));
        m.addRiparazione(new Riparazione("cambio lame", 40));
        System.out.println("Costo riparazioni motozappa m: "+m.getCostoTotaleRiparazioni());
        o.remOrdine(m);
        o.remOrdine(t);
        o.remOrdine(d.getNumeroOrdine());
    }
}
