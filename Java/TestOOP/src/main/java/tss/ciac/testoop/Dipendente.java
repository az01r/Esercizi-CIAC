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
public class Dipendente extends Persona{
    float salario;
    
    public Dipendente (){
        super();
    } 
    public Dipendente (String nome){
        super(nome);
    } 
    public Dipendente (String nome,float salario){
        super(nome);
        this.salario=salario;
    }

    public float getSalario() {
        return salario;
    }
    
    
}
