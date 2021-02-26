package it.tss.javafxjpa;

import it.tss.javafxjpa.business.DbStore;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import it.tss.javafxjpa.business.PropertiesCache;
import it.tss.javafxjpa.business.Song;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    private static Stage rootStage;

    @Override
    public void start(Stage stage) throws IOException {
        rootStage = stage;
        scene = new Scene(loadFXML("main"), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    public static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) throws IOException, FileNotFoundException, URISyntaxException {
        launch();
    }

    public static Stage getRootStage() {
        return rootStage;
    }
}
