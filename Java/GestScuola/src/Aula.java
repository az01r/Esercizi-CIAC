public class Aula {
    String sede="----------";
    String nomeAula="----------";
    int piano=0;
    int capienza=0;
    boolean aulaPC;
    boolean wifi;
    String infoAula(){
        String ris="Aula: "+nomeAula.toUpperCase()+"\nSede: "+sede+"   Piano: "+piano+"\nCapienza: "+capienza+"   Aula PC: "+aulaPC+"   Wifi: "+wifi;
        return ris;
    }
    void spegniWifi(){
        wifi=false;
    }
    void accendiWifi(){
        wifi=true;
    }
}
