/*
 * Uso di ArrayBlockingQueue ; il package java.util.concurrent offre classi 
 * utili nella programmazione concorrente.
 * ArrayBlockingQueue è identico a Coda che abbiamo creato nell'sesercizio 3
 */
package threads.esempio4;

import java.util.concurrent.ArrayBlockingQueue;

/**
 *
 * @author tss
 */
public class App {
    public static void main(String[] args) throws InterruptedException {
        ArrayBlockingQueue<String> q = new ArrayBlockingQueue<>(5);
        String[] text = "Nel mezzo del cammin di nostra vita mi ritrovai per una selva oscura".split(" ");
        Thread p1 = new Thread(new Produttore("p1", 1, q, text));
        Thread c1 = new Thread(new Consumatore("c1", 2, q));
        Thread c2 = new Thread(new Consumatore("c2", 2, q));
        p1.start();
        c1.start();
        c2.start();
        Thread.sleep(20*1000);
        p1.interrupt();
        c1.interrupt();
        c2.interrupt();
        System.out.println(q);
    }
}
