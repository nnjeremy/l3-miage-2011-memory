/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package javaapplication2;

import java.util.HashMap;
import java.util.Iterator;

/**
 *
 * @author michelre
 */
public class Partie {

    //Attributs
    private int nbParticipants;
    private int joueurActif;
    private boolean partieActif;
    private boolean partieWait;
    private HashMap<String, Joueur> mapJoueur;
    private HashMap<String, Carte> mapCarte;

    //Methodes

        /**
     * Constructeur
     */
    public Partie(int nbParticipants, int nbCarte, int partieA, boolean joueurA){
        this.nbParticipants = nbParticipants;
        this.partieActif = false;
        this.partieWait = false;
        this.joueurActif = 0;
        this.mapCarte = new HashMap();
        this.mapJoueur = new HashMap();
    }

        /**
     * Surcharge du constructeur par défaut
     */
    Partie() {

        this.nbParticipants = 0;
        this.partieActif = false;
        this.partieWait = false;
        this.joueurActif = 0;
        this.mapCarte = new HashMap();
        this.mapJoueur = new HashMap();

    }

    /**
     * @return the nbParticipants
     */
    public int getNbParticipants() {
        return nbParticipants;
    }

    /**
     * @param nbParticipants the nbParticipants to set
     */
    public void setNbParticipants(int nbParticipants) {
        this.nbParticipants = nbParticipants;
    }

    /**
     * @return the mapJoueur
     */
    public HashMap<String, Joueur> getMapJoueur() {
        return mapJoueur;
    }

    /**
     * @param mapJoueur the mapJoueur to set
     */
    public void putJoueur(int id, String name) {

        Joueur joueur = new Joueur(name);
        this.mapJoueur.put(String.valueOf(id), joueur);
        
    }

    /**
     * @return the mapCarte
     */
    public HashMap<String, Carte> getMapCarte() {
        return mapCarte;
    }

    /**
     * @param mapCarte the mapCarte to set
     */
    public void setMapCarte(HashMap<String, Carte> mapCarte) {
        this.mapCarte = mapCarte;
    }

        /**
     * @return le Pseudo correspondant à un numéro de joueur 
     */
    public String getPseudoId(int numJoueur){
        Iterator i = this.mapJoueur.keySet().iterator();
        while (i.hasNext())
        {
            String clef = (String)i.next();
            if(clef.equalsIgnoreCase(String.valueOf(numJoueur)))
                return mapJoueur.get(clef).getPseudo();
        }
            return "";
    }

        /**
     * @return Un Joueur correspondant à un numéro de joueur
     */
    public Joueur getJoueurId(int numJoueur){
        Iterator i = this.mapJoueur.keySet().iterator();
        while (i.hasNext())
        {
            String clef = (String)i.next();
            if(clef.equalsIgnoreCase(String.valueOf(numJoueur))) {
            return mapJoueur.get(clef); }
        }
            return null;
    }

        /**
     * @return Le nombre de points correspondant à un numéro de joueur
     */
    public int getPointJoueurId(int numJoueur){
        Iterator i = this.mapJoueur.keySet().iterator();
        Iterator j = this.mapCarte.keySet().iterator();
        int cpt = 0;
        while (i.hasNext())
        {
            String clef = (String)i.next();
            if(clef.equalsIgnoreCase(String.valueOf(numJoueur))) {
                // mapJoueur.get(clef);
               
                while (j.hasNext())
                {
                    String clef2 = (String)j.next();
                    if (this.mapCarte.get(clef2).isTrouve())
                        if (this.mapCarte.get(clef2).getJoueurTrouve().getPseudo().equalsIgnoreCase(mapJoueur.get(clef).getPseudo()))
                            cpt++;
                 }
            }
            
        }

      return cpt;
    }

        /**
     * @return Une carte en fonction de sa position
     */

    public Carte getCartePosition(Point position){
        Iterator i = this.mapCarte.keySet().iterator();
        int x = position.getX();
        int y = position.getY();
        String idCarte="";
        while (i.hasNext())
        {
            idCarte = ((String)i.next());            
            if(mapCarte.get(idCarte).getPosition().getX()==x && mapCarte.get(idCarte).getPosition().getY()==y)
                return mapCarte.get(idCarte);
        }
            return null;
    }

