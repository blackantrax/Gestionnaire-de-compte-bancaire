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
public class Adresse {

    private int numeroCivique; //(maximum 4 chiffres et ne peut commencer par 0) 
    private String rue; // (les exigences sont semblables à ceux du prénom). 
    private String ville; //(la même chose que la rue). 
    private String pays; // (les 2 pays acceptés sont Canada et Etats-Unis ou États-Unis) 

    public Adresse() {

    }

    public Adresse(int numeroCivique, String rue, String ville,
            String pays) {
        this.numeroCivique = numeroCivique;
        this.rue = rue;
        this.ville = ville;
        this.pays = pays;
    }

    public int getNumeroCivique() {
        return numeroCivique;
    }

    public String getRue() {
        return rue;
    }

    public String getVille() {
        return ville;
    }

    public String getPays() {
        return pays;
    }

    public void setNumeroCivique(int numeroCivique) {
        this.numeroCivique = numeroCivique;
    }

    public void setRue(String rue) {
        this.rue = rue;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }


    
    
}
