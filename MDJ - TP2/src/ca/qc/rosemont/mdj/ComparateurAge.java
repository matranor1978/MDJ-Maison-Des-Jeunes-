
package ca.qc.rosemont.mdj;

import ca.qc.rosemont.personne.Personne;
import java.time.LocalDate;
import java.util.Comparator;

/**
 * Classe implémentant l'interface Comparator afin de comparer par âge 
 * deux objets de type Personne
 * @author Hicham
 * @since 27-03-2015
 */
public class ComparateurAge implements Comparator<Personne> {
    
    /**
     * Cette méthode compare l'âge de deux objets de type Personne 
     * afin de les classer par ordre croissant.
     * @param personne1
     * @param personne2
     * @return int un nombre négatif si l'âge du personne1 est inférieur 
     * à celui de la personne2 
     * 0 s'ils sont égaux
     * sinon un nombre positif.
    */
     @Override
    public int compare(Personne personne1, Personne personne2) {
        
        LocalDate dateNaissance1 = personne1.getDateNaissance();
        LocalDate dateNaissance2 = personne2.getDateNaissance();
        
        int diff = personne1.getAge(dateNaissance1) - 
                      personne2.getAge(dateNaissance2);

        return diff;
        
    }
    
}
