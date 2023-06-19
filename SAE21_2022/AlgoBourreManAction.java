import java.util.*;
import javax.swing.*;


/**
 * La classe <code>AlgoBourreManAction</code> est utilisée pour avancer d'une étape dans l'algorithme lorsque l'utilisateur appuie sur une touche
 * @author Lionel Morin et Mathieu Proal
 * @version j'ai plus d'idée
 */
public class AlgoBourreManAction {
    private int[][] casint;
    private int xpos;
    private int ypos;
    private JPanel[] tabnel;
    private JFrame fenetre;
    private Positions po;
    private Try traille;

    /**
     * Constructeur destiné à recevoir le tableau de la composition de la grille, le tableau de JPanel, la fenetre et les objets Try et Positions
     * @param tab Le tableau contenant les informations de la grille
     * @param pos L'objet Position
     * @param tab2 Le tableau de JPanel
     * @param fen La fenetre actuelle
     * @param t L'objet Try
     */
    public AlgoBourreManAction(int[][] tab, Positions pos, JPanel[] tab2, JFrame fen, Try t){
        this.casint=tab;
        this.po=pos;
        this.tabnel=tab2;
        this.fenetre=fen;
        this.xpos=pos.getPos(0);
        this.ypos=pos.getPos(1);
        this.traille=t;
    }

    /**
     * Méthode qui effectue une étape de l'algorithme aléatoire
     */
    public void action(){
        Random rando = new Random();
        int randu;
        randu=rando.nextInt(4);

        if (randu==Direction.HAUT){
            if (this.ypos!=0){
                this.traille.incrementation();
                if (this.casint[this.ypos-1][this.xpos]!=1){
                    for (int i = 0; i < this.casint.length; i++) {
                        for (int j = 0; j < this.casint.length; j++) {
                            if (this.casint[j][i]==4){
                                this.casint[j][i]=0;
                            }
                        }
                    }
                    if (this.casint[this.ypos-1][this.xpos]!=3){
                        this.casint[this.ypos-1][this.xpos]=4;
                    }
                    this.po.setPos(this.xpos, this.ypos-1);
                }
                if (this.casint[this.ypos-1][this.xpos]==3){
                    JOptionPane.showMessageDialog(null, "L'algorithme aléatoire est sorti en "+this.traille.getTry()+" coups !", 
                    null, JOptionPane.INFORMATION_MESSAGE, null);
                    this.fenetre.dispose();
                }
            }
        }

        else if (randu==Direction.DROITE){
            if (this.xpos!=this.casint.length-1){     
                this.traille.incrementation();       
                if (this.casint[this.ypos][this.xpos+1]!=1){
                    for (int i = 0; i < this.casint.length; i++) {
                        for (int j = 0; j < this.casint.length; j++) {
                            if (this.casint[j][i]==4){
                                this.casint[j][i]=0;
                            }
                        }
                    }
                    if (this.casint[this.ypos][this.xpos+1]!=3){
                        this.casint[this.ypos][this.xpos+1]=4;
                    }
                    this.po.setPos(this.xpos+1, this.ypos);
                }
                if (this.casint[this.ypos][this.xpos+1]==3){
                    JOptionPane.showMessageDialog(null, "L'algorithme aléatoire est sorti en "+this.traille.getTry()+" coups !", 
                    null, JOptionPane.INFORMATION_MESSAGE, null);
                    this.fenetre.dispose();
                }
            }
        }

        else if (randu==Direction.BAS){
            if (this.ypos!=this.casint.length-1){
                this.traille.incrementation();
                if (this.casint[this.ypos+1][this.xpos]!=1){
                    for (int i = 0; i < this.casint.length; i++) {
                        for (int j = 0; j < this.casint.length; j++) {
                            if (this.casint[j][i]==4){
                                this.casint[j][i]=0;
                            }
                        }
                    }
                    if (this.casint[this.ypos+1][this.xpos]!=3){
                        this.casint[this.ypos+1][this.xpos]=4;
                    }
                    this.po.setPos(this.xpos, this.ypos+1);
                }
                if (this.casint[this.ypos+1][this.xpos]==3){
                    JOptionPane.showMessageDialog(null, "L'algorithme aléatoire est sorti en "+this.traille.getTry()+" coups !", 
                    null, JOptionPane.INFORMATION_MESSAGE, null);
                    this.fenetre.dispose();
                }
            }
        }

        else if (randu==Direction.GAUCHE){
            if (this.xpos!=0){
                this.traille.incrementation();
                if (this.casint[this.ypos][this.xpos-1]!=1){
                    for (int i = 0; i < this.casint.length; i++) {
                        for (int j = 0; j < this.casint.length; j++) {
                            if (this.casint[j][i]==4){
                                this.casint[j][i]=0;
                            }
                        }
                    }
                    if (this.casint[this.ypos][this.xpos-1]!=3){
                        this.casint[this.ypos][this.xpos-1]=4;
                    }
                    this.po.setPos(this.xpos-1, this.ypos);
                }
                if (this.casint[this.ypos][this.xpos-1]==3){
                    JOptionPane.showMessageDialog(null, "L'algorithme aléatoire est sorti en "+this.traille.getTry()+" coups !", 
                    null, JOptionPane.INFORMATION_MESSAGE, null);
                    this.fenetre.dispose();
                }
            }
        }


        Avancee ava = new Avancee();
        ava.avancer(this.casint, this.tabnel, this.fenetre);
    }
}