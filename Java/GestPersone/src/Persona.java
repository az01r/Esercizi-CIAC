
import java.util.Date;

public class Persona {
    private String nome;
    private String cognome;
    private int nMatricola;
    private String telefono = "non fornito";
    private String email = "non fornito";
    private Date dataNascita=new Date();

    String infoPersona() {
        Date d=new Date();
        int anni =d.getYear()-dataNascita.getYear();
        return "Nome: " + nome + "\nCognome: " + cognome + "\nData di nascita: " + dataNascita + "\nNumero Matricola: "
                + nMatricola + "\nTelefono: " + telefono + "\nEmail: " + email+"\nAnni: "+anni;
    }

    // GETTER
    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public int getnMatricola() {
        return nMatricola;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getEmail() {
        return email;
    }

    public Date getDataNascita() {
        return dataNascita;
    }
    // ----------------------------------------------------------------

    // SETTER
    public void setEmail(String email) {
        if (email.length() > 100) {
            this.email = email.substring(0, 100); // prende solo i primi 100 caratteri
        }
        this.email = email;
    }

    public void setDataNascita(Date dataNascita) {
        this.dataNascita = dataNascita;
    }
    public void setDataNascita(int year,int month,int date) {
        this.dataNascita = new Date(year, month, date);
    }
    // ----------------------------------------------------------------

    /**
     * COSTRUTTORE di Persona
     * 
     * @param nome
     * @param cognome
     * @param nMatricola
     */
    Persona(String nome, String cognome, int nMatricola) {
        this.nome = nome;
        this.cognome = cognome;
        this.nMatricola = nMatricola;
    }

    /**
     * COSTRUTTORE di Persona con la data di nascita
     * 
     * @param nome
     * @param cognome
     * @param nMatricola
     * @param year
     * @param month
     * @param date
     */
    Persona(String nome, String cognome, int nMatricola, int year, int month, int date) {
        this.nome = nome;
        this.cognome = cognome;
        this.nMatricola = nMatricola;
        Date data = new Date(year, month, date);
        dataNascita = data;
    }
    Persona(String nome, String cognome, int nMatricola, Date dataNascita) {
        this.nome = nome;
        this.cognome = cognome;
        this.nMatricola = nMatricola;
        this.dataNascita=dataNascita;
    }

    /*
     * anche se corretto generalmente non si fa così Persona(String no, String co,
     * int nMat) { nome = no; cognome = co; nMatricola = nMat;
     * 
     * }
     */
}
