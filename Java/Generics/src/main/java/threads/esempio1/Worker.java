/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads.esempio1;

import static java.lang.Thread.sleep;

/**
 *
 * @author tss
 */
public class Worker extends Thread {

    int n;

    public Worker(String name) {
        super(name);
        this.n = 10;
    }

    public Worker(String name, int n) {
        super(name);
        this.n = n;
    }

    @Override
    public void run() {
        for (int i = 0; i < n; i++) {
            System.out.println(i + " " + getName()); // getName è dentro Thread
            try {
                sleep((long) (Math.random() * 1000));
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("DONE! " + getName());
    }

}
