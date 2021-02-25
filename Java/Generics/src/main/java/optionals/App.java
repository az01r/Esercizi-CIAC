/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package optionals;

import java.util.Optional;

/**
 *
 * @author Paolo
 */
public class App {
    public static void main(String[] args) {
        Optional<String> opt = Optional.of("ciao");
        Optional<String> empty = Optional.empty();
        if(opt.isPresent()){
            System.out.println(opt.get());
        }
    }
}