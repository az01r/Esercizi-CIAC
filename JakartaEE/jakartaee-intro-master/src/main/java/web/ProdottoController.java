/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import prodotti.Prodotto;
import prodotti.ProdottoStore;

/**
 *
 * @author alfonso
 */
@Named("prodController")
@RequestScoped
public class ProdottoController {

    @Inject
    private ProdottoStore store;

    public ProdottoController() {
        System.out.println("nuova istanza di ProdottoControlle....");
    }

    @PostConstruct
    public void init() {
        System.out.println("init() ProdottoControlle....");
    }

    @PreDestroy
    public void ending() {
        System.out.println("ending() ProdottoControlle....");
    }

    public List<Prodotto> all() {
        return store.allProdotti();
    }
}
