/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clone;

/**
 *
 * @author Paolo
 */
public class Rectangle implements Cloneable{
    private int w,h;
    private Point origin;

    public Rectangle(int w, int h, Point origin) {
        this.w = w;
        this.h = h;
        this.origin = origin;
    }

    public int getW() {
        return w;
    }

    public int getH() {
        return h;
    }

    public Point getOrigin() {
        return origin;
    }

    public void setW(int w) {
        this.w = w;
    }

    public void setH(int h) {
        this.h = h;
    }

    public void setOrigin(Point origin) {
        this.origin = origin;
    }

    @Override
    public String toString() {
        return "Rectangle{" + "w=" + w + ", h=" + h + ", origin=" + origin + '}';
    }
    
    
/* 
    origin va gestito separatamente perchè è un'istanza di un'altra classe la 
    che deve anch'essa implementare Cloneable
*/
    @Override
    public Object clone() throws CloneNotSupportedException {
        Rectangle r =(Rectangle) super.clone();
        r.setOrigin((Point)origin.clone());
        return r; //To change body of generated methods, choose Tools | Templates.
    }
    
    

}
