public class Attore extends Persona {
    private String carnagione;
    private int altezza;
    private int peso;

    String infoAttore() {
        return infoPersona()+"\nCarnagione: " + carnagione + "\nAltezza: " + altezza + "\nPeso: " + peso;
    }

    /**
     * COSTRUTTORE di Attore --> estende Persona
     * 
     * @param nome
     * @param cognome
     * @param nMatricola
     * @param carnagione
     * @param altezza
     * @param peso
     */
    public Attore(String nome, String cognome, int nMatricola, String carnagione, int altezza, int peso) {
        super(nome, cognome, nMatricola);
        this.carnagione = carnagione;
        this.altezza = altezza;
        this.peso = peso;
    }

    // GETTERS
    public String getCarnagione() {
        return carnagione;
    }

    public int getAltezza() {
        return altezza;
    }

    public int getPeso() {
        return peso;
    }

    // SETTERS
    public void setCarnagione(String carnagione) {
        this.carnagione = carnagione;
    }

    public void setAltezza(int altezza) {
        this.altezza = altezza;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

}