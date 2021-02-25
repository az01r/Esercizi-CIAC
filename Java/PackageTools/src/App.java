
import java.util.Date;
import utility.Tool;
public class App {
    public static void main(String[] args) throws Exception {

        
        System.out.println(Tool.leggiFile());
        
        System.out.println("Inserisci float");
        float x = Tool.getFloat(); 
        /* 
         *  NB essendo getFloat STATICO, non ho bisogno di creare 
         *     un'istanza di Tool prima di poterlo usare 
         */
        
        System.out.println("Inserisci double");
        double y = Tool.getDouble(); 
        
        System.out.println("Inserisci stringa");
        String s = Tool.getString();
        
        System.out.println("Inserisci data");
        Date data = Tool.getDate();

        System.out.println("Inserisci codice fiscale");
        String cFisc=Tool.getString();
        if(!Tool.checkCodFiscale(cFisc)){
            System.out.println("Codice fiscale non valido");    
        }

        System.out.println(Tool.leggiFile());

    }

    

}
