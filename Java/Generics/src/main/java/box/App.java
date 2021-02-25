/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package box;

/**
 *
 * @author Paolo
 */
public class App {
    public static void main(String[] args) {
        Box<String> box = new Box();
        box.inserisci("ciao");
        System.out.println(box);
        String s = box.estrai();
        System.out.println(s.toUpperCase());
        Box<Computer> box1 = new Box<>();
        box1.inserisci(new Computer("DELL",2048));
        System.out.println(box1);
        Computer computer = box1.estrai();
    }
    
}

