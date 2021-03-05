/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prodotti;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;

/**
 *
 * @author alfonso
 */
@ApplicationScoped
public class ProdottoStore {

    private List<Prodotto> prodotti;

    public ProdottoStore() {
        System.out.println("nuova istanza di Store....");
    }

    @PostConstruct
    public void init() {
        System.out.println("init() Store....");
        this.prodotti = Stream.of(new Prodotto(1l, "pizza"), new Prodotto(2l, "Coca cola")).collect(Collectors.toList());
    }

    @PreDestroy
    public void ending() {
        System.out.println("ending() Store....");
    }

    public List<Prodotto> allProdotti() {
        //return new ArrayList<>();
        return prodotti;
    }
}
