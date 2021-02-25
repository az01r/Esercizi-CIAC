/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author alfonso
 */
public class App7 {

    public static void main(String[] args) {
        
        try ( BufferedReader keyboard = new BufferedReader(new InputStreamReader(System.in));) {
            while (true) {
                System.out.print("input text: ");
                String l = keyboard.readLine();
                System.out.println(l.toUpperCase());
                if (l.equalsIgnoreCase("end")) {
                    break;
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}