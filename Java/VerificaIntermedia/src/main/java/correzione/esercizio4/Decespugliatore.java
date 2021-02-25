/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package esercizio4;

import esercizio3.*;

/**
 *
 * @author alfonso
 */
public class Decespugliatore extends Macchina {

    public final boolean accensioneEl;

    public Decespugliatore(boolean accensioneEl, String marca) {
        super(marca);
        this.accensioneEl = accensioneEl;
    }

    public boolean isAccensioneEl() {
        return accensioneEl;
    }

    @Override
    public String toString() {
        return "Decespugliatore{" + "accensioneEl=" + accensioneEl + "}\n" + super.toString();
    }

}
