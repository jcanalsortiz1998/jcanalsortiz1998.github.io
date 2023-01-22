/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 *
 * @author jcanals
 */
public class ModelQuerys extends ConexionSQLite {

    private PreparedStatement pst;
    private ResultSet rs;

    public boolean esborrarDadesformulari(DataModel mo) {

        boolean facturacioesborrada = false;

        return facturacioesborrada;
    }

    public boolean updateOnsiteAssistant(DataModel mo, String p) throws SQLException {
        PreparedStatement pstA = null;
        Connection conn = getConnection();
        //PreparedStatement pstSelect;

        boolean update = false;
        p = p.substring(4, 24);
        System.out.println(p);

        try {

            String queryA = "UPDATE  Assistants set  first_name =?, last_name = ?, email = ?, NIF = ? , deseaFactura=?, metodoPago=? WHERE epc = ?";
            pstA = conn.prepareStatement(queryA);

            pstA.setString(1, mo.getFirst_name());
            System.out.println(mo.getFirst_name());
            pstA.setString(2, mo.getLast_name());
            System.out.println(mo.getLast_name());
            pstA.setString(3, mo.getEmail());
            System.out.println(mo.getEmail());
            pstA.setString(4, mo.getNif_Assistant());
            System.out.println(mo.getNif_Assistant());
            pstA.setString(5, mo.getDeseaFactura());
            System.out.println(mo.getDeseaFactura());
            pstA.setString(6, mo.getMetodoPago());
            System.out.println(mo.getMetodoPago());
            pstA.setString(7, p);

            pstA.execute();
            update = true;

            if (mo.getDeseaFactura().equals("Sí")) {

                String queryO = "INSERT INTO Onsite_ExtraData (epc,invoicing_name,invoicing_lastname,invoicing_email ,invoicing_nif ,company_name ,telephone ,country ,province ,city ,postal_code ,address) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
                pstA = conn.prepareStatement(queryO);

                try {

                    pstA.setString(1, p);
                    pstA.setString(2, mo.getInvoicing_name());
                    pstA.setString(3, mo.getInvoicing_lastname());
                    pstA.setString(4, mo.getInvoicing_email());
                    pstA.setString(5, mo.getInvoicing_nif());
                    pstA.setString(6, mo.getCompany_name());
                    pstA.setString(7, mo.getTelephone());
                    pstA.setString(8, mo.getCountry());
                    pstA.setString(9, mo.getProvince());
                    pstA.setString(10, mo.getCity());
                    pstA.setString(11, mo.getPostal_code());
                    pstA.setString(12, mo.getAddress());

                    pstA.execute();

                   
                    update = true;
                } catch (SQLException e) {
                    System.out.println(e);
                    update = false;
                }
                
            }

            if (mo.getMetodoPago().equals("En Sede - Tarjeta de crédito") || mo.getMetodoPago().equals("A posteriori - Tarjeta de crédito")) {
                String queryP = "INSERT INTO Onsite_PaymentMethods  (nTarjeta,cAutorizacion,epc)  VALUES (?,?,?)";
                pstA = conn.prepareStatement(queryP);

                try {

                    pstA.setString(1, mo.getnTarjeta());
                    System.out.println(mo.getnTarjeta());
                    pstA.setString(2, mo.getcAutorizacion());
                    System.out.println(mo.getcAutorizacion());
                    pstA.setString(3, p);
                    System.out.println("p");

                    pstA.execute();

                   
                    update = true;
                } catch (SQLException e) {
                    System.out.println(e);
                    update = false;
                }

                
            }

            pstA.close();

            conn.close();

        } catch (Exception e) {
            update = false;
        }

        return update;

    }

    public boolean updateOnsiteExtraData(DataModel mo, String p) throws SQLException {

        Connection con = getConnection();
        PreparedStatement pstO = null;
        boolean update = false;

        p = p.substring(4, 24);
        System.out.println(p);

        String queryO = "INSERT INTO Onsite_ExtraData (epc,invoicing_name,invoicing_lastname,invoicing_email ,invoicing_nif ,company_name ,telephone ,country ,province ,city ,postal_code ,address) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
        pstO = con.prepareStatement(queryO);

        try {

            pstO.setString(1, p);
            pstO.setString(2, mo.getInvoicing_name());
            pstO.setString(3, mo.getInvoicing_lastname());
            pstO.setString(4, mo.getInvoicing_email());
            pstO.setString(5, mo.getInvoicing_nif());
            pstO.setString(6, mo.getCompany_name());
            pstO.setString(7, mo.getTelephone());
            pstO.setString(8, mo.getCountry());
            pstO.setString(9, mo.getProvince());
            pstO.setString(10, mo.getCity());
            pstO.setString(11, mo.getPostal_code());
            pstO.setString(12, mo.getAddress());

            pstO.execute();

            pstO.close();
            con.close();
            update = true;
        } catch (SQLException e) {
            System.out.println(e);
            update = false;
        }
        return update;
    }

