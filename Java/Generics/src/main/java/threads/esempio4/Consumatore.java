/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads.esempio4;

import java.util.concurrent.ArrayBlockingQueue;

/**
 *
 * @author tss
 */
public class Consumatore implements Runnable {
    private final String name;
    private final int intervallo;
    private final ArrayBlockingQueue<String> q;// NB si usa final perchè q è un puntatore a un oggetto --> la coda può cambaire al suo interno ma non posso usare un'altra coda
    private final StringBuilder log = new StringBuilder();

    public Consumatore(String name, int intervallo, ArrayBlockingQueue<String> q) {
        this.name = name;
        this.intervallo = intervallo;
        this.q = q;
    }
    
    @Override
    public void run() {
        try{
            while (true) {                
                String s = q.remove();
                log.append(" ").append(s);
                long p =(long) (Math.random()*1000*intervallo);
                Thread.sleep(p);
            }
        }catch(InterruptedException e){
            //System.out.println(e.getMessage());
        }
        System.out.println(name+" "+log);
    }
    
}
