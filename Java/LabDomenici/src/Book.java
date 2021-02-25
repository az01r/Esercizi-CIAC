public final class Book {
    private final String titolo;
    private final String autore;
    
    public Book(String titolo, String autore){
        if(titolo==null||titolo.isEmpty()){
            throw new IllegalAccessException("Il titolo non può essere vuoto")
        }
        this.titolo=titolo;
        this.autore=autore;
    }
    public String getTitolo() {
        return titolo;
    }
    public String getAutore() {
        return autore;
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return super.toString();
    }
    public String mioToString(){
        return super.toString();
    }
    
}
