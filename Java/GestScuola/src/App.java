public class App {
    public static void main(String[] args) throws Exception {
        Corso corsoJava = new Corso();
        corsoJava.bando = "1234";
        corsoJava.codiceCorso = "C465-RT54";
        corsoJava.nomeCorso = "Tecnico Sviluppo Software";
        Materia mat = new Materia();
        mat.nomeMateria = "java base";
        mat.descrizione = "fondamenti di programmazione";
        mat.nOre = 90;
        corsoJava.materiaCorso = mat;
        String txt = corsoJava.infoCorso();
        System.out.println(txt);

        Aula aula = new Aula();
        aula.nomeAula = "G1-7";
        aula.aulaPC = true;
        aula.capienza = 20;
        aula.piano = 1;
        aula.sede = "Ghiglieno";
        aula.wifi = true;
        String testo = aula.infoAula();
        System.out.println(testo);
        aula.spegniWifi();
        aula.accendiWifi();

        Allievo io = new Allievo();
        io.nome = "Paolo";
        io.cognome = "Grosso";
        io.nOrdine = 8;
        String tx = io.infoAllievo();
        System.out.println(tx);

        Allievo[] registro = new Allievo[30]; // 30 allievi
    }
}
