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
public class Moto extends Mezzo{
    
    private float costoAssicurazioneGiornaliero;

    public Moto(float costoAssicurazioneGiornaliero, TipoMezzo tipo, String modello, float prezzoGiornaliero, float prezzoOrario) {
        super(tipo, modello, prezzoGiornaliero, prezzoOrario);
        this.costoAssicurazioneGiornaliero = costoAssicurazioneGiornaliero;
    }

    @Override
    public float costoNoleggioGG(int giorni){
        return (this.prezzoGiornaliero+this.costoAssicurazioneGiornaliero)*giorni;
    }

    @Override
    public String toString() {
        return super.toString()+"Moto{" + "costoAssicurazioneGiornaliero=" + costoAssicurazioneGiornaliero + '}';
    }

    

    

    
    
}
