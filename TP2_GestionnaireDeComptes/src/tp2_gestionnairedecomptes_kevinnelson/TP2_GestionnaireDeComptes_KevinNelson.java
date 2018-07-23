/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2_gestionnairedecomptes_kevinnelson;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import java.util.regex.*;
import javax.swing.ImageIcon;

/**
 *
 * @author BlackAntrax DA: <b>1769692</b>
 * Date de Remise: 10 mai 2018 Prof: <u><i>Mme Amal El Kharraz</i></u>
 */
public class TP2_GestionnaireDeComptes_KevinNelson {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {

        start(); // point d'entrée du programme

    }

    /**
     * Méthode principale permettant de gérer le programme.</br>
     * Elle joue ici le rôle du main
     *
     * @throws java.io.IOException
     */
    public static void start() throws IOException {

        String fichierClients = null;

        int nombreClients;

        fichierClients = ouverturefichier();
        
        nombreClients = compterNombreEspions(fichierClients);

        Client[] tabClients = new Client[nombreClients];

        Banque r = null;

        int choixClient = affichageMenu();
        /**
         * récupère la variable du bouton sélectionné par le Client
         */

        Banque nomEntreprise = extractionNomEntreprise(
                fichierClients, r); // on extrait du fichier le nom de la Banque

        System.out.println(nomEntreprise);
        
        Client kevin = new Client();
       int nip = 1266952;
        kevin.setNip(nip);
        System.out.println(kevin);

    }

    /**
     * Cette méthode permet à l'utilisateur d'ouvrir le fichier qui
     * contient</br>
     * la liste des clients.</br>
     * Le nom de fichier par défaut est <b>clients.txt<b>
     *
     * @return file
     */
    private static String ouverturefichier() {
        String file = "";
        file = (String) JOptionPane.showInputDialog(null,
                "Entrez le nom", "Saisie du nom de fichier",
                JOptionPane.QUESTION_MESSAGE, null, null,
                "clients.txt");
        if (file.isEmpty()) {
            JOptionPane.showMessageDialog(null, "alert", "alert",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
        return file;

    }

//        private static String ouverturefichier() {
//        String file = "";
//        file = (String) JOptionPane.showInputDialog(null,
//                "Entrez le nom", "Saisie du nom de fichier",
//                JOptionPane.QUESTION_MESSAGE, null, null,
//                "clients.txt");
//        if (file.isEmpty()) {
//            JOptionPane.showMessageDialog(null, "Désolé ", "Vous n'avez entré"
//                    + " aucun nom de fichier. ", JOptionPane.PLAIN_MESSAGE);
//        } else if (!"clients.txt".equals(file)) {
//            JOptionPane.showMessageDialog(null, "Désolé ", "Ce nom de fichier"
//                    + " n'existe pas \nveuillez recommencer. "
//                    , JOptionPane.PLAIN_MESSAGE);
//        }
//
//        return file;
//
//    }
    /**
     * Cette méthode permet de compter le nombre de clients initialement
     * enregistrés à la banque.</br>
     * Elle prends en paramètre <i>le nom de fichier</i> et retourne un compteur
     * qui représente le nombre lignes entrées dans le fichier.</br>
     * Ces ignes sont représentatives du nombre de clients
     *
     * @param txt
     * @return compt
     * @throws FileNotFoundException
     * @throws IOException
     */
    private static int compterNombreEspions(String txt)
            throws FileNotFoundException, IOException {
        String line = "";
        int compt = 0;
        try {
            BufferedReader lecteurFichier;
            lecteurFichier = new BufferedReader(new FileReader(txt));
            while ((line = lecteurFichier.readLine()) != null) {
                compt++;
            }
            lecteurFichier.close();

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "Le fichier " + txt
                    + " n'existe pas", " Désolé", JOptionPane.PLAIN_MESSAGE);

        }

        return compt;

    }

    /**
     * Cette méthode permet de générer le menu initial.</br>
     * Après avoir entré pris en compte le nom du fichier, l'utilisateur arrive
     * à ce menu afin d'exécuter une tâche, dépendament de ses besoins.
     *
     * @return retour
     */
    private static int affichageMenu() {
        // les textes figurant sur les boutons
        String textesDesBoutons[] = {
            "Quitter", // indice 0
            "Modifier données Client", // indice 1
            "Afficher classement", // indice 2
            "Ajouter Client", // indice 3
            "Lister Clients", // indice 4
        };
        ImageIcon img = new ImageIcon("download.jpg");//insertion image
        int retour
                = // indice du bouton qui a été cliqué 
                JOptionPane.showOptionDialog(null,
                        null,
                        "Gestionnaire d'espions",
                        0, JOptionPane.PLAIN_MESSAGE, img, // image voulue
                        textesDesBoutons, // les textes des boutons
                        textesDesBoutons[4]); // le bouton par défaut
        return retour;

    }

    /**
     * Cette méthode me permet d'extraire du fichier le <i>nom de la Banque</i>
     * Elle prends en paramètre le <i>nom du fichier</i> et la <i> la variable
     * qui va contenir le nom de la Banque à la sortie de la méthode.
     *
     * @param tabClient
     * @param nomFichier
     * @param nomBanque
     * @return nomBanque
     * @throws FileNotFoundException
     * @throws IOException
     */
    private static Banque extractionNomEntreprise(
            String nomFichier, Banque nomBanque)
            throws FileNotFoundException, IOException {

        nomBanque = new Banque(); // instanciation de l'objet 
        String ligne;
        BufferedReader lecteurFichier; // déclaration du buffer
        try {
            lecteurFichier = new BufferedReader(new FileReader(nomFichier));
            while ((ligne = lecteurFichier.readLine()) != null) {
                Pattern extractionNomBanque; //Patron d'extraction
                extractionNomBanque = Pattern.compile("TrustFinancialCanada");
                Matcher regexMatcher;
                regexMatcher = extractionNomBanque.matcher(ligne);

                if (regexMatcher.find()) {
                    nomBanque.setNom(regexMatcher.group().trim());
                    /**
                     * Nom de la Banque
                     */
                }

            }
            lecteurFichier.close(); // Fermeture du fichier

        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Le fichier " + nomFichier
                    + " n'existe pas", " Désolé, nous n'avons "
                    + "pas trouvé votre "
                    + "fichier", JOptionPane.PLAIN_MESSAGE);
        }

        return nomBanque;
    }

}
