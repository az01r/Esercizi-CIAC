/*
 * 2. convertire in maiuscolo le linee di un file
 */
package tss.ciac.esfile;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Collectors;

/**
 *
 * @author tss
 */
public class App2 {

    public static void main(String[] args) {

        try {

            Path path = FileSystems.getDefault().getPath("Anagrafica.txt");
            Path patho = FileSystems.getDefault().getPath("Anagrafica-Maiuscolo.txt");

            Files.write(patho,
                    Files.lines(path)
                            .map(v -> v.toUpperCase())
                            .collect(Collectors.toList()));

        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }
}
