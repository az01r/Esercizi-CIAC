/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tss.ciac.escollectioninterfacestream.esercizio4;

/**
 *
 * @author Paolo
 */

import java.util.Objects;

public class Contatto {

    public static enum TipoContatto {
        PERSONALE, CASA, UFFICIO, EMAIL, TELEGRAM
    }

    private final TipoContatto tipo;
    private final String contatto;

    public Contatto(TipoContatto tipo, String contatto) {
        this.tipo = tipo;
        this.contatto = contatto;
    }

    public TipoContatto getTipo() {
        return tipo;
    }

    public String getContatto() {
        return contatto;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.tipo);
        hash = 37 * hash + Objects.hashCode(this.contatto);
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
        final Contatto other = (Contatto) obj;
        if (!Objects.equals(this.contatto, other.contatto)) {
            return false;
        }
        return this.tipo == other.tipo;
    }

    @Override
    public String toString() {
        return "\t\t" + contatto + " - " + tipo.name();
    }

}