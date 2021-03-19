/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.bankSystem.control;

import it.tss.bankSystem.entity.Account;
import it.tss.bankSystem.entity.User;
import java.util.List;
import java.util.Optional;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.json.JsonObject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.ws.rs.NotFoundException;
import static javax.ws.rs.client.Entity.json;

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
    
    public User create(User u) {
        User saved = em.merge(u);
        Account account = new Account(0d, 0l, saved);
        accountStore.create(account);
        return saved;
    }

    public void delete(Long id) {
        em.merge(em.find(User.class, id)).setDeleted(true);
        //em.remove(em.find(User.class, id));
    }

    public User update(User user, JsonObject json) {
        if(json.getJsonString("fname")!=null)   user.setFname(json.getJsonString("fname").getString());
        if(json.getJsonString("lname")!=null)   user.setFname(json.getJsonString("lname").getString());
        if(json.getJsonString("usr")!=null)     user.setFname(json.getJsonString("usr").getString());
        if(json.getJsonString("pwd")!=null)     user.setFname(json.getJsonString("pwd").getString());
        if(json.getJsonString("email")!=null)   user.setFname(json.getJsonString("email").getString());
        if(json.getJsonString("tel")!=null)     user.setFname(json.getJsonString("tel").getString());
        if(json.getJsonString("role")!=null)    user.setFname(json.getJsonString("role").getString());
        return em.merge(user);
    }
    
    public List<User> search(){
        return em.createQuery("select e from User e WHERE e.deleted==false e ORDER BY e.usr", User.class)//NB le query sono fatte non sul database ma sulle entità di Java
                .getResultList();
    }
    
    public Optional<User> find(Long id){
        /*
        EntityManager ha un metodo find che cerca un'entity dando una classe e la chiave primaria
        */
        User found = em.find(User.class, id); 
        return found == null ? Optional.empty() : Optional.of(found); // ritorna null se non lo ha trovato oppure l'elemento trovato
    }
}

    
