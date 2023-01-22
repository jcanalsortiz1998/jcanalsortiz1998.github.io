/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controllers;

import MainPackage.App;
import Models.DataModel;
import Models.ModelQuerys;
import Views.DocumentacionEntregada;
import Views.InscripcioPrevia;
import Views.Onsite;
import Views.Main;
import java.awt.HeadlessException;
import java.awt.print.*;

//import com.sun.jdi.connect.spi.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.*;

import java.sql.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import Views.Main;
import Views.NoReconocido;
import Views.Ticket;
import Views.VistaPreImpresion;
import static com.google.protobuf.TextFormat.printer;
import java.io.IOException;
import java.net.URISyntaxException;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.print.PageLayout;
import javafx.print.PageOrientation;
import javafx.print.Paper;
import javafx.print.Printer;
import javafx.print.PrinterJob;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

/**
 *
 * @author jcanals
 */
public class Controller {

    public boolean pintarCorrecte;
    public String valorFactura;
    public String valorPagaments;
    private DataModel model;
    private Connection conn;
    private ModelQuerys modelQ;
    private Main main;
    private DocumentacionEntregada docEntregada;
    private InscripcioPrevia insPrevia;
    private Onsite onsite;
    private VistaPreImpresion vistaPreImp;
    private NoReconocido noRecon;
    private Ticket ticket;
    private Scene scene;
    private String epc;
    private boolean assistantBBDD = false;
    private boolean onsiteBBDD = false;
    private boolean methodsPaymentBBDD = false;
    private final Stage stage;
    private final App app;
    private int cont = 1;

    public Controller(DataModel model, ModelQuerys modelQ, Main main, VistaPreImpresion vistaPreImp, NoReconocido noRecon, Scene scene, Stage stage, App app) {
        this.model = model;
        this.modelQ = modelQ;
        this.main = main;
        this.stage = stage;
        this.app = app;
        // this.docEntregada = docEntregada;
        // this.insPrevia = insPrevia;
        this.onsite = onsite;
        this.vistaPreImp = vistaPreImp;
        this.noRecon = noRecon;
        // this.ticket = ticket;
        this.scene = scene;
    }

