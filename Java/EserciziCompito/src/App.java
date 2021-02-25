import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner lettore = new Scanner(System.in);
        int index;
        Esercizi esercizio = new Esercizi();
        do {
            System.out.println("Scegliere esercizio: 1-2-3-4 , 0 per uscire");
            index = lettore.nextInt();
            switch (index) {
                case 0:
                    break;
                case 1:
                    esercizio.es1();
                    break;
                case 2:
                    esercizio.es2();
                    break;
                case 3:
                    esercizio.es3();
                    break;
                case 4:
                    esercizio.es4();
                    break;
                default:
                    System.out.println("Esercizio non corretto");

            }
        } while (index != 0);
    }

}
