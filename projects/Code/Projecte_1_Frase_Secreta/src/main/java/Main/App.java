package Main;

import Controller.Controlador;
import Resources.CarregarFrases;
import Resources.GestionarFrase;
import Views.UI;
import javafx.application.Application;
import javafx.scene.Scene;

import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        CarregarFrases FraseN = new CarregarFrases();
        GestionarFrase gN = new GestionarFrase();
        UI ui = new UI();
        Scene scena = new Scene(ui.getRootPane(), 800, 800);
        Controlador ct = new Controlador(ui, FraseN, gN, scena);
        ct.initController();
        stage.setTitle("Pràctica JavaFX");
        stage.setScene(scena);
        stage.show();

    }

    public static void main(String[] args) {

        launch(args);
    }

}
