/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2_gestionnairedecomptes_kevinnelson;

/**
 *
 * @author BlackAntrax
 */
public class Banque {

    private String nom;
    Client[] tableauClients;

    public Banque() {

    }

    @SuppressWarnings("SillyAssignment")
    public Banque(String nom, Client[] tab) {
        this.nom =nom;
        this.tableauClients = tableauClients;
    }

    public String getNom() {
        return nom;
    }

    public Client[] getTableauClients() {
        return tableauClients;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setTableauClients(Client[] tableauClients) {
        this.tableauClients = tableauClients;
    }

    @Override
    public String toString() {
        return "Le nom de la banque est: "+getNom();
    }
    
    

}
