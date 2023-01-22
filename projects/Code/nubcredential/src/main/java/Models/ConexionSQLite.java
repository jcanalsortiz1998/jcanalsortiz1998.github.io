/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import MainPackage.Principal;
import java.io.File;
import java.net.URISyntaxException;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionSQLite {

    Connection ccn = null;

    String database = "nubcredential";

    String Url = "jdbc:sqlite:C:\\\\Users\\\\joanc\\\\OneDrive\\\\Documents\\\\NetBeansProjects\\\\nubcredential\\\\nubcredential.db";
    String Url1 = "jdbc:sqlite:C:\\\\nubcredentialPrueba\\\\nubcredential.db";

    public Connection getConnection() {
        try {

            try {
                File file = null;
                try {
                    file = new File(ConexionSQLite.class.getProtectionDomain().getCodeSource()
                            .getLocation().toURI().getPath());
                } catch (URISyntaxException ex) {
                    Logger.getLogger(ConexionSQLite.class.getName()).log(Level.SEVERE, null, ex);
                }
                String basePath = file.getParent();
                
                 String Url = "jdbc:sqlite:"+basePath+"\\\\nubcredential.db";
                System.out.println(basePath);
                //Overrides the existing value of "user.dir"
                System.getProperties().put("user.dir", basePath);
            } catch (Exception ex) {
                System.out.println("error ruta bbdd");
            }

            // Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            ccn = DriverManager.getConnection(Url);
            System.out.println("Ha entrado en la BBDD de sqlite");
        } catch (SQLException e) {
            System.err.println(e);
            System.out.println("No ha entrado en la BBDD de sqlite");
        }

        return ccn;
    }

}
