import java.util.Date;


public class Food extends Prodotto {

    private float peso;
    private int date, month, year;
    private Date dataScadenza;
    private String infoFood;

    /**
     * Costruttore che usa la data divisa in giorno, mese e anno
     * 
     * @param nomeProdotto tipo String
     * @param prezzo       tipo float
     * @param peso         tipo float
     * @param date         tipo int
     * @param month        tipo int
     * @param year         tipo int
     */
    public Food(String nomeProdotto, float prezzo, float peso, int date, int month, int year) {
        super(nomeProdotto,prezzo);
        this.peso = peso;
        this.date = date;
        this.month = month;
        this.year = year;
        infoFood = getInfoProdotto() + "\nPeso: " + peso + "\nScadenza: " + date + "/" + month + "/" + year;
    }
/*
    public Food(String nomeProdotto, float prezzo, float peso, Date dataScadenza) {
        super(nomeProdotto,prezzo);
        this.peso = peso;
        this.date = dataScadenza.getDate();
        this.month = dataScadenza.getMonth();
        this.year = dataScadenza.getYear();
        this.dataScadenza=dataScadenza;
        infoFood = getInfoProdotto() + "\nPeso: " + peso + "\nScadenza: " + date + "/" + month + "/" + year;
    }
*/
    //GETTERS
    public float getPeso() {
        return peso;
    }
    public int getDate() {
        return date;
    }
    public int getMonth() {
        return month;
    }
    public int getYear() {
        return year;
    }
    public Date getDataScadenza() {
        Date dataScadenza=new Date(year, month, date);
        return dataScadenza;
    }
    public String getInfoFood() {
        return infoFood;
    }

}
