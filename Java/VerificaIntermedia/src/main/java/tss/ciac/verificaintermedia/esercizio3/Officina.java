/*
NB è possibile creare variabili del tipo di un'interfaccia ma non è possibile 
creare un'istanza di un'interfaccia

private Riparabile e = new Riparabile();            SBAGLIATO
private Riparabile o = new Tosaerba(............);  CORRETTO
private Tosaerba t = new Tosaerba(............);    CORRETTO
La differenza tra o e t sta nel fatto che o vede solo i metodi di o implementati
dalla classe Tosaerba mentre t vede tutti i metodi della classe Tosaeba

Può talvolta essere utile creare un'interfaccia al fine di avere un metodo 
comune a tutti gli oggetti che implementano l'interfaccia a prescindere dal tipo




 */
package tss.ciac.verificaintermedia.esercizio3;

import java.util.ArrayList;

/**
 *
 * @author Paolo
 */
public class Officina {

    private static ArrayList<Integer> numeriOrdini = new ArrayList<Integer>();
    private int nAttrezzi;
    private int numeroOrdine = 0;

    private void addOrdine() {
        if (numeriOrdini.size() < nAttrezzi) {
            numeriOrdini.add(numeroOrdine++);
        }
    }

    public void remOrdineIndex(int index) {
        numeriOrdini.remove(index);
    }

    public void remOrdine(int nOrdine) {
        boolean trovato = false;
        for (int i = 0; i < numeriOrdini.size(); i++) {
            if (nOrdine == numeriOrdini.get(i)) {
                numeriOrdini.remove(i);
                trovato = true;
            }
        }
        if (!trovato) {
            throw new ArrayIndexOutOfBoundsException("Inserito ordine non in elenco");
        }
    }

    public void remOrdine(Decespugliatore d) {
        numeriOrdini.remove(d.getNumeroOrdine());
    }

    public void remOrdine(Motozappa m) {
        numeriOrdini.remove(m.getNumeroOrdine());
    }

    public void remOrdine(Tosaerba t) {
        numeriOrdini.remove(t.getNumeroOrdine());
    }

    public Motozappa creaMotozappa(int numeroRuote, Marca marca) {
        addOrdine();
        return new Motozappa(numeroOrdine, numeroRuote, marca);
    }

    public Tosaerba creaTosaerba(int numeroRuote, Marca marca) {
        addOrdine();
        return new Tosaerba(numeroOrdine, numeroRuote, marca);
    }

    public Decespugliatore creaDecespugliatore(boolean accensioneElettronica, Marca marca) {
        addOrdine();
        return new Decespugliatore(numeroOrdine, accensioneElettronica, marca);
    }

    public Officina(int nAttrezzi) {
        this.nAttrezzi = nAttrezzi;
    }

}
