/*
 *   creare classi apposite con solo gli attributi che voglio restituire e usare
 *   queste per rispondere alle chiamate dei servizi. In questo modo Swagger 
 *   crea la documentazione autonomamente senza dover usare due tipi di annotazioni
 * 
 * In questo progetto abbiamo scelto quest'ultima strada
 */
package it.tss.banksystem.bank.boundary.dto;

/**
 *
 * @author Paolo
 */
public class AccountCreate {
    public double amount;
    public int overDraft;

    public AccountCreate() {
    }

    public AccountCreate(double amount, int overDraft) {
        this.amount = amount;
        this.overDraft = overDraft;
    }
    
    
}
