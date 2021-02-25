import java.util.Date;

public class Movimento {
    private float importo;
    private Date dataMovimento;
    Movimento(float imp){
        importo=imp;
        dataMovimento=new Date();
    }
    String infoMov(){
        return("Importo movimento: "+importo+"\nEffettuato in data: "+dataMovimento);
    }

    public Date getDataMovimento() {
        return dataMovimento;
    }
    public float getImporto() {
        return importo;
    }
}
