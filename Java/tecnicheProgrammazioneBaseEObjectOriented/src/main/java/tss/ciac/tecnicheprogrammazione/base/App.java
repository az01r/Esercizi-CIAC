/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tss.ciac.tecnicheprogrammazione.base;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import tss.ciac.tecnicheprogrammazione.base.Spesa.Valuta;

/**
 *
 * @author Paolo
 */
public class App {
    static final int MAX_SPESE = 8;
    static Scanner lettore = new Scanner(System.in);
    static String nome;
    static String cognome;
    static LocalDate dataDiNascita;
    static List<Spesa> spese = new ArrayList<>();
    static boolean aggiungiSpesa=true;
    static float anticipo;
    enum Tipo {
        GIOVANE,ADULTO,SENIOR
    }
    
    public static void main(String[] args) {
        
        
        /**
         * main per inserire credenziali
         */
        System.out.println("Inserire nome");
        nome = lettore.nextLine();
        System.out.println("Inserire cognome");
        cognome = lettore.nextLine();
        System.out.println("Inserire data di nascita (yyyy-MM-dd)");
        dataDiNascita = LocalDate.parse(lettore.nextLine(), DateTimeFormatter.ISO_LOCAL_DATE);
        
        stampaScheda(nome,cognome,dataDiNascita);
        
        /**
         * main per aggiungere spese
         */
        while (aggiungiSpesa&&spese.size()<MAX_SPESE) {
            System.out.println("Scegliere valuta: EURO,DOLLARO,STERLINA,YEN");
            lettore = new Scanner(System.in);
            Valuta valuta = Valuta.valueOf(lettore.nextLine());
            System.out.println("Inserire importo");
            lettore = new Scanner(System.in);
            float importo = Float.parseFloat(lettore.nextLine());
            spese.add(new Spesa(valuta, importo));
            System.out.println("Inserire nuova spesa? (true,false)");
            lettore = new Scanner(System.in);
            aggiungiSpesa = lettore.nextBoolean();
        }
        
        System.out.println("Inserire un anticipo");
        lettore = new Scanner(System.in);
        anticipo = lettore.nextFloat();
        
        stampaSpese();
    }

    public static void stampaScheda(String nome, String cognome, LocalDate dataDiNascita) {
        if(dataDiNascita.getYear()<18)
        System.out.println(
                "Nome: " + nome
                + "\nCognome: " + cognome
                + "\nAnno nascita: " + dataDiNascita.getYear()
                + "\nAnni: " + LocalDate.now().minusYears(dataDiNascita.getYear())
                + "\nTipo: " + getTipo(dataDiNascita)
        );
    }
    
    public static Tipo getTipo(LocalDate dataDiNascita) {
        if(dataDiNascita.getYear()<0) throw new IllegalArgumentException("Data non corretta");
        else if(dataDiNascita.getYear()<18) return Tipo.GIOVANE;
        else if(dataDiNascita.getYear()<60) return Tipo.ADULTO;
        else return Tipo.SENIOR;
    }
    
    public static void stampaSpese(){
        System.out.println("Spese: ");
        for (int i = 0; i < spese.size(); i++) {
            System.out.println(i+") "+spese.get(i).toString());
        }
        System.out.print("Totale: ");
        System.out.printf("%.2f\n",getTotaleSpese());
        System.out.print("Anticipati: ");
        System.out.printf("%.2f",anticipo);
        if(getReportSpese(anticipo)<0){
            System.out.print("Credito: ");
            System.out.printf("%.2f",-getReportSpese(anticipo));
        }else{
            System.out.print("Debito: ");
            System.out.printf("%.2f",getReportSpese(anticipo));
        }
        
    }
    
    /**
     * calcola il totale delle spese
     * @return 
     */
    public static float getTotaleSpese(){
        float totale=0;
        for (Spesa spesa : spese) {
            totale+=spesa.getImporto();
        }
        return totale;
    }
    
    /**
     * fa la differenza tra il totale delle spese e l'anticipo pagato
     * se negativo significa che ho avanzato dei soldi
     * se positivo significa che devo ancora saldare il conto
     * @param anticipo
     * @return 
     */
    public static float getReportSpese(float anticipo) {
        return getTotaleSpese()-anticipo;
    }
}
