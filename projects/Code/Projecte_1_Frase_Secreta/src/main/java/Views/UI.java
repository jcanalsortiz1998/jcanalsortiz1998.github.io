/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Views;

import java.util.ArrayList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;

public class UI {

    private BorderPane rootPane;
    private ComboBox<String> comboBox;
    private ComboBox<String> comboBoxlletres;
    private ComboBox lletra;

    private Button jugar;
    private Button comprobar;
    private Button rendicion;
    private Button pistas;
    private TilePane crucigrama;
    private TilePane crucigramaUser;
    private TilePane seleccion;
    private Text titol;
    private GridPane selectPane;
    private VBox buttonPane;
    private int longitudFrase;
    private String fraseEscogida;
    private GridPane lletresPane;
    private VBox nPistas;

    private String[] arxius;
    private String abc[] = {"a", "b", "c", "ç", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "ñ", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
    private String[] pistasGenerades;

    public UI() {

        //Creació components utilitzats en la Vista
        rootPane = new BorderPane();
        selectPane = new GridPane();
        lletresPane = new GridPane();
        nPistas = new VBox();

        /*-----------------------------------------------------------------------------------*/
        selectPane.setMinHeight(50);
        //selectPane.setBackground(new Background(new BackgroundFill(Color.web("#114B5F"), CornerRadii.EMPTY, Insets.EMPTY)));
        selectPane.setStyle("-fx-font-family: Verdana, sans-serif;-fx-background-color:#114B5F;-fx-border-style: solid inside;-fx-border-width: 0;-fx-border-color: black");

        /*-----------------------------------------------------------------------------------*/
        buttonPane = new VBox();
        buttonPane.setPrefHeight(Double.MAX_VALUE);
        //buttonPane.setBackground(new Background(new BackgroundFill(Color.web("#114B5F"), CornerRadii.EMPTY, Insets.EMPTY)));
        buttonPane.setStyle("-fx-font-family: Verdana, sans-serif;-fx-background-color:#114B5F;-fx-border-style: solid inside;-fx-border-width: 0;-fx-border-color: black");

        /*-----------------------------------------------------------------------------------*/
        crucigrama = new TilePane();


        /*-----------------------------------------------------------------------------------*/
        seleccion = new TilePane();

        /*-----------------------------------------------------------------------------------*/
        jugar = new Button("Jugar");
        jugar.setStyle("-fx-background-color:#FFFF00;-fx-border-color: black;-fx-border-width: 1 2 1 2;-fx-font-family: Verdana;-fx-font-weight:bold;");
        jugar.setTextFill(Color.BLACK);
        jugar.setPrefWidth(110);
        jugar.setDisable(true);

        /*-----------------------------------------------------------------------------------*/
        comprobar = new Button("Comprovar");
        comprobar.setStyle("-fx-background-color:#FFFF00;-fx-border-color: black;-fx-border-width: 1 2 1 2;-fx-font-family: Verdana;-fx-font-weight:bold");
        comprobar.setTextFill(Color.BLACK);
        comprobar.setPrefWidth(110);
        comprobar.setDisable(true);

        /*-----------------------------------------------------------------------------------*/
        rendicion = new Button("Rendició");
        rendicion.setStyle("-fx-background-color:#FFFF00;-fx-border-color: black;-fx-border-width: 1 1 1 1;-fx-font-family: Verdana;-fx-font-weight:bold");
        rendicion.setTextFill(Color.BLACK);
        rendicion.setPrefWidth(110);
        rendicion.setDisable(true);

        /*-----------------------------------------------------------------------------------*/
        pistas = new Button("Pistas");
        pistas.setStyle("-fx-background-color:#FFFF00;-fx-border-color: black;-fx-border-width: 1 1 1 1;-fx-font-family: Verdana;-fx-font-weight:bold");
        pistas.setTextFill(Color.BLACK);
        pistas.setPrefWidth(110);
        pistas.setDisable(true);

        /*-----------------------------------------------------------------------------------*/
        rootPane.setTop(generarTopPane());

        comboBox = new ComboBox<String>();
        comboBox.setPrefWidth(120);
        comboBox.setPromptText("Frases");
        comboBoxlletres = new ComboBox<>();

        /*-----------------------------------------------------------------------------------*/
        selectPane.setPrefWidth(120);
        selectPane.add(comboBox, 0, 0);
        rootPane.setLeft(selectPane);

        /*-----------------------------------------------------------------------------------*/
        buttonPane.setPrefWidth(170);
        buttonPane.setPadding(new Insets(36, 36, 36, 36));
        buttonPane.setSpacing(40.0);
        buttonPane.getChildren().addAll(jugar, comprobar, rendicion, pistas, nPistas);
        rootPane.setRight(buttonPane);
        /*-----------------------------------------------------------------------------------*/

    }

    public void generarMatriuPrincipal(String fraseLlegida, int longitudFrase) {

        crucigrama = new TilePane();
        crucigrama.setMaxWidth(Double.MAX_VALUE);
        crucigrama.setMaxHeight(Double.MAX_VALUE);

        for (int i = 0; i < longitudFrase; i++) {

            Label l = new Label();
            l.setPrefHeight(45);
            l.setPrefWidth(45);

            char lletra = fraseLlegida.charAt(i);
            String lletraCorrecta = Character.toString(lletra);

            if (lletraCorrecta.equals(" ")) {
                lletraCorrecta = "";
                l.setStyle("-fx-border-color: black;" + "-fx-padding: 4px; " + "-fx-background-color:black;");
            } else {
                l.setStyle("-fx-border-color: black;" + "-fx-padding: 4px; " + "-fx-background-color:white;");
            }
            l.setText(lletraCorrecta);

            crucigrama.getChildren().add(l);
            crucigrama.setStyle("-fx-font-family: Verdana, sans-serif;-fx-background-color:#114B5F;-fx-border-style: solid inside;-fx-border-width:10;-fx-border-color: black");
            crucigrama.setAlignment(Pos.CENTER);

            rootPane.setCenter(crucigrama);
        }

    }

    public void generarMatriuJoc(ArrayList<Integer> taulerLletres) {
        crucigramaUser = new TilePane();
        crucigramaUser.setMaxWidth(Double.MAX_VALUE);
        crucigramaUser.setMaxHeight(Double.MAX_VALUE);

        for (int i = 0; i < taulerLletres.size(); i++) {
            Label l = new Label();
            l.setPrefHeight(45);
            l.setPrefWidth(45);

            if (taulerLletres.get(i) == -1) {
                l.setStyle("-fx-border-color: black;" + "-fx-padding: 4px; " + "-fx-background-color:black;");
                l.setText("");
            } else {
                l.setStyle("-fx-border-color: black;" + "-fx-padding: 4px; " + "-fx-background-color:white;");
                l.setText(taulerLletres.get(i).toString());
                l.setId(taulerLletres.get(i).toString());
            }

            crucigramaUser.getChildren().add(l);
            crucigramaUser.setStyle("-fx-font-family: Verdana, sans-serif;-fx-background-color:#114B5F;-fx-border-style: solid inside;-fx-border-width:10;-fx-border-color: black");
            crucigramaUser.setAlignment(Pos.CENTER);

            rootPane.setCenter(crucigramaUser);
        }

    }

    public void generarBottom() {

        seleccion.setStyle("-fx-font-family: Verdana, sans-serif;-fx-background-color:#114B5F;-fx-border-style: solid inside;-fx-border-width: 10;-fx-border-color: black");
        seleccion.setAlignment(Pos.CENTER);
        rootPane.setBottom(seleccion);
        seleccion.setPrefHeight(150);

    }

    public void generarMatriuLletres(ArrayList<Integer> lletres) {
        seleccion.getChildren().clear();

        for (int i = 0; i < lletres.size(); i++) {
            lletra = new ComboBox();
            lletra.setPromptText(lletres.get(i).toString());
            lletra.getItems().addAll(abc);

            seleccion.setPrefHeight(150);
            seleccion.getChildren().add(lletra);

        }
        rootPane.setBottom(seleccion);
        lletres.clear();

    }

    public void generarPistes(String[] pistasGenerades) {
        nPistas.setSpacing(10);
        nPistas.setPadding(new Insets(6, 6, 6, 6));
        nPistas.setAlignment(Pos.CENTER);
        for (int i = 0; i < pistasGenerades.length; i++) {
            Label pista = new Label(" ");
            pista.setMinSize(45, 45);
            pista.setPadding(new Insets(4, 8, 1, 15));
            pista.setStyle("-fx-background-color:cyan;-fx-border-color: black;-fx-border-width: 1 2 1 2");
            pista.setText(pistasGenerades[i]);
            nPistas.getChildren().addAll(pista);
        }
    }

    public GridPane generarTopPane() {

        GridPane topGrid = new GridPane();

        Label titolPanel = new Label("Frase Secreta");

        titolPanel.setTextFill(Color.web("#FFFF00"));

        titolPanel.setPrefSize(1920, 100);
        titolPanel.setPadding(new Insets(15.5, 15.5, 15.5, 15.5));
        titolPanel.setAlignment(Pos.CENTER);
        titolPanel.setStyle("-fx-font-size: 60px;-fx-font-family: Verdana, sans-serif;-fx-background-color:#114B5F;-fx-border-style: solid inside;-fx-border-width: 10;-fx-border-color: black");

        topGrid.getChildren().add(titolPanel);

        return topGrid;

    }

    public BorderPane getRootPane() {
        return rootPane;
    }

    public Button getButtonJugar() {
        return jugar;

    }

    public Button getButtonComprobar() {
        return comprobar;

    }

    public Button getButtonRendicio() {
        return rendicion;

    }

    public Button getButtonPistas() {
        return pistas;
    }

    public ComboBox<String> getComboBox() {

        return comboBox;
    }

    public void setFraseEscogida(String fraseEscogida) {
        this.fraseEscogida = fraseEscogida;
    }

    public String getFraseEscogida() {
        return fraseEscogida;
    }

    public int getLongitudFrase() {
        return longitudFrase;
    }

    public void setLongitudFrase(int longitudFrase) {
        this.longitudFrase = longitudFrase;
    }

    public void setArxius(String[] arxius) {

        this.arxius = arxius;
        comboBox.getItems().addAll(arxius);
    }

    public String[] getFrasesArray() {
        return arxius;
    }

    public TilePane getSeleccion() {
        return seleccion;
    }

    public TilePane getCrucigramaUser() {
        return crucigramaUser;
    }

    public ComboBox getLletra() {
        return lletra;
    }

    public TilePane getCrucigrama() {
        return crucigrama;
    }

    public VBox getnPistas() {
        return nPistas;
    }
}
