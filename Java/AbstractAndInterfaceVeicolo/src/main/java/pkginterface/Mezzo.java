/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkginterface;

/**
 *
 * @author luca lorenzo guerrin
 */
public abstract class Mezzo implements Movimento, Printable {

    private int x;
    private int y;
    protected int velocita;
    protected int direzione;
    public abstract void printMezzo();

    public Mezzo(int x, int y, int velocita, int direzione) {
        this.x = x;
        this.y = y;
        this.velocita = velocita;
        this.direzione = direzione;
    }

    
    
    
 @Override
    public void move(int x, int y) {
        this.x=x;
        this.y=y;
        
    }


    public int getX() {
        return x;
    }

   
    public int getY() {
        return y;
    }

   
    public int getVelocita() {
        return velocita;
    }

   

    public int getDirezione() {
        return direzione;
    }

 

}
