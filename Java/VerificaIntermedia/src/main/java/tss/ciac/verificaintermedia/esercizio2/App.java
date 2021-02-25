/*
E' necessario scrivere una applicazione che simula il funzionamento di un  frammento del sistema informativo di un operatore di telefonia cellulare. 
Si devono quindi rappresentare i dati relativi ad una carta SIM ed in  particolare: 
il numero di telefono 
il credito disponibile in euro  
la lista delle telefonate effettuate  

Per ciascuna telefonata deve essere rappresentata la durata in minuti  

La classe SIM dovrà fornire le seguenti funzionalità: 
- un costruttore parametrizzato che crea una SIM con numero di telefono, un  credito e la lista delle telefonate vuota
- un metodo per l'inserimento di una telefonata con i dati forniti dall'utente. 
- una funzione per il calcolo dei minuti totali di conversazione.  
- una funzione per il calcolo delle telefonate effettuate verso un certo numero 
- una procedura per la stampa dei dati della SIM e l'elenco delle telefonate.
 */
package tss.ciac.verificaintermedia.esercizio2;

/**
 *
 * @author Paolo
 */
public class App {
    public static void main(String[] args) {
        
        Sim sim = new Sim("3450000000", 50);
        sim.addTelefonata("3450000001", 3);
        sim.addTelefonata("3450000002", 5);
        sim.addTelefonata("3450000001", 4);
        System.out.println("Minuti chiamate con 3450000001: "+sim.minutiConDestinatario("3450000001"));
        System.out.println("Totale minuti chiamate: "+sim.minutiTotati());
        sim.printInfo();
        
        
    }
}
