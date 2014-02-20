/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication2;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author remimichel
 */
public class Dessin {
    //Attributs
    private Forme formeADessiner;
    private JPanel panCarte;
    private Point position;


    //Méthodes
        /**
     * Constructeur de la classe Dessin
     */
    public Dessin(Forme formeADessiner,Point position, JPanel panCarte){
        this.formeADessiner=formeADessiner;
        this.position=position;
        this.panCarte=panCarte;
    }


        /**
     * Permet de dessiner nos différentes formes
     */
    public void dessiner(Graphics g){
       int x = this.position.getX()+(int)panCarte.getWidth()/3;
       int y  = this.position.getY()+(int)panCarte.getHeight()/3;
       if(formeADessiner==Forme.cercle){
           g.fillOval(x, y, 30, 30);
       }
       else if(formeADessiner==Forme.cercleGreen){
           g.setColor(Color.GREEN);
           g.fillOval(x, y, 30, 30);
       }
       else if(formeADessiner==Forme.cercleMagenta){
           g.setColor(Color.MAGENTA);
           g.fillOval(x, y, 30, 30);
       }
       else if(formeADessiner==Forme.cercleYellow){
           g.setColor(Color.yellow);
           g.fillOval(x, y, 30, 30);
       }
       else if(formeADessiner==Forme.rectangle)
           g.fillRect(x, y, 30, 30);
       else if(formeADessiner==Forme.rectangleCyan){
           g.setColor(Color.CYAN);
           g.fillRect(x, y, 30, 30);
       }
       else if(formeADessiner==Forme.rectangleGreen){
           g.setColor(Color.GREEN);
           g.fillRect(x, y, 30, 30);
       }
       else if(formeADessiner==Forme.rectangleYellow){
           g.setColor(Color.yellow);
           g.fillRect(x, y, 30, 30);
       }
    }

    /**
     * @return the formeADessiner
     */
    public Forme getFormeADessiner() {
        return formeADessiner;
    }

    /**
     * @param formeADessiner the formeADessiner to set
     */
    public void setFormeADessiner(Forme formeADessiner) {
        this.formeADessiner = formeADessiner;
    }    

}
