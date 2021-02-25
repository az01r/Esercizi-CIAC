/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package threads.esempio2;

/**
 *
 * @author tss
 */
public class Worker implements Runnable{
    private final String name;

        public Worker(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            try {
                int i = 0;
                while (true) { // sempre (viene poi interrotto dal main)
                    Thread.sleep((long) (Math.random() * 1000));
                    System.out.println(i++ + " " + this.name);
                }
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
            System.out.println("DONE! " + this.name);
        }
}
