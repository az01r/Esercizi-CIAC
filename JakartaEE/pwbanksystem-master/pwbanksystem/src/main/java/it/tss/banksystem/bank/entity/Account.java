/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.banksystem.bank.entity;

import it.tss.banksystem.bank.boundary.UserLinkAdapter;
import java.io.Serializable;
import javax.json.bind.annotation.JsonbTypeAdapter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author alfonso
 */
@Entity
@Table(name = "account")
public class Account extends AbstractEntity implements Serializable {

    private Double balance;
    @Column(name = "over_draft")
    private Long overDraft;

    @ManyToOne(optional = false) // un user può avere tanti account ovvero tanti conti
    @JoinColumn(name = "user_id")
    @JsonbTypeAdapter(UserLinkAdapter.class) // converte in Json usando la classe UserLinkAdapter
    private User user;

    private boolean deleted = false;

    public Account() {
    }

    public Account(Double balance, Long overDraft, User user) {
        this.balance = balance;
        this.overDraft = overDraft;
        this.user = user;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Long getOverDraft() {
        return overDraft;
    }

    public void setOverDraft(Long overDraft) {
        this.overDraft = overDraft;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

}
