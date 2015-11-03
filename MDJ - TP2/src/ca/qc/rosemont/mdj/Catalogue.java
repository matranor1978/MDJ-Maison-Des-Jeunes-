/*
 * La classe Catalogue
 */

package ca.qc.rosemont.mdj;

import java.util.*;
import javax.swing.JOptionPane;

/**
 * Permet de gérer les objets de la classe Activite  qui appartiennent à 
 * l'Arraylist listeActivites
 * @author Hicham
 * @since 27-03-2015
 */

public class Catalogue {
    
    private ArrayList <Activite> listeActivites = new ArrayList <Activite> () ;
    
    /**
     * Constructeur sans paramètres
     */
    public Catalogue () {
    
    }
    
    /**
     * Permet d'ajouter des objets de la classe Activite à listeActivites à 
     * l'indice indice.
     * @param indice
     * @param activite 
     */
    public void insererActivite (int indice , Activite activite ) {
        listeActivites.add(indice, activite);      
    }
    
    /**
     * Permet d'effacer des objets de la classe Activite. 
     * @param activite
     */
    public void effacerActivite (Activite activite) {
        String message="Activité non existante";
        String nomActivite = JOptionPane.showInputDialog(null,"Entrez le nom "
                + "de l'activité à effacer :");
        if (listeActivites.isEmpty()) {
            message = "Liste vide";
        }
        for(Activite element : listeActivites) {
            if(nomActivite.equals(element.getNom())) {
                listeActivites.remove(element);
                message = "L'activite " + nomActivite + " a été supprimée"; 
                break;   
            }
        }
        JOptionPane.showMessageDialog(null, message );
    }
    
    /**
     * Permet de vérifier si une activité existe ou non dans le catalogue
     */
    public void chercherActivite () {
       
        String nomActivite = JOptionPane.showInputDialog(null,"Entrez le nom "
                + "de l'activité à chercher :");
        Activite activite = new Activite();
        activite.setNom(nomActivite);
        String message="Activité non existante";
        if (listeActivites.isEmpty()) {
            message = "Liste vide";
        }
        for(Activite element : listeActivites) {
            if(activite.getNom().equals(element.getNom())) {
                message = activite.getNom() + " fait partie des activités de "
                        + "la maison";
                break; 
            }    
        }
        JOptionPane.showMessageDialog(null, message );
    }
    
    /**
     * Permet de vider le catalogue et de remettre à zéro le nmbre d'instance
     * à zéro
     */
    public void viderListeActivites () {
        listeActivites.clear();
        Activite.setNbInstanceActivite();
        JOptionPane.showMessageDialog (null, "La liste a été vidée");
    }

    public ArrayList<Activite> getCatalogue () {
        return listeActivites;
    }

    public int getNbActivite () {
        return listeActivites.size();
    }
    
}