        /**
     * Permet de créér nos 16 cartes et de les insérer dans la collection de cartes
     */
    public void creerCarte(){
        Forme dessin[] = Forme.values();
        int num=-1;
        for(int i=0; i<16; i++){
            if(i%2==0)
                num++;
            this.mapCarte.put(String.valueOf(i), new Carte(dessin[num], false));
        }
    }

        /**
     * @return Vrai si la position correspondant aux coordonnées (x;y) est libre
     */
    public boolean positionLibre(int x, int y){
        boolean trouve = true;
        Iterator i = this.getMapCarte().keySet().iterator();
        while (i.hasNext())
        {
            String clef = (String)i.next();
            if(this.mapCarte.get(clef).getPosition().getX()==x
               && this.mapCarte.get(clef).getPosition().getY()==y)
                trouve=false;
        }
        return trouve;
    }

        /**
     * Permet de modifier aléatoirement la position de nos carte dans notre collection
     */
    public void positionnerAleatoire(){
        Iterator i = this.getMapCarte().keySet().iterator();
        int randX = 0;
        int randY =0;
        while (i.hasNext())
        {
            String clef = (String)i.next();
            do{
                randX = 1 + (int)(Math.random()*4);
                randY = 1 + (int)(Math.random()*4);
            }while(!this.positionLibre(randX, randY));
          this.mapCarte.get(clef).getPosition().setX(randX);
          this.mapCarte.get(clef).getPosition().setY(randY);
        }
    }

        /**
     * @return un tableau de Carte retournées
     */
    public Carte[] tabCarteRetourne(){
        int nbCarte=0;
        Carte[] tabCarte = new Carte[2];
        Iterator i = this.getMapCarte().keySet().iterator();
        while (i.hasNext())
        {
            String clef = (String)i.next();
            if(this.mapCarte.get(clef).isRetourne()){
                tabCarte[nbCarte]=this.mapCarte.get(clef);
                nbCarte++;
            }
        }
        return tabCarte;
   }

        /**
     * @return Vrai si deux cartes ont été trouvées (Donc si elles ont la même forme)
     */
    public boolean verifCarteTrouve(){
        boolean deuxCartes=false;
        Carte tabCarte[]=this.tabCarteRetourne();
            if(tabCarte[0].getDessin()==tabCarte[1].getDessin()){
                tabCarte[0].setTrouve(true);
                tabCarte[1].setTrouve(true);
                tabCarte[0].setJoueurTrouve(this.getJoueurId(this.joueurActif));
                tabCarte[1].setJoueurTrouve(this.getJoueurId(this.joueurActif));
                deuxCartes=true;
            } else {
                this.setJoueurActif(this.joueurSuivant(this.getJoueurActif()));
            }
        return deuxCartes;
    }

        /**
     * Permet de réinitialiser toutes nos cartes
     */
    public void reinitialiserCarte(){
        Iterator i = this.getMapCarte().keySet().iterator();
        while (i.hasNext())
        {
            String clef = (String)i.next();
            this.mapCarte.get(clef).setRetourne(false);
            this.mapCarte.get(clef).setTrouve(false);
        }
    }

        /**
     * @return Vrai seulement si 2 cartes sont retournées
     */
    public boolean deuxCartesRetourne(){
        int nbCarte=0;
        Iterator i = this.getMapCarte().keySet().iterator();
        while (i.hasNext())
        {
            String clef = (String)i.next();
            if(this.mapCarte.get(clef).isRetourne())
                nbCarte++;
        }
        if(nbCarte==2)
            return true;
        else
            return false;
    }

        /**
     * @return Vrai seulement si une seule carte est retournée
     */
      public boolean uneCartesRetourne(){
        int nbCarte=0;
        Iterator i = this.getMapCarte().keySet().iterator();
        while (i.hasNext())
        {
            String clef = (String)i.next();
            if(this.mapCarte.get(clef).isRetourne())
                nbCarte++;
        }
        if(nbCarte==1)
            return true;
        else
            return false;
    }

        /**
     * Permet de modifier l'attribut retourné de chacune des cartes de notre collection
     */
    public void retournerTouteCarte(){
        Iterator i = this.getMapCarte().keySet().iterator();
        while (i.hasNext())
        {
            String clef = (String)i.next();
            this.mapCarte.get(clef).setRetourne(false);

        }
    }

