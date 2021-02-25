/*
Definire una interfaccia Articolo che rappresenta articoli commerciali, dotata dei metodi: • String getNome() che restituisce il nome dell'articolo  
• double getPrezzo() che restituisce il prezzo dell'articolo 
• String toString() che restituisce una descrizione (nome e prezzo) dell'articolo.  
Scrivere una classe generica Catalogo<E extends Articolo> che rappresenta un catalogo di  articoli commerciali. La classe memorizza gli articoli in una lista ed è dotata dei metodi: 
• void aggiungiArticolo(E art) 
◦ che aggiunge un articolo al catalogo 
• List<E> getArticoliSottoPrezzo(double prezzo) 
◦ che restituisce una lista degli articoli il cui prezzo è minore del valore passato come  parametro 
• String toString()  
◦ che stampa l'intero catalogo. 
Catalogo deve inoltre fornire la possibilità di visitare i propri articoli tramite un iteratore  implementando l’interfaccia Iterable

 */
package tss.ciac.escollectioninterfacestream.esercizio1;

import java.util.Iterator;

/**
 *
 * @author Paolo
 */
public class App {
    public static void main(String[] args) {
        
    }
}
