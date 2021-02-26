/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.javafxjpa.gui;

import it.tss.javafxjpa.App;
import it.tss.javafxjpa.business.DbManager;
import it.tss.javafxjpa.business.DbStore;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author alfonso
 */
public class MainController implements Initializable {

    @FXML
    BorderPane borderPane;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            DbManager.check();
            DbStore.init();
        }catch(SQLException ex){
            Messages.showMessage("Errore nell'apertura del database. verifica la configurazione", "", Alert.AlertType.ERROR);
        }

    }

    @FXML
    public void onClose() {
        System.exit(0);
    }

    @FXML
    public void onViewSongs() throws IOException {
        Parent view = App.loadFXML("viewSongs");
        borderPane.setCenter(view);
    }

    @FXML
    public void onNewSong() throws IOException {
        Parent view = App.loadFXML("newSong");
        borderPane.setCenter(view);
    }

    @FXML
    public void onConfigure() throws IOException {
        Parent view = App.loadFXML("configuration");
        borderPane.setCenter(view);
    }

    @FXML
    public void onAbout() throws IOException {
        Parent view = App.loadFXML("about");
        borderPane.setCenter(view);
    }
}
