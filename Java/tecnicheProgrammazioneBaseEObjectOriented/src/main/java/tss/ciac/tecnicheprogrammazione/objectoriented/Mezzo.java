/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tss.ciac.tecnicheprogrammazione.objectoriented;

/**
 *
 * @author Paolo
 */
enum TipoMezzo {
    MOTORE,SENZA_MOTORE
}
public class Mezzo {
    protected TipoMezzo tipo;
    protected String modello;
    protected float prezzoGiornaliero;
    protected float prezzoOrario;

    public Mezzo(TipoMezzo tipo, String modello, float prezzoGiornaliero, float prezzoOrario) {
        this.tipo = tipo;
        this.modello = modello;
        this.prezzoGiornaliero = prezzoGiornaliero;
        this.prezzoOrario = prezzoOrario;
    }
    
    public TipoMezzo getTipo() {
        return tipo;
    }

    public void setTipo(TipoMezzo tipo) {
        this.tipo = tipo;
    }

    public String getModello() {
        return modello;
    }

    public void setModello(String modello) {
        this.modello = modello;
    }

    public float getPrezzoGiornaliero() {
        return prezzoGiornaliero;
    }

    public void setPrezzoGiornaliero(float prezzoGiornaliero) {
        this.prezzoGiornaliero = prezzoGiornaliero;
    }

    public float getPrezzoOrario() {
        return prezzoOrario;
    }

    public void setPrezzoOrario(float prezzoOrario) {
        this.prezzoOrario = prezzoOrario;
    }

    @Override
    public String toString() {
        return "Mezzo{" + "tipo=" + tipo + ", modello=" + modello + ", prezzoGiornaliero=" + prezzoGiornaliero + ", prezzoOrario=" + prezzoOrario + '}';
    }
    
    public float costoNoleggioGG(int giorni){
        return this.prezzoGiornaliero*giorni;
    }
}
