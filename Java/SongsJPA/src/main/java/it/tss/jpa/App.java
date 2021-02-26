/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.jpa;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author tss
 */
public class App {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pu");

        EntityManager em = emf.createEntityManager();

        System.out.println("------------------ START --------------------------");
        System.out.println("");
        System.out.println("");

        List<Song> list = em.createQuery("select e.titolo from Song e where e.artista like 'Prince'",
                 Song.class)
                .getResultList();

        list.forEach(v -> System.out.println(v.getTitolo()));

        System.out.println("");
        System.out.println("");
        System.out.println("------------------ END --------------------------");

        /*
        em.getTransaction().begin();

        Song song = new Song("Kiss", "Prince", "Kiss");

        em.persist(song);

        em.getTransaction().commit();
         */
        em.close();
        emf.close();

        //comeFunzionaDietroLeQuinte();
    }

    private static void comeFunzionaDietroLeQuinte() {
        try {
            //Reflection
            Class<?> c = Class.forName("it.tss.jpa.Song");

            Field[] df = c.getDeclaredFields();
            System.out.println(Arrays.toString(df));
            Field f = c.getDeclaredField("id");
            System.out.println(Arrays.toString(f.getAnnotations()));
        } catch (ClassNotFoundException | SecurityException | NoSuchFieldException ex) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
