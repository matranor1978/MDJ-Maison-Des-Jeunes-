/*
 * Fenêtre d'acceuil
 */
package ca.qc.rosemont.mdj;

import ca.qc.rosemont.personne.Participant;
import ca.qc.rosemont.personne.Personne;
import ca.qc.rosemont.personne.Responsable;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.*;
import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.plaf.FontUIResource;

/**
 * Cette classe hérite de la classe JFrame et contient les menus et les boutons
 * nécessaire pour faire marcher le programme
 * @author Hicham
 * @since 27-03-2015
 */

public class Fenetre1 extends JFrame {
    
    static Activite activite = new Activite();
    static Catalogue catalogue = new Catalogue();
    static Personne personne;
    static Responsable responsable = new Responsable();
    static ArrayList <Personne> listeResponsables = new ArrayList <Personne>();
    static Participant participant = new Participant ();
    static ArrayList <Personne> listeParticipants = new ArrayList <Personne>();
    static CarnetAdresses carnet = new CarnetAdresses();
    static Groupe groupe = new Groupe();
    
    private JMenuBar menuBar = new JMenuBar();
    private JMenu menu1 = new JMenu("Catalogue d'activités");
    private JMenu menu1_2 = new JMenu("Ajouter une activité");
    private JMenu menu2 = new JMenu("Carnet d'adresses");
    private JMenu menu2_2 = new JMenu("Ajouter une personne");
    private JMenu menu2_3 = new JMenu("Afficher le nombre et la liste "
            + "des personnes");
    private JMenu menu3 = new JMenu("Groupes");
    private JMenu menu3_2 = new JMenu("Assigner Activité");
    
    private JMenuItem item2 = new JMenuItem("Éliminer une activité");
    private JMenuItem item3 = new JMenuItem("Chercher une activité");
    private JMenuItem item4 = new JMenuItem("Vider la liste des activités");
    private JMenuItem item5 = new JMenuItem("Afficher le nombre et la liste "
                                             + "des activités");
    private JMenuItem item6 = new JMenuItem("Éliminer une personne");
    private JMenuItem item7 = new JMenuItem("Chercher une personne");
    private JMenuItem item8 = new JMenuItem("Vider la liste des personnes");
    private JMenuItem item1_1 = new JMenuItem("À partir d'une source");
    private JMenuItem item1_2 = new JMenuItem("Manuellement");
    private JMenuItem item2_1 = new JMenuItem("À partir d'une source");
    private JMenuItem item2_2 = new JMenuItem("Manuellement");
    private JMenuItem item2_3 = new JMenuItem("Trier par nom");
    private JMenuItem item2_4 = new JMenuItem("Trier par âge");
    private JMenuItem item2_5 = new JMenuItem("Trier par âge décroissant");
    private JMenuItem item3_1 = new JMenuItem("Choisir activité");
    private JMenuItem item3_2 = new JMenuItem("Créer date de début et de fin");
    private JMenuItem item10 = new JMenuItem("Ajouter un responsable");
    private JMenuItem item11 = new JMenuItem("Supprimer un responsable");
    private JMenuItem item12 = new JMenuItem("Ajouter un participant");
    private JMenuItem item13 = new JMenuItem("Supprimer un participant");
    private JMenuItem item14 = new JMenuItem("Afficher groupe");
    
    // Instanciation d'un panneau pano de Jpanel
    JPanel pano = new JPanel(new BorderLayout(50,50));
    
    //Création d'un bouton QUITTER
    private JButton quitter = new JButton("Quitter");
    
