/*
Sia definita una classe Mobile che implementa l'interfaccia Articolo definita 
nell'esercizio  precedente e rappresenta articoli per arredamento. La classe 
Mobile definisce i metodi: • int getLarghezza() 
• int getAltezza() 
• int getProfondita() che restituiscono le dimensioni di un mobile.  
Scrivere una classe ProvaMobile dotata di un metodo scegliMobile che riceve in 
ingresso un  catalogo di oggetti di tipo Mobile(o suoi sotto-tipi), un prezzo e 
tre dimensioni (larghezza,  altezza, profondità) e restituisce un lista di 
mobili il cui prezzo è inferiore al prezzo dato e le cui  dimensioni sono 
inferiori alle dimensioni date. 
 */
package tss.ciac.escollectioninterfacestream.esercizio2;

import tss.ciac.escollectioninterfacestream.esercizio1.Articolo;

/**
 *
 * @author Paolo
 */
public class Mobile implements Articolo {

    private final String nome;
    private final double prezzo;
    private final int larghezza;
    private final int altezza;
    private final int profondita;

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public double getPrezzo() {
        return prezzo;
    }

    public int getLarghezza() {
        return larghezza;
    }

    public int getAltezza() {
        return altezza;
    }

    public int getProfondita() {
        return profondita;
    }

    public Mobile(String nome, double prezzo, int larghezza, int altezza, int profondita) {
        this.nome = nome;
        this.prezzo = prezzo;
        this.larghezza = larghezza;
        this.altezza = altezza;
        this.profondita = profondita;
    }

}