        /**
     * @return Un numéro de joueur aléatoire
     */
    public int joueurAleatoire(){
        return 1 + (int)(Math.random()*this.getNbParticipants());
    }

        /**
     * @return Le numéro du joueur suivant en fonction du joueur actuel
     */
    public int joueurSuivant(int joueurActu){
        if (joueurActu < this.getNbParticipants())
            return joueurActu +1; //si on est pas sur le dernier joueur on retourne joueur+1
        else
            return 1; //sinon on retourne le 1er joueur
    }

        /**
     * @return Le nombre de cartes trouvées
     */
    public int nbCarteTrouve(){
        int cpt = 0;
        Iterator i = this.getMapCarte().keySet().iterator();
        while (i.hasNext())
        {
            String clef = (String)i.next();
            if (this.mapCarte.get(clef).isTrouve())
                cpt++;
        }
       return cpt;
    }

    /**
     * @return the joueurActif
     */
    public int getJoueurActif() {
        return joueurActif;
    }

    /**
     * @param joueurActif the joueurActif to set
     */
    public void setJoueurActif(int joueurActif) {
        this.joueurActif = joueurActif;
    }

    /**
     * @return the partieActif
     */
    public boolean isPartieActif() {
        return partieActif;
    }

    /**
     * @param partieActif the partieActif to set
     */
    public void setPartieActif(boolean partieActif) {
        this.partieActif = partieActif;
    }

    /**
     * @return the partieWait
     */
    public boolean isPartieWait() {
        return partieWait;
    }

    /**
     * @param partieWait the partieWait to set
     */
    public void setPartieWait(boolean partieWait) {
        this.partieWait = partieWait;
    }

