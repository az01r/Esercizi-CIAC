/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tss.ciac.testoop;

import java.util.ArrayList;

/**
 *
 * @author Paolo
 */
public class TestOOP {
    ArrayList<Persona> lista = new ArrayList<Persona>();
    public static void main(String[] args) {
        // TODO code application logic here
        String nom="mario";
        Magazziniere m = new Magazziniere(nom);
        m.setSalario(2000.00f);
        m.setMezzo("Bilico");
        nom="Luisa";
        Cliente c = new Cliente(nom);
        c.setCod_tessera(123123);
        System.out.println(m.info());
        System.out.println(c.info());
}
