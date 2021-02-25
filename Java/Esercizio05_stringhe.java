
import java.util.Scanner;

import javax.xml.catalog.Catalog;

import jdk.javadoc.internal.doclets.formats.html.resources.standard;

public class Esercizio05_stringhe {
    static Scanner lettores = new Scanner(System.in); // crea l'oggetto lettore di tipo Scanner
    static Scanner lettorei = new Scanner(System.in); // crea l'oggetto lettore di tipo Scanner
    static Scanner lettoref = new Scanner(System.in); // crea l'oggetto lettore di tipo Scanner

    public static void main(String[] args) {
        System.out.println("Scegliere esercizio: 1 - 2 - 3 - 4");
        int es = lettorei.nextInt();
        switch (es) {
            case 1:
                es1();
                break;
            case 2:
                es2();
                break;
            case 3:
                es3();
                break;
            case 4:
                es4();
                break;
            default:
                System.out.println("errore");
                break;
        }

    }

    /*
     * es1: creare 3 variabili di tipo testo e chiedere 3 nomi diversi, creare una
     * variabile sempre di testo risultato in cui inserire i 3 nomi separati da un
     * trattino, al termine presentare il risultato
     */
    static void es1() {
        System.out.println("Inserire primo nome");
        String nome1 = lettores.nextLine();
        System.out.println("Inserire secondo nome");
        String nome2 = lettores.nextLine();
        System.out.println("Inserire terzo nome");
        String nome3 = lettores.nextLine();

        String risultato = (nome1 + "-" + nome2 + "-" + nome3);
        System.out.println(risultato);
    }

    /*
     * es2: creare 2 variabili di tipo numerico e chiedere i 2 numeri, creare una
     * variabile per il risultato in cui sommare i 2 numeri, moltiplicare i 2 numeri
     * sottrarre i due e al termine presentare il risultato sottoforma di 4 righe
     * con visualizzati i 2 numeri utitlizzati - somma - molt - sottr
     */

    static void es2() {

        System.out.println("Inserire numero x");
        int x = lettorei.nextInt();
        System.out.println("Inserire numero y");
        int y = lettorei.nextInt();

        int result = x + y;
        System.out.println("Somma = " + result);
        result = x * y;
        System.out.println("Moltiplicazione = " + result);
        result = x - y;
        System.out.println("Differenza = " + result);
    }

    /*
     * es3: creare 2 variabili di tipo numerico e chiedere i 2 numeri, creare una
     * variabile risultato, fare la somma e dire se supera 100 con messaggio (la
     * somma e' 123 e supera 100 di 23)
     */
    static void es3() {
        System.out.println("Inserire voto in centesimi");
        int x = lettorei.nextInt();
        System.out.println("Inserire voto in centesimi");
        int y = lettorei.nextInt();

        int result = x + y;
        int diff;
        if (result > 100) {
            diff = result - 100;
            System.out.println("Somma = " + result + " e supera 120 di " + diff);
        } else {
            System.out.println("Somma = " + result + " e non supera 120");
        }
    }

    /*
     * es4: creare un array di tipo testo da 5 elementi chiedere per 5 volte di
     * inserire 5 nomi prodotto stampare i 5 prodotti una riga per volta ( ad
     * esempio xt10 - r50 - turboplus - rocket5 ....) chiedere i prezzi per i 10
     * articoli, presentando nella richiesta la frase "ins. prezzo prodotto 1" o
     * ancora meglio "ins. prezzo prodotto xt10" e stampare 5 righe con nome e
     * prezzo prodotto
     */

    
    static String[] prodotti = new String[5]; // crea array da 5 stringhe
    static float[] prezzi = new float[5]; // crea array da 5 float

    static void es4() {
        
        for (int i = 0; i < 5; i++) {
            System.out.println("Inserire prodotto " + (i + 1));
            prodotti[i] = lettores.nextLine();
            System.out.println("Inserire prezzo " + prodotti[i] + ":");
            prezzi[i] = lettoref.nextFloat();
        }

        catalogo();
        System.out.println("Inserire numero prodotto da scontare (1 - 2 - 3 - 4 - 5)");
        int prodotto = lettorei.nextInt();
        System.out.println("Inserire percentuale sconto (es: 20 - 50 - 70)");
        int sconto = lettorei.nextInt();
        prezzi[prodotto - 1] = scontare(sconto, prezzi[prodotto - 1]);

        for (int i = 0; i < 5; i++) {
            System.out.println("Nome prodotto: " + prodotti[i] + " Prezzo: " + prezzi[i]);
        }
        /*
         * creare un metodo a cui passo uno sconto, richiamarlo con un valore a scelta,
         * e poi richiamare il metodo di stampa precedente per vedere i prodotti con i
         * nuovi prezzi
         */

    }

    static void catalogo(){
        for (int i = 0; i < 5; i++) {
            System.out.println("Nome prodotto: " + prodotti[i] + " Prezzo: " + prezzi[i]);
        }

    }

    static float scontare(int sconto, float prezzo) {
        return prezzo * (100 - sconto) / 100;
    }

}
// riordinare prodotti per prezzo crescente
