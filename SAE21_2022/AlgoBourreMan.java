import javax.swing.*;

/**
 * La classe <code>AlgoBourreMan</code> ajoute un keyListener à la fenetre et charge AlgoBourreKey
 * @author Lionel Morin et Mathieu Proal
 * @version 123.0
 */
public class AlgoBourreMan {
    private JFrame fenetre;
    private AlgoBourreKey key;

    /**
     * Constructeur destiné à recevoir le tableau de la composition de la grille, le tableau de JPanel
     * la fenetre dans laquelle on se trouve et les objets Positions et Try
     * 
     * @param fen La fenêtre
     * @param tab le tableau contenant les informations de la grille 
     * @param po L'objet Position
     * @param tabnel Le tableau de JPanel
     * @param t L'objet Try
     */
    public AlgoBourreMan(JFrame fen, int[][] tab, Positions po, JPanel[] tabnel, Try t){
        this.fenetre=fen;
        this.key=new AlgoBourreKey(tab, po, tabnel, this.fenetre, t);
    }


    /**
     * Méthode qui sert à ajouter un keyListener sur la fenetre
     */
    public void manuel(){
        this.fenetre.addKeyListener(this.key);
    }
}
