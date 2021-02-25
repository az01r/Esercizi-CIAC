/*
Si assuma una Rubrica come un insieme di voci formate da coppie chiave, valore. 
La chiave deve essere univoca ed è definita dalle seguenti proprietà: nome di 
tipo String,  tipologia di tipo definito con una enumerazione di valori 
{AMICIZIE, LAVORO, SPORT, MUSICA,  FAMIGLIA..}. 
Il valore è definito da un insieme privo di duplicati di Contatti dove ogni 
Contatto è definito dalle seguenti proprietà: tipo definito con una enumerazione
di valori  
{PERSONALE,CASA,UFFICIO,EMAIL,TELEGRAM…}, contatto di tipo String. 
Scrivere la classe Rubrica e le altre classi necessarie. La classe Rubrica deve 
prevedere i metodi necessari per aggiungere, modificare, eliminare, cercare, 
scorrere ed ordinare le voci al suo  interno. 

 */
package tss.ciac.escollectioninterfacestream.esercizio4;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * @author alfonso
 */
public class App {

    public static void main(String[] args) {

        Rubrica r = new Rubrica();

        Voce voce = new Voce(Voce.TipoVoce.SPORT, "Rossi mario");

        r.addOld(voce, new Contatto(Contatto.TipoContatto.CASA, "012512345"));

        //r.addOld(null, new Contatto(Contatto.TipoContatto.CASA, "01241234"));
        //r.addOld(new Voce(Voce.TipoVoce.SPORT, "Rossi mario"), null);
        //Set<Contatto> contatti = Stream.of(new Contatto(Contatto.TipoContatto.CASA, "012312345"), new Contatto(Contatto.TipoContatto.PERSONALE, "349111111")).collect(Collectors.toSet());
        
        r.addOld(voce, Stream.of(new Contatto(Contatto.TipoContatto.CASA, "012312345"), new Contatto(Contatto.TipoContatto.PERSONALE, "349111111")).collect(Collectors.toSet()));

        r.stampa();

        
        r.add(Voce.TipoVoce.AMICIZIE, "Rossi Mario", Contatto.TipoContatto.PERSONALE, "123456789");
        
        r.add(Voce.TipoVoce.AMICIZIE, "Bianchi Anna", Contatto.TipoContatto.PERSONALE, "888997766");
        
        r.add(Voce.TipoVoce.AMICIZIE, "Rossi Mario", Contatto.TipoContatto.EMAIL, "mario.rossi@gmail.com");
        
        r.stampa();
        
        r.elimina(Voce.TipoVoce.AMICIZIE, "Rossi Mario", Contatto.TipoContatto.EMAIL, "mario.rossi@gmail.com");
        
        r.stampa();
        
        r.add(Voce.TipoVoce.AMICIZIE, "Rossi Mario", Contatto.TipoContatto.EMAIL, "mario.rossi@gmail.com");
        
        r.stampa();
        
        r.find(Contatto.TipoContatto.EMAIL, "mario.rossi@gmail.com").ifPresentOrElse(System.out::println,() -> System.out.println("non trovato"));

        r.stampa();
        
        System.out.println("--------------------------- iterator ...................");
        for (Map.Entry<Voce, Set<Contatto>> en : r) {
            Voce key = en.getKey();
            Set<Contatto> val = en.getValue();
            System.out.println(key);
            val.forEach(System.out::println);
        }
        
    }
}