/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io;

import java.io.DataInputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.util.Locale;

/**
 *
 * @author alfonso
 */
public class App6 {

    public static void main(String[] args) {

        String inFile = FileSystems.getDefault().getPath("Anagrafica-copia.bin").toAbsolutePath().toString();
        try ( DataInputStream dis = new DataInputStream(new FileInputStream(inFile));) {
            while(true){
                String nome = dis.readUTF();
                String cognome = dis.readUTF();
                int eta = dis.readInt();
                int tel = dis.readInt();
                String email = dis.readUTF();
                System.out.format("%s, %s, %d, %d,%s",nome,cognome,eta,tel,email);
                System.out.println("");
            }
            
        }catch(EOFException ex){
            
        } 
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}