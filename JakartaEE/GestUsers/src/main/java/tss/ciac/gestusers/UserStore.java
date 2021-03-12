/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tss.ciac.gestusers;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.ApplicationScoped;
import javax.json.JsonObject;
import javax.json.JsonString;
import javax.json.bind.JsonbBuilder;

/**
 * Classe Singleton ovvero ne viene creata una sola istanza
 *
 * si realizza lasciando la creazione dell'istanza della classe è lasciata alla
 * classe stessa mettendo il costruttore privato e creando un metodo pubblico
 * getInstance() che ritorna l'istanza creata, unica
 *
 * @author Paolo
 */
@ApplicationScoped
public class UserStore {

    private final Map<Integer, User> users = new HashMap<>();
    private int userCount = 0;

    @PostConstruct
    public void init() {
        loadUsers().forEach(this::add); // carica gli utenti; per ogni utente, aggiunge l'utente all'elenco
    }

    /**
     * da finire
     */
   @PreDestroy
    public void save() {
        try (FileWriter file = new FileWriter("/META-INF/users.json")) {
            JsonbBuilder.create().toJson(users.values(),file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<User> loadUsers() {
        List<User> result = null;
        try (InputStream is = this.getClass().getClassLoader().getResourceAsStream("/META-INF/users.json");) {
            if (is == null) {
                System.err.println("File non trovato");
            } else {
                result = JsonbBuilder.create().fromJson(is, new ArrayList<User>() {
                }.getClass().getGenericSuperclass());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public User add(User u) {
        ++userCount;
        u.setId(userCount);
        users.putIfAbsent(userCount, u);
        return u;
    }

    public void remove(int id) {
        users.remove(id);
    }

    public List<User> all() {
        return users.values().stream().collect(Collectors.toList());
    }

    public Optional<User> find(int id) {
        User found = users.get(id);
        return found == null ? Optional.empty() : Optional.of(found);
    }

    /**
     * aggiungere /id_user nell'url aggiungere /id_user nel json (oltre a
     * nome/cognome)
     *
     * @param u
     */
    public void update(User u) {
        find(u.getId()).ifPresent(v -> users.put(u.getId(), u));
    }

    public void partialUpdate(int id, JsonObject json) {
        JsonString nome = json.getJsonString("nome");
        JsonString cognome = json.getJsonString("cognome");
        partialUpdate(id, nome == null ? null : nome.getString(), cognome == null ? null : cognome.getString());
    }

    public void partialUpdate(int id, String nome, String cognome) {
        Optional<User> found = find(id);
        if (found.isPresent()) {
            User u = found.get();
            u.setNome(nome != null ? nome : u.getNome());
            u.setCognome(cognome != null ? cognome : u.getCognome());
            users.put(id, u);
        }
    }

    public List<User> find(String nome, String cognome) {
        return users.values().stream().filter(v -> (nome == null ? true : v.getNome().equals(nome)) && (cognome == null ? true : v.getCognome().equals(cognome))).collect(Collectors.toList());
    }

    /*
    NON SI FA COSI MA PASSANDO I PARAMETRI TRAMITE URL
    public Optional<User> find(String nome) {
        for (User user : users.values()) {
            if(user.getNome().equals(nome)){
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }
     */
}
