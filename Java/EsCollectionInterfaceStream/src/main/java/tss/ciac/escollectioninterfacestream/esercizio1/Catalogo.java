/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tss.ciac.escollectioninterfacestream.esercizio1;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Paolo
 */
public class Catalogo<E extends Articolo> implements Iterable<E> {

    private final List<E> elencoArticoli;

    public Catalogo() {
        elencoArticoli= new ArrayList<>();
    }
    
    

    public void aggiungiArticolo(E art) {
        elencoArticoli.add(art);
    }

    /**
     *
     * @param prezzo
     * @return List elencoArticoli con prezzo inferiore al prezzo dato come
     * parametro
     */
    public List<E> getArticoliSottoPrezzo(double prezzo) {
        return elencoArticoli.stream()
                .filter(a->a.getPrezzo()<prezzo)
                .collect(Collectors.toList()); 
                // Collectors è una classe statica con metodi statici tra cui to list
        
        // ALTRI MODI DI FARLO MA IN PIU' RIGHE
        /*
        List<E> elencoArticoliSottoPrezzo = new ArrayList<>();
        Iterator<E> scorri = elencoArticoli.iterator();
        while (scorri.hasNext()) {
            E e = scorri.next();
            if (e.getPrezzo() < prezzo) {
                elencoArticoliSottoPrezzo.add(e);
            }
        }
        return elencoArticoliSottoPrezzo;
        */
        /*
        for (int i = 0; i < elencoArticoli.size(); i++) {
            if(elencoArticoli.get(i).getPrezzo()<prezzo){
                elencoArticoliSottoPrezzo.add(elencoArticoli.get(i));
            }
        }
        return elencoArticoliSottoPrezzo;
        */
        
    }

    @Override
    public String toString() {
        // return catalogo.toString();  //NB anche ArrayList ha un metodo toString che poteva essere utilizzato
        
        //return "Catalogo{" + "elencoArticoli=" + elencoArticoli + '}';
        
        return elencoArticoli.stream()
                .map(v->v.getNome()+" - "+v.getPrezzo()) 
                // map trasforma un tipo di flusso in un altro flusso 
                .collect(Collectors.joining(" || "));
    }

    @Override
    public Iterator<E> iterator() {
        return new elencoIterator();
    }

    private class elencoIterator implements Iterator<E> {

        private int current;

        public elencoIterator() {
            this.current = -1;
        }

        @Override
        public boolean hasNext() {
            return this.current < elencoArticoli.size() - 1;
        }

        @Override
        public E next() {
            return elencoArticoli.get(++current);
        }
    }
    
    public <E extends Articolo> Catalogo<E> sottoCatalogo(Class<E> clazz){
        Catalogo<E> result = new Catalogo<>();
        elencoArticoli.stream().filter(v->clazz.isInstance(v)).forEach(v->result.aggiungiArticolo((clazz.cast(v))));
        /*
        for(Articolo articolo : elencoArticoli){
            if(clazz.isInstance(articolo)){
                result.aggiungiArticolo((E)articolo);
            }
        }
        */
        return result;        
    }
    
}
