public class App {
    public static void main(String[] args) throws Exception {
        Agenzia agenzia=new Agenzia();
        
    /*  Persona newPersona = new Persona("Paolo", "Grosso", 123);
        System.out.println(newPersona.infoPersona());
        System.out.println("---------------------------------");
        ag.dipendenti.add(newPersona);  // add new dipendente, metodo standard ArrayList
       
        Attore nuovaPersona = new Attore("Brad", "Pitt", 333, "bianca", 78, 70);
        System.out.println(nuovaPersona.infoAttore());
        System.out.println("---------------------------------");
        ag.addNewDipendente(nuovaPersona); // add new dipendente, metodo della classe Agenzia
    */
        agenzia.creaNuovaPersona(); 
        agenzia.creaNuovoAttore();
        agenzia.stampaElencoDipendenti();
        agenzia.stampaInfoByMatricola();
    }
}
