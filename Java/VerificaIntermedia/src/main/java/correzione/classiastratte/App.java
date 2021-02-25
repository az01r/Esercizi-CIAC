/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classiastratte;

import interfacce1.*;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author alfonso
 */
public class App {

    public static void main(String[] args) {

        List<? extends AbstractOrdinabile> persone = Arrays.asList(new Persona("mario", 45), new Persona("anna", 30), new Persona("maria", 55));
        
        System.out.println(persone);
        
        System.out.println("--------------------------------------------------");
        
        ordina((List<AbstractOrdinabile>)persone);
        
        System.out.println(persone);
        
        System.out.println("--------------------------------------------------");
        System.out.println("--------------------------------------------------");
        
        List<? extends AbstractOrdinabile> computers = Arrays.asList(new Computer("DELL", 2048),new Computer("ASUS", 4096), new Computer("HP", 1024));
        
        System.out.println(computers);
        
        System.out.println("--------------------------------------------------");
        
        ordina((List<AbstractOrdinabile>)computers);
        
        System.out.println(computers);
        
    }

    private static void ordina(List<AbstractOrdinabile> list) {
        boolean ordinato;
        do {
            ordinato = true;
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i).confronta(list.get(i + 1)) > 0) {
                    AbstractOrdinabile tmp = list.get(i);
                    list.set(i, list.get(i + 1));
                    list.set(i + 1, tmp);
                    ordinato = false;
                }
            }
        } while (!ordinato);
    }
   
}
