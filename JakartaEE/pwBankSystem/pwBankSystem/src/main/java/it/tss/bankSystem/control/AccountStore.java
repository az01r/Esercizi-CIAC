/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.bankSystem.control;

import it.tss.bankSystem.entity.Account;
import java.util.List;
import java.util.Optional;
import javax.enterprise.context.RequestScoped;
import javax.json.JsonObject;
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
        if(account==null){
            throw new IllegalArgumentException("This account already exist");
        }
        return em.merge(account);
    }

    public void delete(Long id) {
        em.merge(em.find(Account.class, id)).setDeleted(true);
    }

    public Account update(Account account, JsonObject json) {
        if(json.getJsonString("overdraft")!=null)   account.setOverdraft(json.getJsonNumber("overdraft").longValue());
        return em.merge(account);
    }

    /*
    deve ritornare solo gli account attivi
    */
    public List<Account> search() {
        return em.createQuery("select e from Account e WHERE e.deleted==false e ORDER BY e.usr", Account.class)//NB le query sono fatte non sul database ma sulle entità di Java
                .getResultList();
    }
    /*
    deve ritornare solo gli account appartenenti ad un utente
    */
    public List<Account> searchByUser(Long id) {
        return em.createQuery("select e from Account e where e.user.id= :user_id and e.user.deleted=false")
                .setParameter("user_id", id)
                .getResultList();
    }

    public Optional<Account> find(Long id) {
        /*
        EntityManager ha un metodo find che cerca un'entity dando una classe e la chiave primaria
        */
        Account found = em.find(Account.class, id); 
        return found == null ? Optional.empty() : Optional.of(found); // ritorna null se non lo ha trovato oppure l'elemento trovato
    }
    
}
