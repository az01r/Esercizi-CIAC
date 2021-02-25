import java.util.Scanner; // Import the Scanner class

public class Esercizio02_for {

    public static void main(String[] args) {
        Scanner lettore = new Scanner(System.in); // crea l'oggetto lettore di tipo Scanner
        int maxn;
        System.out.println("Inserire massimo indice");
        maxn = lettore.nextInt();

        for (int i = 1; i <= maxn; i++) {
            System.out.println(i);
        }

        // int voi[] == int[] voti
        int voti[] = {10,10,8,5};   // voti.lenght == 4 non modificabile
        
        voti[2]=3;  // assegno 5 al terzo elemento

        
        for (int i = 0; i<voti.length; i++)  {
            System.out.println(voti[i]);
        }

        lettore.close();

        for(int i=0; i<voti.length; i++){
            voti[i]=voti[i]-1;
        }
        

        for (int i = 0; i<voti.length; i++)  {
            System.out.println(voti[i]);
        }
    }
}
