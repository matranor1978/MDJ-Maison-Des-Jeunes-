/*
 * Maison des Jeunes
 */
package ca.qc.rosemont.mdj;

import java.awt.Font;
import javax.swing.plaf.FontUIResource;

/**
 * Permet d'instancier un objet de la classe Fenetre1, qui hérite de la classe
 * JFrame.
 * @author Hicham
 */

public class Mdj {
public static void main(String[] args){
   
    javax.swing.UIManager.put("OptionPane.messageFont", 
    new FontUIResource(new Font("Courier New", Font.PLAIN, 11)));
    Fenetre1 fen = new Fenetre1();
  }

}