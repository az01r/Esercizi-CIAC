/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.bankSystem.control;

import it.tss.bankSystem.entity.Account;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 *
 * @author Paolo
 */

@RequestScoped
@Transactional(Transactional.TxType.REQUIRED)
public class AccountStore {
    
    @PersistenceContext
    private EntityManager em;
    
    public Account create(Account account){
        if(account!=null){
            throw new IllegalArgumentException("This account already exist");
        }
        return em.merge(account);
    }
}
