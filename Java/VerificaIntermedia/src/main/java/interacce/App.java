/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interacce;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author Paolo
 */
public class App {

    public static void main(String[] args) {
        List<Persona> persone = Arrays.asList(new Persona("mario", 45), new Persona("anna", 30), new Persona("maria", 55));
        System.out.println(persone);
        System.out.println("Elenco ordinato: ");
        ordina(persone); // metodo ordina creato da noi
        System.out.println(persone);
        System.out.println("----------------------------------");

        List<Computer> computers = Arrays.asList(new Computer("DELL", 4096), new Computer("ASUS", 8192), new Computer("HP", 2048));
        System.out.println(computers);
        System.out.println("Elenco ordinato: ");
        Collections.sort(computers); // metodo sort di Java ottenuto dall'implementazione di Comparable
        System.out.println(computers);
        System.out.println("----------------------------------");

        /* ---------------------------------------------------------------------
            altri modi per fare ordinamenti (ora usando la marca dei computers
           ------------------------------------------------------------------ */
        /**
         * usa la classe ComputerComparator
         */
        Collections.sort(computers, new ComputerCoparator());
        System.out.println(computers);
        System.out.println("----------------------------------");
        
        /**
         * identico a quello sopra ma non ha bisogno di implementare una classe
         * ComputerComparator perchè crea un'istanza all'interno
         */
        Collections.sort(computers, new Comparator<Computer>() {
            @Override
            public int compare(Computer c1, Computer c2) {
                return c1.getMarca().compareTo(c2.getMarca());
            }
        });
        System.out.println(computers);
        System.out.println("----------------------------------");
        
        /**
         * identico ma più leggibile implementa una interfaccia funzionale
         * tramite lambda expression
         */
        Collections.sort(computers, (Computer c1, Computer c2) -> c1.getMarca().compareTo(c2.getMarca()));
        System.out.println(computers);
        System.out.println("----------------------------------");
    }

    private static <T extends Ordinabile<? super T>> void ordina(List<T> list) {
        boolean ordinato;
        do {
            ordinato = true;
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i).confronta(list.get(i + 1)) > 0) {
                    T tmp = list.get(i);
                    list.set(i, list.get(i + 1));
                    list.set(i + 1, tmp);
                    ordinato = false;
                }
            }

        } while (!ordinato);
    }
}

class ComputerCoparator implements Comparator<Computer> {

    @Override
    public int compare(Computer c1, Computer c2) {
        return c1.getMarca().compareTo(c2.getMarca());
    }
}
