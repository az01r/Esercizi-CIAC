import java.util.Scanner;

public class Esercizio06_ordinarearray {
    static int NPRODOTTI = 3;
    static String[] prodotti = new String[NPRODOTTI]; // crea array da 5 stringhe
    static float[] prezzi = new float[NPRODOTTI]; // crea array da 5 float
    static Scanner lettores = new Scanner(System.in); // crea l'oggetto lettore di tipo Scanner
    static Scanner lettorei = new Scanner(System.in); // crea l'oggetto lettore di tipo Scanner
    static Scanner lettoref = new Scanner(System.in); // crea l'oggetto lettore di tipo Scanner
    

    public static void main(String[] args) {
        chiediProdotti();
        System.out.println("----------------Elenco Prodotti----------------");
        mostraProdotti();
        
        sconto();
        System.out.println("-----------Elenco Prodotti con Sconto-----------");
        mostraProdotti();

        ordinaProdotti();
        System.out.println("-------Elenco Prodotti Ordinati per Nome--------");
        mostraProdotti();
        
        ordinaPrezzi();
        System.out.println("------Elenco Prodotti Ordinati per Prezzo-------");
        mostraProdotti();
    }

    static void chiediProdotti() {
        for (int i = 0; i < NPRODOTTI; i++) {
            System.out.println("Inserire prodotto " + (i + 1));
            prodotti[i] = lettores.nextLine();
            System.out.println("Inserire prezzo " + prodotti[i] + ":");
            prezzi[i] = lettoref.nextFloat();
        }
    }

    static void mostraProdotti() {
        for (int i = 0; i < NPRODOTTI; i++) {
            System.out.println("Nome prodotto: " + prodotti[i] + " Prezzo: " + prezzi[i]);
        }
    }

    static void sconto() {
        System.out.println("Inserire numero prodotto da scontare (1 - 2 - 3 - 4 - 5)");
        int numero = lettorei.nextInt();
        System.out.println("Inserire percentuale sconto (es: 20 - 50 - 70)");
        float sconto = lettoref.nextFloat();
        prezzi[numero - 1] = prezzi[numero - 1] * (100 - sconto) / 100;
    }

    static void ordinaProdotti() {
        for (int i = 0; i < NPRODOTTI; i++) { 
            for (int j = i+ 1; j < NPRODOTTI; j++){
                if (prodotti[i].compareTo(prodotti[j]) > 0) { 
                    // se il primo viene dopo in ordine alfabetico 
                    // scambio il primo con il secondo
                    String temp = prodotti[i];
                    prodotti[i] = prodotti[j];
                    prodotti[j] = temp;
         
                    // scambio i relativi prezzi (senza creare altre variabili)
                    prezzi[i] = prezzi[i] + prezzi[j];
                    prezzi[j] = prezzi[i] - prezzi[j]; 
                    prezzi[i] = prezzi[i] - prezzi[j]; 
                } 
            }
        } 
    }

    static void ordinaPrezzi(){
        for(int i=0;i<NPRODOTTI;i++){
            for(int j=i+1;j<NPRODOTTI;j++){
                if(prezzi[j]<prezzi[i]){
                    prezzi[i] = prezzi[i] + prezzi[j];
                    prezzi[j] = prezzi[i] - prezzi[j]; 
                    prezzi[i] = prezzi[i] - prezzi[j];

                    String temp = prodotti[i];
                    prodotti[i] = prodotti[j];
                    prodotti[j] = temp;
                }
            }
        }
    }

}
