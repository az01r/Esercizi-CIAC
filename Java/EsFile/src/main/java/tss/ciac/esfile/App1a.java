/*
 * 1. leggere un file e riscriverlo con il numero di riga
 */
package tss.ciac.esfile;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;



/**
 *
 * @author tss
 */
public class App1a {
    public static void main(String[] args) throws IOException {
        try {

            Path srcPath = FileSystems.getDefault().getPath("file.txt");
            Path destPath = FileSystems.getDefault().getPath("destinazione.txt");
            
            List<String> righe = Files.readAllLines(srcPath);
            List<String> righeNumerate = new ArrayList<>(righe.size());
            
            int count=1;
            for (String riga : righe) {
                righeNumerate.add(count++ +" "+riga);
            }
            Files.write(destPath, righeNumerate);
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
}
