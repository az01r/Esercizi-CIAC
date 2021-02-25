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
public interface Movimento {
    void move(int x, int y);
    void cambiaDirezione(int nuovaDirezione);
    void cambiaVelocita(int nuovaVelocita);
    
}
