/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package box;

/**
 *
 * @author Paolo
 * @param <T>
 */
public class Box<T> {

    private T oggetto;

    public void inserisci(T o) {
        oggetto = o;
    }

    public T estrai() {
        return oggetto;
    }

    @Override
    public String toString() {
        return "Box{" + "oggetto=" + oggetto + '}';
    }

}
