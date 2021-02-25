/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esercizio4;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author alfonso
 */
public class Macchina implements Riparabile {

    private int no;

    private final String marca;

    private float tot;

    private final List<Lavorazione> lavorazioni = new ArrayList<>();

    public Macchina(String marca) {
        this.marca = marca;
    }

    
    @Override
    public void addLavorazione(Lavorazione lav) {
        lavorazioni.add(lav);
        tot += lav.getCosto();
    }

    @Override
    public void initLavorazioni() {
        lavorazioni.clear();
        tot = 0;
    }

    @Override
    public int getNo() {
        return no;
    }

    @Override
    public void setNo(int no) {
        this.no = no;
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
