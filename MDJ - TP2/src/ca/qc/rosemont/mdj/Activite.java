/*
 *La classe Activite
 */

package ca.qc.rosemont.mdj;

/**
 * Permet de définir les objets Activité.
 * @author Hicham
 * @since 27-03-2015
 */

public class Activite {
    private String nom ;
    private String description ;
    private String id;
    private static int nbInstanceActivite = 0;
    
    /**
    * Constructeur Activite sans paramètres
    * @author Hicham
    */
    public Activite() {
      
    }
    
    /**
     * Constructeur Activite
     * @param nom 
     */
    public Activite(String nom) {
        this.nom = nom;
    }
    
    /**
     * Constructeur Activite
     * @param nom
     * @param description 
     */
    public Activite(String nom, String description) {
        this.nom = nom;
        this.description = description;
        nbInstanceActivite++;
        id = "ACT" + nbInstanceActivite;
    }

    private void setId(String id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    /**
     * Remettre le nombre d'activités ajoutées à zéro
     */
    public static void setNbInstanceActivite() {
        nbInstanceActivite = 0;
    }

    public String getNom() {
        return nom;
    }

    public String getDescription() {
        return description;
    }
    
    public String getId() {
        return id;
    }

}
