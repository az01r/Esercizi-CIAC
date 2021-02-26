/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.javafxjpa.business;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author alfonso
 */
public class DbStore {

    private static EntityManager em;
    private static EntityManagerFactory emf;

    static {
        init();
    }

    public static void init() {
        Map<String, String> map = new HashMap();
        map.put("javax.persistence.jdbc.url", DbManager.urlWithDb());
        map.put("javax.persistence.jdbc.driver", DbManager.driver());
        map.put("javax.persistence.schema-generation.database.action", "create");
        map.put("hibernate.dialect", DbManager.dialect());
        emf = Persistence.createEntityManagerFactory("songs", map);
        em = emf.createEntityManager();
    }

    public static List<Song> all() {
        return em.createQuery("select e from Song e order by e.artista", Song.class)
                .getResultList();
    }

    public static Song save(Song s) {
        em.getTransaction().begin();
        Song saved = em.merge(s);
        em.getTransaction().commit();
        return saved;
    }

    public static Song save(String titolo, String artista, String album, String filename, File file) {
        Song tosave = new Song(titolo, titolo, album);
        tosave.setFilename(filename);
        em.getTransaction().begin();
        Song saved = em.merge(tosave);
        if (filename != null && !filename.isEmpty() && file != null) {
            FileManager.copy(file, filename);
        }
        em.getTransaction().commit();
        return saved;
    }

    public static void delete(long id) {
        em.getTransaction().begin();
        Song found = find(id);
        String filename = found.getFilename();
        em.remove(found);
        if (filename != null && !filename.isBlank()) {
            FileManager.delete(filename);
        }
        em.getTransaction().commit();
    }

    public static Song find(long id) {
        return em.find(Song.class, id);
    }
}
