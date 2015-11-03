/*
 * La classe CarnetAdresses
 */
package ca.qc.rosemont.mdj;

import ca.qc.rosemont.personne.Participant;
import ca.qc.rosemont.personne.Personne;
import ca.qc.rosemont.personne.Responsable;
import java.time.LocalDate;
import java.util.*;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 * Permet de gérer les objets de la classe Personne  qui appartiennent à 
 * l'Arraylist listePersonnes
 * @author Hicham
 * @since 27-03-2015
 */

public class CarnetAdresses {
    private ArrayList <Personne> listePersonnes = new ArrayList <Personne> () ;
    
    private Comparator methodeTri = new ComparateurNom();
    
    /**
     * Permet d'ajouter des objets de la classe Personne à listePersonnes
     * @param personne 
     */
    public void ajouterPersonne (Personne personne) {
        listePersonnes.add(personne);
    }
    
     /**
     * Permet d'effacer des objets de la classe Personne, plus précisément
     * de ses classes filles Responsable et Participant.
     * @param personne 
     */
    public void effacerPersonne (Personne personne) {
        JTextField nom = new JTextField() ;
        JTextField prenom = new JTextField() ;
        JTextField dateNaissance = new JTextField() ;
        JTextField statut = new JTextField() ;
        
        String message="Personne non existante";
        
        Object[] message1 = {"Entrez le nom de la personne : ", nom,
                "Entrez le prénom de la personne : " , prenom,  
                "Entrez la date de naissance de la personne au format "
                + "aaaa-mm-jj : ", dateNaissance, "Statut (Entrez PART pour "
                + "participant et RESP pour responsable) :", statut};     
        JOptionPane.showMessageDialog(null, message1);
        
        if(statut.getText().equalsIgnoreCase("part")) {
            personne = new Participant(nom.getText(),prenom.getText(),  
                LocalDate.parse(dateNaissance.getText()));
        }
        else  {
            personne = new Responsable(nom.getText(),prenom.getText(),  
                LocalDate.parse(dateNaissance.getText()));
        }
       
        if (listePersonnes.isEmpty()) {
            message = "Liste vide";
        }
        for(Personne element : listePersonnes) {
            if(personne.equals(element)) {
                listePersonnes.remove(element);
                message = "La personne "+personne.getNom() + " a été supprimée"; 
                break;   
            }
        }
        JOptionPane.showMessageDialog(null, message );
    }
    
    /**
     * Permet de chercher des personnes dans listePersonnes
     * @param personne 
     */
    public void chercherPersonne (Personne personne) {
        
        JTextField nom = new JTextField() ;
        JTextField prenom = new JTextField() ;
        JTextField dateNaissance = new JTextField() ;
        JTextField statut = new JTextField() ;
        String message="Personne non existante";
       
        
        Object[] message1 = {"Entrez le nom de la personne : ", nom,
                "Entrez le prénom de la personne : " , prenom, 
                "Entrez la date de naissance de la personne au format "
                + "aaaa-mm-jj : ", dateNaissance, "Statut (Entrez PART pour "
                + "participant et RESP pour responsable) :", statut};     
        JOptionPane.showMessageDialog(null, message1);
        
        if(statut.getText().equalsIgnoreCase("part")) {
            personne = new Participant(nom.getText(),prenom.getText(),  
                LocalDate.parse(dateNaissance.getText()));
        }
        else  {
            personne = new Responsable(nom.getText(),prenom.getText(),  
                LocalDate.parse(dateNaissance.getText()));
        }
       
        if (listePersonnes.isEmpty()) {
            message = "Liste vide";
        }
        for(Personne element : listePersonnes) {
            if(element.equals(personne)) {
                message = personne.getPrenom() + " " + personne.getNom() 
                        + " est une personne active au sein de la MDJ";
                break; 
            }    
        }
        JOptionPane.showMessageDialog(null, message );
    }
    
    /**
     * Permet de trier listePersonnes selon l'objet methodeTri de l'interface
     * Comparator
     */
    public void trier() {
    
        Collections.sort(listePersonnes, methodeTri);
    }

    public void setMethodeTri(Comparator methodeTri) {
        this.methodeTri = methodeTri;
    }
    
    /**
     * Permet de vider listePersonnes et de remettre à zéro le nmbre d'instance
     * et pour les responsables et pour les participants.
     */
    public void viderListePersonnes () {
        listePersonnes.clear();
        Responsable.setNbInstanceResponsable();
        Participant.setNbInstanceParticpant();
        JOptionPane.showMessageDialog (null, "La liste a été vidée");
    }

    public ArrayList<Personne> getCarnet () {
        return listePersonnes;
    }

    public int getNbPersonnes () {
        return listePersonnes.size();
    }   
}
