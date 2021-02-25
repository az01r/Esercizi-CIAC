import java.util.Scanner;

public class Esercizio07_OperatoriLogici {
    static Scanner lettorei = new Scanner(System.in); // crea l'oggetto lettore di tipo Scanner

    public static void main(String[] args) {
        System.out.println("Inserire voto in centesimi");
        int x = lettorei.nextInt();
        System.out.println("Inserire voto in centesimi");
        int y = lettorei.nextInt();

        int somma = x + y;
        int diff;
        diff = x - y;
        /* diff  = Math.abs(num); */
        if (somma > 100 && ((diff < 30) && (diff > 0) || (diff > -30) && (diff < 0))) {

            System.out.println("Superato: somma = " + somma + ", supera 120 di " + (somma - 120)
                    + " e la differenza tra i due è minore di 30");
        } else {
            System.out.println("Non superato");
        }

    }
}