    public boolean updateOnsiteMethodsPayment(DataModel mo, String p) throws SQLException {
        Connection connect = getConnection();
        PreparedStatement pstP = null;
        boolean update = false;

        p = p.substring(4, 24);
        System.out.println(p);

        String queryP = "INSERT INTO Onsite_PaymentMethods  (nTarjeta,cAutorizacion,epc)  VALUES (?,?,?)";
        pstP = connect.prepareStatement(queryP);

        try {

            pstP.setString(1, mo.getnTarjeta());
            System.out.println(mo.getnTarjeta());
            pstP.setString(2, mo.getcAutorizacion());
            System.out.println(mo.getcAutorizacion());
            pstP.setString(3, p);
            System.out.println("p");

            pstP.execute();

            pstP.close();
            connect.close();
            update = true;
        } catch (SQLException e) {
            System.out.println(e);
            update = false;
        }

        return update;
    }

//    public boolean updateOnsiteExtraData(DataModel mo, String p) throws SQLException {
//
//        Connection con = getConnection();
//        PreparedStatement pstO = null;
//        boolean update = false;
//
//        p = p.substring(4, 24);
//        System.out.println(p);
//
//
//        
//
//        String queryO = "UPDATE Onsite_ExtraData SET epc= ?,  invoicing_name = ?, invoicing_lastname = ?,invoicing_email = ?,invoicing_nif = ?,company_name = ?,telephone = ?,country = ?,province = ?,city = ?,postal_code = ?,address = ? WHERE epc = ?";
//        pstO = con.prepareStatement(queryO);
//       
//
//        try {
//            
//                pstO.setString(1, p);
//                pstO.setString(2, mo.getInvoicing_name());
//                pstO.setString(3, mo.getInvoicing_lastname());
//                pstO.setString(4, mo.getInvoicing_email());
//                pstO.setString(5, mo.getInvoicing_nif());
//                pstO.setString(6, mo.getCompany_name());
//                pstO.setString(7, mo.getTelephone());
//                pstO.setString(8, mo.getCountry());
//                pstO.setString(9, mo.getProvince());
//                pstO.setString(10, mo.getCity());
//                pstO.setString(11, mo.getPostal_code());
//                pstO.setString(12, mo.getAddress());
//                pstO.setString(13, p);
//           
//            
//
//            pstO.execute();
//
//            pstO.close();
//            con.close();
//            update=true;
//        } catch (SQLException e) {
//            System.out.println(e);
//            update= false;
//        }
//        return update;
//    }
//
//    public boolean updateOnsiteMethodsPayment(DataModel mo, String p) throws SQLException {
//        Connection connect = getConnection();
//        PreparedStatement pstP = null;
//        boolean update = false;
//        
//        
//
//        p = p.substring(4, 24);
//        System.out.println(p);
//
//        String queryP = "UPDATE Onsite_PaymentMethods SET  nTarjeta=?,cAutorizacion=?, epc=?  WHERE epc = ?";
//        pstP = connect.prepareStatement(queryP);
//
//       
//        try {
//           
//
//                pstP.setString(1, mo.getnTarjeta());
//                System.out.println(mo.getnTarjeta());
//                pstP.setString(2, mo.getcAutorizacion());
//                System.out.println(mo.getcAutorizacion());
//                pstP.setString(3, p);
//                pstP.setString(4, p);
//           
//
//            pstP.execute();
//
//            pstP.close();
//            connect.close();
//            update = true;
//        } catch (SQLException e) {
//            System.out.println(e);
//         update = false;
//        }
//        
//        return update;
//    }
    public boolean delete(DataModel mo) {

        PreparedStatement ps = null;
        Connection con = getConnection();

        String queryD = "DELETE FROM ASSISTANTS WHERE EPC";
        return false;

    }

    public boolean deleteOnsite(DataModel m) {

        return false;
    }

    public boolean selectEpc(DataModel m, String p) throws SQLException {

        Connection conn = getConnection();

        System.out.println(p);

        //String query = ;
        PreparedStatement st;
        ResultSet rs;

        try {

            st = conn.prepareStatement("SELECT * from Assistants where epc = ? ");
            st.setString(1, p);

            rs = st.executeQuery();

            if (rs.next()) {
                m.setFirst_name(rs.getString("first_name"));
                System.out.println(m.getFirst_name());
                m.setLast_name(rs.getString("last_name"));
                System.out.println(m.getLast_name());
                m.setEmail(rs.getString("email"));
                System.out.println(m.getEmail());
                m.setEpc(rs.getString("epc"));
                m.setDelivery_time(rs.getLong("delivery_time"));
                m.setOnsite(Integer.parseInt(rs.getString("onsite")));
                m.setPend_doc_plat(rs.getString("pend_doc_plat"));
                m.setNif_Assistant(rs.getString("NIF"));
                System.out.println(m.isPend_doc_plat());

                rs.close();
                st.close();
                return true;

                //rs.getTimestamp("doc_delivery_time");
            }

            return false;

        } catch (SQLException e) {
            System.out.println(e);
            return false;

        } finally {
            conn.close();

        }

    }

    public boolean select(DataModel m, String p) {
        PreparedStatement pstS = null;
        Connection con = getConnection();

        String query = " SELECT * from Assistants where epc LIKE '" + p + "' ";

        try {

            pstS.setTimestamp(5, new Timestamp(System.currentTimeMillis()));
            pstS.setBoolean(7, true);
            return true;
        } catch (SQLException e) {
            System.out.println(e);
            return false;
        } finally {
            try {
                con.close();
            } catch (SQLException e) {
                System.out.println(e);
            }

        }
    }

    public boolean updateInscripcioprevia(DataModel mo,String p) {
        PreparedStatement pstIns = null;
        Connection conInsc = getConnection();
        //PreparedStatement pstSelect;

        boolean update = false;
        p = p.substring(4, 24);
        System.out.println(p);

        try {

            String queryA = "UPDATE  Assistants set  delivery_time=? WHERE epc = ?";
            pstIns = conInsc.prepareStatement(queryA);

            pstIns.setLong(1, System.currentTimeMillis()/1000);
            System.out.println(System.currentTimeMillis());
            pstIns.setString(2, p);

            pstIns.execute();
            update = true;

           
            pstIns.close();

            conInsc.close();

        } catch (Exception e) {
            update = false;
        }

        return update;

    }

      
}
