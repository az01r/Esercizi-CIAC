/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacce1;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author alfonso
 */
public class App {

    public static void main(String[] args) {

        Ordinabile<Computer> o = new Computer("IBM", 1024);
        
        Computer c = new Computer("DELL", 2048);

        //Collections.sort(list);
        List<Persona> persone = Arrays.asList(new Persona("mario", 45), new Persona("anna", 30), new Persona("maria", 55));

        System.out.println(persone);

        System.out.println("--------------------------------------------------");

        ordina(persone);

        System.out.println(persone);

        System.out.println("--------------------------------------------------");
        System.out.println("--------------------------------------------------");

        List<Computer> computers = Arrays.asList(new Computer("DELL", 2048), new Computer("ASUS", 4096), new Computer("HP", 1024));

        System.out.println(computers);

        System.out.println("--------------------------------------------------");

        //Collections.sort(computers);
        //Interfaccia implementata tramite classe anomima
        Collections.sort(computers, new Comparator<Computer>() {
            @Override
            public int compare(Computer c1, Computer c2) {
                return c1.getMarca().compareTo(c2.getMarca());
            }
        });

        System.out.println(computers);

        System.out.println("--------------------------------------------------");
        System.out.println("--------------------------------------------------");

        //Implementazione di una interfaccia funzionale tramite lambda expression
        Comparator<Persona> comp = (p1, p2) -> p1.getNome().compareTo(p2.getNome());

        Collections.sort(persone, comp);

        //Implementazione di una interfaccia funzionale tramite method reference
        Collections.sort(persone,App::ordinaPersoneByNome);
        
        System.out.println(persone);

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

    private static int ordinaPersoneByNome(Persona p1, Persona p2) {
        return p1.getNome().compareTo(p2.getNome());
    }

}

class ComputerComparator implements Comparator<Computer> {

    @Override
    public int compare(Computer c1, Computer c2) {
        return c1.getMarca().compareTo(c2.getMarca());
    }

}
