/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tss.ciac.gestusers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;


/**
 * Classe Singleton
 * ovvero ne viene creata una sola istanza
 * 
 * si realizza lasciando la creazione dell'istanza della classe è lasciata 
 * alla classe stessa mettendo il costruttore privato e creando un metodo 
 * pubblico getInstance() che ritorna l'istanza creata, unica 
 * @author Paolo
 */
@ApplicationScoped
public class UserStore {
    
    private final Map<Integer,User> users= new HashMap<>();
    
    @PostConstruct
    public void init(){
        Stream.of(new User("Paolo", "Grosso"),new User("Luis", "Scott-Vargas"),new User("William", "Jensen"),new User("Reid","Duke"))
                .forEach(v->users.put(v.getId(),v));
        
    }
    
    public void add (User u){
        users.putIfAbsent(u.getId(), u);
    }
    
    public void remove (int id) {
        users.remove(id);
    }
    
    public List<User> all () {
        return users.values().stream().collect(Collectors.toList());
    }
    
    public Optional<User> find(int id) {
        User found = users.get(id);
        return found == null ? Optional.empty() : Optional.of(found);
    }

    /**
     * aggiungere /id_user nell'url
     * aggiungere /id_user nel json (oltre a nome/cognome)
     * @param u 
     */
    public void update(User u) {
        find(u.getId()).ifPresent(v->users.put(u.getId(),u));
        //users.put(u.getId(), u);
    }
}
