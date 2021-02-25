/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacce2;

/**
 *
 * @author alfonso
 */
public class App {
    public static void main(String[] args) {
        Computer c1 = new Computer("IBM", 1024);
        log(c1);
        log(new Persona("gianni", 45));
    }
    
    public static void log(Loggable l){
        l.log();
    }
}