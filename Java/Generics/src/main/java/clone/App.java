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
public class App {
    public static void main(String[] args) throws CloneNotSupportedException {
        
        System.out.println("---------------------------Point---------------------------");
        Point p1=new Point(0, 0);
        Point p2;
        // uso =
        System.out.println("p2 = p1");
        p2=p1;
        System.out.println("p1: "+p1);
        System.out.println("p2: "+p2);
        System.out.println("Sposto p1");
        p1.move(10, 10);
        System.out.println("p1: "+p1);
        System.out.println("p2: "+p2);
        /* =
        muovendo p1 ha spostato anche p2 perchè p2 punta a p1 ovvero ho creato 
        solo un oggetto
        */
        // uso clone
        System.out.println("p2 = clone di p1");
        p2=(Point)p1.clone();
        System.out.println("p1: "+p1);
        System.out.println("p2: "+p2);
        System.out.println("Sposto p1");
        p1.move(20, 20);
        System.out.println("p1: "+p1);
        System.out.println("p2: "+p2);
        /* .clone()
        muovendo p1 non ha spostato anche p2 perchè p2 crea un oggetto uguale a 
        p1 ovvero ho creato 2 oggetti
        */
        System.out.println("---------Rettangle - classe dipendente da Point---------");
        p1.move(0, 0);
        Rectangle r1=new Rectangle(5, 10, p1);
        Rectangle r2;
        System.out.println("r2 = r1");
        r2=r1;
        System.out.println("r1: "+r1);
        System.out.println("r2: "+r2);
        System.out.println("Allargo r1");
        r1.setW(10);
        System.out.println("r1: "+r1);
        System.out.println("r2: "+r2);
        /* 
        muovendo r1 ha spostato anche r2 perchè r2 punta a r1 ovvero ho creato 
        solo un oggetto
        */
        // uso clone
        System.out.println("r2 = clone di r1");
        r2=(Rectangle)r1.clone();
        System.out.println("r1: "+r1);
        System.out.println("r2: "+r2);
        System.out.println("Allargo r1");
        r1.setW(30);
        System.out.println("r1: "+r1);
        System.out.println("r2: "+r2);
        /* .clone()
        V1  allargando p1 non ha allargato anche p2 perchè p2 crea un oggetto uguale
            a p1 ovvero ho creato 2 oggetti
        V2  ora allargando p1 ha allargato anche p2 perchè ho implementato clone
            anche per il punto, dipendete dalla classe Point
        */
        
        System.out.println("Sposto origine r1");
        p1.move(15, 15);
        r1.setOrigin(p1);
        System.out.println("r1: "+r1);
        System.out.println("r2: "+r2);
    }
}
