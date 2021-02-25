/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esercizio4;

/**
 *
 * @author alfonso
 */
public interface Riparabile {
    
    int getNo();
    
    void setNo(int numero);
    
    void initLavorazioni();
    
    void addLavorazione(Lavorazione l);
    
}
