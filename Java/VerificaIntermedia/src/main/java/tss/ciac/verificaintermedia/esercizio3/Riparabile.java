/*
All'aggiusteria agricola possono essere riparati tre tipi di apparecchiature:  
motozappe, decespugliatori, tosaerba. 
Ciascuna di queste macchine, ha dei dati comuni:

- Un numero intero che costituisce il numero d'ordine della lavorazione, 
ogni volta che una macchina viene consegnata all'aggiusteria acquisisce un 
nuovo numero d'ordine, anche se quella macchina è già stata lì in precedenza. 
- Deve essere specificata la marca dell'apparecchio.  
- Ad ogni macchina deve essere associato il totale del costo di riparazione. 

Per i tosaerba e le motozappe va specificato il numero di ruote della macchina. 
Per i decespugliatori bisogna specificare se l'accensione è elettronica 
oppure no. 

Costruire una opportuna gerarchia di classi, strutturando 
correttamente la base dei dati. Il massimo numero di macchine che possonono 
essere simultaneamente in lavorazione è 10 perché questi sono i posti in 
officina. Ad ogni macchina riparata, deve essere associata una lista delle 
lavorazioni effettuate e del loro costo, la cui somma costituisce il totale 
del costo della riparazione.
 */
package tss.ciac.verificaintermedia.esercizio3;

import java.util.ArrayList;

/**
 *
 * @author Paolo
 */
enum Marca {
    FIAT,
    LAMBORGHINI,
    JOHNDEER
}

public interface Riparabile {

    public abstract Marca getMarca();

    public abstract float getCostoTotaleRiparazioni();

    public abstract int getNumeroOrdine();

    public abstract ArrayList<Riparazione> getRiparazioni();

    public abstract void addRiparazione(Riparazione r);

    public abstract void remRiparazione(int i);
}
