/*
Scrivere un metodo generico minoriDi che riceve in ingresso un array di un tipo 
numerico T e  un valore di tipo T e restituisce una lista di elementi di tipo T 
contenente tutti gli elementi  dell'array che sono minori del valore dato.
 */
package tss.ciac.escollectioninterfacestream.esercizio3;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author Paolo
 */
public class App {

    public static void main(String[] args) {
        Integer[] numeri = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        minoriDi(numeri, 5).stream().forEach(System.out::println);
    }

    public static <T extends Number> List<T> minoriDi(T[] array, T valore) {
        return Arrays.asList(array).stream()
                .filter(v -> v.doubleValue() < valore.doubleValue())
                .collect(Collectors.toList());
    }
}
