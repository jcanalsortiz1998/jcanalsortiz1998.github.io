/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Views;

import Models.DataModel;

import javafx.geometry.Pos;
import javafx.scene.control.Label;

import javafx.scene.*;
import javafx.scene.layout.GridPane;
import javafx.geometry.HPos;
import org.controlsfx.control.textfield.TextFields;

import javafx.geometry.Pos;

import javafx.scene.control.Label;
import com.sun.javafx.event.EventHandlerManager;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import Views.Main;
import com.sun.javafx.scene.control.LabeledText;
import java.util.HashMap;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.VPos;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import org.controlsfx.control.textfield.AutoCompletionBinding;
import org.controlsfx.control.textfield.TextFields;
import org.controlsfx.control.CheckComboBox;

/**
 *
 * @author jcanals
 */
public class Onsite {
    
    private HashMap<String, TextField> map;
    private HashMap<String, TextField> mapFacturacion;
    private HashMap<String,TextField> mapPagament;
    private HashMap<String,ComboBox> mapPaises;
    private GridPane rootPane;
    private Label datosFacturacion;
    private Label datosAsistente;
    private Label nombre;
    private Label apellidos;
    private Label email;
    private Label nif;
    private Label nifFacturacio;
    private Label nombreEmpresa;
    private Label telefono;
    private Label pais;
    private Label provincia;
    private Label ciudad;
    private Label codigoPostal;
    private Label direccion;
    private Label importantetext;
    private Label metodosdepago;
    private Label camposObligatorios;
    private Label tarjetaCredit;
    private Label autorizacion;
    private Label nombreFacturacion;
    private Label apellidoFacturacion;
    private Label emailFacturacion;
    private GridPane contentPane;

    private TextField inputNombreFacturacion;
    private TextField inputApellidoFacturacion;
    private TextField inputEmailFacturacion;
    private TextField inputNifAssistant;

    private TextField[] inputs;

    private ComboBox deseaFactura;
    private ComboBox pagos;
    private final TextField inputNombre;
    private final TextField nTarjeta;
    private final TextField cAutoritzacion;
    private TextField inputApellidos;
    private TextField inputEmail;
    private TextField inputNif;
    private TextField inputInvoicingName;
    private TextField inputInvoicingLastname;
    private TextField inputInvoicingEmail;
    private TextField inputInvoicingNif;
    private TextField inputNifFacturacio;
    private TextField inputNombreEmpresa;
    private TextField inputTelefono;
    private ComboBox inputPais;
    private ComboBox inputProvincia;
    private TextField inputCiudad;
    private TextField inputCodigopostal;
    private TextField inputDireccion;
    private Button enviar;
    private GridPane bannerpane;
    private GridPane panelRootp;
    private GridPane buttonpane;
    private GridPane panelFacturacio;
    private Label campsObligatoris;
    private HBox campsO;

