/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esercizio3;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alfonso
 */
public class Macchina {

    private int no;

    private final String marca;

    private float tot;

    private final List<Lavorazione> lavorazioni = new ArrayList<>();

    public Macchina(String marca) {
        this.marca = marca;
    }

    public void addLavorazione(Lavorazione l) {
        lavorazioni.add(l);
        tot += l.getCosto();
    }

    public void initLavorazioni() {
        lavorazioni.clear();
        tot = 0;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getMarca() {
        return marca;
    }

    public float getTot() {
        return tot;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.no;
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
        final Macchina other = (Macchina) obj;
        return this.no == other.no;
    }

    @Override
    public String toString() {
        return "Macchina{" + "no=" + no + ", marca=" + marca + ", tot=" + tot + ", lavorazioni=" + lavorazioni + '}';
    }

}
