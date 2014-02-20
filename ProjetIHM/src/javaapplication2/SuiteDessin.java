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
public class SuiteDessin extends Vector {
    //Attributs
    private Vector vectorGraphics;
    private Vector vectorCarteTrouve;

    //Methodes
    public SuiteDessin(){
        this.vectorGraphics=new Vector();
        this.vectorCarteTrouve=new Vector();
    }

        /**
     * Permet d'ajouter un nouveau dessin dans notre vecteur
     */
    public void ajoutDessin(Dessin dessin, JPanel panelCarte){
        this.addElement(dessin);
        this.getVectorGraphics().add(panelCarte);
    }

        /**
     * Permet de dessiner l'ensemble des éléments de notre vecteur
     */
    public void dessiner(Graphics g) {
        Dessin dessin;
        JPanel carte;
        Enumeration enumGraphics = getVectorGraphics().elements();
        for (Enumeration e=elements(); e.hasMoreElements();){
            enumGraphics.hasMoreElements();
            dessin=(Dessin) e.nextElement();
            carte=(JPanel)enumGraphics.nextElement();
            dessin.dessiner(carte.getGraphics());
        }
    }
    /**
     * @param vectorGraphics the vectorGraphics to set
     */
    public void setVectorGraphics(Vector vectorGraphics) {
        this.vectorGraphics = vectorGraphics;
    }

    /**
     * @return the vectorGraphics
     */
    public Vector getVectorGraphics() {
        return vectorGraphics;
    }


}
