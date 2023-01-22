/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Views;

import Models.DataModel;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.TextAlignment;

public class DocumentacionEntregada {

    private Label MensajeEntregado;
    private Timestamp timeEntrega;
    private DataModel model;
    private Main main;
    private GridPane bannerpane;
    private GridPane paneRoot;
    private GridPane contentpane;
    private Button back;
    private GridPane buttonpane;
    private Label user;

    public DocumentacionEntregada(DataModel model, Main main) {

        bannerpane = new GridPane();
        contentpane = new GridPane();
        paneRoot = new GridPane();
        buttonpane = new GridPane();

        Image background = new Image("file:\\Users\\joanc\\OneDrive\\Documents\\NetBeansProjects\\nubcredential\\src\\main\\java\\Imagenes\\backNub.jpg");

        paneRoot = new GridPane();

        BackgroundImage bImg = new BackgroundImage(background,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(1920, 830, true, true, true, true)
        );
        Background bGround = new Background(bImg);
        paneRoot.setBackground(bGround);
        // Long timeEntrega = System.currentTimeMillis()/1000;
        //  System.out.println(timeEntrega);
        Timestamp t = new Timestamp(model.getDelivery_time());
        System.out.println(t);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        System.out.println(sdf);
        String formatDate = sdf.format(t);
        System.out.println(formatDate);

        bannerpane = main.getBannerPanel();
        
        back= new Button("Volver");
        buttonpane.getChildren().add(back);
        buttonpane.setAlignment(Pos.CENTER);
        
       // contentpane.setPrefSize(1920, 830);
       // contentpane.setAlignment(Pos.CENTER);
        
         buttonpane.setPadding(new javafx.geometry.Insets(15, 0, 0, 300));
        
        user= new Label(model.getFirst_name().toUpperCase()+ " " + model.getLast_name().toUpperCase());
        GridPane.setHalignment(user, HPos.CENTER);
       // user.setPadding(new Insets(15,0,0,760));
        user.setStyle("-fx-text-fill:black; -fx-font-size:45;");
        MensajeEntregado = new Label("La documentació fue entregada a las  " + formatDate +" " + "por el usuario " );
        MensajeEntregado.setStyle("-fx-text-fill:black; -fx-font-size:45;");
        MensajeEntregado.setPadding(new Insets(300, 14, 9, 180));
        back.setPrefSize(120, 60);
        GridPane.setHalignment(MensajeEntregado, HPos.CENTER);
        GridPane.setHalignment(back, HPos.CENTER);
        paneRoot.add(MensajeEntregado, 0, 0);
        paneRoot.add(user, 0, 1);
        paneRoot.add(buttonpane, 0, 2);
        paneRoot.setPrefSize(1920, 830);

        contentpane.add(bannerpane, 0, 0);
        contentpane.add(paneRoot, 0, 1);

    }

    public void setRootp(GridPane contentpane) {
        this.contentpane = contentpane;
    }

    public GridPane getRootp() {
        return contentpane;
    }

    public Timestamp getTimeEntrega() {
        return timeEntrega;
    }

    public void setTimeEntrega(Timestamp timeEntrega) {
        this.timeEntrega = timeEntrega;
    }

    public Button back(){
        return back;
    }
            
    
}
