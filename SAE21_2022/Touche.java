import java.awt.event.*;
import javax.swing.*;
/**
 * La classe <code>Touche</code> sert à changer le Mode dès qu'une touche du clavier est actionnée
 */
public class Touche implements KeyListener {
    private int count;
    private Mode maud;
    private int[][] casint;
    private JFrame fenetre;
    private JPanel[] tabnel;

    /**
     * Le constructeur permet de récupérer le Mode dans lequel on se trouve, le tableau qui représente la grille, la fenetre dans laquelle on est et le tableau de JPanel
     * @param mode le mode dans lequel on est 
     * @param tab le tableau représentant la constitution de la grille
     * @param fen La fenetre dans laquelle on est
     * @param tab2 Le tableau de JPanel
     */
    public Touche(Mode mode, int[][] tab, JFrame fen, JPanel[] tab2){
        this.maud=mode;
        this.casint=tab;
        this.fenetre=fen;
        this.tabnel=tab2;
    }

    /**
     * Implémentation de la méthode de keyTyped qui permet d'incrémenter le mode
     */
    public void keyTyped(KeyEvent e){
        if (this.maud.getMode()!=Mode.FINI){
            if (this.maud.getMode()==Mode.MUR_A){
                this.maud.setMode(Mode.ENTREE);
                JOptionPane.showMessageDialog(null, "Changement de mode --> ENTREE");
            } else if (this.maud.getMode()==Mode.ENTREE){
                this.maud.setMode(Mode.SORTIE);
                JOptionPane.showMessageDialog(null,"Changement de mode --> SORTIE");
            } else if (this.maud.getMode()==Mode.SORTIE){
                this.maud.setMode(Mode.MUR_B);
                JOptionPane.showMessageDialog(null,"Changement de mode --> MUR");
            } else if (this.maud.getMode()==Mode.MUR_B){
                this.maud.setMode(Mode.FINI);
                JOptionPane.showMessageDialog(null,"Changement de mode --> FINI");
                ChoixAlgo ca = new ChoixAlgo(this.casint, this.fenetre, this.tabnel);
                ca.anneHidalgo();
                //donner un ordre pour terminer la fenetre
                //un ordre pour afficher la fenetre des algos
        }
        }
    }

    public void keyPressed(KeyEvent e){}
    public void keyReleased(KeyEvent e){}

    public int co(){
        return this.count;
    }
}