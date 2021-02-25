/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interacce;

/**
 *
 * @author Paolo
 * @param <T> oggetto ti tipo generico usato come parametro: sarà la classe che
 * implementa Ordinabile a definirne il tipo
 */
public interface Ordinabile<T> {

    int confronta(T o);
}
