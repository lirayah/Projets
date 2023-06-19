import java.awt.event.*;

/**
 * La classe <code>AlgoIntelKey</code> implémente l'interface KeyListener et est un controleur et permet de faire une itération de la méthode imSmart() à chaque appui sur une touche
 * @author Lionel Morin et Mathieu Proal
 * @version 387493
 */
public class AlgoIntelKey implements KeyListener {
    private AlgoIntel intel;
    private boolean sortie;
    private int mode;
    /**
     * Le constructeur est destiné à recevoir un booléen s qui dit si la sortie a été atteinte ou non, le mode m qui dit à AlgoIntel qu'on est en mode manuel et l'objet AlgoIntel
     * @param s Un booléen qui dit si on a atteint la sortie ou non
     * @param i L'objet AlgoIntel
     * @param m Le mode manuel
     */
    public AlgoIntelKey(boolean s,AlgoIntel i,int m){
        this.sortie=s;
        this.intel=i;
        this.mode=m;
    }

    /**
     * implémentation de la méthode keyTyped
     */
    public void keyTyped(KeyEvent e){
        IntelMan intelMan=new IntelMan(this.intel,this.sortie);
        intelMan.manuel(this.mode);
    }

    public void keyPressed(KeyEvent e){}
    public void keyReleased(KeyEvent e){}
}
