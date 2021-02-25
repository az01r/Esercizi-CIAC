/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tss.ciac.escollectioninterfacestream.esercizio2;

import java.util.List;
import java.util.stream.Collectors;
import tss.ciac.escollectioninterfacestream.esercizio1.Catalogo;

/**
 *
 * @author Paolo
 */
public class ProvaMobile {

    List<Mobile> mobiliSottoPrezzo;

    public static <T extends Mobile> List<T> scegliMobile(Catalogo<T> elMobili, double prezzo, int larghezza, int altezza, int profondita) {
        return elMobili.getArticoliSottoPrezzo(prezzo).stream()
                .filter(v->v.getAltezza()<altezza&&v.getLarghezza()<larghezza&&v.getProfondita()<profondita)
                .collect(Collectors.toList());
        /*Iterator<T> scorri = elMobili.iterator();
        while (scorri.hasNext()) {
            T t = scorri.next();
            if (t.getPrezzo() < prezzo) {
                if (t.getLarghezza() < larghezza) {
                    if (t.getAltezza() < altezza) {
                        if (t.getProfondita() < profondita) {
                            mobiliSottoPrezzo.add(t);
                        }
                    }
                }
            }
        }
        return mobiliSottoPrezzo;
        */
    }
}
