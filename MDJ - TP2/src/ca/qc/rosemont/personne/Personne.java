/*
 * La classe Personne
 */
package ca.qc.rosemont.personne;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

/**
 * Permet de gérer les objets de la classe Personne. Cette classe est une classe
 * mère des deux classes Participant et responsable
 * @author Hicham
 * @since 27-03-2015
 */

public abstract class Personne {
    protected String nom ;
    protected String prenom ;
    protected String telephone ;
    protected String courriel;
    LocalDate dateNaissance ;
    protected String id;
    
    /**
    * Constructeur sans paramètres
    * @author Hicham
    */
    public Personne() {   
        
    }
    
    /**
     * Constructeur avec 3 paramètres
     * @param nom
     * @param prenom
     * @param dateNaissance 
     */
    public Personne(String nom, String prenom, LocalDate dateNaissance) {
        this.nom = nom;
        this.prenom = prenom;
        this. dateNaissance = dateNaissance;
        
    }
    
    /**
     * Constructeur avec 5 paramètres
     * @param nom
     * @param prenom
     * @param telephone
     * @param courriel
     * @param dateNaissance 
     */
    public Personne(String nom, String prenom, String telephone, String courriel
            , LocalDate dateNaissance) {
        this.nom = nom;
        this.prenom = prenom;
        this.telephone = telephone;
        this.courriel = courriel;
        this. dateNaissance = dateNaissance;
       
    }

    protected void setId(String id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public void setCourriel(String courriel) {
        this.courriel = courriel;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getId() {
        return id;
    }
    
    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getCourriel() {
        return courriel;
    }

     public LocalDate getDateNaissance() {
        return dateNaissance;
    }
    
    /**
      * Permet de calculer l'âge de la personne
      * @param dateNaissance
      * @return un int qui représente l'âge de la personne en nombre d'années
      */
    public int getAge(LocalDate dateNaissance) {
       
        LocalDate dateActuelle = LocalDate.now();
        Period age = Period.between(dateNaissance, dateActuelle);
        return age.getYears();
    }
    
    /**
     * Cette méthode est une redéfinition de la méthode equals et qui permet
     * de vérifier l'égalité d'une personne avec une autre, en vérifiant
     * l'égalite de leurs noms,prénoms et date de naissance.
     * @param obj
     * @return un boolean true si égalité et false sinon
     */
    @Override
    public boolean equals(Object obj) {
        
        if (obj == this) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Personne personne = (Personne)obj;
        if (!Objects.equals(this.nom, personne.nom)){
            return false;
        }
        if (!Objects.equals(this.prenom, personne.prenom)) {
            return false;
        }
        
        if (!Objects.equals(this.dateNaissance, personne.dateNaissance)) {
            return false;
        }
        return true;
    }  
}
