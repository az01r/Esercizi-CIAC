/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tss.ciac.tecnicheprogrammazione.objectoriented;

import java.time.LocalDate;
import java.time.temporal.TemporalAmount;

/**
 *
 * @author Paolo
 */
enum TipoNoleggio {
    MEZZO, MEZZO_VITTO, MEZZO_VITTO_ALLOGGIO
}

public class Noleggio {

    private Turista turista;
    private Mezzo mezzo;
    private LocalDate dataNoleggio;
    private LocalDate dataReso;
    private TipoNoleggio tipoNoleggio;

    public Noleggio(Turista turista, Mezzo mezzo, LocalDate dataNoleggio, LocalDate dataReso, TipoNoleggio tipoNoleggio) {
        this.turista = turista;
        this.mezzo = mezzo;
        this.dataNoleggio = dataNoleggio;
        this.dataReso = dataReso;
        this.tipoNoleggio = tipoNoleggio;
    }

    public Turista getTurista() {
        return turista;
    }

    public void setTurista(Turista turista) {
        this.turista = turista;
    }

    public Mezzo getMezzo() {
        return mezzo;
    }

    public void setMezzo(Mezzo mezzo) {
        this.mezzo = mezzo;
    }

    public LocalDate getDataNoleggio() {
        return dataNoleggio;
    }

    public void setDataNoleggio(LocalDate dataNoleggio) {
        this.dataNoleggio = dataNoleggio;
    }

    public LocalDate getDataReso() {
        return dataReso;
    }

    public void setDataReso(LocalDate dataReso) {
        this.dataReso = dataReso;
    }

    public TipoNoleggio getTipoNoleggio() {
        return tipoNoleggio;
    }

    public void setTipoNoleggio(TipoNoleggio tipoNoleggio) {
        this.tipoNoleggio = tipoNoleggio;
    }

    @Override
    public String toString() {
        return "Noleggio{" + "turista=" + turista + ", mezzo=" + mezzo + ", numGG=" + (int) (dataNoleggio.toEpochDay()-dataReso.toEpochDay()) + ", dataNoleggio=" + dataNoleggio + ", dataReso=" + dataReso + ", tipoNoleggio=" + tipoNoleggio + '}';
    }

    public float renditaNoleggio() {
        return this.mezzo.costoNoleggioGG((int) (dataReso.toEpochDay()-dataNoleggio.toEpochDay()));
    }

    public String reportNoleggioMezzo() {
        return this.toString()+"\nRendita: "+this.renditaNoleggio()+"€";
    }
}
