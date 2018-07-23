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
public class Compte {

    public enum TypeCompte {

        CAD, USD
    }
    private long numeroCompte;
    private TypeCompte typeCompte;
    private double soldeCompte;

    public Compte() {

    }

    public Compte(long numeroCompte, TypeCompte typeCompte, double soldeCompte) {

        this.numeroCompte = numeroCompte;
        this.typeCompte = typeCompte;
        this.soldeCompte = soldeCompte;

    }

}
