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
public class Produttore implements Runnable{
    private final String name;
    private final int intervallo;
    private final ArrayBlockingQueue<String> q;
    private final StringBuilder log = new StringBuilder();
    private final String[] text;

    public Produttore(String name, int intervallo, ArrayBlockingQueue<String> q, String[] text) {
        this.name = name;
        this.intervallo = intervallo;
        this.q = q;
        this.text = text;
    }
    
    
    @Override
    public void run() {
        int i = 0;
        try{ // fatto perchè aggiungi e togli di coda possone generare una InterruptedException
            while(true){
                q.add(text[i]);
                log.append(" ").append(text[i]);
                i=(i+1)%text.length;
                long p = (long) (Math.random()*1000*intervallo); // calcola tempo di attesa, massimo 5
                Thread.sleep(p);
            }
        }catch(InterruptedException e){
            // System.out.println(e.getMessage());
        }
        System.out.println(name+ " " + log);
    }
    
}