    public void initController() {
        System.out.println("ha entrado en initController");
        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                onButtonPress();
            }
        });

    }

    public void onButtonPress() {

        this.epc = main.epc.getText();
        System.out.println(this.epc);
        checkEpc(this.epc);

    }

    public void checkEpc(String p) {
        Onsite on = new Onsite(model, main);
        p = p.substring(4, 24);
        // System.out.println(p);
        String codi_congres = p.substring(0, 4);
        System.out.println(codi_congres);
        String query = " SELECT * from Assistants where epc LIKE '" + p + "' ";
        boolean epcTrobat = false;

        //System.out.println(query);
        boolean cCongres_trobat = false;
        try {

            epcTrobat = modelQ.selectEpc(model, p);
            if (epcTrobat) {
                //System.out.println(model.isPend_doc_plat());
                if (!model.getDelivery_time().equals(0L)) {
                    //Panel DocEntregada

                    System.out.println("Panel Docentregada");

                    DocumentacionEntregada docEntregada = new DocumentacionEntregada(model, main);

                    Stage window = (Stage) main.epc.getScene().getWindow();
                    window.setScene(new Scene(docEntregada.getRootp(), 1920, 1080));

                    main.getContentPanel().getChildren().clear();

                    System.out.println("La documentación fue entregada");
                    
                    alertBoxDocEntregada(docEntregada);
                } else {
                    if (model.getOnsite() == 0) {

                        System.out.println("panel inscripcion previa");
                        InscripcioPrevia insc = new InscripcioPrevia(model, main);

                        Stage window = (Stage) main.epc.getScene().getWindow();
                        window.setScene(new Scene(insc.getRootPaneIns(), 1920, 1080));

                        main.getContentPanel().getChildren().clear();
                        updateInsPrevia();
                        alertBoxInsPrevia(insc);

                    } else {
                        System.out.println("onsite dins");
                        //scene.getStylesheets().add(getClass().getResource("Views/style.css").toExternalForm());

                        Stage window = (Stage) main.epc.getScene().getWindow();
                        window.setScene(new Scene(on.getRootPane(), 1920, 1080));
                      

                            main.getContentPanel().getChildren().clear();

                        on.getDeseaFactura().setOnAction(new EventHandler() {
                            @Override
                            public void handle(Event t) {
                                try {
                                    String factura = on.getDeseaFactura().getValue().toString();
                                    System.out.println(factura);

                                    if (factura.equals("Sí")) {
                                        on.getPanelFacturacio().setVisible(true);
                                    } else {
                                        on.getPanelFacturacio().setVisible(false);
                                    }
                                } catch (NullPointerException e) {
                                    System.out.println("NullPointerException thrown!");
                                }

                                Object obj1 = on.getDeseaFactura().getSelectionModel().getSelectedItem();
                                valorFactura = obj1.toString();

                            }
                        });

                        on.getPagos().setOnAction(new EventHandler() {
                            @Override
                            public void handle(Event t) {
                                try {
                                    String pagos = on.getPagos().getValue().toString();
                                    System.out.println(pagos);

                                    if (pagos.equals("En Sede - Tarjeta de crédito") || (pagos.equals("A posteriori - Tarjeta de crédito"))) {
//                                        
                                        on.getcAutoritzacion().setVisible(true);

                                        on.getAutorizacion().setVisible(true);

                                        on.getTarjetaCredit().setVisible(true);

                                        on.getnTarjeta().setVisible(true);

                                        on.getcAutoritzacion().setVisible(true);
                                    } else {
                                        on.getAutorizacion().setVisible(false);

                                        on.getTarjetaCredit().setVisible(false);

                                        on.getnTarjeta().setVisible(false);

                                        on.getcAutoritzacion().setVisible(false);
                                    }
                                } catch (NullPointerException e) {
                                    System.out.println("NullPointerException thrown!");
                                }
                                Object obj2 = on.getPagos().getSelectionModel().getSelectedItem();
                                valorPagaments = obj2.toString();

                            }
                        });
                        HashMap<String, TextField> valuesFields = on.getInputs();
                        HashMap<String, TextField> fieldsFacturacio = on.getInputsFaturacio();
                        HashMap<String, TextField> fieldsPagament = on.getInputsPagament();
                        ComboBox paisesCombo = on.getPaises();

                        EventHandler<ActionEvent> eventPaises;
                        eventPaises = new EventHandler<ActionEvent>() {
                            public void handle(ActionEvent e) {
                                ComboBox paisesCombobox = on.getPaises();
                                ComboBox provinciasComboBox = on.getProvincias();
                                if (paisesCombobox.getSelectionModel().getSelectedItem().toString().equals("Spain")) {
                                    provinciasComboBox.setDisable(false);
                                } else {
                                    provinciasComboBox.setDisable(true);
                                }
                            }
                        };

                        paisesCombo.setOnAction(eventPaises);

                        on.getEnviar().setVisible(true);

                        alertBoxOnsite(on, valuesFields, fieldsFacturacio, fieldsPagament);

                    }
                }

            } else {

            }

        } catch (HeadlessException | SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);

        }

    }

    private void imprimir(Node node) {
        
        Printer printer= Printer.getDefaultPrinter();

        System.out.println("Creating a printer job...");

        
        PageLayout pageLayout = printer.createPageLayout(Paper.A4, 
                                PageOrientation.LANDSCAPE, Printer.MarginType.DEFAULT);
        
        // PageLayout pageLayout = printer.createPageLayout(Paper.A4, PageOrientation.LANDSCAPE, 300, 30, 5, 5);
       
        PrinterJob job = PrinterJob.createPrinterJob();
        job.printPage(pageLayout, node);
        if (job != null) {
            System.out.println(job.jobStatusProperty().asString());
            

            boolean printed = job.printPage(pageLayout, node);//job.printPage(node);
            if (printed) {
                job.endJob();
                System.out.println("impres");
            } else {
                System.out.println("Printing failed.");
            }
        } else {
            System.out.println("Could not create a printer job.");
        }

    }
    
    private boolean updateInsPrevia() throws SQLException {
        boolean updateInsPrevia= false;
        updateInsPrevia= modelQ.updateInscripcioprevia(model,epc);
        
        if(updateInsPrevia) return true;
        else return false;
    }
    

    private boolean updateTableAssistant() throws SQLException {
        boolean updateAssistant = false;

        updateAssistant = modelQ.updateOnsiteAssistant(model, epc);

        if (updateAssistant) {
            return true;
        } else {
            return false;
        }
    }

    private boolean updateTableOnsite() throws SQLException {
        boolean updateOnsite = false;

        updateOnsite = modelQ.updateOnsiteExtraData(model, epc);

        if (updateOnsite) {
            return true;
        } else {
            return false;
        }
    }

    private boolean updateTableMethodsPayment() throws SQLException {
        boolean UpdateMethodsPayment = false;

        UpdateMethodsPayment = modelQ.updateOnsiteMethodsPayment(model, epc);

        if (UpdateMethodsPayment) {
            return true;
        } else {
            return false;
        }

    }

    private boolean validarCorreo(HashMap<String, TextField> valuesFields, int aux) {

        boolean mailCoorecte = false;
        boolean pintarCorrecte = false;

        Pattern pattern = Pattern
                .compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                        + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");

        if (aux == 1) {
            String email = valuesFields.get("Email").getText();
            Matcher mather = pattern.matcher(email);
            if (mather.find() == true) {
                camposObligatoriosC(valuesFields.get("Email"));

                mailCoorecte = true;

            } else {
                camposObligatorios(valuesFields.get("Email"), pintarCorrecte);

                mailCoorecte = false;

            }
        }

        if (aux == 2) {
            String emailFacturacio = valuesFields.get("EmailFacturacion").getText();

            Matcher matherFacturacio = pattern.matcher(emailFacturacio);

            if (matherFacturacio.find() == true) {
                camposObligatoriosC(valuesFields.get("EmailFacturacion"));

                mailCoorecte = true;

            } else {
                camposObligatorios(valuesFields.get("EmailFacturacion"), pintarCorrecte);

                mailCoorecte = false;

            }

        }

        return mailCoorecte;
    }

    private boolean validarCampos(HashMap<String, TextField> valuesFields, String deseaFactura, String tipoPago, HashMap<String, TextField> fieldsFacturacio, HashMap<String, TextField> fieldsPagament, Onsite on) {

        pintarCorrecte = false;
        boolean enviatValidat = false;
        boolean RangoValidat = false;
        int aux = 1;

        RangoValidat = colorInputs(valuesFields, pintarCorrecte, aux);

        if (RangoValidat == true) {
            enviatValidat = true;
            model.setFirst_name(on.getInputs().get("Nombre").getText());
            model.setLast_name(on.getInputs().get("Apellidos").getText());
            model.setEmail(on.getInputs().get("Email").getText());
            model.setNif_Assistant(on.getInputs().get("NIF").getText());
            model.setDeseaFactura(on.getDeseaFacturaString());
            model.setMetodoPago(on.getMetodoPagoString());
        } else {
            enviatValidat = false;
        }

        if (deseaFactura.equals("Sí")) {
            aux = 2;
            RangoValidat = colorInputs(fieldsFacturacio, pintarCorrecte, aux);

            if (RangoValidat == true) {
                enviatValidat = true;
                model.setInvoicing_name(on.getInputsFaturacio().get("NombreFacturacion").getText());
                model.setInvoicing_lastname(on.getInputsFaturacio().get("ApellidoFacturacion").getText());
                model.setInvoicing_email(on.getInputsFaturacio().get("EmailFacturacion").getText());
                model.setInvoicing_nif(on.getInputsFaturacio().get("NIFFacturacion").getText());
                model.setCompany_name(on.getEmpresaName().getText());
                model.setTelephone(on.getInputsFaturacio().get("Telefono").getText());
                model.setCountry(on.valuePais());
                model.setProvince(on.valueProvincia());
                model.setCity(on.getInputsFaturacio().get("Ciudad").getText());
                model.setPostal_code(on.getInputsFaturacio().get("CPostal").getText());
                model.setAddress(on.getInputsFaturacio().get("Direccion").getText());
            } else {
                enviatValidat = false;
            }
        }
        if (tipoPago.equals("En Sede - Tarjeta de crédito") || tipoPago.equals("A posteriori - Tarjeta de crédito")) {
            aux = 3;
            RangoValidat = colorInputs(fieldsPagament, pintarCorrecte, aux);
            if (RangoValidat == true) {
                enviatValidat = true;
                model.setnTarjeta(on.getInputsPagament().get("NTarjeta").getText());
                model.setcAutorizacion(on.getInputsPagament().get("CAutorizacion").getText());
                model.setEpc(epc);

            } else {
                enviatValidat = false;
            }
        }
        return enviatValidat;

    }

    public boolean colorInputs(HashMap<String, TextField> camps, boolean pintarCorrecte, int aux) {
        boolean correcte = false;
        pintarCorrecte = false;
        boolean mailCorrecte = true;
        boolean campCorrecte = true;
        int cont = 0;

        for (Map.Entry<String, TextField> entry : camps.entrySet()) {
            String key = entry.getKey();
            TextField value = entry.getValue();

            if (!value.getText().isEmpty()) {

                if (key.equals("Email") || key.equals("EmailFacturacion")) {
                    mailCorrecte = validarCorreo(camps, aux);
                    if (!mailCorrecte) {
                        campCorrecte = false;
                        pintarCorrecte = false;
                    } else {
                        campCorrecte = true;
                        pintarCorrecte = true;
                    }
                } else {
                    pintarCorrecte = true;
                }

                if (campCorrecte) {
                    cont++;
                }

            } else {
                pintarCorrecte = false;
            }
            camposObligatorios(value, pintarCorrecte);

            if (camps.size() == cont) {
                correcte = true;
            }

        }
        return correcte;
    }

    public boolean campsPrincipals(HashMap<String, TextField> camps) {
        boolean valid = true;
        int cont = 0;

        for (Map.Entry<String, TextField> entry : camps.entrySet()) {
            String key = entry.getKey();
            TextField value = entry.getValue();

            if (!value.getText().isEmpty()) {

                cont++;

            } else {
                valid = false;
            }

            if (camps.size() == cont) {
                valid = true;
            }

        }
        return valid;
    }

    public void alertBoxDocEntregada(DocumentacionEntregada doc) {

        ButtonType Cancelar = new ButtonType("Cancelar", ButtonBar.ButtonData.BACK_PREVIOUS);

        ButtonType Confirmar = new ButtonType("Confirmar", ButtonBar.ButtonData.OK_DONE);

        Alert a = new Alert(AlertType.CONFIRMATION, "", Cancelar, Confirmar);

        EventHandler<ActionEvent> eventDocEntregada;
        eventDocEntregada = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                try {
                    Thread.sleep(8000);
                    app.start(stage);

                } catch (URISyntaxException ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        };

        doc.back().setOnAction(eventDocEntregada);
    }

    public void alertBoxInsPrevia(InscripcioPrevia insc) { 
        ButtonType Cancelar = new ButtonType("Cancelar", ButtonBar.ButtonData.BACK_PREVIOUS);

        ButtonType Confirmar = new ButtonType("Confirmar", ButtonBar.ButtonData.OK_DONE);

        Alert a = new Alert(AlertType.CONFIRMATION, "", Cancelar, Confirmar);

        EventHandler<ActionEvent> eventInscprevia;
        eventInscprevia = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                try {
                    Thread.sleep(8000);
                    app.start(stage);

                } catch (URISyntaxException ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        };

        insc.back().setOnAction(eventInscprevia);
    }
    

    public void camposObligatorios(TextField t, boolean pintarCorrecte) {
        if (!pintarCorrecte) {
            t.setStyle("-fx-border-color:red;-fx-border-width:2px;");
        } else {
            t.setStyle("-fx-border-color:green;-fx-border-width:2px;");
        }

    }

    public void camposObligatoriosC(TextField t) {
        t.setStyle("-fx-border-color:green;-fx-border-width:2px;");
    }

    public void camposObligatoiosPaises(ComboBox c, boolean pintarCorrecte) {
        if (!pintarCorrecte) {
            c.setStyle("-fx-border-color:red;-fx-border-width:2px;");
        } else {
            c.setStyle("-fx-border-color:green;-fx-border-width:2px;");
        }
    }

    public void alertBoxOnsite(Onsite on, HashMap<String, TextField> valuesFields, HashMap<String, TextField> fieldsFacturacio, HashMap<String, TextField> fieldsPagament) {
        ButtonType Cancelar = new ButtonType("Cancelar", ButtonBar.ButtonData.BACK_PREVIOUS);

        ButtonType Confirmar = new ButtonType("Confirmar", ButtonBar.ButtonData.OK_DONE);

        // create a alert
        Alert a = new Alert(AlertType.CONFIRMATION, "", Cancelar, Confirmar);

//                    
        //validarCorreo(valuesFields);
        EventHandler<ActionEvent> event;
        event = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                // set alert type
                boolean campsValidats = false;
                //boolean emailValidat = validarCorreo(valuesFields);
                valorFactura = on.getDeseaFactura().getValue().toString();
                valorPagaments = on.getPagos().getValue().toString();

                campsValidats = validarCampos(valuesFields, valorFactura, valorPagaments, fieldsFacturacio, fieldsPagament, on);
                if (campsValidats) {
                    a.setTitle("Confirmación de envio de datos");
                    //a.setAlertType(AlertType.CONFIRMATION);

                    a.setHeaderText("Por favor, revise los campos introducidos");

                    // show the dialog
                    Optional<ButtonType> result = a.showAndWait();
                    if (result.orElse(Cancelar) == Confirmar) {
                        System.out.println("Ok entrat button");

                        try {
                            assistantBBDD = updateTableAssistant();

                        } catch (SQLException ex) {
                            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        ButtonType Back = new ButtonType("Back", ButtonBar.ButtonData.BACK_PREVIOUS);

                        ButtonType Print = new ButtonType("Print", ButtonBar.ButtonData.OK_DONE);

                        Alert aPrint = new Alert(AlertType.CONFIRMATION, "", Back, Print);

                        aPrint.setTitle("Confirmación");
                        //a.setAlertType(AlertType.CONFIRMATION);

                        aPrint.setHeaderText("Si desea imprimir los datos pulse el botón Print. Sinó pulse el botón Back para volver al inicio");

                        Optional<ButtonType> resultPrint = aPrint.showAndWait();

                        if (resultPrint.orElse(Back) == Print) {
                            System.out.println("ha entrat al botó imprimir");
                            Ticket tc = new Ticket(model);
                            Stage window = (Stage) on.getEnviar().getScene().getWindow();
                            window.setScene(new Scene(tc.root(), 400, 200));
                            System.out.println("dd");
                            
                             
                          

                            System.out.println(tc.getAssistant().getText());
                            imprimir(tc.root());
                            try {
                                Thread.sleep(8000);
                                app.start(stage);

                            } catch (URISyntaxException ex) {
                                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (IOException ex) {
                                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } else if (resultPrint.orElse(Print) == Back) {

                            try {
                                Thread.sleep(8000);
                                app.start(stage);

                            } catch (URISyntaxException ex) {
                                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (IOException ex) {
                                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                            }

                        }

                    } else if (result.orElse(Confirmar) == Cancelar) {
                        System.out.println("Cancelar boton entrat");
                    }
                }

            }
        };

        on.getEnviar().setOnAction(event);

    }

}
