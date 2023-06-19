import javax.swing.*;

/**
 * La classe <code>AlgoIntel</code> est utilisée pour utiliser l'algorithme
 * déterministe de résolution du labyrinthe
 * 
 * @author Lionel Morin et Mathieu Proal
 * @version 1245
 */
public class AlgoIntel {
    private int[][] casint;
    private JFrame fenetre;
    private JPanel[] tabnel;

    private boolean sortie;

    int[][] coor;
    int[] current;

    private int pbr;
    private int count;
    private int xpos;
    private int ypos;
    private int i;
    private int check;

    /**
     * Le contructeur est destiné à recevoir le tableau de la constitution de la
     * grille, celui de JPanel pour pouvoir changer la couleur du Panel et la
     * fenetre
     * 
     * @param tab  Le tableau contenant les informations de la grille
     * @param fen  La fenetre
     * @param tab2 Le tableau de JPanel
     */
    public AlgoIntel(int[][] tab, JFrame fen, JPanel[] tab2) {
        this.casint = tab;
        this.fenetre = fen;
        this.tabnel = tab2;

        coor = new int[3][100000];
        current = new int[100000];
        
        for (int i = 0; i < this.casint.length; i++) {
            for (int j = 0; j < this.casint.length; j++) {
                if (this.casint[j][i] == 2) {
                    this.xpos = i;
                    this.ypos = j;
                }
            }
        }
        current[0] = 1;
        coor[0][0] = xpos;
        coor[1][0] = ypos;
        coor[2][0] = 0;

        this.count = 0;
        this.pbr = 0;
    }

    /**
     * La méthode imSmart() permet d'utiliser l'algorithme de résolution
     * déterministe du labyrinthe
     * 
     * @param s    Un booléen permettant de savoir si on a atteint la sortie
     * @param mode Le mode (automatique ou non)
     * @return un booléen: true si la sortie a été atteinte, false sinon
     */
    public boolean imSmart(boolean s, int mode) {
        this.sortie = s;
        if (mode == 1) {
            for (int i = 0; i < casint.length; i++) {
                for (int j = 0; j < casint.length; j++) {
                    if (casint[i][j] == 4) {
                        casint[i][j] = 5;
                    }
                }
            }
        }
        if (current[i] == 1) {
            current[i] = 0;
            xpos = coor[0][i];
            ypos = coor[1][i];

            int possible1 = 1;
            if (ypos != 0 && !sortie) { // aller en haut
                for (int j = 0; j <= count; j++) {
                    if (coor[0][j] == xpos && coor[1][j] == ypos - 1 && this.casint[ypos - 1][xpos] == 5) {
                        possible1 = 0;
                    }
                }
                if (possible1 == 1) {
                    count++;
                    if (this.casint[ypos - 1][xpos] != 1) {
                        current[count] = 1;
                        coor[0][count] = xpos;
                        coor[1][count] = ypos - 1;
                        coor[2][count] = (coor[2][i]) + 1;
                        check = this.casint[ypos - 1][xpos];
                        this.casint[ypos - 1][xpos] = 4;
                    } else {
                        current[count] = -1;
                        coor[0][count] = -1;
                        coor[1][count] = -1;
                        coor[2][count] = -1;
                    }
                }
                if (check == 3) {
                    pbr = coor[2][count];
                    sortie = true;
                }
            }

            int possible2 = 1;
            if (xpos != casint.length - 1 && !sortie) { // aller à droite
                for (int j = 0; j <= count; j++) {
                    if (coor[0][j] == xpos + 1 && coor[1][j] == ypos && this.casint[ypos][xpos + 1] == 5) {
                        possible2 = 0;
                    }
                }
                if (possible2 == 1) {
                    count++;
                    if (this.casint[ypos][xpos + 1] != 1) {
                        current[count] = 1;
                        coor[0][count] = xpos + 1;
                        coor[1][count] = ypos;
                        coor[2][count] = (coor[2][i]) + 1;
                        check = this.casint[ypos][xpos + 1];
                        this.casint[ypos][xpos + 1] = 4;
                    } else {
                        current[count] = -1;
                        coor[0][count] = -1;
                        coor[1][count] = -1;
                        coor[2][count] = -1;
                    }
                }
                if (check == 3) {
                    pbr = coor[2][count];
                    sortie = true;
                }
            }

            int possible3 = 1;
            if (ypos != casint.length - 1 && !sortie) { // aller en bas
                for (int j = 0; j <= count; j++) {
                    if (coor[0][j] == xpos && coor[1][j] == ypos + 1 && this.casint[ypos + 1][xpos] == 5) {
                        possible3 = 0;

                    }
                }
                if (possible3 == 1) {
                    count++;
                    if (this.casint[ypos + 1][xpos] != 1) {
                        current[count] = 1;
                        coor[0][count] = xpos;
                        coor[1][count] = ypos + 1;
                        coor[2][count] = (coor[2][i]) + 1;
                        check = this.casint[ypos + 1][xpos];
                        this.casint[ypos + 1][xpos] = 4;
                    } else {
                        current[count] = -1;
                        coor[0][count] = -1;
                        coor[1][count] = -1;
                        coor[2][count] = -1;
                    }
                }
                if (check == 3) {
                    pbr = coor[2][count];
                    sortie = true;
                }
            }

            int possible4 = 1;
            if (xpos != 0 && !sortie) { // aller à gauche
                for (int j = 0; j <= count; j++) {
                    if (coor[0][j] == xpos - 1 && coor[1][j] == ypos && this.casint[ypos][xpos - 1] == 5) {
                        possible4 = 0;
                    }
                }
                if (possible4 == 1) {
                    count++;
                    if (this.casint[ypos][xpos - 1] != 1) {
                        current[count] = 1;
                        coor[0][count] = xpos - 1;
                        coor[1][count] = ypos;
                        coor[2][count] = (coor[2][i]) + 1;
                        check = this.casint[ypos][xpos - 1];
                        this.casint[ypos][xpos - 1] = 4;
                    } else {
                        current[count] = -1;
                        coor[0][count] = -1;
                        coor[1][count] = -1;
                        coor[2][count] = -1;
                    }
                }
                if (check == 3) {
                    pbr = coor[2][count];
                    sortie = true;
                }
                if(possible1==0 && possible2==0 && possible3==0 && possible4==0){
                    JOptionPane.showMessageDialog(null,"L'algorithme n'a pas trouvé de sortie");
                    sortie=true;
                }
            }
        }
        if (mode == 1) {
            Avancee a = new Avancee();
            a.avancer(casint, tabnel, fenetre);
        }
        i++;
        return sortie;
    }

    /**
     * La méthode getEtapes() permet de savoir le nombre d'étapes que l'on a effectué
     * @return le nombre d'étapes
     */
    public int getEtapes() {
        return this.pbr;
    }
}
