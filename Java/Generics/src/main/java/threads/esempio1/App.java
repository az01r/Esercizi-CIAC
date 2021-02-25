package threads.esempio1;


/*
 * Due thread stampano 10 stringhe, ciascuno ad intervalli casuali <= 1 secondo.
 */

/**
 *
 * @author alfonso
 */
public class App {

    public static void main(String[] args) {
        Worker t1 = new Worker("Worker1");
        Worker t2 = new Worker("Worker2");
        t1.start();
        t2.start();
        new Worker("Worker3", 100);
    }
}
