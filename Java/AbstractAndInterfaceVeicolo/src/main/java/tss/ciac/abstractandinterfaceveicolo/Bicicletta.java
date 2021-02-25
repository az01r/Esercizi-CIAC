/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tss.ciac.abstractandinterfaceveicolo;

/**
 *
 * @author Paolo
 */
public class Bicicletta extends Veicolo{

    /*
    @Override
    public void changeSpeed(int newSpeed) {
        speed=newSpeed;
    }
    */

    @Override
    public void changeDirection(int direction) {
    setDirection(direction);
    }

    @Override
    public void changePosition(int x, int y) {
        setX(x);
        setY(y);
    }

    @Override
    public String printPosition() {
        return(""+getX()+" - "+getY());
    }

    public Bicicletta(int x,int y,int speed,int direction) {
        super(x,y,speed,direction);
    }

    

    
    
    
}
