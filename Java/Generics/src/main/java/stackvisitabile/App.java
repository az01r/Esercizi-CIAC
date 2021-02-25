/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stackvisitabile;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author alfonso
 */
public class App {

    public static void main(String[] args) {

        System.out.println("");
        MioStack<Integer> stack = new MioStack<>(5);

        stack.put(1);
        stack.put(5);
        stack.put(10);
        stack.put(15);
        stack.put(20);

        stampa(null);

        System.out.println("------------------------------------------------");

        for (Integer elemento : stack) {
            System.out.println(elemento);
        }

        List<Integer> lista = new ArrayList<>();

        lista.add(1);
        lista.add(3);
        lista.add(5);
        lista.add(7);
        lista.add(9);

        System.out.println("------------------------------------------------");

        stampa(lista);

        System.out.println("------------------------------------------------");

        for (Integer elemento : lista) {
            System.out.println(elemento);
        }

        System.out.println("Totale stack: " + totale(stack));

        System.out.println("Totale lista: " + totale(lista));

        Stack<String> stringStack = new MioStack<>(10);

        stringStack.put("ciao");

        //System.out.println(totale(stringStack)); errore perchè string non è un tipo numerico...
    }

    public static <T> void stampa(Iterable<T> it) {
        if (it == null) {
            return;
        }
        Iterator<T> scorri = it.iterator();
        while (scorri.hasNext()) {
            System.out.println(scorri.next());
        }
    }

    public static <T extends Number> double totale(Iterable<T> it) {
        double result = 0;
        for (T t : it) {
            result += t.doubleValue();
        }
        return result;
    }

    public static <T> Stack<T> unisci(Stack<T> s1, Stack<T> s2) {
        return null;
    }
}
