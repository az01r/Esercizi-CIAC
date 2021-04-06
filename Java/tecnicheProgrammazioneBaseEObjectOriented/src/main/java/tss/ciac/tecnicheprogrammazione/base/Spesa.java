/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tss.ciac.tecnicheprogrammazione.base;

import java.text.DecimalFormat;

/**
 *
 * @author Paolo
 */
public class Spesa {
    enum Valuta {
        EURO,DOLLARO,STERLINA,YEN
    }
    private Valuta valuta;
    private float importo;
    private DecimalFormat numberFormat = new DecimalFormat("#.00");

    public Spesa(Valuta valuta, float importo) {
        this.valuta = valuta;
        this.importo = importo;
    }

    public Valuta getValuta() {
        return valuta;
    }

    public float getImporto() {
        return importo;
    }

    @Override
    public String toString() {
        return "Spesa{" + "valuta=" + valuta + ", importo=" + numberFormat.format(importo) + '}';
    }

    
}
