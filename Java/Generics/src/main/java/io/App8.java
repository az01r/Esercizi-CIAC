/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 *
 * @author tss
 */
public class App8 {

    public static void main(String[] args) {

        try {
            //Paths.get("/home/tss/jse2021/IO/Anagrafica.txt");

            Path path = FileSystems.getDefault().getPath("Anagrafica.txt");

            Files.readAllLines(path).stream().forEach(System.out::println);
            
            Files.lines(path).forEach(System.out::println);
            
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

    }
}