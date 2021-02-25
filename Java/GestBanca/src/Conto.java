import java.util.Date;

public class Conto {

    // -----------------------------------------------------------------------------------------------------
    // lista attributi classe
    // -----------------------------------------------------------------------------------------------------
    /*
     * private blocca lettura e scrittura del dato al di fuori della classe di
     * appartenenza
     */
    private String codiceConto;
    private String codiceFiscale;
    Movimento[] movimenti;
    private Date dataCreazione;
    private float fido = 0;

    // -----------------------------------------------------------------------------------------------------
    // lista costruttori classe
    // -----------------------------------------------------------------------------------------------------
    /**
     * specificando il metodo costruttore di Conto, pretendo che per usare la classe
     * Conto vengano passati i parametri rispettivamente
     * 
     * @param cc     codice del conto
     * @param cf     codice fiscale
     * @param totMov numero massimo movimenti
     */

    Conto(String cc, String cf, int totMov) {
        dataCreazione = new Date();
        codiceConto = cc;
        codiceFiscale = cf;
        if (totMov <= 0) {
            movimenti = new Movimento[1000]; // defisco una dimensione di default
        } else {
            movimenti = new Movimento[totMov]; // defisco la dimensione dell'array movimenti
        }
    }

    // -----------------------------------------------------------------------------------------------------
    // lista getter e setter
    // -----------------------------------------------------------------------------------------------------
    /*
     * i getter sono metodi che permettono la lettura di una variabile privata
     * ritornandone il valore i setter sono metodi che permettono di modificare una
     * variabile privata tramite un metodo appartenente alla classe stessa
     */

    public String getCodiceConto() {
        return codiceConto;
    }
    public Date getDataCreazione() {
        return dataCreazione;
    }
    public String getCodiceFiscale() {
        return codiceFiscale;
    }
    public void setCodiceFiscale(String codiceFiscale, String psw) {
        if (psw.equals("password") && checkCodiceFiscale(codiceFiscale)) {
            // this. indica l'oggetto stesso, in questo caso conto
            this.codiceFiscale = codiceFiscale;
        }
        // NB il nome della variabile passata come parametro è lo stesso dell'attributo
        // della classe
        // ovverto il parametro codiceFiscale ha lo stesso nome di Conto.codiceFiscale
    }
    public float getFido() {
        return fido;
    }
    public void setFido(float fido) {
        if (fido >= 0)
            this.fido = fido;
    }

    // -----------------------------------------------------------------------------------------------------
    // altri metodi
    // -----------------------------------------------------------------------------------------------------

    String infoConto() {
        return ("Codice Conto: " + codiceConto);
    }

    float getSaldo() {
        float saldo = 0;
        for (int i = 0; i < movimenti.length && movimenti[i] != null; i++) {
            saldo += movimenti[i].getImporto();
        }
        return saldo;
    }

    void stampaSaldo() {
        System.out.println("Il saldo attuale del conto " + codiceConto + " è:" + getSaldo());
    }

    private boolean checkCodiceFiscale(String cf) {
        boolean ris = true;
        if (cf.length() != 16)
            ris = false;
        // qui posso inserire tutti i controlli che voglio fare prima di accettare
        // l'inserimento di un nuovo codice fiscale
        // ...
        if (!ris)
            System.out.println("Codice fiscale inserito non valido");
        return ris;
    }

    public void addMovimento(Movimento newMovimento) {
        int indexNewMov = -1;
        for (int i = 0;i < movimenti.length; i++) {
            if(movimenti[i] == null) {
                indexNewMov = i;
                break;
            }
        }
        if (indexNewMov != -1) {
            movimenti[indexNewMov] = newMovimento;
        } else {
            System.out.println("Raggiunto massimo numero movimenti");
        }
    }

    void stampaMovimenti() {
        for (int i = 0; i < movimenti.length; i++) {
            if (movimenti[i] != null)
                System.out.println("Importo movimento: " + movimenti[i].getImporto() + " eseguito in data "
                        + movimenti[i].getDataMovimento());
            else
                break;
        }
    }

    /**
     * find cliente cerca tra tutti i clienti della banca il proprietario del conto
     * @return  ritorna nome e cognome dell'intestatario
     */
    public String findCliente(){
        for(int i=0;i<App.clienti.length;i++){
            if(App.clienti[i]==null)
                return "Intestatario non trovato";
            if(App.clienti[i].codFiscale.equals(codiceFiscale)){
                return App.clienti[i].nome+" "+App.clienti[i].cognome;
            }
        }
        return ""; // 
    }

}
