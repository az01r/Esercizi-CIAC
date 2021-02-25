/*
 * 
 */
package interacce;

/**
 *
 * @author Paolo
 */
public class Persona implements Ordinabile<Persona> {
    private final String nome;
    private final int eta;

    public Persona(String nome, int eta) {
        this.nome = nome;
        this.eta = eta;
    }

    public String getNome() {
        return nome;
    }

    public int getEta() {
        return eta;
    }
    
    @Override
    public String toString(){
        return "Persona{nome: "+nome+", età: "+eta+"}";
    }
    
    public int confronta (Persona p){
        return this.eta-p.getEta();
    }
}
