/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.banksystem.main;

import it.tss.banksystem.services.Account;
import it.tss.banksystem.services.Bank;
import it.tss.banksystem.services.Deposit;
import it.tss.banksystem.services.InvalidCode;
import it.tss.banksystem.services.InvalidValue;
import java.time.LocalDate;

/**
 *
 * @author tss
 */
public class App {
    public static void main(String[] args) throws InvalidCode, InvalidValue {
        Bank b = new Bank("Unicredit");
        Bank bb = new Bank("Intesa San Paolo");
        int codiceConto = b.createAccount("Paolo Antonio Grosso", 1000);
        int codiceConto2 = b.createAccount("Mario Rossi", 2000);
        int codiceConto3 = b.createAccount("Giuseppe Verdi", 10000);
        b.deleteAccount(codiceConto3, LocalDate.now());
        Account mioConto=b.getAccount(codiceConto);
        mioConto.addOperation(new Deposit(LocalDate.now(), 500));
        b.deposit(codiceConto, LocalDate.now(), 300);
        b.withdrawal(codiceConto, LocalDate.now(), 700);
        System.out.println("Saldo mioConto: "+b.getAccount(codiceConto).getBalance());
        b.transfer(codiceConto, codiceConto2, LocalDate.now(), 1000);
        
        System.out.println("Saldo mioConto: "+b.getAccount(codiceConto).getBalance());
        
        System.out.println("------------------------------- Metodi di Account -------------------------------\n");
        System.out.println(mioConto.getMovements()+"\n");
        System.out.println(mioConto.getDeposits()+"\n");
        System.out.println(mioConto.getWithdrawal()+"\n");
        
        System.out.println("------------------------------- Metodi di Bank -------------------------------\n");
        System.out.println(b.getTotalDeposit()+"\n");
        System.out.println(b.getAccounts()+"\n");
        System.out.println(b.getAccountsByBalance(1000, 3000)+"\n");
        System.out.println(b.getPerCentHigher(1000)+"\n");
        
    }
}
