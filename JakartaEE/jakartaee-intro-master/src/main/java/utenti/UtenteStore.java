/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utenti;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;

/**
 *
 * @author alfonso
 */
@RequestScoped
public class UtenteStore {

    @PostConstruct
    public void init() {
        System.out.println("init() UtenteStore....");
    }

    @PreDestroy
    public void ending() {
        System.out.println("ending() UtenteStore....");
    }

    public void add(Utente utente) {
        System.out.println("salvataggio utente...");
        System.out.println(utente);
    }
}
