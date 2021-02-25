import jdk.javadoc.internal.doclets.formats.html.resources.standard;

public class Esercizio11_passaggioParametri {
    public static void main(String[] args) {
        float x=3; 
        float y=5; 
        float z=2;
        float ris= somma(x,y);
        stampaRis(ris);
        ris=differemza(z,x);
        stampaRis(ris);
        ris=divisione(x,z);
        stampaRis(ris);
        ris=somma(x,y,z);
        stampaRis(ris);

        String s1="000100";
        String s2="000110";
        ris=somma(s1, s2);
        stampaRis(ris);
    }

    static float somma(float a,float b){
        return a+b;
    }
    static float differemza(float a,float b){
        return a-b;
    }
    static float divisione(float a,float b){
        if(b==0){
            System.out.println("Errore: divisione per zero");
            return 0;
        }
        return a/b;
    }
    static float somma(float a,float b,float c){
        return a+b+c;
    }
    static void stampaRis(float risultato){
        System.out.println("risultato = "+risultato);
    }

    static float somma(String addendo1, String addendo2) {
        float ris;
        float n1=Float.parseFloat(addendo1);
        float n2=Float.parseFloat(addendo2);
        ris = n1 + n2;
        return ris;
    }

}
