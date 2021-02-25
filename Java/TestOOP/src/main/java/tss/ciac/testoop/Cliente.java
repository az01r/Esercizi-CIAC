/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tss.ciac.testoop;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Paolo
 */
public class Cliente extends Persona{
    String codTessera;
    
    public Cliente (){
        super();
    }
    public Cliente (String nome){
        super(nome);
    } 
    public Cliente (String nome,String codTessera){
        super(nome);
        this.codTessera=codTessera;
    } 
    public void setCodTessera(String codTessera) {
        this.codTessera=codTessera;
    }

    public String getCodTessera() {
        return codTessera;
    }
    
}
