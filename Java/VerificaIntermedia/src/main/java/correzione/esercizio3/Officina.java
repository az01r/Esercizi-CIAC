/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esercizio3;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 *
 * @author alfonso
 */
public class Officina {

    private static int noGenerator = 0;
    private final int maxLavoriContemporanei;
    private final List<Macchina> inLavorazione = new ArrayList<>();

    public Officina(int maxLavoriContemporanei) {
        this.maxLavoriContemporanei = maxLavoriContemporanei;
    }

    public void nuovoLavoro(Macchina m) {
        Objects.requireNonNull(m, "macchinario da riparare non specificato..");
        if (inLavorazione.size() >= maxLavoriContemporanei) {
            throw new OfficinaException("Impossibile accettare nuovi lavori...");
        }
        m.setNo(++noGenerator);
        m.initLavorazioni();
        inLavorazione.add(m);
    }

    public Macchina consegnaLavoro(int no) {
        Macchina m = inLavorazione.get(inLavorazione.indexOf(findLavoro(no).orElseThrow()));
        inLavorazione.remove(m);
        return m;
    }

    public void addLavorazione(int no, Lavorazione l) {
        inLavorazione.get(inLavorazione.indexOf(findLavoro(no).orElseThrow())).addLavorazione(l);
    }

    private Optional<Macchina> findLavoro(int no) {
        for (Macchina m : inLavorazione) {
            if (m.getNo() == no) {
                return Optional.of(m);
            }
        }
        return Optional.empty();
    }

    @Override
    public String toString() {
        return "Officina{" + "maxLavoriContemporanei=" + maxLavoriContemporanei + ", inRiparazione=" + inLavorazione + '}';
    }
    
    
}
