public class ValoriNutrizionaliBean {
    private int dose; // (mL)required
    private int numero;// (per container) required
    private int calorie;// (per serving)optional
    private int grassi;// (g/serving)optional
    private int sodio;// (mg/serving)optional
    private int carboidrati; // (g/serving)optional

    public void ValoriNutrizionali(){

    }

    public int getDose() {
        return dose;
    }

    public void setDose(int dose) {
        this.dose = dose;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int getCalorie() {
        return calorie;
    }

    public void setCalorie(int calorie) {
        this.calorie = calorie;
    }

    public int getGrassi() {
        return grassi;
    }

    public void setGrassi(int grassi) {
        this.grassi = grassi;
    }

    public int getSodio() {
        return sodio;
    }

    public void setSodio(int sodio) {
        this.sodio = sodio;
    }

    public int getCarboidrati() {
        return carboidrati;
    }

    public void setCarboidrati(int carboidrati) {
        this.carboidrati = carboidrati;
    }

    /*
     * CONVENZIONE BEAN: creare costruttore vuoto, creare tutti i
     *                   get e i set
     * PRO più leggibile dal main
     * CONTRO si da la possibilità di modificare gli attributi
     *        in qualsiasi momento
     */
    
}
