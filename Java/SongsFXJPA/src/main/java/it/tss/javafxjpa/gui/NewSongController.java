/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.javafxjpa.gui;

import it.tss.javafxjpa.App;
import it.tss.javafxjpa.business.DbStore;
import it.tss.javafxjpa.business.Song;
import it.tss.javafxjpa.business.SongsStoreException;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

/**
 *
 * @author alfonso
 */
public class NewSongController implements Initializable{
 @FXML
    private TextField txtTitolo;
    @FXML
    private TextField txtArtista;
    @FXML
    private TextField txtAlbum;
    @FXML
    private Label txtFilename;
    private File file;

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        System.out.println("initialize newSong controller...");
        txtFilename.setText("");
    }

    public void onSave() {
        try {
            DbStore.save(txtTitolo.getText(), txtArtista.getText(), txtAlbum.getText(), txtFilename.getText(),this.file);
            clearFields();
            Messages.showMessage("Song salvata correttamente", "", Alert.AlertType.INFORMATION);
        } catch (SongsStoreException ex) {
            Messages.showMessage(ex.getMessage(), "", Alert.AlertType.ERROR);
        }
    }

    public void onChooseFile() {
        final FileChooser fileChooser = new FileChooser();
        this.file = fileChooser.showOpenDialog(App.getRootStage());
        txtFilename.setText(this.file.getName());
    }

    private void clearFields() {
        txtTitolo.setText("");
        txtArtista.setText("");
        txtAlbum.setText("");
        txtFilename.setText("");
    }
}
