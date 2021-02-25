/*
 * Un thread continua a stampare stringhe e un altro (il main) lo interrompe dopo 10 sec.
 */
package threads.esempio2;

/**
 *
 * @author alfonso
 */
public class App {

    public static void main(String[] args) {
        Runnable worker = new Worker("worker1");
        Thread thread = new Thread(worker);
        thread.start(); // t si mette in pausa ogni 10s (esplicitato in Worker)
        try{
        Thread.sleep(10 * 1000); // mette in pausa il thread del main per 10s
        }catch(InterruptedException e){
            System.err.println(e.getMessage());
        }
        thread.interrupt(); // interromper il thread
    }

    

}
