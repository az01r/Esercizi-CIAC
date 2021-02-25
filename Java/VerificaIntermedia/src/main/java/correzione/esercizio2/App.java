/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esercizio2;

/**
 *
 * @author alfonso
 */
public class App {

    public static void main(String[] args) {
        Sim sim = new Sim("+393498531750", 10);
        sim.chiama(10, "+391234567898");
        sim.chiama(5, "+391234567898");
        sim.chiama(3, "+391234567898");
        sim.chiama(2, "+391234567835");
        sim.chiama(6, "+391234567835");
        sim.chiama(new Sim.Telefonata(3,"+391234567835"));
        
        System.out.println(sim);

        System.out.println(String.format("totale minuti di comversazione: %s",
                sim.totaleMinutiConversazione()));

        System.out.println(String.format("totale chiamate al numero %s -> %s",
                "+391234567898", sim.telefonateAlNumero("+391234567898")));

        System.out.println(String.format("totale minuti conversazione con il numero %s -> %s",
                "+391234567898", sim.totaleMinutiConversazioneAlNumero("+391234567898")));
    }
}
