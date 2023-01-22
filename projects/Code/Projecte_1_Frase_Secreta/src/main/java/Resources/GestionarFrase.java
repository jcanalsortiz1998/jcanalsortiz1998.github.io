/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;


public class GestionarFrase {

    private ArrayList<String> Lletres = new ArrayList<String>();
    private ArrayList<Integer> positions = new ArrayList<Integer>();
    private ArrayList<String> fraseNeta = new ArrayList<>();
    private CarregarFrases fraseInicial = new CarregarFrases();


    private ArrayList<String> añadirLletresYnetejarCaracterEspecials() {
        String[] frase = fraseInicial.getFraseBona().toLowerCase().split("");
        this.fraseNeta.clear();
        this.Lletres.clear();
        for (int i = 0; i < frase.length; i++) {
            if ("qwertyuiopasdfghjklñzxcvbnmáàéèíìóòúùç ".contains(frase[i])) {
                switch (frase[i]) {
                    case "á":
                    case "à":
                        Lletres.add("a");
                        break;
                    case "è":
                    case "é":
                        Lletres.add("e");
                        break;
                    case "í":
                    case "ì":
                        Lletres.add("i");
                        break;
                    case "ò":
                    case "ó":
                        Lletres.add("o");
                        break;
                    case "ú":
                    case "ü":
                        Lletres.add("u");
                        break;
                    default:
                        Lletres.add(frase[i]);
                        break;
                }
            }
        }
        this.fraseNeta.addAll(Lletres);
        Set<String> hasSet = new HashSet<String>(Lletres);
        Lletres.clear();
        Lletres.addAll(hasSet);
      
        if (Lletres.contains(" ")) {
            Lletres.remove(0);
        }
        return Lletres;
    }

    public ArrayList<String> assignarNumerosLletes() {
        Lletres = añadirLletresYnetejarCaracterEspecials();
        Collections.shuffle(Lletres);
        return Lletres;
    }

    public void mostrarLletres() {
        Lletres = assignarNumerosLletes();
        for (int i = 0; i < Lletres.size(); i++) {
            System.out.print(Lletres.get(i));
        }
    }

    public int getPosicioByLletre(String lletre) {
        int posicio = 0;
        for (int i = 0; i < Lletres.size(); i++) {
            if (Lletres.get(i).equals(lletre)) {
                posicio = i;
            }
        }
        return posicio;
    }

    public String getLletraByNumero(int numero) {
        String Lletra = "";
        for (int i = 0; i < Lletres.size(); i++) {
            if (i == numero) {
                Lletra = Lletres.get(i);
            }
        }
        return Lletra;
    }

    public ArrayList<Integer> getArrayLletres() {
        ArrayList<String> LletresAux = new ArrayList<String>();
        LletresAux = assignarNumerosLletes();

        for (int i = 0; i < LletresAux.size(); i++) {
            positions.add(i);
        }
        return positions;
    }

    public ArrayList<String> getLletres() {
        return Lletres;
    }

    public String[] getPistes() {
        String[] lletresPista = new String[3];
        Arrays.fill(lletresPista, null);
        

        for (int i = 0; i < lletresPista.length; i++) {
            lletresPista[i] = Lletres.get(i);
        }
        return lletresPista;
    }
     public ArrayList<String> getFraseNeta() {
        return fraseNeta;
    }

}
