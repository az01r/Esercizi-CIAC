/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author alfonso
 */
@Named("regController")
@RequestScoped
public class RegistratiController {

    
    private String nome;
    private String cognome;

    @PostConstruct
    public void init() {
        System.out.println("init()");
    }

    public void onSave() {
        System.out.println(String.format("nome: %s , cognome: %s", nome, cognome));
        nome = "";
        cognome = "";
        FacesContext.getCurrentInstance().addMessage("", new FacesMessage("Notifica", "Grazie per esserti registrato"));
    }

    /*
    getter and setter
     */
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

}
