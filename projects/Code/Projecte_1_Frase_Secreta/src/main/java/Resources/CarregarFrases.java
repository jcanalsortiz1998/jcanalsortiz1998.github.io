/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Resources;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;


public class CarregarFrases {

    static final String fraseProva = "Hola Josep, no m'agrada res el Java FX!!";
    static public String fraseBona;
    static public String nomFitxer = "test.txt";

    public String carregarFraseFitxer() {
        String rutaCreacio = System.getProperty("user.home");
        String carpetaRuta = rutaCreacio + "/CarpetaFrases/";
        File Arxiu = new File(carpetaRuta + nomFitxer);
        File DirectoriAbsolut = new File("Users");
        File carpeta = new File(carpetaRuta);

        try {
            if (carpeta.exists()) {
                System.out.println("SI");
                llegirFrase(Arxiu);
            } else {
                System.out.println("Carpeta Creada");
                carpeta.mkdir();
                if (!Arxiu.exists()) {
                    escriureArxiu(Arxiu, carpetaRuta);
                } else {
                    System.out.println("Existe");
                }
            }
        } catch (IOException ex) {
            System.out.println("No s'ha pogut llegir el arxiu ");
        } catch (Exception ex) {
            System.out.println("No s'ha pogut crear el arxiu");
        }
        return fraseBona;
    }

    private void escriureArxiu(File Arxiu, String carpetaRuta) throws IOException {
        Arxiu.createNewFile();
        FileReader frases = new FileReader(Arxiu);
        BufferedReader lector = new BufferedReader(frases);
        BufferedWriter escriureFrase = new BufferedWriter(new FileWriter(carpetaRuta + "/" + nomFitxer));
        for (int i = 0; i < fraseProva.length(); i++) {
            escriureFrase.write(fraseProva.charAt(i));
        }
        escriureFrase.close();
    }

    private void llegirFrase(File Arxiu) throws FileNotFoundException, IOException {
        FileReader fraseDirectori = new FileReader(Arxiu);
        BufferedReader lector = new BufferedReader(new InputStreamReader(new FileInputStream(Arxiu), StandardCharsets.UTF_8));
        String fraseLlegida;
        fraseBona = "";
        while ((fraseLlegida = lector.readLine()) != null) {
            this.fraseBona += fraseLlegida;
        }
        lector.close();
    }

    public String[] llegirArxiusCarpeta() {
        String rutaCreacio = System.getProperty("user.home");
        String carpetaRuta = rutaCreacio + "/CarpetaFrases";
        File carpeta = new File(carpetaRuta);
        String[] ArxiusCarpeta = carpeta.list();

        return ArxiusCarpeta;
    }

    public String getFrase() {
        return fraseProva;
    }

    public String getFraseBona() {
        return fraseBona;
    }

    public String getNomFitxer() {
        return nomFitxer;
    }

    public void setNomFitxer(String nomFitxer) {
        this.nomFitxer = nomFitxer;
    }

    public int getSize() {
        return fraseBona.length();
    }

}
