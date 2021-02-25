/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads.esempio3;

import java.util.LinkedList;

/**
 *
 * @author tss
 */
public class Coda {
    private final int capacita;
    private final LinkedList<String> coda;
    private int nProd, nCons; // contatori per tutte le volte che un produttore o un consumatore sono messi in attesa

    public Coda(int capacita) {
        this.capacita = capacita;
        this.coda= new LinkedList<String>();
    }
    
    public synchronized void aggiungi(String s)throws InterruptedException{ // synchronized - se libero prende il lock se no aspetta
        while (coda.size()==capacita) { // non è if perchè le condizioni variano (i consumatori tolgono dalla coda)
            nProd++; // c'è un produttore in attesa
            wait(); // lascia il lock
        }
        coda.add(s);
        notifyAll();
    }
    
    public synchronized String togli() throws InterruptedException{ // synchronized - se libero prende il lock se no aspetta
        while (coda.isEmpty()) { // non è if perchè le condizioni variano (i consumatori tolgono dalla coda)
            nCons++; // c'è un consumatore in attesa
            wait(); // lascia il lock
        }
        String s = coda.remove(); // rimuove il primo e lo ritorna
        notifyAll();
        return s;
    }

    @Override
    public String toString() {
        return String.format("Numero attese produttori: %d - Numero attese consumatori: %d", nProd,nCons);
    }
    
    
    
}
