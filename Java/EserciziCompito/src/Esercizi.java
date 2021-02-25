import java.util.ArrayList;
import java.util.Scanner;

public class Esercizi {

    void es1() {
        /*
         * esercizio1 programma lineare chiedere informazioni all'utente elaborarle e
         * fornire un output utilizzando apposite funzioni/procedure richiesta costo
         * totale acquisto - importo di acconto - in output restante a pagare
         */
        float tot;
        float acconto;
        Scanner lettore = new Scanner(System.in);
        System.out.println("Inserire totale da pagare");
        tot = lettore.nextFloat();
        System.out.println("Inserire acconto");
        acconto = lettore.nextFloat();
        System.out.println("Restano da pagare " + (tot - acconto) + "€");
    }

    void es2() {
        /*
         * esercizio 2 programma di verifica su costrutti condizionali richiesta di voto
         * orale e scritto e seguente promozione solo in caso di entrambi maggiori
         * uguali a 18 utilizzo sempre di pocedure e funzioni
         */

        int votoOrale, votoScritto;
        boolean promosso = false;
        Scanner lettore = new Scanner(System.in);
        System.out.println("Inserire voto orale");
        votoOrale = lettore.nextInt();
        System.out.println("Inserire voto scritto");
        votoScritto = lettore.nextInt();
        if (votoOrale >= 18) {
            if (votoScritto >= 18) {
                promosso = true;
                System.out.println("Promosso");
            }
        }
        if (!promosso) {
            System.out.println("Rimandato");
        }
    }

    void es3() {
        /*
         * esercizio 3 verifica su concetti di array e utilizzo cicli for richiesta di 5
         * nomi da eleggere e corrispondenti voti ricevuti in output il nome del
         * vincitore ed i suoi voti
         */
        int nPolitici = 5;
        Scanner lettore = new Scanner(System.in);
        String nomi[] = new String[nPolitici];
        int voti[] = new int[5];
        // input
        for (int i = 0; i < nPolitici; i++) {
            System.out.println("Inserire nome da eleggere");
            nomi[i] = lettore.nextLine();
            lettore = new Scanner(System.in);
            System.out.println("Inserire voti ricevuti");
            voti[i] = lettore.nextInt();
            lettore = new Scanner(System.in);
        }
        // elaborazione
        int max = voti[0];
        String vincitore = nomi[0];
        for (int i = 1; i < nPolitici; i++) {
            if (voti[i] > max) {
                max = voti[i];
                vincitore = nomi[i];
            }
        }
        // output
        System.out.println("Il vincitore è " + vincitore + " con " + max + " voti");
    }

    void es4() {
        /*
         * esercizio 4 verifica su cicli while chiedere i pezzi lavorati a cottimo da
         * una serie indefinita di operai al termine fornire il numero operai che hanno
         * lavorato, la media dei pezzi prodotti ed il totale di pezzi
         */
        
        ArrayList<Integer> pezziOperai = new ArrayList<Integer>();
        Scanner lettore = new Scanner(System.in);
        boolean finito = false;
        int operai = 0;
        int totPezzi = 0;
        float media;
        while (!finito) {
            System.out.println("Inserire numero pezzi finiti dall'operaio " + (operai + 1));
            pezziOperai.add(lettore.nextInt()) ;
            totPezzi = totPezzi + pezziOperai.get(operai);
            operai++;
            System.out.println("Aggiungere altri opera? (true/false)");
            finito = !(lettore.nextBoolean());
        }
        if (pezziOperai.size() != 0) {
            media = totPezzi / (operai);
            System.out.println("Hanno lavorato " + (operai) + " operai con una media di " + media
                    + " per operaio\nTotale pezzi prodotti: " + totPezzi);
        } else
            System.out.println("Hanno lavorato 0 operai\nTotale pezzi prodotti: " + totPezzi);

    }
}
