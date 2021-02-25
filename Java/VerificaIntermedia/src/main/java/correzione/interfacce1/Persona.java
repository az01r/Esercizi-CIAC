/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfacce1;

/**
 *
 * @author alfonso
 */
public class Persona implements Ordinabile<Persona>, Comparable<Persona>{

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

    @Override
    public int confronta(Persona p) {
       return this.eta - p.getEta();
    }

    @Override
    public int compareTo(Persona p) {
        return confronta(p);
    }


}
