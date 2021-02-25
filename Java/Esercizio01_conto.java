import java.util.Scanner; // Import the Scanner class

public class Esercizio1 {
    public static void main(String[] args) {
        // faccio una operazione sul conto
        // fare una domanda all'utente
        // aspettare che l'utente risponda
        // prendere quello che ha risposto e usarlo per muovere il saldo
        // mostro il nuovo saldo
        int saldoConto = 0;
        int importo;
        Scanner lettore = new Scanner(System.in); // crea l'oggetto lettore di tipo Scanner
        String strOutput;
        
        do {
        System.out.println("Inserire importo versamento (n) o prelievo (-n)");
        importo = lettore.nextInt();

        if (importo > 0) {
            saldoConto = saldoConto + importo;
        } else if (importo < 0) {
            if (importo > saldoConto) {
                System.out.println("Saldo inferiore alla richiesta");
            } else {
                saldoConto = saldoConto + importo;
            }
        }
        strOutput = "Saldo attuale: " + saldoConto + "€";
        System.out.println(strOutput);
        while (importo!=0);
        }    
        
        
    }
}