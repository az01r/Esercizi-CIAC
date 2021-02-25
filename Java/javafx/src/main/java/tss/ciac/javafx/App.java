/*
NB per risolvere l'errore di netbeans andare su
proejct->properties->actions->run project->execute goals->
clean javafx:run 

per info -> javafx api
 */
package tss.ciac.javafx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {   
        var scene = new Scene(new MainContent(), 200, 100);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}