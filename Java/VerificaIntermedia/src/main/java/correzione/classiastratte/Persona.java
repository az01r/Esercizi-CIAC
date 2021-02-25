/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classiastratte;

import interfacce1.*;

/**
 *
 * @author alfonso
 */
public class Persona extends AbstractOrdinabile{

    private final String nome;
    private final int eta;

    public Persona(String nome, int eta) {
        this.nome = nome;
        this.eta = eta;
    }

    public String getNome() {
        return nome;
    }

    public int getEta() {
        return eta;
    }

    @Override
    public String toString() {
        return "Persona{" + "nome=" + nome + ", eta=" + eta + '}';
    }

    /**
     * 
     * @param p
     * @return <0 piu piccola, 0 uguale, >0 piu grande 
     */
    @Override
    public int confronta(Object p){
        return this.eta - ((Persona)p).getEta();
    }
}
