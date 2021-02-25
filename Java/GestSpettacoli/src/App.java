public class App {
    public static void main(String[] args) throws Exception {
        Artista art1 = new Artista();
        art1.nomeArtista="deadmau5";
        art1.genere="progressive";
        art1.email="deadmau5.official@gmail.com";
        art1.telefono="3456915501";
        System.out.println(art1.infoArtista());
        System.out.println("----------------------\n----------------------");

        Artista art2 = new Artista();
        art2.nomeArtista="Mirrored Theory";
        art2.genere="progressive";
        art2.email="mirrored.therory@gmail.com";
        art2.telefono="0432451677";
        System.out.println(art2.infoArtista());
        System.out.println("----------------------\n----------------------");

        Concerto conc1 = new Concerto();
        conc1.nomeTeatro="Move";
        conc1.localita="Torino";
        conc1.data="20/12/2020";
        conc1.artist=art1;
        conc1.nPosti=5000;
        System.out.println(conc1.infoConcerto());
        System.out.println("----------------------\n----------------------");

        Concerto conc2 = new Concerto();
        conc2.nomeTeatro="Piazza Duomo";
        conc2.localita="Milano";
        conc2.data="31/12/2020";
        conc2.artist=art2;
        conc2.nPosti=6000;
        System.out.println(conc2.infoConcerto());
    }
}

/*
 * creare proj uguale con array spettacoli e array artisti 
 */