    public Onsite(DataModel model, Main main) {
        
    String[] paises= {" ","Afghanistan", "Albania", "Algeria", "Andorra", "Angola", "Antarctica", "Antigua and Barbuda",
"Argentina", "Armenia", "Australia", "Austria", "Azerbaijan", "Bahamas", "Bahrain", "Bangladesh", "Barbados",
"Belarus", "Belgium", "Belize", "Benin", "Bermuda", "Bhutan", "Bolivia", "Bosnia and Herzegovina", "Botswana",
"Brazil", "Brunei", "Bulgaria", "Burkina Faso", "Burma", "Burundi", "Cambodia", "Cameroon", "Canada", "Cape Verde",
"Central African Republic", "Chad", "Chile", "China", "Colombia", "Comoros", "Congo, Democratic Republic",
"Congo, Republic of the", "Costa Rica", "Cote d'Ivoire", "Croatia", "Cuba", "Cyprus", "Czech Republic", "Denmark",
"Djibouti", "Dominica", "Dominican Republic", "East Timor", "Ecuador", "Egypt", "El Salvador", "Equatorial Guinea",
"Eritrea", "Estonia", "Ethiopia", "Fiji", "Finland", "France", "Gabon", "Gambia", "Georgia", "Germany", "Ghana",
"Greece", "Greenland", "Grenada", "Guatemala", "Guinea", "Guinea-Bissau", "Guyana", "Haiti", "Honduras", "Hong Kong",
"Hungary", "Iceland", "India", "Indonesia", "Iran", "Iraq", "Ireland", "Israel", "Italy", "Jamaica", "Japan",
"Jordan", "Kazakhstan", "Kenya", "Kiribati", "Korea, North", "Korea, South", "Kuwait", "Kyrgyzstan", "Laos", "Latvia",
"Lebanon", "Lesotho", "Liberia", "Libya", "Liechtenstein", "Lithuania", "Luxembourg", "Macedonia", "Madagascar",
"Malawi", "Malaysia", "Maldives", "Mali", "Malta", "Marshall Islands", "Mauritania", "Mauritius", "Mexico", "Micronesia",
"Moldova", "Mongolia", "Morocco", "Monaco", "Mozambique", "Namibia", "Nauru", "Nepal", "Netherlands", "New Zealand",
"Nicaragua", "Niger", "Nigeria", "Norway", "Oman", "Pakistan", "Panama", "Papua New Guinea", "Paraguay", "Peru",
"Philippines", "Poland", "Portugal", "Qatar", "Romania", "Russia", "Rwanda", "Samoa", "San Marino", " Sao Tome",
"Saudi Arabia", "Senegal", "Serbia and Montenegro", "Seychelles", "Sierra Leone", "Singapore", "Slovakia", "Slovenia",
"Solomon Islands", "Somalia", "South Africa", "Spain", "Sri Lanka", "Sudan", "Suriname", "Swaziland", "Sweden",
"Switzerland", "Syria", "Taiwan", "Tajikistan", "Tanzania", "Thailand", "Togo", "Tonga", "Trinidad and Tobago",
"Tunisia", "Turkey", "Turkmenistan", "Uganda", "Ukraine", "United Arab Emirates", "United Kingdom", "United States",
"Uruguay", "Uzbekistan", "Vanuatu", "Venezuela", "Vietnam", "Yemen", "Zambia", "Zimbabwe"};
    
     String [] provincias = {" ","Alava","Albacete","Alicante","Almería","Asturias","Avila","Badajoz","Barcelona","Burgos","Cáceres",
"Cádiz","Cantabria","Castellón","Ciudad Real","Córdoba","La Coruña","Cuenca","Gerona","Granada","Guadalajara",
"Guipúzcoa","Huelva","Huesca","Islas Baleares","Jaén","León","Lérida","Lugo","Madrid","Málaga","Murcia","Navarra",
"Orense","Palencia","Las Palma","Pontevedra","La Rioja","Salamanca","Segovia","Sevilla","Soria","Tarragona",
"Santa Cruz de Tenerife","Teruel","Toledo","Valencia","Valladolid","Vizcaya","Zamora","Zaragoza"};
     
     
        
        panelRootp = new GridPane();

        rootPane = new GridPane();
        bannerpane = new GridPane();
        panelFacturacio = new GridPane();
        panelFacturacio.setPadding(new javafx.geometry.Insets(0, 0, 0, 0));
        buttonpane = new GridPane();
        rootPane.setPadding(new javafx.geometry.Insets(0, 0, 0, 0));
        campsObligatoris = new Label("Por favor, complete los campos obligatorios*:");
        campsO = new HBox();

        rootPane.setAlignment(Pos.CENTER);

        rootPane.setVgap(12);
        rootPane.setHgap(14);

        inputs = new TextField[17];

        TextFlow nombreAsterisco = new TextFlow();
        TextFlow apellidoAsterisco = new TextFlow();
        TextFlow emailAsterisco = new TextFlow();
        TextFlow nifAsterisco = new TextFlow();
        TextFlow nombreFacturacioAsterisco = new TextFlow();
        TextFlow apellidoFacturacioAsterisco = new TextFlow();
        TextFlow emailFacturacionAsterisco = new TextFlow();
        TextFlow nifFacturacionAsterisco = new TextFlow();
        TextFlow telefonoAsterisco = new TextFlow();
        TextFlow paisAsterisco = new TextFlow();
        TextFlow provinciaAsterisco = new TextFlow();
        TextFlow ciudadAsterisco = new TextFlow();
        TextFlow codigoPostalAsterisco = new TextFlow();
        TextFlow direccionAsterisco = new TextFlow();
        TextFlow numeroTarjetaAsterisco = new TextFlow();
        TextFlow cAutorizacionAsterisco = new TextFlow();

        Text nombreA = new Text("Nombre ");
        Text apellidoA = new Text("Apellidos ");
        Text emailA = new Text("Dirección de correo electrónico");
        Text nifA = new Text("CIF/NIF ");
        Text nombreFacturacionA = new Text("Nombre de facturación ");
        Text apellidoFacturacionA = new Text("Apellido de facturación ");
        Text emailFacturacionA = new Text("Email de facturación ");
        Text nifFacturacionA = new Text("CIF/NIF de facturación ");
        Text telefonoFacturacionA = new Text("Teléfono ");
        Text paisFacturacionA = new Text("País ");
        Text provinciaFacturacionA = new Text("Provincia ");
        Text ciudadFacturacionA = new Text("Ciudad ");
        Text codigoPostalFacturacionA = new Text("Código Postal/ZIP ");
        Text direccionFacturacionA = new Text("Direccíon ");
        Text numerotarjetaA = new Text("Número de tarjeta");
        Text cAutorizacionA = new Text("Código de autorización");

        Text asteriscoNombre = new Text("*");
        asteriscoNombre.setFill(Color.RED);

        Text asteriscoApellido = new Text("*");
        asteriscoApellido.setFill(Color.RED);

        Text asteriscoEmail = new Text("*");
        asteriscoEmail.setFill(Color.RED);

        Text asteriscoNif = new Text("*");
        asteriscoNif.setFill(Color.RED);

        Text asteriscoNombreFacturacion = new Text("*");
        asteriscoNombreFacturacion.setFill(Color.RED);

        Text asteriscoApellidoFacturacion = new Text("*");
        asteriscoApellidoFacturacion.setFill(Color.RED);

        Text asteriscoEmailFacturacion = new Text("*");
        asteriscoEmailFacturacion.setFill(Color.RED);

        Text asteriscoNifFacturacion = new Text("*");
        asteriscoNifFacturacion.setFill(Color.RED);

        Text asteriscoTelefono = new Text("*");
        asteriscoTelefono.setFill(Color.RED);

        Text asteriscoPais = new Text("*");
        asteriscoPais.setFill(Color.RED);

        Text asteriscoProvincia = new Text("*");
        asteriscoProvincia.setFill(Color.RED);

        Text asteriscoCiudad = new Text("*");
        asteriscoCiudad.setFill(Color.RED);

        Text asteriscoCodigoPostal = new Text("*");
        asteriscoCodigoPostal.setFill(Color.RED);

        Text asteriscoCodigoDireccio = new Text("*");
        asteriscoCodigoDireccio.setFill(Color.RED);

        Text asterisconTarjeta = new Text("*");
        asterisconTarjeta.setFill(Color.RED);

        Text asteriscocAutorizacion = new Text("*");
        asteriscocAutorizacion.setFill(Color.RED);

        

        nombreAsterisco.getChildren().add(nombreA);
        nombreAsterisco.getChildren().add(asteriscoNombre);

        apellidoAsterisco.getChildren().add(apellidoA);
        apellidoAsterisco.getChildren().add(asteriscoApellido);

        emailAsterisco.getChildren().add(emailA);
        emailAsterisco.getChildren().add(asteriscoEmail);

        nifAsterisco.getChildren().add(nifA);
        nifAsterisco.getChildren().add(asteriscoNif);

        nombreFacturacioAsterisco.getChildren().add(nombreFacturacionA);
        nombreFacturacioAsterisco.getChildren().add(asteriscoNombreFacturacion);

        apellidoFacturacioAsterisco.getChildren().add(apellidoFacturacionA);
        apellidoFacturacioAsterisco.getChildren().add(asteriscoApellidoFacturacion);

        emailFacturacionAsterisco.getChildren().add(emailFacturacionA);
        emailFacturacionAsterisco.getChildren().add(asteriscoEmailFacturacion);

        nifFacturacionAsterisco.getChildren().add(nifFacturacionA);
        nifFacturacionAsterisco.getChildren().add(asteriscoNifFacturacion);

        telefonoAsterisco.getChildren().add(telefonoFacturacionA);
        telefonoAsterisco.getChildren().add(asteriscoTelefono);

        paisAsterisco.getChildren().add(paisFacturacionA);
        paisAsterisco.getChildren().add(asteriscoPais);

        provinciaAsterisco.getChildren().add(provinciaFacturacionA);
        provinciaAsterisco.getChildren().add(asteriscoProvincia);

        ciudadAsterisco.getChildren().add(ciudadFacturacionA);
        ciudadAsterisco.getChildren().add(asteriscoCiudad);

        codigoPostalAsterisco.getChildren().add(codigoPostalFacturacionA);
        codigoPostalAsterisco.getChildren().add(asteriscoCodigoPostal);

        direccionAsterisco.getChildren().add(direccionFacturacionA);
        direccionAsterisco.getChildren().add(asteriscoCodigoDireccio);

        numeroTarjetaAsterisco.getChildren().add(numerotarjetaA);
        numeroTarjetaAsterisco.getChildren().add(asterisconTarjeta);

        cAutorizacionAsterisco.getChildren().add(cAutorizacionA);
        cAutorizacionAsterisco.getChildren().add(asteriscocAutorizacion);

        String ApellidosHTML = "<html><font  color=BLACK> Apellidos </font> <font color=RED> *</font></html>";
//        apellidos.setText(ApellidosHTML);
//
        String CorreoHTML = "<html><font  color=BLACK> Dirección de correo electrónico </font> <font color=RED> *</font></html>";
//        email.setText(CorreoHTML);
//        
        String NIFHTML = "<html><font  color=BLACK> CIF/NIF </font> <font color=RED> *</font></html>";
//        nif.setText(NIFHTML);
//        
//        
        autorizacion = new Label("Código de autorización");
        autorizacion.setStyle("-fx-font-size:18px;");
        autorizacion.setVisible(false);
        tarjetaCredit = new Label("Número de tarjeta de crédito");
        tarjetaCredit.setVisible(false);
        tarjetaCredit.setStyle("-fx-font-size:18px;");
        nTarjeta = new TextField();
        nTarjeta.setVisible(false);
        cAutoritzacion = new TextField();
        cAutoritzacion.setVisible(false);

        //rootPane.setPadding(new Insets(11, 12, 13, 14));
        deseaFactura = new ComboBox();
        datosAsistente = new Label("Datos del Asistente");
        datosAsistente.setStyle("-fx-font-size:24px;");
        //nombre = new Label(asteriscoNombre.getText());
        // nombre= new Label(nombreAsistente);
//         nombre.setStyle("-fx-font-size:18px;");
        inputNombre = new TextField();
        inputNombre.setMaxWidth(600);
        //inputNombre.setStyle("-fx-margin: px;");
        apellidos = new Label(ApellidosHTML);
        apellidos.setStyle("-fx-font-size:18px;");
        inputApellidos = new TextField();
        inputApellidos.setMaxWidth(600);
        email = new Label(CorreoHTML);
        email.setStyle("-fx-font-size:18px;");
        inputEmail = new TextField();
        metodosdepago = new Label("Método de pago");
        metodosdepago.setStyle("-fx-font-size:18px;");
        inputEmail.setMaxWidth(600);
        deseaFactura.setMaxWidth(600);
        deseaFactura.setValue("No");
        //pagos.setMaxWidth(600);
        deseaFactura.setPromptText("No");
       // deseaFactura.setValue("No");
        pagos = new ComboBox();
        pagos.setValue("En Sede - Efectivo");
        //pagos.setValue("En Sede - Efectivo");
        deseaFactura.getItems().addAll("Sí", "No");
        pagos.getItems().addAll("En Sede - Efectivo", "En Sede - Tarjeta de crédito", "A posteriori - Tarjeta de crédito", "A posteriori - Transferéncia bancaria");
        importantetext = new Label("¿Desea factura?");
        importantetext.setStyle("-fx-font-size:18px;");
        nif = new Label(NIFHTML);
        nif.setStyle("-fx-font-size:18px;");
        inputNif = new TextField();

        datosFacturacion = new Label("Datos de facturación");
        datosFacturacion.setStyle("-fx-font-size:24px;");

        nombreFacturacion = new Label("Nombre de facturación");
        nombreFacturacion.setStyle("-fx-font-size:18px;");
        inputInvoicingName = new TextField();
        inputInvoicingName.setMaxWidth(600);
        apellidoFacturacion = new Label("Apellidos de facturación");
        apellidoFacturacion.setStyle("-fx-font-size:18px;");
        inputInvoicingLastname = new TextField();
        inputInvoicingLastname.setMaxWidth(600);
        emailFacturacion = new Label("Correo electrónico de facturación");
        emailFacturacion.setStyle("-fx-font-size:18px;");
        inputInvoicingEmail = new TextField();
        inputInvoicingEmail.setMaxWidth(600);

        nifFacturacio = new Label("CIF/NIF Facturación");
        nifFacturacio.setStyle("-fx-font-size:18px;");
        inputInvoicingNif = new TextField();
        inputInvoicingNif.setMaxWidth(600);

        nombreEmpresa = new Label("Nombre de la empresa (opcional)");
        nombreEmpresa.setStyle("-fx-font-size:18px;");
        inputNombreEmpresa = new TextField();
        telefono = new Label("Teléfono");
        telefono.setStyle("-fx-font-size:18px;");
        inputTelefono = new TextField();
        pais = new Label("País");
        pais.setStyle("-fx-font-size:18px;");
//        inputPais = new TextField();
//        TextFields.bindAutoCompletion(inputPais,paises);
        
        inputPais = new ComboBox();
        Object[] objectsPaises = paises;
        Object[] objectsProvincias = provincias;
        
        inputPais.getItems().addAll(paises);  
        inputPais.setEditable(true);
        TextFields.bindAutoCompletion(inputPais.getEditor(), inputPais.getItems());
        
        
                
       

        
        provincia = new Label("Provincia");
        provincia.setStyle("-fx-padding: 4px;-fx-font-size:18px;");
        inputProvincia = new ComboBox();
        inputProvincia.getItems().addAll( provincias );
        TextFields.bindAutoCompletion(inputProvincia.getEditor(), inputProvincia.getItems());
        inputProvincia.setDisable(true);
        inputProvincia.setEditable(true);
        ciudad = new Label("Ciudad");
        ciudad.setStyle("-fx-font-size:18px;");
        inputCiudad = new TextField();
        codigoPostal = new Label("Código postal/ZIP");
        codigoPostal.setStyle("-fx-font-size:18px;");
        inputCodigopostal = new TextField();
        direccion = new Label("Dirección");
        direccion.setStyle("-fx-font-size:18px;");
        inputDireccion = new TextField();
        camposObligatorios = new Label("Los campos que contengan * són obligatorios");
        camposObligatorios.setStyle("-fx-font-size:24px;");
        enviar = new Button("Enviar");

        enviar.setPrefWidth(120);
        enviar.setPrefHeight(60);

        ColumnConstraints col1 = new ColumnConstraints();
        col1.setPercentWidth(15);
        ColumnConstraints col2 = new ColumnConstraints();
        col2.setPercentWidth(15);
        ColumnConstraints col3 = new ColumnConstraints();
        col3.setPercentWidth(15);
        ColumnConstraints col4 = new ColumnConstraints();
        col4.setPercentWidth(15);
        rootPane.getColumnConstraints().addAll(col1, col2, col3, col4);

        Image background = new Image("file:\\Users\\joanc\\OneDrive\\Documents\\NetBeansProjects\\nubcredential\\src\\main\\java\\Imagenes\\backNub.jpg");

        contentPane = new GridPane();
        campsObligatoris.setStyle("-fx-font-size:30px;-fx-margin-left:480px");
        campsObligatoris.setVisible(false);

        campsO.getChildren().add(campsObligatoris);

        campsO.setAlignment(Pos.CENTER);
        BackgroundImage bImg = new BackgroundImage(background,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(1920, 830, true, true, true, true)
        );
        Background bGround = new Background(bImg);
        contentPane.setBackground(bGround);

        this.map = new HashMap<String, TextField>();
        this.mapFacturacion = new HashMap<String, TextField>();
        this.mapPagament= new HashMap<String,TextField>();
        this.mapPaises= new HashMap<String,ComboBox>();
     
        this.map.put("Nombre", inputNombre);
        this.map.put("Apellidos", inputApellidos);
        this.map.put("Email", inputEmail);
        this.map.put("NIF", inputNif);
        
      
        this.mapFacturacion.put("NombreFacturacion", inputInvoicingName);
        this.mapFacturacion.put("ApellidoFacturacion", inputInvoicingLastname);
        this.mapFacturacion.put("EmailFacturacion", inputInvoicingEmail);
        this.mapFacturacion.put("NIFFacturacion", inputInvoicingNif);
        this.mapFacturacion.put("Telefono", inputTelefono);
        this.mapFacturacion.put("Ciudad",inputCiudad);
        
      
        this.mapFacturacion.put("CPostal", inputCodigopostal);
        this.mapFacturacion.put("Direccion", inputDireccion);
        
        
        this.mapPagament.put("NTarjeta", nTarjeta);
        this.mapPagament.put("CAutorizacion", cAutoritzacion);
        

       
      

        rootPane.add(datosAsistente, 0, 0);
        rootPane.add(nombreAsterisco, 0, 1);
        rootPane.add(inputNombre, 0, 2);
        rootPane.add(apellidoAsterisco, 1, 1);
        rootPane.add(inputApellidos, 1, 2);
    
        rootPane.add(emailAsterisco, 2, 1);
        rootPane.add(inputEmail, 2, 2);
        rootPane.add(importantetext, 0, 3);
        rootPane.add(nifAsterisco, 3, 1);
        rootPane.add(inputNif, 3, 2);
        rootPane.add(deseaFactura, 0, 4);
        rootPane.add(metodosdepago, 1, 3);
        rootPane.add(pagos, 1, 4);
        rootPane.add(numeroTarjetaAsterisco, 2, 3);
        rootPane.add(nTarjeta, 2, 4);
        rootPane.add(cAutorizacionAsterisco, 3, 3);
        rootPane.add(cAutoritzacion, 3, 4);

        rootPane.setPadding(new javafx.geometry.Insets(-150, 0, 0, 0));
        rootPane.setPrefWidth(1920);

        panelFacturacio.setAlignment(Pos.CENTER);
        panelFacturacio.setVgap(12);
        panelFacturacio.setHgap(14);

        panelFacturacio.setPadding(new javafx.geometry.Insets(20, 40, 10, 10));
        panelFacturacio.setVisible(false);

        panelFacturacio.add(datosFacturacion, 0, 0);
        panelFacturacio.add(nombreFacturacioAsterisco, 0, 1);
        panelFacturacio.add(inputInvoicingName, 0, 2);
        panelFacturacio.add(apellidoFacturacioAsterisco, 1, 1);
        panelFacturacio.add(inputInvoicingLastname, 1, 2);
        panelFacturacio.add(emailFacturacionAsterisco, 2, 1);
        panelFacturacio.add(inputInvoicingEmail, 2, 2);
        panelFacturacio.add(nifFacturacionAsterisco, 3, 1);
        panelFacturacio.add(inputInvoicingNif, 3, 2);
        panelFacturacio.add(nombreEmpresa, 0, 3);
        panelFacturacio.add(inputNombreEmpresa, 0, 4);
        panelFacturacio.add(telefonoAsterisco, 1, 3);
        panelFacturacio.add(inputTelefono, 1, 4);
        panelFacturacio.add(paisAsterisco, 2, 3);
        panelFacturacio.add(inputPais, 2, 4);
        panelFacturacio.add(provinciaAsterisco, 3, 3);
        panelFacturacio.add(inputProvincia, 3, 4);
        panelFacturacio.add(ciudadAsterisco, 0, 5);
        panelFacturacio.add(inputCiudad, 0, 6);
        panelFacturacio.add(codigoPostalAsterisco, 1, 5);
        panelFacturacio.add(inputCodigopostal, 1, 6);
        panelFacturacio.add(direccionAsterisco, 2, 5);
        panelFacturacio.add(inputDireccion, 2, 6);

        buttonpane.getChildren().add(enviar);
        buttonpane.setAlignment(Pos.CENTER);

        contentPane.add(rootPane, 0, 0);
        contentPane.add(panelFacturacio, 0, 1);
        contentPane.add(campsO, 0, 2);
        contentPane.add(buttonpane, 0, 3);

        contentPane.setPrefSize(1920, 830);
        contentPane.setAlignment(Pos.CENTER);

        ColumnConstraints col11 = new ColumnConstraints();
        col1.setPercentWidth(15);
        ColumnConstraints col22 = new ColumnConstraints();
        col2.setPercentWidth(15);
        ColumnConstraints col33 = new ColumnConstraints();
        col3.setPercentWidth(15);

        ColumnConstraints col44 = new ColumnConstraints();
        col3.setPercentWidth(15);

        buttonpane.setPadding(new javafx.geometry.Insets(15, 0, 10, 10));

        panelFacturacio.getColumnConstraints().addAll(col11, col22, col33, col44);

        bannerpane = main.getBannerPanel();

        panelRootp.add(bannerpane, 0, 0);
        panelRootp.add(contentPane, 0, 1);

    }

//    public HashMap<String, ComboBox> getMapPaises() {
//        return this.mapPaises;
//    }
    
