
package ca.qc.rosemont.personne;

import java.time.LocalDate;

/**
 * La classe hérite de la classe Personne
 * @author Hicham
 * @since 27-03-2015
 */
public class Responsable extends Personne{
    
    protected static int nbInstanceResponsable=0;
    
    /**
    * Constructeur sans paramètres
    * @author Hicham
    */
    public Responsable() {
        
    }
    
    /**
     * Constructeur avec 3 paramètres
     * @param nom
     * @param prenom
     * @param dateNaissance 
     */
    public Responsable(String nom, String prenom, LocalDate dateNaissance) {
        super(nom, prenom, dateNaissance);
        
    }
    
    /**
     * Constructeur avec 5 paramètres. Le nombre d'instance est incrémenté à 
     * chaque fois que le constructeur est appellé, permettant ainsi d'attribuer 
     * un ID différent à chaque responsable.
     * @param nom
     * @param prenom
     * @param telephone
     * @param courriel
     * @param dateNaissance 
     */
    public Responsable(String nom, String prenom, String telephone, 
            String courriel, LocalDate dateNaissance) {
        super(nom, prenom, telephone, courriel, dateNaissance);
        nbInstanceResponsable++;
        id = "RESP" + nbInstanceResponsable;
    } 
    
    /**
     * Remettre le nombre d'instance à zéro.Utile dans le cas ou on vide la 
     * le carnet d'adresse
     */
    public static void setNbInstanceResponsable() {
        nbInstanceResponsable = 0;
    }

}
