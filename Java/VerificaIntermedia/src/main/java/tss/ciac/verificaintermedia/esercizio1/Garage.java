/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tss.ciac.verificaintermedia.esercizio1;

/**
 *
 * @author Paolo
 */
public class Garage {

    private int[] postoOccupato = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    public void parcheggia(Veicolo v) {
        int posizione = v.getPosizione();
        if (posizione == -1) {
            for (int i = 0; i < 15; i++) {
                if (postoOccupato[i] == 0) {
                    postoOccupato[i] = 1;
                    posizione = i;
                    v.setPosizione(posizione);
                    break;
                }
            }
            if (posizione == -1) {
                System.out.println("Parcheggio pieno");
            }
        }else{
                System.out.println("Veicolo già parcheggiato in posizione "+v.getPosizione());
        }
    }

    public void rimuovi(Veicolo v) {
        postoOccupato[v.getPosizione()] = 0;
        v.setPosizione(-1);
    }
    
    public String infoGarage(){
        String info="---------Info Garage---------\n";
        for (int i=0;i<postoOccupato.length;i++) {
            if(postoOccupato[i]==1){
                info+="Posto "+i+" occupato\n";
                info+="\n-----------------------------\n";
            }
        }
        return info;
    }
}
