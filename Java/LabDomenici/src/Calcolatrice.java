import jdk.javadoc.internal.doclets.formats.html.resources.standard;

public class Calcolatrice {
/* 
 * se il tipo Mode è usato per più classi allora creo un file a parte
 * se è solo una è meglio farlo nella classe stessa 
 */
    public enum Mode {
        BASE,STANDARD,ADVANCED;
    }
    

    private Mode mode;
    public float somma(float a, float b){
        return a+b;
    }

    public Calcolatrice(Mode mode){
        this.mode=mode;
    }
}
