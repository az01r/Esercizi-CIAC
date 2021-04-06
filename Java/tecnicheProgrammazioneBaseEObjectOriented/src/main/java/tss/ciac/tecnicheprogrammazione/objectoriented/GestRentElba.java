/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tss.ciac.tecnicheprogrammazione.objectoriented;

import java.time.LocalDate;
import java.time.Month;

/**
 *
 * @author Paolo
 */
public class GestRentElba {
    public static void main(String[] args) {
        Moto moto = new Moto(20, TipoMezzo.MOTORE, "Ducati Panigale", 200, 50);
        System.out.println(moto.toString());
        System.out.println("Costo noleggio per 10 giorni: " + moto.costoNoleggioGG(10) + "€");
        Turista turista = new Turista("pol", "pol", "Paolo", "Grosso", LocalDate.of(1998, Month.JANUARY, 21), "333");
        Noleggio noleggio = new Noleggio(turista, moto, LocalDate.of(2021, Month.AUGUST, 10), LocalDate.of(2021, Month.AUGUST, 16), TipoNoleggio.MEZZO_VITTO_ALLOGGIO);
        System.out.println(noleggio.reportNoleggioMezzo());
        
    }
}
