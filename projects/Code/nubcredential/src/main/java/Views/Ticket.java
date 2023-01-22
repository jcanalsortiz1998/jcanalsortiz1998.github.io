/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Views;

import Models.DataModel;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author joanc
 */
public class Ticket {

    private GridPane ticketPane;
    private Label assistant;

    public Ticket() {
    }

    public Ticket(DataModel model) {

        ticketPane = new GridPane();
        assistant = new Label(model.getFirst_name() + "," + model.getLast_name());
      /* assistant.setRotate(270);

        //VBox.setMargin(ticketPane, new Insets(10,10,0,0));
       
        ticketPane.setPrefSize(200, 400);
        ticketPane.setPadding(new Insets(10,15,0,0));
       // ticketPane.setAlignment(Pos.TOP_LEFT);
       // ticketPane.setPadding(new Insets(10,10,0,0));
        //ticketPane.setPadding();

       
     //  assistant.setAlignment(Pos.CENTER);
*/
       //assistant.setAlignment(Pos.CENTER);
       //ticketPane.setPadding(new Insets(20,20,0,0));
        ticketPane.add(assistant, 0, 0);
       

        System.out.println(assistant.getText());
        

    }

    public Label getAssistant() {
        return assistant;
    }

    public GridPane root() {
        return ticketPane;
    }

}
