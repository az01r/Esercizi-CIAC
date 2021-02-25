/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.FileSystems;

/**
 *
 * @author alfonso
 */
public class App2 {

    public static void main(String[] args) {

        String inFile = FileSystems.getDefault().getPath("Anagrafica.txt").toAbsolutePath().toString();
        String outFile = FileSystems.getDefault().getPath("Anagrafica-copia.txt").toAbsolutePath().toString();
        try ( FileReader is = new FileReader(inFile);  
              FileWriter os = new FileWriter(outFile)) {
            int b;
            while ((b = is.read()) != -1) {
                System.out.println("lettura:" + b);
                os.write(b);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}