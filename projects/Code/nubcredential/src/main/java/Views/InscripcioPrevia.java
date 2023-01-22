/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Views;

import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import Views.Main;
import Models.DataModel;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Timer;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import java.awt.event.ActionListener;
import java.util.Timer;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.control.Button;

/**
 *
 * @author jcanals
 */
public class InscripcioPrevia {

    private GridPane paneRootIns;
    private GridPane paneRootInsContent;
    private Label inscripcio;
    private GridPane bannerpane;
    private Label MensajeEntregado;
    private Button back;
    private GridPane buttonPane;

    public InscripcioPrevia(DataModel model, Main main) {

        Image background = new Image("file:\\Users\\joanc\\OneDrive\\Documents\\NetBeansProjects\\nubcredential\\src\\main\\java\\Imagenes\\backNub.jpg");

        paneRootInsContent = new GridPane();
        buttonPane = new GridPane();
        
        back= new Button("Volver");

        buttonPane.getChildren().add(back);
        buttonPane.setAlignment(Pos.CENTER);
        

        BackgroundImage bImg = new BackgroundImage(background,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(1920, 830, true, true, true, true)
        );
        Background bGround = new Background(bImg);
        paneRootInsContent.setBackground(bGround);
        
        buttonPane.setPadding(new javafx.geometry.Insets(15, 0, 0, 415));

        String nomusuari = model.getFirst_name() + " " + model.getLast_name();
        paneRootIns = new GridPane();

        bannerpane = new GridPane();
        inscripcio = new Label(" Se le ha entregado la documentació al usuario " + nomusuari);
        inscripcio.setStyle("-fx-text-fill:black; -fx-font-size:45;");
        inscripcio.setPadding(new Insets(300, 14, 9, 360));

        Timestamp t = new Timestamp(System.currentTimeMillis());
        System.out.println(t);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        System.out.println(sdf);
        String formatDate = sdf.format(t);
        System.out.println(formatDate);

        MensajeEntregado = new Label("La documentació fue entregada: " + formatDate);
        MensajeEntregado.setStyle("-fx-text-fill:red; -fx-font-size:45;");
        MensajeEntregado.setPadding(new Insets(100, 14, 10, 380));

        GridPane.setHalignment(inscripcio, HPos.CENTER);
        GridPane.setHalignment(MensajeEntregado, HPos.CENTER);

        bannerpane = main.getBannerPanel();

        paneRootIns.add(bannerpane, 0, 0);

        paneRootInsContent.setPrefSize(1920, 830);

        paneRootInsContent.add(inscripcio, 1, 0);
        paneRootInsContent.add(MensajeEntregado, 1, 1);
        paneRootInsContent.add(buttonPane,1,2);

        paneRootIns.add(paneRootInsContent, 0, 1);

    }

    public GridPane getRootPaneIns() {
        return paneRootIns;
    }

    public GridPane getRootPaneInsContent() {
        return paneRootInsContent;
    }

    public GridPane getRootBannerPane() {
        return bannerpane;
    }
    
    public Button back(){
        return back;
    }

}
