/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.banksystem.bank.boundary.dto;

import it.tss.banksystem.bank.entity.Account;

/**
 *
 * @author Paolo
 */
public class AccountView extends AccountViewLink {

    public double balance;
    public int overdraft;
    public UserViewLink user;
    
    public AccountView() {
    }

    public AccountView(Account a) {
        super(a);
        this.balance = a.getBalance();
        this.overdraft = a.getOverdraft();
        this.user = new UserViewLink(a.getUser());
    }

}
