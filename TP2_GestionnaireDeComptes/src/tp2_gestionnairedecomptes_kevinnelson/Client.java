/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2_gestionnairedecomptes_kevinnelson;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author BlackAntrax
 */
public class Client {

    private long numeroIdentification;
    private String prenom;
    private String nom;
    private int nip;

    Compte[] tabComptes = new Compte[2];

    public Client() {

    }

    public Client(long numeroIdentification, String prenom, String nom, int nip) {

        this.numeroIdentification = numeroIdentification;
        this.prenom = prenom;
        this.nom = nom;
        this.nip = nip;

    }

    public long getNumeroIdentification() {
        return numeroIdentification;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNom() {
        return nom;
    }

    public int getNip() {
        return nip;
    }

    public void setNumeroIdentification(long numeroIdentification) {
        this.numeroIdentification = numeroIdentification;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setNip(int nip) {
        String str = Integer.toString(nip);
        Pattern validationNip = Pattern.compile("^[0-9]{4,6}$");
        Matcher nipMatcher;
        nipMatcher = validationNip.matcher(str);
        if (nipMatcher.find()) {
            nip = Integer.parseInt(str);
            this.nip = nip;
        }
       

    }

    @Override
    public String toString() {
        return "Le nip du client: "+getNip();
    }

}
