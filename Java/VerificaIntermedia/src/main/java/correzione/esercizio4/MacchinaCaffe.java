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
public class MacchinaCaffe extends Elettrodomestico implements Riparabile{

    private int no;
    private int tot;
    
    private final List<Lavorazione> lavorazioni = new ArrayList<>();
    
    public MacchinaCaffe(String categoria) {
        super(categoria);
    }

    @Override
    public int getNo() {
        return this.no;
    }

    @Override
    public void setNo(int numero) {
       this.no = numero;
    }

    @Override
    public void initLavorazioni() {
        lavorazioni.clear();
    }

    @Override
    public void addLavorazione(Lavorazione l) {
       lavorazioni.add(l);
       tot += l.getCosto();
    }

    @Override
    public String toString() {
        return "MacchinaCaffe{" + "no=" + no + ", tot=" + tot + ", lavorazioni=" + lavorazioni + '}';
    }

    
    
}
