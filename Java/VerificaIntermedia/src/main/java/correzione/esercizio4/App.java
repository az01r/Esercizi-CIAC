/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esercizio4;

/**
 *
 * @author alfonso
 */
public class App {

    public static void main(String[] args) {

        Officina off = new Officina(10);

        Decespugliatore de = new Decespugliatore(true, "KTM");

        Tosaerba te = new Tosaerba(3, "XX");

        off.nuovoLavoro(de);

        off.nuovoLavoro(te);

        off.addLavorazione(de.getNo(), new Lavorazione(Lavorazione.Tipo.SOSTITUZIONE_CANDELA, 50));

        off.addLavorazione(de.getNo(), new Lavorazione(Lavorazione.Tipo.TAGLIANDO, 100));

        off.addLavorazione(te.getNo(), new Lavorazione(Lavorazione.Tipo.SOSTITUZIONE_CANDELA, 80));

        System.out.println(de.toString());

        System.out.println(te.toString());

        System.out.println(off);

        off.consegnaLavoro(de.getNo());

        System.out.println("--------------------------------------------------------");

        System.out.println(off);

        MacchinaCaffe mc = new MacchinaCaffe("cucina");
        off.nuovoLavoro(mc);
        off.addLavorazione(mc.getNo(), new Lavorazione(Lavorazione.Tipo.ALTRO, 10));

        System.out.println(mc);

        System.out.println("--------------------------------------------------------");

        System.out.println(off);

    }
}
