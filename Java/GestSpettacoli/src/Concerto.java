public class Concerto {
    String nomeTeatro="";
    String localita="";
    String data="";
    int nPosti=0;
    Artista artist;
    String infoConcerto(){
        return "Teatro: "+nomeTeatro+"\nLocalità: "+localita+"\nData: "+data+"\nPosti: "+nPosti+"\nArtista: "+artist.nomeArtista;
    }
}
