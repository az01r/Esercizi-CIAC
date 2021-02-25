import java.util.Scanner;

public class Esercizio03_array {
    // dichiarazione array della dimensione inserita
    // dichiaro 3 array a livello di classe per poter essere utilizzati dai metodi
    static String nomi[];
    static int voti[];
    static float[] versamenti;
    
    public static void main(String[] args) {
        Scanner lettores = new Scanner(System.in); // crea l'oggetto lettore di tipo Scanner
        Scanner lettorei = new Scanner(System.in); // crea l'oggetto lettore di tipo Scanner
        Scanner lettoref = new Scanner(System.in); // crea l'oggetto lettore di tipo Scanner

        int maxn;
        System.out.println("Inserire numero alunni");
        maxn = lettorei.nextInt();

        nomi = new String[maxn]; // assegno dimensione maxn
        voti = new int[maxn];
        versamenti = new float[maxn];

        /* ----------------------------------------- CARICA ARRAY STUDENTI ---------------------------------*/   
        for (int i = 0; i < nomi.length; i++) {
            System.out.println("Inserire nome alunno");
            nomi[i] = lettores.nextLine();
            System.out.println("Inserire voto alunno");
            voti[i] = lettorei.nextInt();
            System.out.println("Inserire importo verssamento tassa");
            versamenti[i] = lettoref.nextFloat();
        }
        /*-------------------------------------------------------------------------------------------------*/

        // stampa elenco alunni
        stampaElencoAlunni();

        // totale versato
        float totVersato = calcoloTotaleVersato();
        System.out.println("Il totale versato è di " + totVersato + "€");

        // calcolare media
        float media = calcolaMedia();
        System.out.println("La media è di " + media);

        // trovare il migliore
        String strMigliore = trovaMigliore();
        System.out.println("Il migliore è " + strMigliore);

        // dire quanti sono promossi
        int promossi = contaPromossi();        
        System.out.println("Gli studenti promossi sono " + promossi);

        // modifica voti
        System.out.println("Inserire valore modifa voti");
        int modifica = lettoref.nextInt();
        System.out.println("Inserire voto massimo");
        int votoMax = lettoref.nextInt();
/*----------------------------------------PASSAGGIO PARAMETRI A METODO--------------------------------------------------------*/
        modificaVoti(modifica, votoMax);        
/*----------------------------------------------------------------------------------------------------------------------------*/ 

        // esami effettuati
        esamiEffettuati();
    }







/*---------------------------------------------------ALTRI METODI-----------------------------------------------------------*/

/*--------------------------------------------------------------------------------------------------------------*/
/*--------------------------------------------------------------------------------------------------------------*/

    static void stampaElencoAlunni() {
        System.out.println("---------------------------elenco alunni--------------------------------");
        for (int i = 0; i < nomi.length; i++) {

            System.out.println(
                    "Nominativo:  " + nomi[i] + "\nVoto:  " + voti[i] + "\n Versamento:  " + versamenti[i] + "€");
            System.out.println("------------------------------------------------------------------------");

        }
    }

/*--------------------------------------------------------------------------------------------------------------*/
/*--------------------------------------------------------------------------------------------------------------*/

    static float calcoloTotaleVersato() {
        float totVersatoMetodo = 0;
        for (int i = 0; i < versamenti.length; i++) {
            totVersatoMetodo = totVersatoMetodo + versamenti[i];
        }
        return totVersatoMetodo;     

    }

/*--------------------------------------------------------------------------------------------------------------*/
/*--------------------------------------------------------------------------------------------------------------*/

    static int contaPromossi(){
        int promossi = 0;
        for (int i = 0; i < nomi.length; i++) {
            if (voti[i] > 18) {
                promossi++;
            }
        }
        return promossi;
    }

/*--------------------------------------------------------------------------------------------------------------*/
/*--------------------------------------------------------------------------------------------------------------*/

    static String trovaMigliore () {
        int maxVoti = voti[0];
        String strMigliore = nomi[0];
        for (int i = 1; i < nomi.length; i++) {
            if (maxVoti < voti[i]) {
                maxVoti = voti[i];
                strMigliore = nomi[i];
            }
        }
        return strMigliore;
    }
    
/*--------------------------------------------------------------------------------------------------------------*/
/*--------------------------------------------------------------------------------------------------------------*/

    static float calcolaMedia (){
        float totVoti = 0;
        for (int i = 0; i < voti.length; i++) {
            totVoti = totVoti + voti[i];
        }
        float media = totVoti / voti.length;
        return media;
    }

/*--------------------------------------------------------------------------------------------------------------*/
/*-------------------------------------- PASSARE PARAMETRI A UN METODO -----------------------------------------*/

    static void modificaVoti(int parametroModifica,int parametroVotoMax) {
        for(int i=0; i<voti.length;i++){
            if((voti[i]+parametroModifica)<=0){
                voti[i]=0;
            }else if((voti[i]+parametroModifica)>=parametroVotoMax){
                voti[i]=parametroVotoMax;
            }else{
                voti[i]=voti[i]+parametroModifica;
            }          
        }
    }

/*--------------------------------------------------------------------------------------------------------------*/
/*--------------------------------------------------------------------------------------------------------------*/

    static void esamiEffettuati(){
        System.out.println("Oggi sono stati effettuati "+voti.length+" esami");
    }

}
