/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.banksystem.services;

import java.time.LocalDate;

/**
 *
 * @author tss
 */
public class Withdrawal extends Operation{
    
    public Withdrawal(LocalDate date, float amount) {
        this.date=date;
        this.amount=amount;
    }
    
    @Override
    public String toString() {
        return date+",-" + amount;
    }
}
