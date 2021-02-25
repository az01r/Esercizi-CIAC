/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author alfonso
 */
public class App5 {

    public static void main(String[] args) {

        String inFile = FileSystems.getDefault().getPath("Anagrafica.txt").toAbsolutePath().toString();
        String outFile = FileSystems.getDefault().getPath("Anagrafica-copia.bin").toAbsolutePath().toString();
        try ( BufferedReader br = new BufferedReader(new FileReader(inFile));  
              DataOutputStream dos = new DataOutputStream(new FileOutputStream(outFile))) {
            List<String> righe = br.lines().collect(Collectors.toList());
            for (String l : righe) {
                String[] w = l.split(",");
                System.out.println(Arrays.toString(w));
                dos.writeUTF(w[0]);
                dos.writeUTF(w[1]);
                dos.writeInt(Integer.parseInt(w[2]));
                dos.writeInt(Integer.parseInt(w[3]));
                dos.writeUTF(w[4]);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}