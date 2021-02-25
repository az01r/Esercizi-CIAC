public class Book extends Prodotto {
    
    
    private String autore;
    private int nPagine;
    
    private String infoBook;

    //COSTRUTTORI
    Book(String nomeProdotto,float prezzo,String autore,int nPagine) {
        super(nomeProdotto,prezzo);
        this.autore=autore;
        this.nPagine=nPagine;
        infoBook = getInfoProdotto() + "\nAutore: " + autore + "\nNumero Pagine: " + nPagine;
    }
        
    //GETTERS
    public String getAutore() {
        return autore;
    }
    public int getnPagine() {
        return nPagine;
    }
    public String getInfoBook() {
        return infoBook;
    }
}
