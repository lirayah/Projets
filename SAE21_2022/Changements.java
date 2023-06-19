import java.awt.*;
import javax.swing.*;

/**
 * La classe <code>Changements</code> permet de modifier l'affichage de la grille lorsque l'utilisateur modifie des cases
 * @author Mathieu Proal
 * @version 1.0
 */
public class Changements {

    /**
     * La méthode changer 
     * @param casint Le tableau contenant les informations de la grille
     * @param tabnel Le tableau de JPanel
     * @param fenetre La fenetre contenant le tableau de JPanel
     */
    public void changer(int[][] casint, JPanel[] tabnel, JFrame fenetre){
        int k=0;

        for (int i = 0; i < casint.length; i++) {
            for (int j = 0; j < casint.length; j++) {
                if (casint[i][j]==0){
                    if (tabnel[k].getComponentCount()!=0){
                        Component[] compo = new Component[1];
                        compo=tabnel[k].getComponents();
                        tabnel[k].remove(compo[0]);
                        tabnel[k].repaint();
                    }
                    tabnel[k].setBackground(Color.WHITE);
                } 

                else if (casint[i][j]==1){
                    if (tabnel[k].getComponentCount()!=0){
                        Component[] compo = new Component[1];
                        compo=tabnel[k].getComponents();
                        tabnel[k].remove(compo[0]);
                        tabnel[k].repaint();
                    }
                    tabnel[k].setBackground(Color.BLACK);
                }

                else if (casint[i][j]==2){
                    if (tabnel[k].getComponentCount()==0){
                        JLabel lab = new JLabel("Θ");
                        tabnel[k].add(lab);
                    }
                }

                else if (casint[i][j]==3){
                    if (tabnel[k].getComponentCount()==0){
                        JLabel lab = new JLabel("∩");
                        tabnel[k].add(lab);
                    }
                }

                fenetre.add(tabnel[k]);
                k++;
            }
        }
        fenetre.setVisible(true);
    }
}
