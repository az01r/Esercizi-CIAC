/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.bankSystem.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


/**
 *
 * @author Paolo
 */

@Entity
@Table(name = "account")
public class Account extends AbstractEntity implements Serializable{
    
    private Double balance;
    
    private Long overdraft;
    
    @ManyToOne(optional = false)  // un user può avere tanti account ovvero tanti conti
    @JoinColumn(name = "user_id")
    private User user;

    public Account() {
    }

    public Account(Double balance, Long overdraft, User user) {
        this.balance = balance;
        this.overdraft = overdraft;
        this.user = user;
    }

    
    
    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Long getOverdraft() {
        return overdraft;
    }

    public void setOverdraft(Long overdraft) {
        this.overdraft = overdraft;
    }
    
}
