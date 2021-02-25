/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.FileSystems;

/**
 *
 * @author alfonso
 */
public class App3 {

    public static void main(String[] args) {

        String inFile = FileSystems.getDefault().getPath("Anagrafica.txt").toAbsolutePath().toString();
        String outFile = FileSystems.getDefault().getPath("Anagrafica-copia.txt").toAbsolutePath().toString();
        try ( BufferedReader br = new BufferedReader(new FileReader(inFile));  
              PrintWriter pw = new PrintWriter(new FileWriter(outFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println("lettura:" + line);
                pw.println(line);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}