    public Fenetre1(){
        this.setSize(1200, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);

        //On ajoute les éléments dans notre sous-menu
        this.menu1_2.add(item1_1);
        this.menu1_2.addSeparator();
        this.menu1_2.add(item1_2);
        this.menu2_2.add(item2_1);
        this.menu2_2.addSeparator();
        this.menu2_2.add(item2_2);
        this.menu2_3.add(item2_3);
        this.menu2_3.addSeparator();
        this.menu2_3.add(item2_4);
        this.menu2_3.addSeparator();
        this.menu2_3.add(item2_5);
        this.menu3_2.add(item3_1);
        this.menu3_2.addSeparator();
        this.menu3_2.add(item3_2);
        
        //Ajout des sous-menu dans les menus
        this.menu1.add(this.menu1_2);
        this.menu2.add(this.menu2_2);
        this.menu2.addSeparator();
        this.menu2.add(this.menu2_3);
        this.menu3.add(this.menu3_2);

        //On initialise nos menus      
        this.menu1.add(menu1_2);
        this.menu1.addSeparator();
        this.menu1.add(item2);
        this.menu1.addSeparator();
        this.menu1.add(item3);
        this.menu1.addSeparator();
        this.menu1.add(item4);
        this.menu1.addSeparator();
        this.menu1.add(item5);
        this.menu2.addSeparator();
        this.menu2.add(item6);
        this.menu2.addSeparator();
        this.menu2.add(item7);
        this.menu2.addSeparator();
        this.menu2.add(item8);
        this.menu3.addSeparator();
        this.menu3.add(item10);
        this.menu3.addSeparator();
        this.menu3.add(item11);
        this.menu3.addSeparator();
        this.menu3.add(item12);
        this.menu3.addSeparator();
        this.menu3.add(item13);
        this.menu3.addSeparator();
        this.menu3.add(item14);

        this.menuBar.add(menu1);
        this.menuBar.add(menu2);
        this.menuBar.add(menu3);
        this.menuBar.add(menu3);
        this.setJMenuBar(menuBar);
        this.setVisible(true);
        
        // ajout de la photo dans l'arrière plan
        JLabel icon = new JLabel(new ImageIcon("PNG.jpg"));
        
        pano.setBackground(Color.white);
        pano.setLayout(new BorderLayout());
        pano.add(icon);
        pano.add(quitter, BorderLayout.PAGE_END);
        add(pano);
        setVisible(true);
        
        quitter.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0) {
            System.exit(0);
            }
        });

        item1_1.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent arg0) {

                try {
                    ajouterCatalogueDepuisFichier();
                }   catch (Exception ex) {
                        Logger.getLogger(
                                Fenetre1.class.getName()).log(Level.SEVERE,
                                null, ex);
                }
            }
        });

        item1_2.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent arg0) { 
                activite = saisirInfoActivite();
                int indice = chercherIndiceActivite(catalogue,activite); 
                if(indice != -1){
                catalogue.insererActivite(indice , activite); } 
            }
        });

        item2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0) {
                catalogue.effacerActivite(activite);
            }
        });

        item3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0) {
                catalogue.chercherActivite();   
            }
        });

        item4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0) {
                catalogue.viderListeActivites();
            }
        });

        item5.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0) {
                afficherCatalogue(catalogue);
            }
        });

        item2_1.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent arg0) {
                try {
                    ajouterCarnetDepuisFichier();
                }   catch (Exception ex) {
                        Logger.getLogger(
                          Fenetre1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        item2_2.addActionListener(new ActionListener(){
            
            public void actionPerformed(ActionEvent arg0) {
                personne = saisirInfoPersonne();
                boolean drapeau = chercherPersonne(carnet , personne);
                if(drapeau){
                    carnet.ajouterPersonne(personne); 
                } 
            }
        });

        item6.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0) {
                carnet.effacerPersonne(personne);
            }
        });

        item7.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0) {
                carnet.chercherPersonne(personne);   
            }
        });

        item8.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0) {
                carnet.viderListePersonnes();
            }
        });

        item2_3.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0) {
                carnet.setMethodeTri(new ComparateurNom());
                carnet.trier();
                afficherCarnet(carnet);
            }
        });
        
        item2_4.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0) {
                carnet.setMethodeTri(new ComparateurAge());
                carnet.trier();
                afficherCarnet(carnet);
            }
        });
        
        item2_5.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0) {
                carnet.setMethodeTri(new ComparateurAgeInverse());
                carnet.trier();
                afficherCarnet(carnet);
            }
        });
        
        item3_1.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0) {
                Object[] message = creerSelectionActivite(catalogue);
                JOptionPane.showMessageDialog(null, message, "Sélectionner une"
                        + " activité", JOptionPane.QUESTION_MESSAGE);
              choisirActiviteDuGroupe(message, catalogue, groupe);
            }
        });
        
        item3_2.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0) {
                ajouterDatesActivite(groupe);
            }
        });
        
        item10.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0) {
                Object[] message = extraireResponsableDuCarnet(carnet);
                JOptionPane.showMessageDialog(null, message, "Sélectionnez les"
                        + " responsables", JOptionPane.QUESTION_MESSAGE);
                ajouterResponsableGroupe(message,carnet, groupe);
            }
        });
        
        item11.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0) {
                Object[] message = selectionResponsablesASupprimer(groupe);
                JOptionPane.showMessageDialog(null, message, "Cochez les"
                        + " responsables à supprimer", 
                        JOptionPane.QUESTION_MESSAGE);
                supprimerResponsableGroupe(message, groupe);
            }
        }); 
        
        item12.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0) {
                Object[] message = extraireParticipantDuCarnet(carnet);
                JOptionPane.showMessageDialog(null, message, "Sélectionnez les"
                        + " participants", JOptionPane.QUESTION_MESSAGE);
                ajouterParticipantGroupe(message,carnet, groupe);
            }
        });
        
        item13.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0) {
                Object[] message = selectionParticipantsASupprimer(groupe);
                JOptionPane.showMessageDialog(null, message, "Cochez les"
                        + " participants à supprimer", 
                        JOptionPane.QUESTION_MESSAGE);
                supprimerParticipantGroupe(message,groupe);
            }
        }); 
        
        item14.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent arg0) {
                afficherGroupe(groupe);
            }
        });
    }
    
    /**
     *  Permet de créer une nouvelle activité par l'utilisateur
     * @return un objet de la classe Activite
     */
    public static  Activite saisirInfoActivite() {
        
        JTextField nom = new JTextField() ;
        JTextField description = new JTextField() ;
        
        Object[] message = {"Entrez le nom de l'activité : ", nom,
                "Entrez la description de l'activité : " , description};     
        JOptionPane.showMessageDialog(null, message);
        return new Activite(nom.getText(),description.getText());
    }
    
    /**
     * Permet de vérifier si une activité activite existe déjà, en comparant son
     * nom avec celui de chaque activité element de listeActivite
     * @param catalogue
     * @param activite
     * @return -1 si exite et incrémente sinon.
     */
    public static int chercherIndiceActivite(Catalogue catalogue, 
            Activite activite) {
        List<Activite> listeActivite = catalogue.getCatalogue();
        int compteur = 0;
        for (Activite element : listeActivite) {
            if ((element.getNom().compareTo(activite.getNom())) == 0) {
                JOptionPane.showMessageDialog(null, "Cette d'activité "
                        + "existe déja");
                compteur = -1;
            } else if ((element.getNom().compareTo(activite.getNom())) < 0) {                    
                compteur++;
            }
        }
        return compteur;
    }                       
    
    /**
     * Permet de créer un catalogue depuis un fichier contenant une liste
     * d'activités
     * @return un objet de la classe Catalogue
     * @throws Exception 
     */
    public static Catalogue ajouterCatalogueDepuisFichier() throws Exception {
        
        JFileChooser file = new JFileChooser();
        file.showOpenDialog(null);
        BufferedReader br = new BufferedReader(new FileReader(
                file.getSelectedFile()));
        String ligne;
  
        while((ligne  = br.readLine()) != null)  {
            String [] tab = ligne.split(";") ;
            activite = new Activite (tab [0], tab [1]);
            int indice = chercherIndiceActivite(catalogue,activite);
            catalogue.insererActivite(indice , activite);    
        } 
        br.close();
        return catalogue ;
    }
    
    /**
     * Permet d'affichet la liste des activités dans un catalogue
     * @param catalogue
     * @return un affichage String
     */
    public static String afficherCatalogue(Catalogue catalogue) {
        
        ArrayList<Activite> listeActivites = catalogue.getCatalogue();
        
        String affichage = "";
        affichage = affichage.concat(String.format("%-5S %-27S %-30S \n\n",
                "id","activité", "description"));
        String affichage1 = "Liste vide";
        
        if (listeActivites.isEmpty()) {
            JOptionPane.showMessageDialog (null, affichage1);
            return affichage1;
        }
 
        else {
            for(Activite activite : listeActivites) {

                affichage = affichage.concat(String.format("%-5S %-27S "
                        + "%-30S\n\n", activite.getId(), activite.getNom(), 
                        activite.getDescription()));
            }
            affichage ="La maison des jeunes L'initiative organise les "                                               
                + catalogue.getNbActivite() + " suivantes : \n\n" + affichage ;
            JOptionPane.showMessageDialog (null, affichage);

            return affichage;
        }
    }
    
    /**
     * Permet de créer une personne saisie par l'utilisateur. Cette perssone  
     * sera ou bien responsable, ou bien participant selon son statut.
     * @return un objet de la classe Responsable ou de la classe Participant
     */
    public static Personne saisirInfoPersonne() {
        
        JTextField nom = new JTextField() ;
        JTextField prenom = new JTextField() ;
        JTextField telephone = new JTextField() ;
        JTextField courriel = new JTextField() ;
        JTextField dateNaissance = new JTextField() ;
        JTextField statut = new JTextField() ;
        
        Object[] message = {"Entrez le nom de la personne : ", nom,
                "Entrez le prénom de la personne : " , prenom, 
                "Entrez le numero de téléphone de la personne : ", telephone,
                "Entrez le courriel la personne : ", courriel, 
                "Entrez la date de naissance de la personne au format "
                + "aaaa-mm-jj : ", dateNaissance,"Statut (Entrez PART pour "
                + "participant et RESP pour responsable) :", statut};   
        
        JOptionPane.showMessageDialog(null, message);
        
        if(statut.getText().equalsIgnoreCase("part")) {
            return new Participant(nom.getText(),prenom.getText(), 
                    telephone.getText(),courriel.getText(), 
                    LocalDate.parse(dateNaissance.getText()));    
        }
        else {
            return new Responsable(nom.getText(),prenom.getText(), 
                    telephone.getText(),courriel.getText(), 
                    LocalDate.parse(dateNaissance.getText()));          
        }
        
    }
    
    /**
     * Permet de vérifier si une personne existe ou non dans le carnet d'adresse
     * en comparant les nom , prénoms et date de naissance
     * @param carnet
     * @param personne
     * @return un booléan true si existe et false sinon
     */
    public static boolean chercherPersonne (CarnetAdresses carnet, 
            Personne personne)  { 
        ArrayList<Personne> listePersonnes = carnet.getCarnet();
        boolean drapeau = true;
        for(Personne element : listePersonnes) {
            int resultat1 = element.getNom().compareTo(personne.getNom());
            int resultat2 = element.getPrenom().compareTo(personne.getPrenom());
            int resultat3 = element.getDateNaissance().compareTo(
                    personne.getDateNaissance());
            if (resultat1 == 0 && resultat2 == 0 && resultat3 == 0) {
                JOptionPane.showMessageDialog (null, 
                        "Cette personne existe deja"); 
                drapeau = false;
            }
        }
        return drapeau;
    } 
    
    /**
     * Permet de créer un carnet d'adresses à partir d'un fichier
     * @return un objet de la classe carnetAdresses
     * @throws Exception 
     */
    public static CarnetAdresses ajouterCarnetDepuisFichier() throws Exception {
        
        JFileChooser file = new JFileChooser();
        file.showOpenDialog(null);
        BufferedReader br = new BufferedReader(new FileReader(
                file.getSelectedFile()));
        String ligne;
        
        while((ligne  = br.readLine()) != null) {
            String [] tab = ligne.split(";") ;
            if (tab [5].equalsIgnoreCase("part")) {
                personne = new Participant (tab [0], tab [1], tab [2], tab [3],
                    LocalDate.parse(tab [4]));  
            }
            else {
                personne = new Responsable (tab [0], tab [1], tab [2], tab [3],
                    LocalDate.parse(tab [4]));          
            } 
            boolean drapeau = chercherPersonne(carnet,personne);
            if(drapeau){
                carnet.ajouterPersonne(personne); 
            }   
        } 
        br.close();
        return carnet ;
    }
    
    /**
     * Permet d'afficher le carnet d'adresses
     * @param carnet
     * @return un affichage String
     */
    public static String afficherCarnet(CarnetAdresses carnet) {
        
        ArrayList<Personne> listePersonnes = carnet.getCarnet();
        
        String affichage ="";
        affichage = affichage.concat(String.format(
                "%-20S %-20S %-20S %-20S %-20S %-20S %-20S \n",
                "id","nom", "prénom", "date de naissance", "âge", "téléphone",
                "courriel"));
        String affichage1 = "Liste vide";
        
        if (listePersonnes.isEmpty()) {
            JOptionPane.showMessageDialog (null, affichage1);
            return affichage1;
        }
        else {     
            for(Personne personne : listePersonnes) {
                LocalDate dateNaissance = personne.getDateNaissance();
                affichage = affichage.concat(String.format(
                        "%-20S %-20S %-20S %-20S %-20d %-20S %-20S \n",
                        personne.getId(),
                        personne.getNom(),
                        personne.getPrenom() , 
                        personne.getDateNaissance(),
                        personne.getAge(dateNaissance),
                        personne.getTelephone(),
                        personne.getCourriel() ));    
            }

           affichage = carnet.getNbPersonnes() + 
                   " personnes participent aux activités la Maison "
                    + "des Jeunes :\n\n" + affichage;
            JOptionPane.showMessageDialog (null, affichage);

            return affichage;
        }
    }
    
    /**
     * Permet de créer une liste temporaire liste1 qui contient la liste des 
     * participants dans le carnet d'adresses.À partir de cette liste, on crée
     * un objet formulaire1 de la classe JCheckBox[] 
     * @param carnet
     * @return un affichage JCheckBox[] contenant la liste des participants
     */
    public static Object[] extraireParticipantDuCarnet(CarnetAdresses carnet) {
        
        List<Personne> liste = carnet.getCarnet();
        List<Personne> liste1 = new ArrayList();
        Object[] message = null;
        for (Personne personne : liste) {    
            if (personne.getId().startsWith("PART")) {
                liste1.add(personne);
                int tailleCarnet1 = liste1.size();
                JCheckBox[] formulaire1 = new JCheckBox[tailleCarnet1];       
                int i = 0;
                for (Personne personne1 : liste1) {
                    formulaire1[i] = new JCheckBox(String.format(
                        "%S " + " " + "%S\n", 
                        personne1.getNom(),
                        personne1.getPrenom() ));
                    i++;
                }
                message = formulaire1;
            }   
        }
        return message;
    }
    
    /**
     * Permet de créer une liste temporaire liste2 qui contient la liste des 
     * responsables dans le carnet d'adresses.À partir de cette liste, on crée
     * un objet formulaire2 de la classe JCheckBox[] 
     * @param carnet
     * @return un affichage JCheckBox[] contenant la liste des responsables
     */
    public static Object[] extraireResponsableDuCarnet(CarnetAdresses carnet) {
        
        List<Personne> liste = carnet.getCarnet();
        List<Personne> liste2 = new ArrayList();
        Object[] message = null;
        for (Personne personne : liste) {    
            if (personne.getId().startsWith("RESP")) {
                
                liste2.add(personne);
                int tailleCarnet2 = liste2.size();
                JCheckBox[] formulaire2 = new JCheckBox[tailleCarnet2];
                int i = 0;
                for (Personne personne2 : liste2) {
                    
                    formulaire2[i] = new JCheckBox(String.format(
                    "%S " + " " + "%S\n", 
                    personne2.getNom(),
                    personne2.getPrenom() ));
                    i++;
                }
                message = formulaire2;   
            }          
        }
        return message;
    }    
    
    /**
     * Permet de créer un formulaire JCheckBox[] contenant la liste des 
     * responsables qui sont déjà dans le groupe àfin de les supprimer
     * @param groupe
     * @return un affichage JCheckBox[] contenant la liste des responsables
     * dans le groupe
     */
    public static Object[] selectionResponsablesASupprimer(Groupe groupe) {
        
        List<Personne> liste = groupe.getListeResponsables();
        int tailleListeResponsables = liste.size();
        
        JCheckBox[] formulaire = new JCheckBox[tailleListeResponsables]; 
        int i = 0;
        for (Personne personne : liste) {

            formulaire[i] = new JCheckBox(String.format(
                        "%S " + " " + "%S\n", 
                        personne.getNom(),
                        personne.getPrenom() ));
            i++;
            
        }    

        Object[] message = formulaire;
        
        return message;
    }
    
    /**
     * Permet de créer un formulaire JCheckBox[] contenant la liste des 
     * participants qui sont déjà dans le groupe àfin de les supprimer
     * @param groupe
     * @return un affichage JCheckBox[] contenant la liste des participants
     * dans le groupe
     */
    public static Object[] selectionParticipantsASupprimer(Groupe groupe) {
        
        List<Personne> liste = groupe.getListeParticipants();
        int tailleListeParticipants = liste.size();
        
        JCheckBox[] formulaire = new JCheckBox[tailleListeParticipants];     
        
        String affichage = "";
        
        int i = 0;
        for (Personne personne : liste) {

            formulaire[i] = new JCheckBox(String.format(
                        "%S " + " " + "%S\n", 
                        personne.getNom(),
                        personne.getPrenom() ));
            i++;
            
        }    

        Object[] message = formulaire;
        
        return message;
    }
    
    /**
     * Permet d'ajouter un responsable à la liste des responsables dans un
     * groupe en sélectionnant des individus à partir d'un objet selection de 
     * type JCheckBox
     * @param selection
     * @param carnet
     * @param groupe 
     */
    public static void ajouterResponsableGroupe(Object[] selection, 
                                          CarnetAdresses carnet,
                                          Groupe groupe) {
    
        List<Personne> liste = carnet.getCarnet();
        List<Personne> liste2 = new ArrayList();
        for (Personne personne : liste) { 
            
            if (personne.getId().startsWith("RESP")) {
                liste2.add(personne);
            }   
        } 
        for(int i = 0; i < selection.length; i++) {
            if(((JCheckBox)selection[i]).isSelected()) {
                if (groupe.getListeResponsables().contains(liste2.get(i))) {
                    JOptionPane.showMessageDialog(null,liste2.get(i).getNom() 
                            + " " + liste2.get(i).getPrenom()
                            + " existe dejà en tant que responsable!");
                }   else {
                        groupe.ajouterResponsable(liste2.get(i));    
                    }
            }    
        }
    }
 
    /**
     * Permet d'ajouter un paticipant à la liste des participants dans un
     * groupe en sélectionnant des individus à partir d'un objet selection de 
     * type JCheckBox
     * @param selection
     * @param carnet
     * @param groupe 
     */
    public static void ajouterParticipantGroupe(Object[] selection,
                                            CarnetAdresses carnet,
                                            Groupe groupe) {
    
        List<Personne> liste = carnet.getCarnet();
        List<Personne> liste1 = new ArrayList();
        for (Personne personne : liste) {    
            if (personne.getId().startsWith("PART")) {
                liste1.add(personne);
            }
        }
        
        for(int i = 0; i < selection.length; i++) {
            if(((JCheckBox)selection[i]).isSelected()) {
                if (groupe.getListeParticipants().contains(liste1.get(i))) {
                    JOptionPane.showMessageDialog(null,liste1.get(i).getNom() 
                            + " " + liste1.get(i).getPrenom()
                            + " existe dejà en tant que participant!");
                }   else {
                        groupe.ajouterParticipant(liste1.get(i));    
                    }
            }    
        }
    }
    
    /**
     * Permet de supprimer un responsable de la liste des responsables dans un
     * groupe
     * @param selection
     * @param groupe 
     */
    public static void supprimerResponsableGroupe(Object[] selection,
                                            Groupe groupe) {
        
        List<Personne> responsable = groupe.getListeResponsables();
        
            int compteur = 0;
            for(int i = 0; i < selection.length ; i++) {

                if(((JCheckBox)selection[i]).isSelected()) {
                    Personne pers = responsable.get(i-compteur);
                    groupe.supprimerResponsable(pers);
                    compteur++;
                }
            }
    }
    
    /**
     * Permet de supprimer un participant de la liste des participants dans un
     * groupe
     * @param selection
     * @param groupe 
     */
    public static void supprimerParticipantGroupe(Object[] selection,
                                            Groupe groupe) {
        
        List<Personne> participant = groupe.getListeParticipants();
        
            int compteur = 0;
            for(int i = 0; i < selection.length; i++) {
                if(((JCheckBox)selection[i]).isSelected()) {
                    Personne pers = participant.get(i-compteur);
                    groupe.supprimerParticipant(participant.get(i-compteur));
                    compteur++;
                }
            }
        
    }
    
    /**
     * Permet d'afficher la liste des activités dans le catalogue, sous forme
     * d'un JCheckBox[]
     * @param catalogue
     * @return un affichage JCheckBox[] contenant la liste des activités
     */
    
    public static Object[] creerSelectionActivite(Catalogue catalogue) {
        List<Activite> liste = catalogue.getCatalogue();
        int tailleCatalogue = liste.size();
        
        JCheckBox[] formulaire = new JCheckBox[tailleCatalogue];     
        
        String affichage = "";
        
        int i = 0;
        for (Activite activite : liste) {

            formulaire[i] = new JCheckBox(String.format("%-30S %-30S\n\n", 
                                activite.getNom(), activite.getDescription()));
            i++;
            
        }    

        Object[] message = formulaire;
        
        return message;
    }
    
    /**
     * Permet d'attribuer une activité à un groupe, en la sélectionnant à partir 
     * du message JCheckBox[] crée dans la méthode précédente 
     * créerSelectionActivite.
     * @param selection
     * @param catalogue
     * @param groupe 
     */
    public static void choisirActiviteDuGroupe(Object[] selection, 
                                          Catalogue catalogue,
                                          Groupe groupe) {
            
        List<Activite> activite = catalogue.getCatalogue(); 
        
        for(int i = 0; i < selection.length; i++) {
            if(((JCheckBox)selection[i]).isSelected()) {
                groupe.setActivite(activite.get(i));
            }
        }     
    }
    
    /**
     * Permet d'ajouter des dates de début et de fin de l'activité du groupe
     * @param groupe 
     */
    public static void ajouterDatesActivite(Groupe groupe) {
    
        JTextField dateDebut = new JTextField() ;
        JTextField dateFin = new JTextField() ;
        
        Object[] message = {"Date de début (aaaa/mm/jj) : ", dateDebut ,
            "Date de fin (aaaa/mm/jj) : ", dateFin };   
        
        JOptionPane.showMessageDialog(null, message);
        groupe.setDateDebut(LocalDate.parse(dateDebut.getText()));
        groupe.setDateFin(LocalDate.parse(dateFin.getText()));   
    }
    
    /**
     * Permet d'afficher les informations du groupe crée, en l'occurence le nom
     * de l'activité, sa date de début, sa date de fin, les responsables et les 
     * participant s'y impliquant.
     * @param groupe 
     */
    private static void afficherGroupe(Groupe groupe) {
        Activite activite = groupe.getActivite();
        LocalDate dateDebut  = groupe.getDateDebut();
        LocalDate dateFin = groupe.getDateFin() ;
        List<Personne> listeParticipants = groupe.getListeParticipants();
        List<Personne> listeResponsables = groupe.getListeResponsables();
                
        String affichage = "";
        String affichage1 = "RESPONSABLE\n";
        String affichage2 = "PARTICIPANT\n";
        
        affichage = affichage.concat(String.format(
                "%-30S %-30S %-30S  \n",
                "activité", "date de début", "date de fin"));
                
        
        
        affichage = affichage.concat(String.format(
                        "%-30S %-30S %-30S ", 
                        activite.getNom(),
                        dateDebut , 
                        dateFin));
        
        for (Personne responsable : listeResponsables) {
            affichage1 = affichage1 + String.format("%S",responsable.getNom() 
                    + " " + responsable.getPrenom()+ "\n");
            
        }

        for (Personne participant : listeParticipants) {
            affichage2 = affichage2 + String.format("%S",participant.getNom() 
                    + " " + participant.getPrenom()+ "\n");
        } 
        
        Object[] message = {affichage +"\n", "\n"+ affichage1 +"\n",
            affichage2 +"\n"};     
        JOptionPane.showMessageDialog(null, message);
    }
}

