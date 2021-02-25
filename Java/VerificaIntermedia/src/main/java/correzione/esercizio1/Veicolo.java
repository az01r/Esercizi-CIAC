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
public class Veicolo {

    private static int counter;
    private final int id;
    private final String marca;
    private final int anno, colindrata;

    public Veicolo(String marca, int anno, int cilindrata) {
        this.id = ++counter;
        this.marca = marca;
        this.anno = anno;
        this.colindrata = cilindrata;
    }

    public int getId() {
        return id;
    }

    public String getMarca() {
        return marca;
    }

    public int getAnno() {
        return anno;
    }

    public int getColindrata() {
        return colindrata;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Veicolo other = (Veicolo) obj;
        return this.id == other.id;
    }

    

    @Override
    public String toString() {
        return "Veicolo{" + "id=" + id + ", marca=" + marca + ", anno=" + anno + ", colindrata=" + colindrata + '}';
    }

}
