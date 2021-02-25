package pizzeria;

public class Pizza {
    public static enum TipoFarina {
        NORMALE, INTEGRALE, KAMUT, MORESCHINA
    }

    public static enum Formato {
        PICCOLO, MEDIO, GRANDE
    }

    private final TipoFarina tipoFarina; // required
    private final Formato formato; // required
    private final boolean pomodoro;
    private final boolean mozzarella;
    private final boolean prosciutto;
    private final boolean acciughe;
    private final boolean funghi;

    private Pizza(Builder builder) {
        this.tipoFarina = builder.tipoFarina;
        this.formato = builder.formato;
        this.pomodoro = builder.pomodoro;
        this.mozzarella = builder.mozzarella;
        this.prosciutto = builder.prosciutto;
        this.acciughe = builder.acciughe;
        this.funghi = builder.funghi;
    }

    public static class Builder {
        private TipoFarina tipoFarina; // required
        private Formato formato; // required
        private boolean pomodoro;
        private boolean mozzarella;
        private boolean prosciutto;
        private boolean acciughe;
        private boolean funghi;

        public Builder(TipoFarina tipoFarina, Formato formato) {
            this.tipoFarina = tipoFarina;
            this.formato = formato;
        }

        public Builder pomodoro(boolean pomodoro) {
            this.pomodoro = pomodoro;
            return this;
        }

        public Builder mozzarella(boolean mozzarella) {
            this.mozzarella = mozzarella;
            return this;
        }

        public Builder prosciutto(boolean prosciutto) {
            this.prosciutto = prosciutto;
            return this;
        }

        public Builder acciughe(boolean acciughe) {
            this.acciughe = acciughe;
            return this;
        }

        public Builder funghi(boolean funghi) {
            this.funghi = funghi;
            return this;
        }

        public Pizza build() {
            return new Pizza(this); // this passa l'istanza della classe Builder
        }
    }

    /*
     * costruttore private della classe che richiede un parametro di tipo Builder;
     * sottoclasse Builder con:
     *  - gli attributi della classe superiore
     *  - metodi pubblici di tipo Builder che settano gli attributi
     *  - metodo build che crea un'istanza della classe superiore usando il costruttore privato e passando
     *    this come parametro, ovvero l'istanza di Builder con i parametri settati
     *    classe Builder interna a con costruttore pubblico e metodi per settare gli
     *    altri parametri
     */

    public void stampaPizza(){
        System.out.println("Tipo farina: "+tipoFarina+"\nFormato: "+formato+"\nPomodoro: "+pomodoro+"\nMozzarella: "+mozzarella+"\nProsciutto: "+prosciutto+"\nFunghi: "+funghi+"\nAcciughe: "+acciughe);
    }

    public static Pizza margherita(TipoFarina tipoFarina, Formato formato){
        return new Pizza.Builder(tipoFarina, formato)
                        .pomodoro(true).mozzarella(true).build();
        
    }
    public static Pizza prosciuttoFunghi(TipoFarina tipoFarina, Formato formato){
        return new Pizza.Builder(tipoFarina, formato)
                        .pomodoro(true).mozzarella(true).prosciutto(true).funghi(true).build();
        
    }
}
