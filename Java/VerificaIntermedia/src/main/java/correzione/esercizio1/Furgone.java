/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esercizio1;

/**
 *
 * @author alfonso
 */
public class Furgone extends Veicolo {

    private final int capacita;

    public Furgone(int capacita, String marca, int anno, int cilindrata) {
        super(marca, anno, cilindrata);
        this.capacita = capacita;
    }

    public int getCapacita() {
        return capacita;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + "Furgone{" + "capacita=" + capacita + '}';
    }

}
