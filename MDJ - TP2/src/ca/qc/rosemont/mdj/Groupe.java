/*
 * La classe Groupe
 */

package ca.qc.rosemont.mdj;

import ca.qc.rosemont.personne.Personne;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Groupe {
    
    private ArrayList <Personne> listeParticipants = new ArrayList <Personne>();
    private ArrayList <Personne> listeResponsables = new ArrayList <Personne>();
    private Activite activite = new Activite();
    
    private LocalDate dateDebut ;
    private LocalDate dateFin ;
    
    /**
     * Permet de retourner la liste des participants dans le groupe
     * @return listeParticipants. 
     */
    public List<Personne> getListeParticipants() {
        return listeParticipants;
    }
    
    /**
     * Permet de retourner la liste des responsables dans le groupe
     * @return listeResponsables. 
     */
    public List<Personne> getListeResponsables() {
        return listeResponsables;
    }
    
    public void setActivite(Activite activite) {
        this.activite = activite;
        
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public Activite getActivite() {
        return activite;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }
    
    /**
     * /**
     * Permet d'ajouter un participant dans la liste des participants  dans 
     * le groupe
     * @param participant 
     */
    public void ajouterParticipant(Personne participant) {
        listeParticipants.add(participant);  
    }
    
    /**
     * /**
     * Permet d'ajouter un responsable dans la liste des responsables  dans 
     * le groupe
     * @param responsable 
     */
    public void ajouterResponsable(Personne responsable) {
        listeResponsables.add(responsable);
    }
    
    /**
     * /**
     * Permet de supprimer un participant dans la liste des participants  dans 
     * le groupe
     * @param participant 
     */
    public void supprimerParticipant(Personne participant) {
        listeParticipants.remove(participant);  
    }
    
    /**
     * /**
     * Permet de supprimer un responsable dans la liste des responsables  dans 
     * le groupe
     * @param responsable 
     */
    public void supprimerResponsable(Personne responsable) {
        listeResponsables.remove(responsable);
    }
    
}
