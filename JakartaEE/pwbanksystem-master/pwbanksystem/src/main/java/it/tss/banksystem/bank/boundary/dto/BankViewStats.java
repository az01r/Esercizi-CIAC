/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.banksystem.bank.boundary.dto;

/**
 *
 * @author Paolo
 */
public class BankViewStats {
    public long totalUsers ;
    public double totalBalance;
    public double avgBalance;

    public BankViewStats() {
    }

    public BankViewStats(long totalUsers, double totalBalance, double avgBalance) {
        this.totalUsers = totalUsers;
        this.totalBalance = totalBalance;
        this.avgBalance = avgBalance;
    }
}
