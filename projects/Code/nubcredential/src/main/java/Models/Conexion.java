//package Models;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
//public class Conexion {
//     private final String url = "jdbc:mysql://localhost:3306/nub_credential";
//    private final String user = "NubCredentialUser";
//    private final String password = "Jc/LAm22#";
//
//    private Connection conn = null;
//
//    public Connection getConexion(){
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            conn = DriverManager.getConnection(this.url,this.user, this.password);
//        } catch (SQLException e) {
//            System.err.println(e);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//        return conn;
//    }
//}
