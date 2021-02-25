import java.util.Scanner;

public class App {
    private static final String LISTA_COMANDI = "--------------Lista Comandi--------------\n0: exit\n1: aggiungi libro a listino\n2: aggiungi libro a listino\n3: stampa listino\n4: svuota carrello\n5: aggiungi prodotto a carrello (passare indice posizione in listino)\n6: stampa carrello\n7: rimuovi prodotto dal carrello\n8: mostra lista comandi\n-----------------------------------------";

    public static void main(String[] args) throws Exception {
        Scanner lettore = new Scanner(System.in);
        int comando;
        BooknFood booknFood = new BooknFood();
        /*
         * booknFood.creaNuovoProdotto(); booknFood.creaNuovoProdotto();
         * booknFood.creaNuovoProdotto(); booknFood.stampaListino();
         * 
         * booknFood.aggiungiAlCarrello(0); booknFood.aggiungiAlCarrello(1);
         * booknFood.aggiungiAlCarrello(2); booknFood.stampaCarrello();
         * booknFood.svuotaCarrello();
         */

        System.out.println(LISTA_COMANDI);
        do {
            System.out.println("Inserire comando");
            comando = lettore.nextInt();

            switch (comando) {
                case 0:
                    break;
                case 1:
                    booknFood.creaNuovoBook();
                    break;
                case 2:
                    booknFood.creaNuovoFood();
                    break;
                case 3:
                    booknFood.stampaListino();
                    break;
                case 4:
                    booknFood.svuotaCarrello();
                    break;
                case 5:
                    System.out.println("Inserire indice prodotto che si vuole aggiungere al carrello");
                    lettore = new Scanner(System.in);
                    int indexProdotto = lettore.nextInt();
                    booknFood.aggiungiAlCarrello(indexProdotto);
                    break;
                case 6:
                    booknFood.stampaCarrello();
                    break;
                case 7:
                    System.out.println("Inserire indice prodotto che si vuole rimuovere dal carrello");
                    lettore = new Scanner(System.in);
                    int index = lettore.nextInt();
                    booknFood.rimuoviIesimoProdottoDalCarrello(index);
                    break;
                case 8:
                    System.out.println(LISTA_COMANDI);
                    break;
                default:
                    System.out.println("Comando non trovato");
            }
        } while (comando != 0);

        /*
         * NB nella classe BooknFood ho creato metodi (richiesti dall'esercizio) che poi
         * sono risultati obsoleti una volta implementati gli altri e quindi ho deciso
         * di non inserirli nelle opzioni de dello switch. Tali metodi sono:
         * "rimuoviUltimoProdottoDalCarrello" e "creaNuovoProdotto"
         */
    }
}