        /**
     * Permet de gérer la fin de partie et les statistiques associées
     */
    public void finDePartie() {
        int nombreParticipants;
        nombreParticipants = this.nbParticipants;

        if (nombreParticipants == 1)
            this.getJoueurId(1).getStatistique().addPartieGagne();
        
        if (nombreParticipants == 2)
            if (this.getPointJoueurId(1) > this.getPointJoueurId(2)) {
                this.getJoueurId(1).getStatistique().addPartieGagne();
                this.getJoueurId(2).getStatistique().addPartieJoue();
            }
            else if (this.getPointJoueurId(1) < this.getPointJoueurId(2)){
                this.getJoueurId(2).getStatistique().addPartieGagne();
                this.getJoueurId(1).getStatistique().addPartieJoue();
            }
            else {
                this.getJoueurId(1).getStatistique().addPartieGagne();
                this.getJoueurId(2).getStatistique().addPartieGagne();
            }

        if (nombreParticipants == 3)
            if (this.getPointJoueurId(1) > this.getPointJoueurId(2) &&
            this.getPointJoueurId(1) > this.getPointJoueurId(3)) {
                this.getJoueurId(1).getStatistique().addPartieGagne();
                this.getJoueurId(2).getStatistique().addPartieJoue();
                this.getJoueurId(3).getStatistique().addPartieJoue();
            }
            else if (this.getPointJoueurId(2) > this.getPointJoueurId(1) &&
            this.getPointJoueurId(2) > this.getPointJoueurId(3)) {
                this.getJoueurId(2).getStatistique().addPartieGagne();
                this.getJoueurId(1).getStatistique().addPartieJoue();
                this.getJoueurId(3).getStatistique().addPartieJoue();
            }
            else if (this.getPointJoueurId(3) > this.getPointJoueurId(1) &&
            this.getPointJoueurId(3) > this.getPointJoueurId(2)) {
                this.getJoueurId(3).getStatistique().addPartieGagne();
                this.getJoueurId(1).getStatistique().addPartieJoue();
                this.getJoueurId(2).getStatistique().addPartieJoue();
            }
            else if(this.getPointJoueurId(1) == this.getPointJoueurId(2) &&
            this.getPointJoueurId(1) > this.getPointJoueurId(3)) {
                this.getJoueurId(1).getStatistique().addPartieGagne();
                this.getJoueurId(2).getStatistique().addPartieGagne();
                this.getJoueurId(3).getStatistique().addPartieJoue();
            }
            else if (this.getPointJoueurId(1) == this.getPointJoueurId(3) &&
            this.getPointJoueurId(1) > this.getPointJoueurId(2)) {
                this.getJoueurId(1).getStatistique().addPartieGagne();
                this.getJoueurId(3).getStatistique().addPartieGagne();
                this.getJoueurId(2).getStatistique().addPartieJoue();
            }
            else if (this.getPointJoueurId(3) == this.getPointJoueurId(2) &&
            this.getPointJoueurId(3) > this.getPointJoueurId(1)) {
                this.getJoueurId(3).getStatistique().addPartieGagne();
                this.getJoueurId(1).getStatistique().addPartieJoue();
                this.getJoueurId(2).getStatistique().addPartieGagne();
            }
            else {
                this.getJoueurId(1).getStatistique().addPartieGagne();
                this.getJoueurId(2).getStatistique().addPartieGagne();
                this.getJoueurId(3).getStatistique().addPartieGagne();
            }

        if (nombreParticipants == 4)
            if (this.getPointJoueurId(1) > this.getPointJoueurId(2) &&
            this.getPointJoueurId(1) > this.getPointJoueurId(3) &&
            this.getPointJoueurId(1) > this.getPointJoueurId(4)) {
                this.getJoueurId(1).getStatistique().addPartieGagne();
                this.getJoueurId(2).getStatistique().addPartieJoue();
                this.getJoueurId(3).getStatistique().addPartieJoue();
                this.getJoueurId(4).getStatistique().addPartieJoue();
            }
            else if (this.getPointJoueurId(2) > this.getPointJoueurId(1) &&
            this.getPointJoueurId(2) > this.getPointJoueurId(3) &&
            this.getPointJoueurId(2) > this.getPointJoueurId(4)) {
                this.getJoueurId(2).getStatistique().addPartieGagne();
                this.getJoueurId(1).getStatistique().addPartieJoue();
                this.getJoueurId(3).getStatistique().addPartieJoue();
                this.getJoueurId(4).getStatistique().addPartieJoue();
            }
            else if (this.getPointJoueurId(3) > this.getPointJoueurId(1) &&
            this.getPointJoueurId(3) > this.getPointJoueurId(2) &&
            this.getPointJoueurId(3) > this.getPointJoueurId(4)) {
                this.getJoueurId(3).getStatistique().addPartieGagne();
                this.getJoueurId(1).getStatistique().addPartieJoue();
                this.getJoueurId(2).getStatistique().addPartieJoue();
                this.getJoueurId(4).getStatistique().addPartieJoue();
            }
            else if (this.getPointJoueurId(4) > this.getPointJoueurId(1) &&
            this.getPointJoueurId(4) > this.getPointJoueurId(2) &&
            this.getPointJoueurId(4) > this.getPointJoueurId(3)) {
                this.getJoueurId(3).getStatistique().addPartieJoue();
                this.getJoueurId(1).getStatistique().addPartieJoue();
                this.getJoueurId(2).getStatistique().addPartieJoue();
                this.getJoueurId(4).getStatistique().addPartieGagne();
            }
            else if(this.getPointJoueurId(1) == this.getPointJoueurId(2) &&
            this.getPointJoueurId(1) > this.getPointJoueurId(3) &&
            this.getPointJoueurId(1) > this.getPointJoueurId(4)) {
                this.getJoueurId(1).getStatistique().addPartieGagne();
                this.getJoueurId(2).getStatistique().addPartieGagne();
                this.getJoueurId(3).getStatistique().addPartieJoue();
                this.getJoueurId(4).getStatistique().addPartieJoue();
            }
            else if (this.getPointJoueurId(1) == this.getPointJoueurId(3) &&
            this.getPointJoueurId(1) > this.getPointJoueurId(2) &&
            this.getPointJoueurId(1) > this.getPointJoueurId(4)) {
                this.getJoueurId(1).getStatistique().addPartieGagne();
                this.getJoueurId(3).getStatistique().addPartieGagne();
                this.getJoueurId(2).getStatistique().addPartieJoue();
                this.getJoueurId(4).getStatistique().addPartieJoue();
            }
            else if (this.getPointJoueurId(3) == this.getPointJoueurId(2) &&
            this.getPointJoueurId(3) > this.getPointJoueurId(1) &&
            this.getPointJoueurId(3) > this.getPointJoueurId(4)) {
                this.getJoueurId(3).getStatistique().addPartieGagne();
                this.getJoueurId(1).getStatistique().addPartieJoue();
                this.getJoueurId(4).getStatistique().addPartieJoue();
                this.getJoueurId(2).getStatistique().addPartieGagne();
            }
            else if (this.getPointJoueurId(4) == this.getPointJoueurId(2) &&
            this.getPointJoueurId(4) > this.getPointJoueurId(1) &&
            this.getPointJoueurId(4) > this.getPointJoueurId(3)) {
                this.getJoueurId(3).getStatistique().addPartieJoue();
                this.getJoueurId(1).getStatistique().addPartieJoue();
                this.getJoueurId(4).getStatistique().addPartieGagne();
                this.getJoueurId(2).getStatistique().addPartieGagne();
            }
            else if (this.getPointJoueurId(4) == this.getPointJoueurId(3) &&
            this.getPointJoueurId(4) > this.getPointJoueurId(1) &&
            this.getPointJoueurId(4) > this.getPointJoueurId(2)) {
                this.getJoueurId(3).getStatistique().addPartieGagne();
                this.getJoueurId(1).getStatistique().addPartieJoue();
                this.getJoueurId(4).getStatistique().addPartieGagne();
                this.getJoueurId(2).getStatistique().addPartieJoue();
            }
            else if (this.getPointJoueurId(4) == this.getPointJoueurId(1) &&
            this.getPointJoueurId(4) > this.getPointJoueurId(2) &&
            this.getPointJoueurId(4) > this.getPointJoueurId(3)) {
                this.getJoueurId(3).getStatistique().addPartieJoue();
                this.getJoueurId(1).getStatistique().addPartieGagne();
                this.getJoueurId(4).getStatistique().addPartieGagne();
                this.getJoueurId(2).getStatistique().addPartieJoue();
            }

            else if (this.getPointJoueurId(1) == this.getPointJoueurId(3) &&
            this.getPointJoueurId(1) == this.getPointJoueurId(3) &&
            this.getPointJoueurId(1) > this.getPointJoueurId(4)) {
                this.getJoueurId(1).getStatistique().addPartieGagne();
                this.getJoueurId(2).getStatistique().addPartieGagne();
                this.getJoueurId(3).getStatistique().addPartieGagne();
                this.getJoueurId(4).getStatistique().addPartieJoue();
            }
            else if (this.getPointJoueurId(1) == this.getPointJoueurId(4) &&
            this.getPointJoueurId(1) == this.getPointJoueurId(2) &&
            this.getPointJoueurId(1) > this.getPointJoueurId(3)) {
                this.getJoueurId(1).getStatistique().addPartieGagne();
                this.getJoueurId(3).getStatistique().addPartieJoue();
                this.getJoueurId(2).getStatistique().addPartieGagne();
                this.getJoueurId(4).getStatistique().addPartieGagne();
            }
            else if (this.getPointJoueurId(3) == this.getPointJoueurId(4) &&
            this.getPointJoueurId(3) == this.getPointJoueurId(1) &&
            this.getPointJoueurId(3) > this.getPointJoueurId(2)) {
                this.getJoueurId(3).getStatistique().addPartieGagne();
                this.getJoueurId(1).getStatistique().addPartieGagne();
                this.getJoueurId(4).getStatistique().addPartieGagne();
                this.getJoueurId(2).getStatistique().addPartieJoue();
            }
            else if (this.getPointJoueurId(4) == this.getPointJoueurId(3) &&
            this.getPointJoueurId(4) == this.getPointJoueurId(2) &&
            this.getPointJoueurId(4) > this.getPointJoueurId(1)) {
                this.getJoueurId(3).getStatistique().addPartieGagne();
                this.getJoueurId(1).getStatistique().addPartieJoue();
                this.getJoueurId(4).getStatistique().addPartieGagne();
                this.getJoueurId(2).getStatistique().addPartieGagne();
            }
            else {
                this.getJoueurId(1).getStatistique().addPartieGagne();
                this.getJoueurId(2).getStatistique().addPartieGagne();
                this.getJoueurId(3).getStatistique().addPartieGagne();
                this.getJoueurId(4).getStatistique().addPartieGagne();
            }


    }
}