/*
Si realizzi una applicazione java per la gestione di un garage secondo le
specifiche:
il garage ha al max 15 posti ognuno dei quali è identificato da un num a partire
da 0 e per motivi di capienza può ospitare solo auto moto e furgoni partendo
dalla classe base veicolo a motore V; la si estenda, realizzando anche le classi
che modellano le entità furgone (F) auto (A) e moto (M).
Ridefinire il metodo toString in modo che ogni entità possa esternalizzare in
forma di stringa tutte le informazioni che la riguardano.
Si implementi una classe che modelli il garage sopradescritto offrendo le
seguenti operazioni di gestione
1] immissione di un nuovo veicolo
2] estrazione dal garage del veicolo che occupa un determinato posto (ritornare
l'istanza del veicolo stesso)
3] stampa della situazione corrente dei posti nel garage 
veicolo:marca,anno,cilindrata;
auto:porte, alimentazione (diesel/benzina)
moto:tempi
furgone:capacità
 */
package tss.ciac.verificaintermedia.esercizio1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Paolo
 */
public class App {
    private static ArrayList<Veicolo> veicoli = new ArrayList<Veicolo>();
    public static void main(String[] args) {
        Garage g = new Garage();
        Auto v1= new Auto(3, Alimentazione.BENZINA, "Audi", 2020, 2000);
        Furgone v2= new Furgone(5000, "Fiat", 2010, 3000);
        Moto v3 = new Moto(Tempi.DUE, "KTM", 2018, 600);
        g.parcheggia(v1);
        g.parcheggia(v2);
        g.parcheggia(v3);
        g.rimuovi(v1);
        
        System.out.println(v1.info());
        String a = g.infoGarage();
        System.out.println(g.infoGarage());
    }
    
    
    
    /**
     * aggiunge un'auto all'ArrayList veicoli
     *
     * @return veicolo creato
     */
    public static Veicolo addAuto() {
        System.out.println("Inserire marca :");
        Scanner lettore = new Scanner(System.in);
        String marca = lettore.nextLine();
        System.out.println("Inserire cilindrata :");
        lettore = new Scanner(System.in);
        int cilindrata = lettore.nextInt();
        System.out.println("Inserire anno :");
        int anno = lettore.nextInt();
        System.out.println("Inserire numero porte :");
        int nPorte = lettore.nextInt();
        System.out.println("Inserire alimentazione : (DIESEL - BENZINA - ELETTRICA - IBRIDA)");
        lettore = new Scanner(System.in);
        Alimentazione alimentazione= Alimentazione.valueOf(lettore.nextLine());
        switch (alimentazione) {
            case DIESEL:
                alimentazione = Alimentazione.DIESEL;
                break;
            case BENZINA:
                alimentazione = Alimentazione.BENZINA;
                break;
            case ELETTRICA:
                alimentazione = Alimentazione.ELETTRICA;
                break;
            case IBRIDA:
                alimentazione = Alimentazione.IBRIDA;
                break;
            default:
                System.out.println("errore");
        }
        
        Veicolo veicolo = new Auto(nPorte, alimentazione, marca, cilindrata, anno);
        veicoli.add(veicolo);
        return veicolo;
    }
    
    /**
     * aggiunge un furgone all'ArrayList veicoli
     *
     * @return veicolo creato
     */
    public static Veicolo addFurgone() {
        System.out.println("Inserire marca :");
        Scanner lettore = new Scanner(System.in);
        String marca = lettore.nextLine();
        System.out.println("Inserire cilindrata :");
        lettore = new Scanner(System.in);
        int cilindrata = lettore.nextInt();
        System.out.println("Inserire anno :");
        int anno = lettore.nextInt();
        System.out.println("Inserire carico massimo :");
        int maxCarico = lettore.nextInt();
        
        Veicolo veicolo = new Furgone(maxCarico, marca, cilindrata, anno);
        veicoli.add(veicolo);
        return veicolo;
    }
    
    /**
     * aggiunge una moto all'ArrayList veicoli
     *
     * @return veicolo creato
     */
    public static Veicolo addMoto() {
        System.out.println("Inserire marca :");
        Scanner lettore = new Scanner(System.in);
        String marca = lettore.nextLine();
        System.out.println("Inserire cilindrata :");
        lettore = new Scanner(System.in);
        int cilindrata = lettore.nextInt();
        System.out.println("Inserire anno :");
        int anno = lettore.nextInt();
        System.out.println("Inserire numero tempi : (DUE - QUATTRO)");
        lettore = new Scanner(System.in);
        Tempi tempi = Tempi.valueOf(lettore.nextLine());
        Veicolo veicolo = new Moto(tempi, marca, anno, cilindrata);
        veicoli.add(veicolo);
        return veicolo;
    }
}
