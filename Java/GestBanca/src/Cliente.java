import java.util.Date;

public class Cliente {
    String nome;
    String cognome;
    Date dataNascita;
    String codFiscale;
    String telefono;
    String email;

/*  
    Ogni volta che si crea una classe, java crea automaticamente un metodo costruttore
    tale metodo, al contrario di qualsiasi altro metodo, si scrive con la maiuscola
    e può essere modificato specificandolo nella relativa classe

    Specificando il metodo costruttore posso imporre di passare alcuni dati come
    parametri o l'oggetto non potrà essere costruito
*/  
    Cliente(String no, String co, String cf){
        nome=no;
        cognome=co;
        codFiscale=cf;
        telefono="Parametro non fornito";
        email="Parametro non fornito";
    }

/*  
    Posso creare un altro metodo costruttore (OVERLOADING) che serve quando si cerca di creare
    un oggetto senza fornire i parametri necessari
*/
    Cliente(){
        nome="Parametro non fornito";
        cognome="Parametro non fornito";
        codFiscale="Parametro non fornito";
        telefono="Parametro non fornito";
        email="Parametro non fornito";
    }

    Cliente(String no, String co, String cf,Date dt,String tel,String em){
        nome=no;
        cognome=co;
        codFiscale=cf;
        telefono=tel;
        email=em;
        dataNascita=dt;
    }
    String infoCliente(){
        return("Nome: "+nome+"\nCognome: "+cognome+"\nCodice Fiscale: "+codFiscale+"\nData di Nascita: "+dataNascita+"\nTelefono: "+telefono+"\nemail: "+email);
    }
/* 
    Creando 3 metodi costruttori, ogni volta che creo un oggetto di tipo cliente posso
    scegliere se passare 0,3 o tutti i parametri richiesti
    Ovviamente non posso passare 2 o 4 parametri perché non ho creato un costruttore
    apposito
*/
}
