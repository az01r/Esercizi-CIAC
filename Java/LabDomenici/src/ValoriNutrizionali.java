public class ValoriNutrizionali {
    private final int dose; // (mL)required
    private final int numero;// (per container) required
    private final int calorie;// (per serving)optional
    private final int grassi;// (g/serving)optional
    private final int sodio;// (mg/serving)optional
    private final int carboidrati; // (g/serving)optional

    public ValoriNutrizionali(int dose, int numero, int calorie, int grassi, int sodio, int carboidrati) {
        this.dose = dose;
        this.numero = numero;
        this.calorie = calorie;
        this.grassi = grassi;
        this.sodio = sodio;
        this.carboidrati = carboidrati;
    }

    public ValoriNutrizionali(int dose, int numero, int calorie, int grassi, int sodio) {
        this(dose, numero, calorie, grassi, sodio, 0);
    }

    public ValoriNutrizionali(int dose, int numero, int calorie, int grassi) {
        this(dose, numero, calorie, grassi, 0, 0);
    }

    public ValoriNutrizionali(int dose, int numero, int calorie) {
        this(dose, numero, calorie, 0, 0, 0);
    }

    public ValoriNutrizionali(int dose, int numero) {
        this(dose, numero, 0, 0, 0, 0);
    }


    /*
     * this richiama il metodo della classe con (x) parametri
     * quindi i costruttori a cui mancano dei dati chiamano i
     * successivi in cascata
     * 
     * NB non si può scrivere in overload più costruttori 
     * con la stessa firma, ovvero con stesso numero di parametri
     * dello stesso tipo. Il seguente costruttore darebbe errore: 
     * 
            public ValoriNutrizionali(int dose, int numero, int carboidrati) {
                this(dose, numero, calorie, 0, 0, 0);
            }
     */

}
