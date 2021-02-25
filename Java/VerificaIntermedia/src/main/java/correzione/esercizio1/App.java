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
public class App {

    public static void main(String[] args) {
             
        try {
            System.out.println("start esercizio1");

            Garage g = new Garage(1);

            System.out.println(g.getClass());
            
            immissioneInGarage(g, new Auto(4, Auto.Alimentazione.BENZINA, "FIAT", 2020, 1000));

            g.situazione();

            immissioneInGarage(g, new Moto(Moto.Tempi.DUE_TEMPI, "KTM", 2018, 600));

            g.situazione();

            Veicolo uscito = uscitaGarage(g, 20);

            System.out.println("E' uscito il veicolo:\n" + uscito);

            g.situazione();

            immissioneInGarage(g, new Furgone(100, "RENAULT", 2019, 3000));

            immissioneInGarage(g, new Camion(100, "DUCATO", 2000, 2000));

            g.situazione();

            System.out.println("fine esercizio1");

        } catch (Exception e) {
            System.out.println("Oops qualcosa è andato storto...");
        }
    }

    public static void immissioneInGarage(Garage g, Veicolo v) {
        try {
            g.entra(v);
        } catch (GarageException e) {
            System.out.println(e.getMessage());
        }
    }

    public static Veicolo uscitaGarage(Garage g, int posto) {
        try {
            return g.esci(posto);
        } catch (GarageException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
    

}
