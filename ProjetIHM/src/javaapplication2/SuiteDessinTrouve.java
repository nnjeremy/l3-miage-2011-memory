/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication2;

import java.awt.Graphics;
import java.util.Enumeration;
import java.util.Vector;
import javax.swing.JPanel;

/**
 *
 * @author remimichel
 */
public class SuiteDessinTrouve extends Vector {

    //Attributs
    private Vector vectorGraphicsCarteTrouve;

        //Methodes
    public SuiteDessinTrouve(){
        new Vector();
        this.vectorGraphicsCarteTrouve=new Vector();
    }

            /**
     * Permet d'ajouter un nouveau dessin dans notre vecteur
     */
    public void ajoutDessin(Dessin dessin, JPanel panelCarte){
        this.addElement(dessin);
        this.vectorGraphicsCarteTrouve.add(panelCarte);
    }

            /**
     * Permet de dessiner l'ensemble des éléments de notre vecteur
     */
    public void dessiner(Graphics g){
        Dessin dessin;
        JPanel carte;
        Enumeration enumCarteTrouve = this.elements();
        Enumeration enumGraphicsCarteTrouve = this.vectorGraphicsCarteTrouve.elements();
        for (Enumeration e=elements(); e.hasMoreElements();){
            enumCarteTrouve.hasMoreElements();
            dessin=(Dessin) e.nextElement();
            carte=(JPanel)enumGraphicsCarteTrouve.nextElement();
            dessin.dessiner(carte.getGraphics());
        }
    }

    /**
     * @param vectorGraphicsCarteTrouve the vectorGraphicsCarteTrouve to set
     */
    public void setVectorGraphicsCarteTrouve(Vector vectorGraphicsCarteTrouve) {
        this.vectorGraphicsCarteTrouve = vectorGraphicsCarteTrouve;
    }

}