    public ComboBox getPaises(){
        return inputPais;
    }
    
    public ComboBox getProvincias(){
        return inputProvincia;
    }
    
   public String valuePais(){
      return  inputPais.getSelectionModel().getSelectedItem().toString();
   }
   
   public String valueProvincia(){
        return inputProvincia.getSelectionModel().getSelectedItem().toString();
   }
    
   
    
    public HashMap<String,TextField>  getInputs(){
            return this.map;
        }
    
    public HashMap<String,TextField> getInputsFaturacio(){
        return this.mapFacturacion;
    }
    
    public HashMap<String,TextField> getInputsPagament(){
        return this.mapPagament;
    }
        
    public String getDeseaFacturaString(){
        return this.deseaFactura.getValue().toString();
        
    }
    
    public String getMetodoPagoString(){
        return this.pagos.getValue().toString();
    }

    public Label getCampsObligatoris() {
        return campsObligatoris;
    }
    
    public TextField getEmpresaName(){
        return inputNombreEmpresa;
    }



    public Label getTarjetaCredit() {
        return tarjetaCredit;
    }

    public Label getAutorizacion() {
        return autorizacion;
    }

    public TextField getnTarjeta() {
        return nTarjeta;
    }

    public TextField getcAutoritzacion() {
        return cAutoritzacion;
    }

    public GridPane getRootPane() {
        return panelRootp;
    }

    public void setRootPane(GridPane rootPane) {
        this.rootPane = rootPane;
    }

    public GridPane getcontentpane() {
        return rootPane;
    }

    public ComboBox getPagos() {
        return pagos;
    }
    
     public String getPagosString() {
        return pagos.getValue().toString();
    }

    public ComboBox getDeseaFactura() {
        return deseaFactura;
    }

    public GridPane getPanelFacturacio() {
        return panelFacturacio;
    }

    public Button getEnviar() {
        return enviar;
    }

    public Object getScene() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void camposObligatorios(TextField t) {
        t.setStyle("-fx-border-color:red;-fx-border-width:2px;");
    }

}
