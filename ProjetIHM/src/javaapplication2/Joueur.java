/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication2;

/**
 *
 * @author nicolaje
 */
public class Joueur {

    //Attributs
    private String pseudo;
    private Stat statistique;

    //Methodes
    Joueur (String pseudo) {
        this.pseudo = pseudo;
        this.statistique = new Stat();
    }

    /**
     * @return the pseudo
     */
    public String getPseudo() {
        return pseudo;
    }

    /**
     * @param pseudo the pseudo to set
     */
    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

    /**
     * @return the statistique
     */
    public Stat getStatistique() {
        return statistique;
    }

}
