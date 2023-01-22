/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Resources.CarregarFrases;
import Resources.GestionarFrase;
import Views.UI;
import java.util.ArrayList;
import java.util.Optional;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class Controlador {

    final int Espais = -1;
    private UI ui;
    private CarregarFrases carregaFrase;
    private GestionarFrase gestionaFrase;
    private Scene scena;

    public void escribirLog(String text) {
        System.out.println(text);
    }

    public Controlador(UI ui, CarregarFrases carregarFrase, GestionarFrase gestionarFrase, Scene scena) {
        this.ui = ui;
        this.carregaFrase = carregarFrase;
        this.gestionaFrase = gestionarFrase;
        this.scena = scena;
        initView();
    }

    public void initView() {
        carregaFrase.carregarFraseFitxer();
        String[] p = carregaFrase.llegirArxiusCarpeta();
        ui.setArxius(p);
        ui.generarBottom();
    }

    public void initController() {

        ui.getButtonJugar().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                ui.getCrucigrama().getChildren().clear();
                ui.getSeleccion().getChildren().clear();
                ArrayList<Integer> lletres = gestionaFrase.getArrayLletres();
                ArrayList<Integer> taulerLletres = new ArrayList<>();

                for (int i = 0; i < gestionaFrase.getFraseNeta().size(); i++) {
                    if (gestionaFrase.getFraseNeta().get(i).equals(" ")) {
                        taulerLletres.add(Espais);
                    } else {
                        taulerLletres.add(gestionaFrase.getPosicioByLletre(gestionaFrase.getFraseNeta().get(i)));
                    }

                }
                ui.generarMatriuJoc(taulerLletres);
                ui.generarMatriuLletres(lletres);
                generarLletresM();
                useCaseButtonJugar();
            }
        });

        ui.getButtonRendicio().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String frasefinal = String.join("", gestionaFrase.getFraseNeta());
                int longitudFraseFinal = gestionaFrase.getFraseNeta().size();
                ui.generarMatriuPrincipal(frasefinal, longitudFraseFinal);
                ui.getnPistas().getChildren().clear();
                ui.getSeleccion().getChildren().clear();
                useCaseButtonRendicio();

            }
        });
        ui.getComboBox().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String prueba = ui.getComboBox().getValue();
                carregaFrase.setNomFitxer(prueba);

                String fraseLlegida = carregaFrase.carregarFraseFitxer();
                int longitudFrase = carregaFrase.getSize();

                ui.setFraseEscogida(fraseLlegida);
                ui.setLongitudFrase(longitudFrase);
                ui.getButtonJugar().setDisable(false);

            }
        });

        ui.getButtonPistas().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String[] pistasGenerades = gestionaFrase.getPistes();

                ui.getnPistas().getChildren().clear();
                ui.generarPistes(pistasGenerades);
                ui.getButtonPistas().setDisable(true);

                for (int i = 0; i < pistasGenerades.length; i++) {
                    ComboBox comboLletra = (ComboBox) ui.getSeleccion().getChildren().get(i);
                    comboLletra.setDisable(true);
                    for (int a = 0; a < comboLletra.getItems().size(); a++) {
                        if (comboLletra.getItems().get(a).equals(pistasGenerades[i])) {
                            comboLletra.setValue(pistasGenerades[i]);
                        }
                    }
                }
            }
        });

        ui.getButtonComprobar().setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int cont = 0;
                int i = 0;
                boolean encertat = true;
                ui.getButtonPistas().setDisable(false);
                ui.getButtonComprobar().setDisable(false);

                ArrayList<String> lletresAray = gestionaFrase.getFraseNeta();

                while (i < ui.getCrucigramaUser().getChildren().size() && encertat == true) {
                    Label labelComprobat = (Label) ui.getCrucigramaUser().getChildren().get(i);

                    if ((labelComprobat.getText().equals(lletresAray.get(i))) || (labelComprobat.getText().equals(""))) {
                        cont++;
                    } else {
                        encertat = false;
                    }
                    i++;
                }

                if (cont == ui.getCrucigramaUser().getChildren().size()) {
                    ui.getCrucigramaUser().getChildren().clear();
                    Alert alertV = new Alert(Alert.AlertType.WARNING);
                    alertV.setTitle("Victoria");
                    alertV.setHeaderText("La frase secreta és correcte. Enhorabona!!!");

                    Optional<ButtonType> result = alertV.showAndWait();

                    if (result.get() == ButtonType.OK) {  //oke button is pressed
                        ui.getnPistas().getChildren().clear();
                        ui.getSeleccion().getChildren().clear();

                        useCaseButtonComprobar();
                    }
                }
                if (encertat == false) {
                    Alert alertD = new Alert(Alert.AlertType.WARNING);
                    alertD.setTitle("Derrota");
                    alertD.setHeaderText("La frase secreta no era correcte. Més sort la pròxima.");

                    ui.getCrucigramaUser().getChildren().clear();

                    Optional<ButtonType> result = alertD.showAndWait();

                    if (result.get() == ButtonType.OK) //oke button is pressed
                    {
                        ui.getnPistas().getChildren().clear();
                        ui.getSeleccion().getChildren().clear();

                        useCaseButtonComprobar();
                    }
                }
            }
        });
    }

    public void generarLletresM() {

        for (int i = 0; i < ui.getSeleccion().getChildren().size(); i++) {
            ComboBox comboLletra = (ComboBox) ui.getSeleccion().getChildren().get(i);
            comboLletra.setId(String.valueOf(i));
            comboLletra.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {

                    for (int j = 0; j < ui.getCrucigramaUser().getChildren().size(); j++) {
                        Label crucigramaUser = (Label) ui.getCrucigramaUser().getChildren().get(j);

                        if (comboLletra.getId().equalsIgnoreCase(crucigramaUser.getId())) {
                            crucigramaUser.setText(comboLletra.getValue().toString());
                        }
                    }
                }
            });
        }
    }

    public void useCaseButtonJugar() {
        ui.getComboBox().setDisable(true);
        ui.getButtonComprobar().setDisable(false);
        ui.getButtonPistas().setDisable(false);
        ui.getButtonRendicio().setDisable(false);
    }
   
    public void useCaseButtonRendicio() {
        ui.getComboBox().setDisable(false);
        ui.getButtonPistas().setDisable(true);
        ui.getButtonComprobar().setDisable(true);
        ui.getButtonRendicio().setDisable(true);
    }
    
    public void useCaseButtonComprobar() {
        ui.getComboBox().setDisable(false);
        ui.getButtonPistas().setDisable(true);
        ui.getButtonComprobar().setDisable(true);
        ui.getButtonRendicio().setDisable(true);
    }
}
