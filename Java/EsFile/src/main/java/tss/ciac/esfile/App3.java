/*
 * 3. stampare i nomi dei file testuali (.txt) presenti in una cartella.
 */
package tss.ciac.esfile;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

/**
 *
 * @author tss
 */
public class App3 {

    public static void main(String[] args) {

        Path path = FileSystems.getDefault().getPath("");
        /*
            Stream nella documentazione dice di usare un try con attibuti per chiudere gli stream dei files
        */
        try (Stream<Path> s1 = Files.walk(path,1);Stream<Path> s2 = Files.list(path)) {

            
            //modo ricorsivo
            s1
                    .filter(p -> !Files.isDirectory(p))
                    .filter(p -> p.getFileName().toString().endsWith(".txt"))
                    .forEach(p -> System.out.println(p.getFileName()));
            //non ricorsivo
            s2
                    .map(Path::getFileName)
                    .map(Path::toString)
                    .filter(v -> v.endsWith(".txt"))
                    .forEach(System.out::println);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
