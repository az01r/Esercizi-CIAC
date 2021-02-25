/*
 * Un produttore e due consumatori interagiscono tramite una coda di stringhe.
 * synchronised            sincronizza gli accessi ad una struttura dati condivisa
 * notify() e notifyAll()  notificano a chi sta aspettando che qualcosa è cambiato
 *                         e che devono riverificare la condizione di attesa
 */
package threads.esempio3;

/**
 *
 * @author tss
 */
public class App {

    public static void main(String[] args) throws InterruptedException {
        Coda q = new Coda(5);
        String[] text = "Nel mezzo del cammin di nostra vita mi ritrovai per una selva oscura".split(" ");
        Thread p1 = new Thread(new Produttore("p1", 1, q, text));
        Thread c1 = new Thread(new Consumatore("c1", 2, q));
        Thread c2 = new Thread(new Consumatore("c2", 2, q));
        p1.start();
        c1.start();
        c2.start();
        Thread.sleep(10*1000);
        p1.interrupt();
        c1.interrupt();
        c2.interrupt();
        System.out.println(q);
    }
}


/*
Numero attese produttori: 0 - Numero attese consumatori: 23
p1  Nel mezzo del cammin di nostra vita mi ritrovai per una selva oscura Nel mezzo del cammin di nostra vita mi ritrovai per una selva oscura Nel mezzo del cammin di nostra vita mi ritrovai per una selva
c1  Nel del di nostra ritrovai Nel mezzo cammin vita per una Nel mezzo di nostra mi per una
c2  mezzo cammin vita mi per una selva oscura del di nostra mi ritrovai selva oscura del cammin vita ritrovai
*/