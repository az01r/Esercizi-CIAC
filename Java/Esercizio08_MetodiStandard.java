import java.util.Scanner;

import org.graalvm.compiler.phases.schedule.MemoryScheduleVerification;

public class Esercizio08_MetodiStandard {
    static Scanner lettore = new Scanner(System.in); // crea l'oggetto lettore di tipo Scanner

    public static void main(String[] args) {
        /*
         * io sempre pari pc dispari, io dico numero, pc ne sceglie uno a
         * caso li sommo e vedo se è pari o dispari e assoegno punteggio a me o pc
         * al meglio di 5
         */
        int myNum;
        int pcNum;
        int myScore=0;
        int pcScore=0;
        do {
            System.out.println("Inserisci numero");
            myNum = lettore.nextInt();
            pcNum = (int) (Math.random() * 2); // 0 to 1
            
            if ((myNum + pcNum) % 2 == 0) {
                myScore++;
                System.out.println("Vinto!");
            } else {
                pcScore++;
                System.out.println("Perso!");
            }
        } while (myScore<=3||pcScore<=3);

        System.out.println("Fine partita! Punteggio:\ngiocatore: "+myScore+"\ncomputer: "+pcScore);
        if(myScore>pcScore){
            System.out.println("Hai vinto!");
        }else{
            System.out.println("Hai perso!");   
        }
    }
}