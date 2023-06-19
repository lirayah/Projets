/**
 * La classe <code>Mode</code> créé des constantes nommées pour les différents modes qui sont utilisés dans gestionClic
 * @author Mathieu Proal (et Luc Hernandez)
 * @version 1.0
 */
public class Mode {
    public static final int MUR_A=0;
    public static final int ENTREE=1;
    public static final int SORTIE=2;
    public static final int MUR_B=3;
    public static final int FINI=4;
    private int etat;

    /**
     * Le constructeur initialise le mode à MUR_A 
     */
    public Mode(){
        this.etat=Mode.MUR_A;
    }

    /**
     * La méthode getMode() récupère le mode dans lequel on se trouve
     * @return Le mode dans lequel on est 
     */
    public int getMode(){
        return this.etat;
    }

    /**
     * La méthode setMode() change le mode dans lequel on se trouve
     * @param state Le nouveau mode
     */
    public void setMode(int state){
        this.etat=state;
    }
}