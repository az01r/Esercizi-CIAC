import java.util.ArrayList;
import java.util.Scanner;

public class Agenzia {
    String nomeAgenzia;
    String indirizzo;
    ArrayList<Persona> dipendenti = new ArrayList<Persona>();

    /**
     * 
     * metodo che aggiunge un nuovo elemento all'array list dipendenti NB si poteva
     * anche usare il metodo add degli ArrayList direttamente nel main ma in questo
     * modo è più semplice per chi lavora solo col main
     * 
     * @param newDipendente
     */
    private void addNewDipendente(Persona newDipendente) {
        dipendenti.add(newDipendente);
    }

    void stampaElencoDipendenti() {
        for (int i=0;i<dipendenti.size();i++) {
            if(dipendenti.get(i)instanceof Attore){
                Attore at=(Attore) dipendenti.get(i); // cast di una Persona ad Attore
                System.out.println(at.infoAttore());  // in questo modo posso usare infoAttore
                System.out.println("---------------------------------");
            }else if(dipendenti.get(i)instanceof Persona){
                System.out.println(dipendenti.get(i).infoPersona());
                System.out.println("---------------------------------");
            }   
        }
    }

    public void creaNuovaPersona() {
        // dichiarazione
        Persona newPersona;
        String nome, cognome;
        int nMatricola;
        Scanner lettore = new Scanner(System.in);
        // input
        System.out.print("Inserisci nome: ");
        nome = lettore.nextLine();
        System.out.print("Inserisci cognome: ");
        cognome = lettore.nextLine();
        if (dipendenti.size() != 0) {
            // prendo l'ultimo numero matricola +1
            nMatricola = dipendenti.get(dipendenti.size()/**/ - 1/**/).getnMatricola() + 1;
            // dipendenti.get(dipendenti.size() \prende la dimensione dell'array list\ -1 
            // \perchè gli indici partono da 0\)
            // .getMatricola() \prende la matricola di quella persona\ +1 
            // \aggiungo 1 all'ultimo n matricola assegnato
        } else {
            nMatricola = 1; // se l'array è ancora vuoto il primo n matricola sarà 1
        }
        // creazione attore
        newPersona = new Persona(nome, cognome, nMatricola);
        // output
        addNewDipendente(newPersona); // uso un metodo privato per inserire la persona appena profilata
        
    }
    public void creaNuovoAttore() {
        // dichiarazione
        Attore newAttore;
        String nome, cognome, carnagione;
        int nMatricola,altezza,peso;
        Scanner lettore = new Scanner(System.in);
        // input
        System.out.print("Inserisci nome: ");
        nome = lettore.nextLine();
        System.out.print("Inserisci cognome: ");
        cognome = lettore.nextLine();
        System.out.print("Inserisci carnagione: ");
        carnagione = lettore.nextLine();
        lettore = new Scanner(System.in);
        System.out.print("Inserisci altezza: ");
        altezza = lettore.nextInt();
        System.out.print("Inserisci peso: ");
        peso = lettore.nextInt();
        if (dipendenti.size() != 0) {
            // prendo l'ultimo numero matricola +1
            nMatricola = dipendenti.get(dipendenti.size()/**/ - 1/**/).getnMatricola() + 1;
            // dipendenti.get(dipendenti.size() \prende la dimensione dell'array list\ -1 
            // \perchè gli indici partono da 0\)
            // .getMatricola() \prende la matricola di quella persona\ +1 
            // \aggiungo 1 all'ultimo n matricola assegnato
        } else {
            nMatricola = 1; // se l'array è ancora vuoto il primo n matricola sarà 1
        }
        // creazione attore
        newAttore = new Attore(nome, cognome, nMatricola, carnagione, altezza, peso);
        // output
        addNewDipendente(newAttore); // uso un metodo privato per inserire la persona appena profilata
        
    }

    public void stampaInfoByMatricola(){  
        Scanner lettore = new Scanner(System.in);
        System.out.print("Inserire numero matricola da cercare --> ");
        int matricola=lettore.nextInt();
        for(int i=0;i<dipendenti.size();i++){
            if(matricola==dipendenti.get(i).getnMatricola()){
                if(dipendenti.get(i)instanceof Attore){   // se è dipendenti[i] è un attore
                    Attore at=(Attore) dipendenti.get(i); // cast di una Persona ad Attore
                    System.out.println(at.infoAttore());  // in questo modo posso usare infoAttore
                    System.out.println("---------------------------------");
                }else if(dipendenti.get(i)instanceof Persona){
                    System.out.println(dipendenti.get(i).infoPersona());
                    System.out.println("---------------------------------");
                }
            }
            else if(i==dipendenti.size()){
                System.out.println("Matricola non trovata");
                System.out.println("---------------------------------");
            }
        }
    }
}
