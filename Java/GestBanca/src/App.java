import java.util.Date;

public class App {
    static Cliente[] clienti;
    static Conto[] conti;
    public static void main(String[] args) throws Exception {
        clienti=new Cliente[100];
        conti=new Conto[1000];

        String nome="Paolo";
        String cognome="Grosso";
        String cFisc="codicefiscale123";
        String tel="3455824011";
        Date dataNasc = new Date(); // mette la data attuale come data di nascita
        String email = "paolo@gmail.com";

        /*
            creo una nuova istanza, ovvero un oggetto, della classe cliente
            Cliente(), in giallo, è un metodo COSTRUTTORE riservato della classe Cliente
        */
        Cliente cl = new Cliente(nome,cognome,cFisc);
        System.out.println(cl.infoCliente());
        System.out.println("----------------------------------");
        clienti[0]=cl;

        Cliente clPredefinito = new Cliente();
        System.out.println(clPredefinito.infoCliente());
        System.out.println("----------------------------------");

        Cliente clCompleto = new Cliente(nome, cognome, cFisc, dataNasc, tel, email);
        System.out.println(clCompleto.infoCliente());
        System.out.println("----------------------------------");
        
        // creo conto cliente
        Conto cc=new Conto("cOdIcEdElCoNtO", cFisc, 0); // con 0 lo dimensiona standard (1000)
        conti[0]=cc;

        // creo variabile di tipo Movimento
        Movimento mov;
        // creo oggetto di tipo Movimento passando l'importo al costruttore
        mov = new Movimento(100);
        // aggiungo movimento a conto
        cc.addMovimento(mov);
        // cc.movimenti[0]=mov; sarebbe l'istruzione se non avessi creato il metodo addMovimendo
        
        // posso riutilizzare l'oggetto mov perchè è salvato nell'oggetto cc di tipo Comto
        mov=new Movimento(50);
        cc.addMovimento(mov);
        mov=new Movimento(-50);
        cc.addMovimento(mov);
        mov=new Movimento(-60);
        cc.addMovimento(mov);

        cc.stampaSaldo();
        cc.stampaMovimenti();
        System.out.println(cc.findCliente());

        cc.setCodiceFiscale("codicefiscale000","password"); // da fare anche per cliente
    }
}
