/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supplier;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 *
 * @author Paolo
 */
public class App {

    private static final Supplier<Stream<String>> nomi = () -> Stream.of("Paolo", "Luca", "Mario", "Luigi", "Paolo");

    public static void main(String[] args) {
        nomi.get()
                .distinct() // toglie i duplicati
                .sorted() // ordina
                .filter(v -> v.startsWith("L"))
                //.forEach(v -> System.out.println(v)) // stampa
                .forEachOrdered(System.out::println);  // stampa, equivale a quello sopra
        Object[] ris1=nomi.get().filter(v -> v.length() > 3).distinct().sorted().toArray();
        System.out.println(Arrays.toString(ris1));
        Object[] ris2=nomi.get().filter(v -> v.length() > 5).distinct().sorted(Comparator.reverseOrder()).toArray();
        System.out.println(Arrays.toString(ris2));
        long ris3 = nomi.get().filter(v -> v.length() > 5).distinct().count();
        System.out.println(ris3);
        Optional<String> max = nomi.get().filter(v -> v.length() > 5).distinct().max((v1,v2)->v1.compareTo(v2));
        System.out.println(max.orElse("Non presente"));
        nomi.get().distinct().map(v->v.length()).max((v1,v2)->v1.compareTo(v2)).ifPresent(System.out::println);
        nomi.get().distinct().mapToInt(v -> v.length()).map(v->v*v).max().ifPresent(System.out::println);
        List<String> colori = Arrays.asList("blu","bianco","rosso","verde");
        System.out.println(colori.stream().filter(v->v.equals("blu")).findFirst().orElse("Non presente"));
        int ris4 = nomi.get().distinct().mapToInt(v->v.length()).sum();
        System.out.println(ris4);
        OptionalDouble average = nomi.get().distinct().mapToInt(v->v.length()).average();
        System.out.println(average.getAsDouble());
    }

}
