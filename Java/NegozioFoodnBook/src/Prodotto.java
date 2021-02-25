public class Prodotto {
    private String nomeProdotto;
    private float prezzo;
    private String infoProdotto;

    //COSTRUTTORI
    Prodotto(String nomeProdotto,float prezzo){
        this.nomeProdotto=nomeProdotto;
        this.prezzo=prezzo;
        infoProdotto="Nome Prodotto: "+nomeProdotto+"  Prezzo: "+prezzo;
    }

    //GETTERS
    public String getNomeProdotto() {
        return nomeProdotto;
    }
    public float getPrezzo() {
        return prezzo;
    }
    public String getInfoProdotto() {
        return infoProdotto;
    }
    //SETTERS
    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }
}
