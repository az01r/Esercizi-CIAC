public class Corso {
    private String nomeCorso;
    private String docente;
    
    Corso(String nomeCorso,String docente){
        this.docente=docente;
        this.nomeCorso=nomeCorso;
    }
    public String getDocente() {
        return docente;
    }
    public String getNomeCorso() {
        return nomeCorso;
    }
}
