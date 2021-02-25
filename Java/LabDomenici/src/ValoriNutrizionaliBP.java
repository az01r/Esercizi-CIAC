public class ValoriNutrizionaliBP { // BUILDER PATTERN
    private final int dose; // (mL)required
    private final int numero;// (per container) required
    private final int calorie;// (per serving)optional
    private final int grassi;// (g/serving)optional
    private final int sodio;// (mg/serving)optional
    private final int carboidrati; // (g/serving)optional

    private ValoriNutrizionaliBP(Builder builder){
        this.dose=builder.dose;
        this.numero=builder.numero;
        this.calorie=builder.calorie;
        this.grassi=builder.grassi;
        this.sodio=builder.sodio;
        this.carboidrati=builder.carboidrati;
    }

    public static class Builder {
        private int dose; // (mL)required
        private int numero;// (per container) required
        private int calorie;// (per serving)optional
        private int grassi;// (g/serving)optional
        private int sodio;// (mg/serving)optional
        private int carboidrati; // (g/serving)optional

        public Builder(int dose,int numero){
            this.dose=dose;
            this.numero=numero;
        }
        public Builder calorie(int calorie){
            this.calorie=calorie;
            return this;
        }
        public Builder grassi(int grassi){
            this.grassi=grassi;
            return this;
        }
        public Builder sodio(int sodio){
            this.sodio=sodio;
            return this;
        }
        public Builder carboidrati(int carboidrati){
            this.carboidrati=carboidrati;
            return this;
        }
        public ValoriNutrizionaliBP build(){
            return new ValoriNutrizionaliBP(this); // this passa l'istanza della classe Builder
        }
    }
}

/* 
 * costruttore private della classe che richiede un parametro di tipo Builder;
 * sottoclasse Builder con: 
 *  - gli attributi della classe superiore
 *  - metodi pubblici di tipo Builder che settano gli attributi
 *  - metodo build che crea un'istanza della classe superiore 
 *    usando il costruttore privato e passando this come parametro,
 *    ovvero l'istanza di Builder con i parametri settati
 * classe Builder interna a con costruttore pubblico e metodi per settare
 * gli altri parametri 
 */