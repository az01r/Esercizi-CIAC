package tss.ciac.javafx2;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class MainViewController {

    private int valore = 0;
    
    // @FXML è un'annotazione e collega la variabile o il metodo al file fxml
    @FXML
    private Label result;
    
    @FXML
    public void onIncrementa (ActionEvent e){
        result.setText(String.valueOf(++valore));
    }
    @FXML
    public void onDecrementa (ActionEvent e){
        result.setText(String.valueOf(--valore));
    }
}
