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
public class Camion extends Veicolo {
    
    private final int pesoMax;

    public Camion(int pesoMax, String marca, int anno, int cilindrata) {
        super(marca, anno, cilindrata);
        this.pesoMax = pesoMax;
    }

    public int getPesoMax() {
        return pesoMax;
    }

    @Override
    public String toString() {
        return super.toString() +  "\nCamion{" + "pesoMax=" + pesoMax + '}';
    }
    
    
}
