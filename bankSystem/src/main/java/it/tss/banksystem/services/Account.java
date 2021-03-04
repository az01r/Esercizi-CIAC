/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.banksystem.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author tss
 */
public final class Account {

    private final String owner;
    private final int accountCode;
    private LocalDate lastOperation;
    private static int counter = 0;
    private List<Operation> operations = new ArrayList<>();
    private float balance;

    public Account(String owner, LocalDate date, float amount) throws InvalidValue {
        this.owner = owner;
        this.accountCode = ++counter;
        this.addOperation(new Deposit(date, amount));
    }

    public String getOwner() {
        return owner;
    }

    public int getAccountCode() {
        return accountCode;
    }

    public LocalDate getLastOperation() {
        return lastOperation;
    }

    public float getBalance() {
        return balance;
    }

    /**
     * metodo usato implicitamente dai metodi deposit() e withdrawsal() di bank
     * @param o
     * @throws InvalidValue 
     */
    public void addOperation(Operation o) throws InvalidValue {
        operations.add(o);
        lastOperation = o.getDate();
        if (o instanceof Deposit) {
            balance += o.getAmount();
        } else {
            if (o.getAmount() > balance) {
                throw new InvalidValue();
                    
            } else {
                balance -= o.getAmount();
            }
        }
    }

    @Override
    public String toString() {
        return accountCode + "," + owner + "," + lastOperation + "," + balance;
    }

    /**
     *
     * @return la lista di tutte le operazioni effettuate, ordinate per date
     * decrescenti
     */
    public List getMovements() {
        Comparator<Operation> comparatore = new Comparator<Operation>() {
            @Override
            public int compare(Operation t, Operation t1) {
                int ris;
                if (t.getDate().isBefore(t1.getDate())) {
                    ris = -1;
                } else if (t.getDate().isAfter(t1.getDate())) {
                    ris = 1;
                } else {
                    ris = 0;
                }
                return -ris;
            }
        };
        return operations.stream().sorted(comparatore).collect(Collectors.toList());
    }

    /**
     *
     * @return la lista di tutti i versamenti effettuati, ordinati per importi
     * decrescenti
     */
    public List getDeposits() {
        Comparator<Operation> comparatore = new Comparator<Operation>() {
            @Override
            public int compare(Operation t, Operation t1) {
                int ris;
                if (t.getAmount() < (t1.getAmount())) {
                    ris = -1;
                } else if (t.getAmount() > (t1.getAmount())) {
                    ris = 1;
                } else {
                    ris = 0;
                }
                return -ris;
            }
        };
        return operations.stream().filter(v -> (v instanceof Deposit)).sorted(comparatore).collect(Collectors.toList());
    }

    /**
     *
     * @return la lista di tutti i prelievi effettuati, ordinati per importi
     * decrescenti
     */
    public List getWithdrawal() {
        Comparator<Operation> comparatore = new Comparator<Operation>() {
            @Override
            public int compare(Operation t, Operation t1) {
                int ris;
                if (t.getAmount() < (t1.getAmount())) {
                    ris = -1;
                } else if (t.getAmount() > (t1.getAmount())) {
                    ris = 1;
                } else {
                    ris = 0;
                }
                return -ris;
            }
        };
        return operations.stream().filter(v -> (v instanceof Withdrawal)).sorted(comparatore).collect(Collectors.toList());
    }

}
