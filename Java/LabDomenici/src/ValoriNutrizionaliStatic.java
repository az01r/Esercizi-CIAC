public class ValoriNutrizionaliStatic { // COSTRUTTORE PRIVATE e METODI STATICI
    private final int dose; // (mL)required
    private final int numero;// (per container) required
    private final int calorie;// (per serving)optional
    private final int grassi;// (g/serving)optional
    private final int sodio;// (mg/serving)optional
    private final int carboidrati; // (g/serving)optional

    

    private ValoriNutrizionaliStatic(int dose,int numero,int calorie,int grassi, int sodio, int carboidrati){
        this.calorie=calorie;
        this.dose=dose;
        this.numero=numero;
        this.grassi=grassi;
        this.sodio=sodio;
        this.carboidrati=carboidrati;
    }

    public static ValoriNutrizionaliStatic creaConCalorie(int dose,int numero,int calorie){
        return new ValoriNutrizionaliStatic(dose,numero,calorie,0,0,0);
    }
    
    public static ValoriNutrizionaliStatic creaConCarboidrati(int dose,int numero,int carboidrati){
        return new ValoriNutrizionaliStatic(dose,numero,0,0,0,carboidrati);
    }

    /*
     * Attualmente il metodo più utilizzato è quello di creare un solo costruttore
     * privato e tanti metodi pubblici statici che passano parametri al costruttore
     * Il vantaggio è che i metodi hanno nomi che chiariscono cosa si sta
     * passando come parametro
     */
}
