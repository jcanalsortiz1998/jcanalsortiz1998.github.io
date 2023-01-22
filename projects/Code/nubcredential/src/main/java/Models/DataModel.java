/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Models;

import java.io.File;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author jcanals
 */
public class DataModel {

    private String first_name;
    private String last_name;
    public String epc;

    private long delivery_time;

    String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());

    private int onsite;
    private String pend_doc_plat;

    private String email;
    private String DeseaFactura;
    private String company_name;
    private String telephone;
    private String country;
    private String province;
    private String city;
    private String postal_code;
    private String address;
    private String nif_Assistant;
    private String metodoPago;
    private String invoicing_name;
    private String invoicing_lastname;
    private String invoicing_email;
    private String nTarjeta;
    private String cAutorizacion;
    private String invoicing_nif;
   

    public String getDeseaFactura() {
        return DeseaFactura;
    }

    public void setDeseaFactura(String DeseaFactura) {
        this.DeseaFactura = DeseaFactura;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getInvoicing_name() {
        return invoicing_name;
    }

    public void setInvoicing_name(String invoicing_name) {
        this.invoicing_name = invoicing_name;
    }

    public String getInvoicing_lastname() {
        return invoicing_lastname;
    }

    public void setInvoicing_lastname(String invoicing_lastname) {
        this.invoicing_lastname = invoicing_lastname;
    }

    public String getInvoicing_email() {
        return invoicing_email;
    }

    public void setInvoicing_email(String invoicing_email) {
        this.invoicing_email = invoicing_email;
    }

    public String getnTarjeta() {
        return nTarjeta;
    }

    public void setnTarjeta(String nTarjeta) {
        this.nTarjeta = nTarjeta;
    }

    public String getcAutorizacion() {
        return cAutorizacion;
    }

    public void setcAutorizacion(String cAutorizacion) {
        this.cAutorizacion = cAutorizacion;
    }

    public String getInvoicing_nif() {
        return invoicing_nif;
    }

    public void setInvoicing_nif(String invoicing_nif) {
        this.invoicing_nif = invoicing_nif;
    }

    //private  List<Object> arr ;
    public void setDelivery_time(long delivery_time) {
        this.delivery_time = delivery_time;
    }

    public void setNif_Assistant(String nif_Assistant) {
        this.nif_Assistant = nif_Assistant;
    }

    private String settings_name;
    private String settings_values;

    public String getSettings_name() {
        return settings_name;
    }

    public void setSettings_name(String settings_name) {
        this.settings_name = settings_name;
    }

    public String getSettings_values() {
        return settings_values;
    }

    public void setSettings_values(String settingd_values) {
        this.settings_values = settingd_values;
    }

    public void setDelivery_time(Long delivery_time) {
        this.delivery_time = delivery_time;
    }

    public Long getDelivery_time() {

        // delivery_time=System.currentTimeMillis() / 1000L;
        return delivery_time;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getNif_Assistant() {
        return nif_Assistant;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompany_name() {
        return company_name;
    }

    public void setCompany_name(String company_name) {
        this.company_name = company_name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostal_code() {
        return postal_code;
    }

    public void setPostal_code(String postal_code) {
        this.postal_code = postal_code;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEpc() {
        return epc;
    }

    public void setEpc(String epc) {
        this.epc = epc;
    }

    public int getOnsite() {
        return onsite;
    }

    public void setOnsite(int onsite) {
        this.onsite = onsite;
    }

    public String isPend_doc_plat() {
        return pend_doc_plat;
    }

    public void setPend_doc_plat(String pend_doc_plat) {
        this.pend_doc_plat = pend_doc_plat;
    }

}
