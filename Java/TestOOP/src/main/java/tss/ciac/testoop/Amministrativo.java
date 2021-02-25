/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tss.ciac.testoop;

/**
 *
 * @author Paolo
 */
public class Amministrativo extends Dipendente{
    private String ruolo;
    public Amministrativo (String nome){
        super (nome);
    }
    public String getRuolo(){
        return ruolo;
    }

    public void setRuolo(String ruolo) {
        this.ruolo = ruolo;
    }
    public float costoMensile(){
        float ris=0;
        for (Persona P : TestOOP.lista){
            if(p instanceof Dipendente){
                Dipendente d= (Dipendente) p;
            ris+=p.getSalario();
            }
        }
        return ris;
    }
}
