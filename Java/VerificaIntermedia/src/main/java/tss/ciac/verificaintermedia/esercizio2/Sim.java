/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tss.ciac.verificaintermedia.esercizio2;

import java.util.ArrayList;

/**
 *
 * @author Paolo
 */
public class Sim {

    private final String numeroTelefonico;
    private final float credito;
    private ArrayList<Telefonata> elencoTelefonate=new ArrayList<Telefonata>();

    public Sim(String numeroTelefonico, float credito) {
        this.numeroTelefonico = numeroTelefonico;
        this.credito = credito;
    }

    public void addTelefonata(String numeroDestinatario, int durata) {
        elencoTelefonate.add(new Telefonata(numeroDestinatario, durata));
    }

    public int minutiTotati() {
        int minuti = 0;
        for (Telefonata telefonata : elencoTelefonate) {
            minuti += telefonata.getDurata();
        }
        return minuti;
    }

    public int minutiConDestinatario(String numeroDestinatario) {
        int minuti = 0;
        for (int i = 0; i < elencoTelefonate.size(); i++) {
            if (elencoTelefonate.get(i).getNumeroDestinatario().equals(numeroDestinatario)) {
                minuti += elencoTelefonate.get(i).getDurata();
            }
        }
        return minuti;
    }

    public void printInfo() {
        System.out.println("Numero di telefono: " + numeroTelefonico + "\nCredito residuo: " + credito + "\n" + infoElencoTelefonate());
    }

    private String infoElencoTelefonate() {
        String info = "Elenco telefonate: ";
        for (Telefonata telefonata : elencoTelefonate) {
            info += "\nDestinatario: " + telefonata.getNumeroDestinatario() + "\nDurata: " + telefonata.getDurata();
        }
        return info;
    }
}
