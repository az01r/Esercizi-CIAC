
package tss.ciac.abstractandinterfaceveicolo;

/**
 *
 * @author Paolo
 * LEZIONE ABSTRACT E INTERFACE
 * Una classe che implementa un'interfaccia dovrà per forza definire una serie
 * di metodi specificati nell'interfaccia stessa.
 */
public abstract class Veicolo implements Moveable{
    private int speed;
    private int direction;
    private int x,y;

    // posso anche definire i metodi dell'interfaccia nella classe astratta
    @Override
    public void changeSpeed(int newSpeed) {
        speed=newSpeed;
    }
    
    // posso anche aggiungere metodi non contenuti nell'interfaccia    
    protected abstract String printPosition(); 
    
    /**
     * costruttore
     * @param lat
     * @param lon
     * @param speed
     * @param direction 
     */
    public Veicolo (int x,int y,int speed, int direction){
        this.x=x;
        this.y=y;
        this.speed=speed;
        this.direction=direction;
    }
    
    String getAttr(){
        return "("+getX()+","+getY()+"),V:"+getSpeed()+",D:"+getDirection();
    }
    
    
    public int getSpeed() {
        return speed;
    }

    public int getDirection() {
        return direction;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void setDirection(int direction) {
        this.direction = direction;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
      
    
}
