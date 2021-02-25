
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.FileSystems;

/**
 *
 * @author alfonso
 */
public class App1 {

    public static void main(String[] args) {
        String inFile = FileSystems.getDefault().getPath("Anagrafica.txt").toAbsolutePath().toString();
        String outFile = FileSystems.getDefault().getPath("Anagrafica-copia.txt").toAbsolutePath().toString();
        try ( FileInputStream is = new FileInputStream(inFile);  
              FileOutputStream os = new FileOutputStream(outFile)) {
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