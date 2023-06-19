import javax.swing.*;

/**
 * La classe <code>Modif</code> ajoute le MouseListener, elle fait la transition entre Affichage et Detect
 * @author Mathieu Proal
 * @version 1.9
 */
public class Modif {
    private JPanel[] tabnel;
    private Mode mod;
    private int[][] casint;
    private JFrame fenetre;

    /**
     * Le constructeur récupère le tableau de JPanel, l'objet Mode, le tableau représentant la constitution de la grille, et la fenêtre
     * @param va Le tableau de JPanel
     * @param maud L'objet Mode
     * @param tabint Le tableau représentant la constitution de la grille
     * @param fen La fenetre dans laquelle on est
     */
    public Modif(JPanel[] va, Mode maud, int[][] tabint, JFrame fen){
        this.tabnel=va;
        this.mod=maud;
        this.casint=tabint;
        this.fenetre=fen;
    }

    /**
     * La méthode modifier() ajoute un mouseListener sur tous les JPanel du tableau de JPanel
     */
    public void modifier(){
        Detect cli = new Detect(this.tabnel, this.mod, this.casint, this.fenetre);
        for (JPanel lab : this.tabnel) {
            lab.setOpaque(true);
            lab.addMouseListener(cli);
        }
    }
}
