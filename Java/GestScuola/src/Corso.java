public class Corso {
    String nomeCorso = "----------"; // assegno qualcosa in modo che prima di
    String codiceCorso = "----------"; // essere stampato, nel caso sia stato
    String bando = "----------"; // inizializzato, contenga comunque qualcosa
    Materia materiaCorso;

    /**
     * infoCorso mostra tutti i dati relativi all'oggetto di tipo corso
     * 
     * @return ritorna una stringa di testo
     */
    String infoCorso() {
        String ris = "Nome Corso: " + nomeCorso + "  Codice: " + codiceCorso + "  Bando: " + bando;
        ris = ris + "\nMateria: " + materiaCorso.nomeMateria + "   Descrizione materia: " + materiaCorso.descrizione;
        return ris;
    }
}