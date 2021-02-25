public class Alunno {
    private String nome;
    private String cognome;
    private int matricola;

    public Alunno(String nome,String cognome,int matricola){
        this.nome=nome;
        this.cognome=cognome;
        this.matricola=matricola;
    }
    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public int getMatricola() {
        return matricola;
    }
}
