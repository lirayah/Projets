import javax.swing.*;
import java.awt.event.*;

/**
 * La classe <code>Detect</code> implémente l'interface MouseListener et détecte quand l'utilisateur clique sur une case de la grille
 */
public class Detect implements MouseListener {
    private JPanel[] lab;
    private Mode mode;
    private int casint[][];
    private JFrame fenetre;

    /**
     * Le constructeur récupère le tableau de JPanel, le tableau des informations de la grille, la fenetre et l'objet Mode
     * @param g Le tableau de JPanel
     * @param mod L'objet Mode
     * @param tabint Le tableau contenant les informations de la grille
     * @param fen La fenetre
     */
    public Detect(JPanel[] g, Mode mod, int[][] tabint, JFrame fen){
        this.lab=g;
        this.mode=mod;
        this.casint=tabint;
        this.fenetre=fen;
    }

    /**
     * Implémentation de la méthode mouseClicked(MouseEvent e)
     * Lorsque l'utilisateur clique sur un paneau, on change sa couleur
     */
    public void mouseClicked(MouseEvent e){
        JPanel sele = (JPanel) e.getComponent();
        GestionClic gc = new GestionClic(this.lab, this.mode, sele, this.casint, this.fenetre);
        gc.gererClic();
    }

    public void mouseEntered(MouseEvent e){}
    public void mouseExited(MouseEvent e){}
    public void mousePressed(MouseEvent e){}
    public void mouseReleased(MouseEvent e){}
}
