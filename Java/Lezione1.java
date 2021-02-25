import java.util.Scanner;  // Import the Scanner class

public class Lezione1   // le classi iniziano sempre con la maiuscola
                    // Lezione1 è una clase
{
	public static void main(String[] args) {    // main è obbligatorio in ogni programma
	                                            // main è un metodo
	                                            
	    Scanner lettore = new Scanner(System.in);  // crea l'oggetto lettore di tipo Scanner
	    
        System.out.println("Inserisci nome");
        
        // legge stringa e la mette in strNome, 
        // nextLine è un metodo che legge la riga successiva, 
        // String è il tipo della variabile nome, testo
        String strNome = lettore.nextLine();
        
        System.out.println(strNome);   // output per utente
        
        System.out.println("Inserisci età");
        
        // legge intero da tastiera, 
        // nextLine è un metodo che legge la riga successiva, 
        // int è il tipo della variabile strNome, intero
        int intEta = lettore.nextInt();
        
        String strStatus = "";
        if(intEta<18){
            strStatus = "minorenne " + strNome;
            // NB DIFFERENZA CON C: si possono unire stringhe con +
            strStatus = strStatus +".";
        }
        else {
            strStatus = "maggiorenne " + strNome + ".";
        }
	    String strOutput = (strNome+" è "+strStatus);
        System.out.println(strOutput);
	}
}


public class Cubo {     // Cubo è una classe
    
}
