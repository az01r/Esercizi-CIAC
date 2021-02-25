import jdk.internal.joptsimple.internal.SimpleOptionNameMap;

public class Lezione2 {
    public static void main(String[] args) {
        
        /* JAVA PASSA I PARAMETRI BY VALUE */
        int n=5;
        passaggiobyvalue(n);
        System.out.println("il valore di n è: "+n); 
        /* NB il valore di n non cambia nonostante sia cambiato nella funzione */

        /* TRANNE CHE PER GLI ARRAY */
        int[] valori = { 1, 2, 3 };
        passaggio(valori);
        System.out.println("il primo valore del array è: "+valori[0]);
        /* NB il valore di valori[0] cambia perchè è cambiato nella funzione */

        /* OVERLOAD DI UNA FUNZIONE */
        boolean x=false;
        boolean y=true;
        predicatoAnd(x,y);

        /* PASSARE UN NUMERO NON DEEFINITO DI PARAMETRI */
        int a=5;
        int b=3;
        int c=4;
        
        int somma =passaggioNonDefinito(a,b,c);
        System.out.println("la somma è: "+somma);
    }

    static void passaggiobyvalue (int numero){
        numero = 1000;
    }
    static void passaggio(int[] numeri) {
        numeri[0]=10;
    }

    /* NB IN JAVA SI POSSONO CREARE VARIABILI CON LO STESSO NOME 
       MA DEVONO AVERE FIRMA DIVERSA OVVERO NOME(PARAMETRI DIVERSI) */

    static boolean predicatoAnd(boolean a, boolean b){
        return a&&b;
    }
    static boolean predicatoAnd(boolean a){
        return predicatoAnd(a,true);
    }
    /* se mi passano un solo valore chiamo la prima funzione
       passando come predefinitp il valore true come secondo
       parametro */

    static int passaggioNonDefinito(int... valori) {
        int somma=0;
        for (int i=0;i<valori.length;i++){
            somma=somma+valori[i];
        }
        return somma;
    }
}
