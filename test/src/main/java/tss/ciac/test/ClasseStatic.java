/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tss.ciac.test;

import java.util.function.Function;

/**
 *
 * @author Paolo
 */
public class ClasseStatic {
    public static void metodoStatico(){
        new ClasseStatica();
        
        Function <String, String> f1 = x -> x.toUpperCase();
    }
    private static class ClasseStatica {
        public ClasseStatica(){
            
        }
    }
}