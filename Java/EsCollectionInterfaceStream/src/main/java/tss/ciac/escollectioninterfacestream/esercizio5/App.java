/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tss.ciac.escollectioninterfacestream.esercizio5;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author alfonso
 */
public class App {

    private static final Supplier<List<Number>> numeri = () -> Stream.of(4, 6, 8, 3, 5, 6, 3, 1, 4, 6, 8, 90, 66, 45, 76, 87, 11).collect(Collectors.toList());

    public static void main(String[] args) {

        ricalcola(numeri, n -> n).forEach(System.out::println);
        System.out.println("---------------------");

        ricalcola(numeri, n -> n * n).forEach(System.out::println);
        System.out.println("---------------------");

        ricalcola(numeri, n -> n * n * n).forEach(System.out::println);
        System.out.println("---------------------");

        ricalcola(App::getNumeri, n -> Math.sqrt(n)).forEach(System.out::println);
        System.out.println("---------------------");

    }

    public static List<Number> getNumeri() {
        return Stream.of(4, 6, 8, 3, 5, 6, 3, 1, 4, 6, 8, 90, 66, 45, 76, 87, 11).collect(Collectors.toList());
    }

    /*
    public static void quadrato(List<Number> list) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, list.get(i).doubleValue() * list.get(i).doubleValue());
        }
    }
    public static void cubo(List<Number> list) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, list.get(i).doubleValue() * list.get(i).doubleValue() * list.get(i).doubleValue());
        }
    }
    public static void radice(List<Number> list) {
        for (int i = 0; i < list.size(); i++) {
            list.set(i, Math.sqrt(list.get(i).doubleValue()));
        }
    }
     */
    public static List<Number> ricalcola(Supplier<List<Number>> s, Function<Double, Double> f) {
        List<Number> list = s.get();
        for (int i = 0; i < list.size(); i++) {
            list.set(i, f.apply(list.get(i).doubleValue()));
        }
        return list;
    }
}
