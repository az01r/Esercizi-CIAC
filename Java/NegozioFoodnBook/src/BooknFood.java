import java.util.ArrayList;
import java.util.Scanner;

public class BooknFood {
    private ArrayList<Prodotto> listino=new ArrayList<Prodotto>();
    private ArrayList<Prodotto> carrello=new ArrayList<Prodotto>();
    
    /**
     * Crea un nuovo prodotto di tipo Prodotto e lo aggiunge al listino
     * @param nomeProdotto String
     * @param prezzo float
     */
    public void creaNuovoProdotto(){
        String nomeProdotto;
        float prezzo;
        Prodotto nuovoProdotto;
        Scanner lettore=new Scanner(System.in);
        System.out.print("Inserire nome prodotto: ");
        nomeProdotto=lettore.nextLine();
        lettore=new Scanner(System.in);
        System.out.print("Inserire prezzo prodotto: ");
        prezzo=lettore.nextFloat();
        nuovoProdotto= new Prodotto(nomeProdotto,prezzo);
        listino.add(nuovoProdotto);
    }
    public void creaNuovoFood(){
        String nomeFood;
        float prezzo,peso;
        Food nuovoFood;
        int date,month,year;
        Scanner lettore=new Scanner(System.in);

        System.out.print("Inserire nome prodotto: ");
        nomeFood=lettore.nextLine();
        lettore=new Scanner(System.in);
        System.out.print("Inserire prezzo prodotto: ");
        prezzo=lettore.nextFloat();
        System.out.print("Inserire peso prodotto: ");
        peso=lettore.nextFloat();
        lettore=new Scanner(System.in);
        System.out.print("Inserire anno scadenza prodotto: ");
        year=lettore.nextInt();
        System.out.print("Inserire mese scadenza prodotto: ");
        month=lettore.nextInt();
        System.out.print("Inserire giorno scadenza prodotto: ");
        date=lettore.nextInt();
        nuovoFood= new Food(nomeFood, prezzo, peso, date, month, year);
        listino.add(nuovoFood);
    }
    public void creaNuovoBook(){
        String nomeLibro,autore;
        float prezzo;
        Book nuovoLibro;
        int nPagine;
        Scanner lettore=new Scanner(System.in);

        System.out.print("Inserire nome prodotto: ");
        nomeLibro=lettore.nextLine();
        lettore=new Scanner(System.in);
        System.out.print("Inserire prezzo prodotto: ");
        prezzo=lettore.nextFloat();
        lettore=new Scanner(System.in);
        System.out.print("Inserire autore del libro: ");
        autore=lettore.nextLine();
        lettore=new Scanner(System.in);
        System.out.print("Inserire numero pagine del libro: ");
        nPagine=lettore.nextInt();
        nuovoLibro= new Book(nomeLibro, prezzo, autore, nPagine);
        listino.add(nuovoLibro);
    }
    
    
    public void stampaListino(){
        for (int i=0;i<listino.size();i++) {
            System.out.println(listino.get(i).getInfoProdotto()+"\nIndice prodotto: "+i);
        }
    }

    public void aggiungiAlCarrello(int indexProdotto){
        carrello.add(listino.get(indexProdotto));
    }

    public void svuotaCarrello(){
        carrello.clear();
    }

    public void rimuoviUltimoProdottoDalCarrello(){
        carrello.remove(carrello.size()-1);
    }

    /**
     * Rimuove dal carrello il prodotto in posizione @index
     * @param index tipo int: indica la posizione del prodotto da rimuovere dal carrello 
     */
    public void rimuoviIesimoProdottoDalCarrello(int index){
        carrello.remove(index);
    }

    /**
     * Calcola la spesa totale con i prodotti nel carrello
     * @return float somma prezzi
     */
    private float totaleCarrello(){
        float tot=0;
        for (Prodotto prodotto : carrello) {
            tot = tot+prodotto.getPrezzo();
        }
        return tot;
    }
    /**
     * Stampa gli elementi nel carrello e la spesa totale
     */
    public void stampaCarrello(){
        for (int i=0;i<listino.size();i++) {
            System.out.println(carrello.get(i).getInfoProdotto()+"\nIndice prodotto: "+i);
        }
        System.out.println("Spesa Totale: "+totaleCarrello());
    }
}
