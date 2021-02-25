import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class App {
    
    public static void main(String[] args) throws Exception {
        /*
         * posso cancellare il file scuola.txt perché sara ricreato
         * chiedendo i dati all'utente
         */
        String scuola = leggiFileScuola("scuola.txt");
        String[] attributi = scuola.split(":");
        Scuola sc= new Scuola(attributi[0].trim(),attributi[1].trim());

        int nCorsi = sc.importaCorsiDaFile();
        System.out.println("Numero corsi: " + nCorsi);
        int nAlunni = sc.importaAlunniDaFile();
        System.out.println("Numero alunni: " + nAlunni);


        sc.addAlunno();
        sc.addCorso();
        sc.salvaFileAlunni();
        sc.salvaFileCorsi();

        stampaFile("alunni.txt");
        stampaFile("corsi.txt");

        System.out.println(sc.info());

    }

    /**
     * controlla se esiste il file "nomeFile" contenente nomeScuola:indirizzoScuola;
     * se esiste lo legge e ritorna una stringa
     * se no chiede nomeScuola e indirizzoScuola e crea il file
     * @param nomeFile da leggere
     * @return ritorna una stringa con nomeScuola:indirizzoScuola
     */
    static String leggiFileScuola(String nomeFile) {
        String tx="";
        /**
         * ritorna il percorso assoluto della applicazione corrente
         * C:\Users\Paolo\Desktop\Esercizi CIAC\GestSpettacoli
         */
        String pathFile = System.getProperty("user.dir") + "\\dati\\" + nomeFile;
            
        try {
            File myObj = new File(pathFile);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                tx += myReader.nextLine() + "\n"; // aggiungo \n perché nextLine non ritorna \n
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            Scanner myReader = new Scanner(System.in);
            String nomeScuola;
            String indirizzoScuola;
            System.out.println("Inserire nome scuola: ");
            nomeScuola=myReader.nextLine();
            System.out.println("Inserire indirizzo scuola: ");
            indirizzoScuola=myReader.nextLine();
            // costruisco la stringa da ritornare
            tx = nomeScuola + ":" + indirizzoScuola;
            // ora creo il file
            try {
                FileWriter myWriter = new FileWriter(pathFile);
                myWriter.write(tx);
                myWriter.close();
                System.out.println("Successfully wrote to the file.");
            } catch (IOException err) {
                System.out.println("Unable to write to the file.");
                e.printStackTrace();
            }
        }
        return tx;
    }

    static void stampaFile(String nomeFile) {
        String tx="";
        /**
         * ritorna il percorso assoluto della applicazione corrente
         * C:\Users\Paolo\Desktop\Esercizi CIAC\GestSpettacoli
         */
        String pathFile = System.getProperty("user.dir") + "\\dati\\" + nomeFile;
        try {
            File myObj = new File(pathFile);
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                tx += myReader.nextLine() + "\n"; // aggiungo \n perché nextLine non ritorna \n
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        System.out.println(tx);
    }

    
}
