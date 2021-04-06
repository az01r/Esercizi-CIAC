/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tss.ciac.tecnicheprogrammazione.objectoriented;

import java.time.LocalDate;

/**
 *
 * @author Paolo
 */
public class Turista {
    private String usr;
    private String pwd;
    private String nome;
    private String cognome;
    private LocalDate dataDiNascita;
    private String tel;

    public Turista(String usr, String pwd, String nome, String cognome, LocalDate dataDiNascita, String tel) {
        this.usr = usr;
        this.pwd = pwd;
        this.nome = nome;
        this.cognome = cognome;
        this.dataDiNascita = dataDiNascita;
        this.tel = tel;
    }

    public String getUsr() {
        return usr;
    }

    public void setUsr(String usr) {
        this.usr = usr;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

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

    public LocalDate getDataDiNascita() {
        return dataDiNascita;
    }

    public void setDataDiNascita(LocalDate dataDiNascita) {
        this.dataDiNascita = dataDiNascita;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    @Override
    public String toString() {
        return "Turista{" + "usr=" + usr + ", pwd=" + pwd + ", nome=" + nome + ", cognome=" + cognome + ", dataDiNascita=" + dataDiNascita + ", tel=" + tel + '}';
    }
    
}
