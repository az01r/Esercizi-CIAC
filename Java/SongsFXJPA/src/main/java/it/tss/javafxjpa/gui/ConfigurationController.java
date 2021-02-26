/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package it.tss.javafxjpa.gui;

import it.tss.javafxjpa.business.DbManager;
import it.tss.javafxjpa.business.DbStore;
import it.tss.javafxjpa.business.PropertiesCache;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author alfonso
 */
public class ConfigurationController implements Initializable {

    @FXML
    private TextField txttype;
    @FXML
    private TextField txtserver;
    @FXML
    private TextField txtport;
    @FXML
    private TextField txtdbname;
    @FXML
    private TextField txtuser;
    @FXML
    private TextField txtpwd;
    @FXML
    private TextField txtoptions;
    @FXML
    private TextField txtmediapath;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txttype.setText(PropertiesCache.getInstance().getProperty("db.type"));
        txtserver.setText(PropertiesCache.getInstance().getProperty("db.server"));
        txtport.setText(PropertiesCache.getInstance().getProperty("db.port"));
        txtdbname.setText(PropertiesCache.getInstance().getProperty("db.name"));
        txtuser.setText(PropertiesCache.getInstance().getProperty("db.usr"));
        txtpwd.setText(PropertiesCache.getInstance().getProperty("db.pwd"));
        txtoptions.setText(PropertiesCache.getInstance().getProperty("db.options"));
        txtmediapath.setText(PropertiesCache.getInstance().getProperty("media.folder"));
    }

    @FXML
    public void onSave()  {
        try {
            PropertiesCache.getInstance().setProperty("db.type", txttype.getText());
            PropertiesCache.getInstance().setProperty("db.server", txtserver.getText());
            PropertiesCache.getInstance().setProperty("db.port", txtport.getText());
            PropertiesCache.getInstance().setProperty("db.name", txtdbname.getText());
            PropertiesCache.getInstance().setProperty("db.usr", txtuser.getText());
            PropertiesCache.getInstance().setProperty("db.pwd", txtpwd.getText());
            PropertiesCache.getInstance().setProperty("db.options", txtoptions.getText());
            PropertiesCache.getInstance().setProperty("media.folder", txtmediapath.getText());
            PropertiesCache.getInstance().flush();
            DbManager.check();
            DbStore.init();
            Messages.showMessage("Configurazione salvata correttamente", "", Alert.AlertType.INFORMATION);
        } catch (IOException | SQLException | URISyntaxException ex) {
            Messages.showMessage(ex.getMessage(), "", Alert.AlertType.ERROR);
        } 
    }

    @FXML
    public void onCancel() {
        System.out.println("onCancel");
    }

}
