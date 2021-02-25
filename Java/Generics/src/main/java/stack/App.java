/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stack;

/**
 *
 * @author alfonso
 */
public class App {

    public static void main(String[] args) {
        
        Stack<String> stringStack = new MioStack<>(4);
        Stack<Integer> intStack = new MioStack<>(2);
        
        intStack.put(1);
        intStack.put(2);
        
        System.out.println(intStack);
        
        stringStack.put("ciao");
        stringStack.put("arrivederci");
        stringStack.put("saluti");
        
        System.out.println(stringStack);
        
        System.out.println(stringStack.get());
        System.out.println(stringStack.get());
        System.out.println(stringStack);
        
        System.out.println(intStack.put(3));
        System.out.println(intStack);
    }

}
