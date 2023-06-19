import java.awt.*;
import javax.swing.*;

/**
 * La classe <code>Avancee</code> permet de modifier la couleur des cases ou Thésée est passé
 * @author Lionel Morin et Mathieu Proal
 * @version 1.2
 */
public class Avancee {
    /**
     * La méthode avancer permet de modifier la couleur des cases suivant si Thésée est dessus ou s'il est passé dessus
     * @param casint le tableau contenant les informations sur où est Thésée et où il est passé
     * @param tabnel Le tableau de JPanel
     * @param fenetre La fenetre contenant le tableau de JPanel
     */
    public void avancer(int[][] casint, JPanel[] tabnel, JFrame fenetre){
        int k=0;

        for (int i = 0; i < casint.length; i++) {
            for (int j = 0; j < casint.length; j++) {
                if (casint[i][j]==0){
                    tabnel[k].setBackground(Color.WHITE);
                } else if (casint[i][j]==4){
                    tabnel[k].setBackground(Color.GREEN);
                } else if (casint[i][j]==5){
                    tabnel[k].setBackground(new Color(2, 48, 32));
                }
                fenetre.add(tabnel[k]);
                k++;
            }
        }
    }
}
