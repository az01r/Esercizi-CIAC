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
public class Bici extends Mezzo {
    
    private String tipo;
    
    public Bici(int x, int y, int velocita, int direzione) {
        super(x, y, velocita, direzione);
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

   

    @Override
    public void cambiaDirezione(int nuovaDirezione) {
        direzione=nuovaDirezione;
        
       
    }

    @Override
    public void cambiaVelocita(int nuovaVelocita) {
        velocita=nuovaVelocita;
    }

    @Override
    public void printMezzo() {
        
    }

    @Override
    public void printConsole() {
        
    }

    @Override
    public String printCSV() {
        String ris="";
        return ris;
    }

    String getAttr() {
        String ris="";
        ris+="["+getX()+","+getY()+"] v:"+getVelocita()+ " d:"+getDirezione();
        return ris;
    
    }

  
    
}
