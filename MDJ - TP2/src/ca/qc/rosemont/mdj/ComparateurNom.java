
package ca.qc.rosemont.mdj;

import ca.qc.rosemont.personne.Personne;
import java.util.Comparator;

/**
 * Classe implémentant l'interface Comparator afin de comparer alphabétiquement
 * deux objets de type Personne
 * @author Hicham
 * @since 27-03-2015
 */
public class ComparateurNom implements Comparator<Personne> {
    
    /**
     * Cette méthode compare l'attribut nom de deux objets de type Personne 
     * afin de les classer en ordre alphabétique.
     * @param personne1
     * @param personne2
     * @return int un nombre négatif si le nom du personne1 est après 
     * dans l'ordre alphabétique, 
     * 0 s'ils sont égaux
     * un nombre positif si le nom du personne1 est avant dans 
     * l'ordre alphabétique
    */
    @Override
    public int compare(Personne personne1, Personne personne2) {
        
        String nom1 = personne1.getNom();
        String nom2 = personne2.getNom();
        
        return nom1.compareToIgnoreCase(nom2);
        
    }
    
}
