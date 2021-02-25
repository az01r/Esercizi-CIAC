/*
 * MainContent estende BorderPane invece di HBox perchè la prima ha la funzionalità di ridimensionarsi se ridimensiono la finestra
 * --> creo un HBox e lo metto al centro del BorderPane
 */
package tss.ciac.javafx;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;

/**
 *
 * @author tss
 */
public class MainContent extends BorderPane {

    private final Button btnPlus;
    private final Button btnMinus;
    private final Label result;
    private final HBox hbox;
    private int valore;
    
    public MainContent() {
        valore = 0;
        hbox = new HBox(10); // HBox è un contenitore che mette tutti gli oggetti in fila; 10 è lo spazio in px che separa gli oggetti
        hbox.setAlignment(Pos.CENTER); // metto il contenitore principale in centro, è quello che si espande per tutta la finestra
        btnPlus = new Button("incr"); // creo i buttons
        btnMinus = new Button("decr");
        btnMinus.setDisable(true);
        result = new Label(String.valueOf(valore)); 
        result.setTextFill(Color.GREEN);
        /*
        posso usare i metod reference perchè i metodi on___ implementano 
        l'interfaccia funzionale EventHandler, con un solo metodo 
        void handle(T event)
        */
        btnPlus.setOnAction(this::onIncrementa); // definisco gli eventi dei buttons
        btnMinus.setOnAction(this::onDecrementa);
        btnPlus.setOnMouseEntered(this::onMouseEntered);
        btnPlus.setOnMouseExited(this::onMouseExited);
        btnMinus.setOnMouseEntered(this::onMouseEntered);
        btnMinus.setOnMouseExited(this::onMouseExited);
        /* oppure usando le lambda     NB v è di tipo ActionEvent
        btnPlus.setOnAction(v->result.setText(String.valueOf(++valore))); 
        */
        
        hbox.getChildren().addAll(btnPlus, btnMinus, result); // aggiungo (in una sola riga) gli oggetti al contenitore hbox
        this.setCenter(hbox); // this si riferisce a questo BorderPane ---> metto l'HBox creato al centro del BorderPane
    }
    // metodi 
    private void onIncrementa(ActionEvent e) {
        result.setText(String.valueOf(++valore));
        btnMinus.setDisable(false);
    }

    private void onDecrementa(ActionEvent e) {
        result.setText(String.valueOf(--valore));
        btnMinus.setDisable(valore == 0); // if(n in Label result == 0) -> disabilita tasto decrementa
    }

    private void onMouseEntered(MouseEvent e) {
        ((Button) e.getSource()).setBackground(new Background(new BackgroundFill(Paint.valueOf("RED"), CornerRadii.EMPTY.EMPTY, Insets.EMPTY)));
    }

    private void onMouseExited(MouseEvent e) {
        ((Button) e.getSource()).setBackground(null);
    }
}