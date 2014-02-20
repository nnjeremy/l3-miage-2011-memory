/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication2;

/**
 *
 * @author michelre
 */
public class Carte {

    //Attributs
    private Forme dessin;
    private boolean trouve;
    private boolean retourne;
    private Point position;
    private Joueur joueurTrouve;

    //Methodes
        /**
     * Constructeur
     */
    Carte(Forme dessin, boolean trouve){
        this.dessin = dessin;
        this.trouve = trouve;
        this.retourne=false;
        this.position = new Point(0,0);
        this.joueurTrouve = null;
    }

    /**
     * @return the dessin
     */
    public Forme getDessin() {
        return dessin;
    }

    /**
     * @return this.trouve
     */
    public boolean isTrouve() {
        return trouve;
    }

        /**
     * @return this.retourne
     */
    public boolean isRetourne(){
        return this.retourne;
    }
    

    /**
     * @param trouve the trouve to set
     */
    public void setTrouve(boolean trouve) {
        this.trouve = trouve;
    }

    /**
     * @return the position
     */
    public Point getPosition() {
        return position;
    }

    /**
     * @return the joueur
     */
    public Joueur getJoueurTrouve() {
        return joueurTrouve;
    }

    /**
     * @param retourne the retourne to set
     */
    public void setRetourne(boolean retourne) {
        this.retourne = retourne;
    }

    /**
     * @param joueurTrouve the joueurTrouve to set
     */
    public void setJoueurTrouve(Joueur joueurTrouve) {
        this.joueurTrouve = joueurTrouve;
    }
}

