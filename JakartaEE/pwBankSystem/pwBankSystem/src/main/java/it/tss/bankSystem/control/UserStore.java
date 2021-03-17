/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.bankSystem.control;

import it.tss.bankSystem.entity.Account;
import it.tss.bankSystem.entity.User;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 *
 * @author Paolo
 */

/* 
    obbligatorio iniziare e terminare la transazione -> se qualcosa va storto 
    non fa l'intero create
    */
@RequestScoped
@Transactional(Transactional.TxType.REQUIRED) 
public class UserStore {
    
    @PersistenceContext //chiedo a JPA di creare un'istanza di EntityManager
    private EntityManager em;
    
    @Inject
    AccountStore accountStore;
    
    public List<User> search(){
        return em.createQuery("select e from User e ORDER BY e.usr", User.class)//NB le query sono fatte non sul database ma sulle entità di Java
                .getResultList();
    }
    
    public User create(User u) {
        User saved = em.merge(u);
        Account account = new Account(0d, 0l, saved);
        accountStore.create(account);
        return saved;
    }
}

    
