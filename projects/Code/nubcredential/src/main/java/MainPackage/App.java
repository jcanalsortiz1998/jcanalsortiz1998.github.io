package MainPackage;

import Controllers.Controller;
import Models.ConexionSQLite;
import Models.DataModel;
import Models.ModelQuerys;
import Views.DocumentacionEntregada;
import Views.InscripcioPrevia;
import Views.Main;
import Views.NoReconocido;
import Views.Onsite;
import Views.Ticket;
import Views.VistaPreImpresion;
import java.io.File;
import java.io.IOException;

import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;

import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {
private App app;
    @Override
    public void start(Stage stage) throws URISyntaxException, IOException {
        App app= new App();
        //Onsite on = new Onsite();
        //DocumentacionEntregada docE = new DocumentacionEntregada();
        //InscripcionPrevia insP = new InscripcionPrevia();
        NoReconocido noRec = new NoReconocido();
        DataModel model = new DataModel();
        ModelQuerys modQ = new ModelQuerys();
        //Ticket ticket = new Ticket();
        VistaPreImpresion vPreImp = new VistaPreImpresion();
        Main main = new Main();
        Scene scene = new Scene(main.getRootPanel(), 1920, 1080);

        Controller controller = new Controller(model, modQ, main, vPreImp, noRec,  scene,stage,app);

        stage.setTitle("Nubcredential");
        stage.getIcons().add(new Image("file:\\Users\\joanc\\OneDrive\\Documents\\NetBeansProjects\\nubcredential\\src\\main\\java\\Views\\favicon.png"));

        stage.setScene(scene);
        controller.initController();
        stage.show();

    }
    
    public App(){
        this.app=app;
    }

    public static void main(String[] args) throws SQLException {


        launch();
    }

}
