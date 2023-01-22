/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Views;

import java.awt.event.MouseListener;
import java.net.URISyntaxException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import java.awt.event.MouseListener;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

/**
 *
 * @author joanc
 */

public class Settings {

    private GridPane pane;
    private GridPane datosAcceso;
    private GridPane datosExtra;
    private GridPane panelIp;
    private Label datos_acceso;
    private Label datos_update;
    private Label ip;
    private Label password;
    private TextField ipInput;
    private GridPane panePassword;
    private Label passwordS;
    private TextField passwordInput;
    private GridPane ajustesTodo;
    private Button aTodo;
   
    private GridPane ajustesBanner;
    private Button aBanner;
  
    private GridPane ajustesBBDD;
    private Button aBBDD;
   
    private GridPane ajustesSettings;
    private Button aSettings;
   
    

    public Settings() {

        pane = new GridPane();
        datosAcceso = new GridPane();
        datosExtra = new GridPane();
        panelIp= new GridPane(); 
        panePassword= new GridPane();
        ajustesTodo= new GridPane();
        ajustesBanner= new GridPane();
        ajustesSettings= new GridPane();
        ajustesBBDD= new GridPane();
        passwordS= new Label("Password");
        passwordInput= new TextField();
        aTodo= new Button("Actualizar/Descargar ajustes e imágenes");
        aBanner= new Button("Descargar imágenes");
        aBBDD= new Button("Actualizar Base de Datos");
        aSettings= new Button("Actualizar ajustes");
    
        
       
       
        ipInput= new TextField();
        //ipInput.setPadding(new Insets(0,-120,0,0));
       
       
       
        datosAcceso.setStyle("-fx-background-color:lightgrey; -fx-padding:5px");
       
        datosExtra.setStyle("-fx-background-color:lightgrey; -fx-padding:5px;");
        datosAcceso.setPrefWidth(1920);
        datosExtra.setPrefWidth(1920);
        panelIp.setPrefWidth(1920);
        panePassword.setPrefWidth(1920);
        passwordS.setPrefWidth(320);
        ipInput.setPrefWidth(1600);
        passwordInput.setPrefWidth(1600);
        
        aBBDD.setPrefWidth(320);
        aBanner.setPrefWidth(320);
        
       aTodo.setAlignment(Pos.CENTER);
       aTodo.setPrefWidth(1920);
       aTodo.setPadding(new Insets(30,0,30,0));
       aTodo.setStyle("-fx-background-color:white; -fx-text-weight:bold");
       
       aBanner.setAlignment(Pos.CENTER);
       aBanner.setPrefWidth(1920);
       aBanner.setPadding(new Insets(30,0,30,0));
       aBanner.setStyle("-fx-background-color:white; -fx-text-weight:bold");
               
       
        aTodo.setOnMouseEntered(e -> aTodo.setStyle("-fx-background-color:lightgrey"));
        aTodo.setOnMouseExited(e -> aTodo.setStyle("-fx-background-color:white"));
       ajustesTodo.add(aTodo,0,0);
      


        datos_acceso = new Label("Acceso");
        datos_acceso.setStyle("-fx-text-fill: orange; -fx-font-size:30px;-fx-font-weight:bold");
        datos_update = new Label("Actualizaciones/Descargas");
        datos_update.setStyle("-fx-text-fill: orange; -fx-font-size:30px; -fx-font-weight:bold");
        
        ip= new Label("Dirección IP");
        ip.setPrefWidth(320);
        ip.setStyle("-fx-font-size:20px;");
        passwordS.setStyle("-fx-font-size:20px;");
       // ip.setPadding(new Insets(0,0,120,15));
        
        panelIp.add(ip, 0, 0);
        panelIp.add(ipInput, 1, 0);
        panelIp.setStyle("-fx-background-color:azure;-fx-border-color: black; -fx-border-width: 2px");
        panelIp.setPadding(new Insets(15,15,15,15));
        
        panelIp.setVgap(50);
         ColumnConstraints col11 = new ColumnConstraints();
        col11.setPercentWidth(20);
        ColumnConstraints col22 = new ColumnConstraints();
        col22.setPercentWidth(75);
       

        panePassword.add(passwordS, 0, 0);
        panePassword.add(passwordInput, 1, 0);
        
        panePassword.setStyle("-fx-background-color:azure;-fx-border-color: black; -fx-border-width: 2px");
        panePassword.setPadding(new Insets(15,15,15,15));
        
        ColumnConstraints col12 = new ColumnConstraints();
        col12.setPercentWidth(20);
        ColumnConstraints col222 = new ColumnConstraints();
        col222.setPercentWidth(75);

        panelIp.getColumnConstraints().addAll(col11, col22);
        panePassword.getColumnConstraints().addAll(col12, col222);


        datosAcceso.add(datos_acceso, 0, 0);
        

        datosExtra.add(datos_update, 0, 0);
        
        
        //--------------------------------------------
        
        
    

        pane.add(datosAcceso, 0, 0);
        pane.add(panelIp, 0, 1);
        pane.add(panePassword, 0, 2);
        pane.add(datosExtra, 0, 3);
        pane.add(ajustesTodo, 0, 4);
        pane.add(ajustesBBDD, 0, 5);
        pane.add(ajustesBanner, 0, 6); 
        

    }

    public GridPane getRootSetting() {
        return pane;
    }
}
