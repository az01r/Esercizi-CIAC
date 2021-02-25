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
public interface Moveable {
    void changeSpeed(int newSpeed);
    void changeDirection(int direction);
    void changePosition(int x,int y);
    
}
