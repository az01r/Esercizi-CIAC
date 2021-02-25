import pizzeria.Pizza;
import pizzeria.Pizza.Formato;
import pizzeria.Pizza.TipoFarina;

public class App {
    public static void main(String[] args) throws Exception {
        Pizza myPizza = new Pizza.Builder(TipoFarina.INTEGRALE, Formato.GRANDE)
                            .pomodoro(true)
                            .mozzarella(true)
                            .prosciutto(true)
                            .funghi(true)
                            .build();
        myPizza.stampaPizza();
        Pizza margherita = Pizza.margherita(Pizza.TipoFarina.NORMALE,Pizza.Formato.MEDIO);
        margherita.stampaPizza();
        Pizza prosciuttoFunghi = Pizza.prosciuttoFunghi(Pizza.TipoFarina.MORESCHINA, Pizza.Formato.GRANDE);
        prosciuttoFunghi.stampaPizza();
    }
}
