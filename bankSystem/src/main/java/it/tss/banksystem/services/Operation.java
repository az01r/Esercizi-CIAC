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
public abstract class Operation {
    LocalDate date;
    float amount;

    public LocalDate getDate() {
        return date;
    }

    public float getAmount() {
        return amount;
    }

}
