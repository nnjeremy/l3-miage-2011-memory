/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication2;

/**
 *
 * @author nicolaje
 */
public class Stat {
    private int NbPartieJoue;
    private int NbPartieGagne;
    private float PourcentageGagne;

    //Methode
    public Stat() {
        this.NbPartieJoue = 0;
        this.NbPartieGagne = 0;
        this.PourcentageGagne = 0;
    }

    /**
     * @return the NbPartieJoue
     */
    public int getNbPartieJoue() {
        return NbPartieJoue;
    }

    /**
     * @param NbPartieJoue the NbPartieJoue to set
     */
    public void setNbPartieJoue(int NbPartieJoue) {
        this.NbPartieJoue = NbPartieJoue;
    }

    /**
     * @return the NbPartieGagne
     */
    public int getNbPartieGagne() {
        return NbPartieGagne;
    }

    /**
     * @param NbPartieGagne the NbPartieGagne to set
     */
    public void setNbPartieGagne(int NbPartieGagne) {
        this.NbPartieGagne = NbPartieGagne;
    }

    /**
     * @return the PourcentageGagne
     */
    public float getPourcentageGagne() {
        return PourcentageGagne;
    }

        /**
     * Permet d'incrémenter le nombre de parties gagnées
     */
    public void addPartieGagne() {
        this.NbPartieGagne = this.NbPartieGagne +1;
        this.NbPartieJoue = this.NbPartieJoue +1;
        this.calcPourcentage();
    }

        /**
     * Permet d'incrémenter le nombre de parties jouées
     */
    public void addPartieJoue() {
        this.NbPartieJoue = this.NbPartieJoue +1;
        this.calcPourcentage();
    }

        /**
     * Permet de calculer le pourcentage de parties gagnées
     */
    public void calcPourcentage() {
        this.PourcentageGagne = ( this.NbPartieGagne * 100 ) / this.NbPartieJoue;
    }

}
