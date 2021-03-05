/*
 * La classe App con il metodo main presenta esempi di uso dei metodi principali.
 */
package it.tss.banksystem.services;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author tss
 */
public class Bank {

    private final String name;
    private final HashMap<Integer, Account> accountsMap = new HashMap<Integer, Account>();

    public Bank(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    /**
     *
     * @param owner
     * @param amount credito versamento iniziale
     * @return int accountCode
     * @throws it.tss.banksystem.services.InvalidValue
     */
    public int createAccount(String owner, float amount) throws InvalidValue {
        Account a = new Account(owner, LocalDate.now(), amount);
        int accountCode = a.getAccountCode();
        accountsMap.put(accountCode, a);
        return accountCode;
    }

    /**
     *
     * @param accountCode
     * @return Account
     * @throws InvalidCode
     */
    public Account getAccount(int accountCode) throws InvalidCode {
        Account a = accountsMap.get(accountCode);
        if (a == null) {
            throw new InvalidCode();
        }
        return a;
    }

    /**
     * versamento
     *
     * @param accountCode
     * @param date
     * @param amount
     * @throws InvalidCode
     * @throws InvalidValue
     */
    public void deposit(int accountCode, LocalDate date, float amount) throws InvalidCode, InvalidValue {
        Account a = getAccount(accountCode);
        /* controllo implementato in addOperation()
        if(date.isBefore(a.getLastOperation())){
            date=a.getLastOperation();
        }*/
        a.addOperation(new Deposit(date, amount));
    }

    /**
     * prelievo
     *
     * @param accountCode
     * @param date
     * @param amount
     * @throws InvalidCode
     * @throws InvalidValue
     */
    public void withdrawal(int accountCode, LocalDate date, float amount) throws InvalidCode, InvalidValue {
        Account a = getAccount(accountCode);
        /* 
        if(a.getBalance()<amount){
            throw new InvalidValue();
        }*/
        if (date.isBefore(a.getLastOperation())) {
            date = a.getLastOperation();
        }
        a.addOperation(new Withdrawal(date, amount));
    }

    /**
     * trasferisce denaro da un account (conto) a un altro
     *
     * @param giver
     * @param receiver
     * @param date
     * @param amount
     * @throws InvalidCode
     * @throws InvalidValue
     */
    public void transfer(int giver, int receiver, LocalDate date, float amount) throws InvalidCode, InvalidValue {
        Account g = getAccount(giver);
        Account r = getAccount(receiver);
        if (g.getBalance() < amount) {
            throw new InvalidValue();
        }
        if (date.isBefore(g.getLastOperation())) {
            date = g.getLastOperation();
        }
        if (date.isBefore(r.getLastOperation())) {
            date = r.getLastOperation();
        }
        g.addOperation(new Withdrawal(date, amount));
        r.addOperation(new Deposit(date, amount));
    }

    /**
     *
     * @param accountCode
     * @param date
     * @return l'Account appena cancellato dalla mappa della banca
     * @throws InvalidCode
     * @throws InvalidValue
     */
    public Account deleteAccount(int accountCode, LocalDate date) throws InvalidCode, InvalidValue {
        Account a = getAccount(accountCode);
        a.addOperation(new Withdrawal(date, a.getBalance()));
        accountsMap.remove(accountCode);
        return a;
    }

    /**
     *
     * @return l’ammontare di tutto il denaro attualmente depositato presso la
     * banca (somma dei saldi di ogni conto corrente)
     */
    public float getTotalDeposit() {
        float ris = 0;
        for (Account a : accountsMap.values()) {
            ris += (a.getBalance());
        }
        return ris;
    }

    /**
     *
     * @return la lista di tutti i conti correnti attualmente aperti, ordinati
     * per numero di conto crescente;
     */
    public List getAccounts() {
        Comparator<Account> comparatore = new Comparator<Account>() {
            @Override
            public int compare(Account t, Account t1) {
                int ris;
                if (t.getBalance() < (t1.getBalance())) {
                    ris = -1;
                } else if (t.getBalance() > (t1.getBalance())) {
                    ris = 1;
                } else {
                    ris = 0;
                }
                return ris;
            }
        };
        return accountsMap.values().stream().sorted(comparatore).collect(Collectors.toList());
    }

    /**
     *
     * @param from
     * @param to
     * @return la lista dei conti correnti con un saldo attuale compreso
     * nell’intervallo, ordinati per valori di saldo decrescenti
     */
    public List getAccountsByBalance(float from, float to) {
        Comparator<Account> comparatore = new Comparator<Account>() {
            @Override
            public int compare(Account t, Account t1) {
                int ris;
                if (t.getBalance() < (t1.getBalance())) {
                    ris = -1;
                } else if (t.getBalance() > (t1.getBalance())) {
                    ris = 1;
                } else {
                    ris = 0;
                }
                return ris;
            }
        };
        return accountsMap.values().stream().filter(v -> ((v.getBalance() < to) && (v.getBalance() > from))).sorted(comparatore).collect(Collectors.toList());
    }

    /**
     * 
     * @param amount
     * @return la percentuale dei conti correnti con un saldo attuale non
     * inferiore all’importo dato.
     *
     */
    public float getPerCentHigher(float amount) {
        float sum;
        int tot = 0;
        int n = 0;
        for (Account a : accountsMap.values()) {
            if (a.getBalance() > amount) {
                n++;
            }
            tot++;
        }

        return n * 100 / tot;
    }
}
