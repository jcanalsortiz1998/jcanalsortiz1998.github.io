package Views;

import java.awt.event.MouseListener;
import java.net.URISyntaxException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import java.awt.event.MouseListener;
import javafx.scene.Scene;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author jcanals
 */
public class Main {

    private GridPane rootP;
    private Label banner;
    private GridPane bannerP;
    private Label mensaje;
    public TextField epc;
    private Label imgRfid;
    private GridPane root;
    private Button settings;
    private GridPane buttonpane;

    public Main() throws URISyntaxException {

        root = new GridPane();
        rootP = new GridPane();
        bannerP = new GridPane();
        buttonpane = new GridPane();

        System.out.println("Ha entrado en Main");

        // rootP.setStyle(" -fx-background-image: url('backNub.jpg')");
//
        banner = new Label();
// /*
        Image background = new Image("file:\\Users\\joanc\\OneDrive\\Documents\\NetBeansProjects\\nubcredential\\src\\main\\java\\Imagenes\\backNub.jpg");
        Image settingsImage = new Image("file:\\Users\\joanc\\OneDrive\\Documents\\NetBeansProjects\\nubcredential\\src\\main\\java\\Imagenes\\settings.png");

        settings = new Button();
        settings.setPrefSize(50, 50);

        buttonpane.getChildren().add(settings);
       
        buttonpane.setOnMouseEntered(e -> settings.setDisable(false));
        buttonpane.setOnMouseExited(e -> settings.setDisable(true));

        EventHandler<ActionEvent> eh;
        eh = new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {

                Settings setting = new Settings();

                Stage window = (Stage) settings.getScene().getWindow();
                window.setScene(new Scene(setting.getRootSetting(), 1920, 1080));

                getContentPanel().getChildren().clear();

            }
        };

        settings.setOnAction(eh);

        BackgroundImage bSettings = new BackgroundImage(settingsImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(50, 50, true, true, true, true)
        );
        Background backSettings = new Background(bSettings);
        settings.setBackground(backSettings);

        BackgroundImage bImg = new BackgroundImage(background,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(1920, 830, true, true, true, true)
        );
        Background bGround = new Background(bImg);
        rootP.setBackground(bGround);

        Image image = new Image("file:\\Users\\joanc\\OneDrive\\Documents\\NetBeansProjects\\nubcredential\\src\\main\\java\\Imagenes\\provaban.png");
        ImageView imgV = new ImageView(image);
        imgV.setFitWidth(1920);
        imgV.setFitHeight(250);

        banner.setGraphic(imgV);

        bannerP.add(banner, 0, 0);
        // buttonpane.setAlignment(Pos.TOP_RIGHT);
        buttonpane.setPadding(new Insets(20, 20, 20, 1800));

        rootP.add(buttonpane, 0, 1);
//        
        mensaje = new Label("Acerque la acreditación al lector para marcar la documentación entregada");
        mensaje.setStyle("-fx-font-size: 40;-fx-text-fill: red");
        mensaje.setPadding(new Insets(30, 14, 14, 90));

        GridPane.setHalignment(mensaje, HPos.CENTER);

        rootP.add(mensaje, 0, 2);

        imgRfid = new Label();

        Image rfidImg = new Image("file:\\Users\\joanc\\OneDrive\\Documents\\NetBeansProjects\\nubcredential\\src\\main\\java\\Imagenes\\rfid image.png");
        ImageView imgVRif = new ImageView(rfidImg);

        imgVRif.setFitHeight(300);
        imgVRif.setFitWidth(300);

        GridPane.setHalignment(imgRfid, HPos.CENTER);

        imgRfid.setGraphic(imgVRif);
        imgRfid.setPadding(new Insets(30, 14, 9, 60));

        rootP.add(imgRfid, 0, 3);

        epc = new TextField();
        epc.setStyle("-fx-background-color: transparent;-fx-text-fill: transparent;");

        epc.setMaxWidth(400);

        GridPane.setHalignment(epc, HPos.CENTER);

        rootP.add(epc, 0, 4);
        rootP.setPrefSize(1920, 830);

        root.add(bannerP, 0, 0);
        root.add(rootP, 0, 1);

    }

    public GridPane getRootPanel() {
        return root;
    }

    public GridPane getBannerPanel() {
        return bannerP;
    }

    public GridPane getContentPanel() {
        return rootP;
    }

    public void setRootP(GridPane rootP) {
        this.rootP = rootP;
    }

}
