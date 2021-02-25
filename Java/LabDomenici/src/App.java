
public class App {
    public static void main(String[] args) throws Exception {
        new Calcolatrice(Calcolatrice.Mode.ADVANCED);

        Book b = new Book("I promessi sposi", "Manzoni");
        Object o = b; // cast a oggetto
        System.out.println(b.getTitolo());
        System.out.println(b);
        System.out.println(o);

        // NB
        System.out.println(b.getClass());
        System.out.println(o.getClass());
        /*
         * getClass restituisce il tipo di ciò che è stato assegnato alla variabile
         * quindi ritornano entrambe book perché sia b che o puntano alla stessa istanza
         * di Book. L'unica differenza è che o vede i metodi di object mentre b vede i
         * metodi di Book più i metodi di Object (perché tutte le classi Java estendono
         * la classe Object, superClasse di tutte le altre classi)
         * 
         * NB ogni volta che si crea una variabile di tipo oggetto dopo aver creato una
         * nuova istanza di una classe, la variabile conterrà un puntatore all'area di
         * memoria dell'oggetto quindi b in sè non è un oggetto Ciò comporta che non si
         * può rendere un oggetto visibile solo in lettura ma può solo essere O NON
         * MODIFICABILE usando FINAL o MODIFICABILE omettendo FINAL
         * 
         */


        /*
         * PASSAGGIO PARAMETRI
         */
        // PRIMO METODO
        ValoriNutrizionali v1 = new ValoriNutrizionali(100, 1,0,0,0,5);
        System.out.println(v1);
        // SECONDO METODO
        ValoriNutrizionaliBean v2 = new ValoriNutrizionaliBean();
        v2.setDose(100);
        v2.setNumero(1);
        v2.setCarboidrati(5);
        System.out.println(v2);
        // TERZO METODO
        ValoriNutrizionaliStatic v3 = ValoriNutrizionaliStatic.creaConCalorie(100, 1, 5);
        System.out.println(v3);
        // QUARTO METODO
        ValoriNutrizionaliBP v4 = new ValoriNutrizionaliBP.Builder(100, 10)
                                      .carboidrati(5)
                                      .sodio(4)
                                      .build();
    }
}

        /* 
         * MODIFICATORI DI VISIBILITA':     PUBLIC - PROTECTED - DEFAULT/PACKAGE - PRIVATE 
         *  PUBLIC: Può essere utilizzato sia relativamente ad un membro (attributo o 
         *          metodo) che ad una classe stessa:
         *          un membro dichiarato pubblico sarà accessibile da una qualsiasi classe situata in qualsiasi package
         *          una classe dichiarata pubblica sarà anch’essa visibile da un qualsiasi package 
         *  PROTECTED: Può essere utilizzato relativamente ad un membro (attributo o 
         *             metodo) di una classe. Un membro protetto sarà accessibile 
         *             all’interno dello stesso package ed in tutte le sottoclassi della 
         *             classe in cui è definito, anche se non appartenenti allo stesso package.
         *  DEFAULT: Un membro di una classe per default sarà accessibile solo dalle
         *           classi appartenenti al package dove è definito.
         *           Una classe appartenente ad un package definita senza il
         *           modificatore public sarà visibile solo dalle classi appartenenti
         *           allo stesso package.
         * 
         *  PRIVATE: Può essere utilizzato solo con i membri (attributo o metodo) di una
         *           classe, ed un membro privato sarà accessibile solo all’interno della classe.
         *   
         * NB classi senza modificatore di visibilità di default sono package
         * 
         * 
         *  
         * Ogni file .java può avere solo UNA classe public
         * ma può avere più classi private, package o protected
         * 
         *
         *  
         * Tutte le classi java estendono la classe Object ereditandone quindi 
         * tutti i metodi
         * Uno di questi metodi è equals, che confronta 2 puntatori
         *
         *
         *   
         * FINAL  applicato ad una classe permette di renderla non estendibile
         *   ||   applicato ad un metodo permete di renderlo non sovrascrivibile
         *   ||   applicato ad una variabile permette di renderla non modificabile
         *
         * STATIC applicato ad una variabile permette di crearla all'interno della classe
         *        stessa invece che crearne una copia per ogni istanza.
         *        Si può immaginare una variabile statica come comune a tutte le istanze
         *        della data classe
         *        NB ogni istanza di un oggetto può accedere ad una variabile della classe
         *           ma la classe non può accedere ad una variabile di una istanza
         *   ||   applicato ad un metodo permette a questo di essere chiamato senza 
         *        la necessità di creare un'istanza della relativa classe
         *   ||   non si può applicare a una classe
         * 
         * 
         * MEMBRI DI ISTANZA  Sono dichiarazioni di variabili e metodi NON statici
         *                    ovvero OGNI ISTANZA ha la sua copia di variabili e i suoi metodi di istanza
         *                    Per creare una nuova istanza --> new COSTRUTTORE(parametri)
         *                NB  Le variabili e i metodi STATICI non sono membri di istanza, perché 
         *                    static indica che quella variabile o metodo è unico per tutte le istanze della classe
         *                    Se quindi un'istanza di una classe modifica una variabile statica, la modifica per 
         *                    tutte le istanze della classe
         * 
         * NB  se una classe ha solo metodi statici è utile per evitare dubbi, mettere 
         *     il costruttore della classe private
         * 
         * NB posso definire una parte di codice per inizializzare variabili all'interno
         *    di un metodo statico usando   -->   static{......}
         *                    
         */