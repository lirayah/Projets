import java.awt.event.*;
import javax.swing.*;

/**
 *  La classe <code>AlgoBourreKey</code> contrôle lorsque l'utilisateur appuie sur une touche en implémentant l'interface KeyListener
 * 
 * @author Lionel Morin et Mathieu Proal
 * @version 13367
 */
public class AlgoBourreKey implements KeyListener {
    private int[][] casint;
    private JPanel[] tabnel;
    private JFrame fenetre;
    private Positions pos;
    private Try traille;

    /**
     * Le constructeur est destiné à recevoir le tableau de la composition de la grille,
     * le tableau de JPanel, la fenetre et les objets Positions et Try
     * @param tabint Le tableau de la composition de la grille
     * @param po L'objet Positions
     * @param tab2 Le tableau de JPanel
     * @param fen La fenetre actuelle
     * @param t L'objet Try
     */
    public AlgoBourreKey(int[][] tabint, Positions po, JPanel[] tab2, JFrame fen, Try t){
        this.casint=tabint;
        this.pos=po;
        this.tabnel=tab2;
        this.fenetre=fen;
        this.traille=t;
    }

    /**
     * Implémentation de la méthode keyTyped pour pouvoir recevoir les appuis sur les touches de l'utilisateur
     */
    public void keyTyped(KeyEvent e){
        AlgoBourreManAction act = new AlgoBourreManAction(this.casint, this.pos, this.tabnel, this.fenetre, this.traille);
        act.action();
    }

    public void keyPressed(KeyEvent e){}
    public void keyReleased(KeyEvent e){}
}
