import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Scuola {
    private String nomeScuola;
    private String indirizzo;
    private ArrayList<Corso> elencoCorsi = new ArrayList<Corso>();
    private ArrayList<Alunno> elencoAlunni = new ArrayList<Alunno>();

    public Scuola(String nomeScuola, String indirizzo) {
        this.nomeScuola = nomeScuola;
        this.indirizzo = indirizzo;
    }

    public String getNomeScuola() {
        return nomeScuola;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public ArrayList<Corso> getElencoCorsi() {
        return elencoCorsi;
    }

    public ArrayList<Alunno> getElencoAlunni() {
        return elencoAlunni;
    }

    public String info() {
        String tx = "";
        tx += "Nome Scuola: " + nomeScuola + "\n";
        tx += "Indirizzo: " + indirizzo + "\n";
        tx += "n* corsi: " + elencoCorsi.size() + "\n";
        tx += "n* alunni: " + elencoAlunni.size() + "\n";
        tx += "Elenco corsi: \n" + stampaCorsi();
        tx += "Elenco alunni: \n" + stampaAlunni();
        return tx;
    }

    /**
     * 
     * @return stringa corsi
     */
    private String stampaCorsi() {
        // creare un tx con tutti i corsi uno per riga e nome e docente separati da ;
        String tx = "";
        for (Corso c : elencoCorsi) {
            tx += "Nome corso:" + c.getNomeCorso() + " - Docente: " + c.getDocente() + "\n";
        }
        return tx;
    }
    
    /**
     * 
     * @return stringa alunni
     */
    private String stampaAlunni() {
        String tx = "";
        for (Corso c : elencoCorsi) {
            tx += "Nome corso: " + c.getNomeCorso() + " - Docente: " + c.getDocente() + "\n";
        }
        return tx;
    }

    /**
     * aggiunge i corsi contenuti nel file corsi.txt a elencoCorsi
     * 
     * @return ritorna il numero di corsi letti dal file
     */
    int importaCorsiDaFile() {
        int n = 0;
        // ritorna il percorso assoluto della applicazione corrente
        // C:\Users\Paolo\Desktop\Esercizi CIAC\GestSpettacoli
        String pathFile = System.getProperty("user.dir") + "\\dati\\corsi.txt";
        try {
            File myObj = new File(pathFile);
            String tx = "";
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                tx = myReader.nextLine();
                try {
                    String[] attributi = tx.split(":"); // divide la riga in due stringhe che nel file sono separate da
                                                        // :
                    Corso corso = new Corso(attributi[0].trim(), attributi[1].trim()); // trim() toglie gli spazi da
                                                                                       // inizio e fondo di una stringa
                    elencoCorsi.add(corso);
                } catch (Exception e) {
                }
            }

            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        n = elencoCorsi.size();
        return n;
    }

    /**
     * aggiunge gli alunni contenuti nel file alunni.txt a
     * elencoAlunni
     * 
     * @return ritorna il numero di alunni letti dal file
     */
    int importaAlunniDaFile() {
        int n = 0;
        // ritorna il percorso assoluto della applicazione corrente
        // C:\Users\Paolo\Desktop\Esercizi CIAC\GestSpettacoli
        String pathFile = System.getProperty("user.dir") + "\\dati\\alunni.txt";
        try {
            File myObj = new File(pathFile);
            String tx = "";
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                tx = myReader.nextLine();
                try {
                    String[] attributi = tx.split(":"); // divide la riga in due stringhe che nel file sono separate da
                                                        // :
                    Alunno alunno = new Alunno(attributi[0].trim(), attributi[1].trim(),
                            Integer.parseInt(attributi[2].trim())); // trim() toglie gli spazi da
                    // inizio e fondo di una stringa
                    elencoAlunni.add(alunno);
                } catch (Exception e) {
                }
            }

            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        n = elencoAlunni.size();
        return n;
    }

    /**
     * crea o sovrascrive il file corsi con l'elenco attuale dei corsi
     * @param elencoCorsi2 arrayList con l'elenco dei corsi
     */
    void salvaFileCorsi() {
        String tx = "";
        for (Corso c : elencoCorsi) {
            tx += c.getNomeCorso() + ":" + c.getDocente() + "\n";
        }
        String pathFile = System.getProperty("user.dir") + "\\dati\\corsi.txt";

        try {
            FileWriter myWriter = new FileWriter(pathFile);
            myWriter.write(tx);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    
    /**
     * crea o sovrascrive il file alunni con l'elenco attuale degli alunni
     */
    void salvaFileAlunni() {
        String tx = "";
        for (Alunno a : elencoAlunni) {
            tx += a.getNome() + ":" + a.getCognome() + ":" + a.getMatricola() + "\n";
        }
        String pathFile = System.getProperty("user.dir") + "\\dati\\alunni.txt";

        try {
            FileWriter myWriter = new FileWriter(pathFile);
            myWriter.write(tx);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    /**
     * aggiunge un alunno all'elenco alunni tramite input da tastiera
     */
    void addCorso() {
        String nomeCorso;
        String docente;

        Scanner lettore = new Scanner(System.in);
        System.out.println("Inserire nome corso: ");
        nomeCorso = lettore.nextLine();
        System.out.println("Inserire docente: ");
        docente = lettore.nextLine();

        Corso newCorso = new Corso(nomeCorso, docente);
        elencoCorsi.add(newCorso);
    }

    /**
     * aggiunge un alunno all'elenco alunni tramite input da tastiera
     */
    void addAlunno() {
        String nome;
        String cognome;
        int matricola;

        Scanner lettore = new Scanner(System.in);
        System.out.println("Inserire nome alunno: ");
        nome = lettore.nextLine();
        System.out.println("Inserire cognome alunno: ");
        cognome = lettore.nextLine();
        lettore = new Scanner(System.in);
        System.out.println("Inserire numero matricola alunno: ");
        matricola = lettore.nextInt();

        Alunno newAlunno = new Alunno(nome, cognome, matricola);
        elencoAlunni.add(newAlunno);
    }
}
