import javax.swing.*;

/**
 * La classe <code>GestionClic</code> permet de gérer dans quel mode de modification de la grille l'utilisateur est
 * @author Mathieu Proal et Lionel Morin
 * @version 13678
 */
public class GestionClic {
    private JPanel[] tabnel;
    private Mode mode;
    private JPanel sele;
    private int[][] casint;
    private JFrame fenetre;

    /**
     * Le constructeur permet de récupérer le tableau de JPanel, le tableau qui contient la constitution de la grille, le JPanel sélectionné, l'objet Mode et la fenetre où l'on est
     * @param tab le tableau de JPanel
     * @param mo L'objet Mode 
     * @param sel Le JPanel sélectionné
     * @param tabint Le tableau contenant les informations de la grille
     * @param fen La fenêtre
     */
    public GestionClic(JPanel[] tab, Mode mo, JPanel sel, int[][] tabint, JFrame fen){
        this.tabnel=tab;
        this.mode=mo;
        this.sele=sel;
        this.casint=tabint;
        this.fenetre=fen;
    }

    /**
     * La méthode gererClic contrôle ce qui doit être mis en fonction du mode dans lequel on se trouve
     */
    public void gererClic(){
        if (this.mode.getMode()==Mode.MUR_A){
            int k=0;
            for (int i = 0; i < this.casint.length; i++) {
                for (int j = 0; j < this.casint.length; j++) {
                    if (this.tabnel[k]==this.sele){
                        if (this.casint[i][j]==0){
                            this.casint[i][j]=1;
                        }
                        else if (this.casint[i][j]==1){
                            this.casint[i][j]=0;
                        }
                    }
                    k++;
                }
            }
        }

        if (this.mode.getMode()==Mode.ENTREE){
            int k=0;
            for (int i = 0; i < this.casint.length; i++) {
                for (int j = 0; j < this.casint.length; j++) {
                    if (this.tabnel[k]==this.sele){
                        if (this.casint[i][j]==0){
                            for (int m = 0; m < casint.length; m++) {
                                for (int l = 0; l < casint.length; l++) {
                                    if (this.casint[m][l]==2){
                                        this.casint[m][l]=0;
                                    }
                                }
                            }
                            this.casint[i][j]=2;
                        }
                    }
                    k++;
                }
                
            }
        }

        else if (this.mode.getMode()==Mode.SORTIE){
            int k=0;
            for (int i = 0; i < this.casint.length; i++) {
                for (int j = 0; j < this.casint.length; j++) {
                    if (this.tabnel[k]==this.sele){
                        if (this.casint[i][j]==0){
                            for (int m = 0; m < casint.length; m++) {
                                for (int l = 0; l < casint.length; l++) {
                                    if (this.casint[m][l]==3){
                                        this.casint[m][l]=0;
                                    }
                                }
                            }
                            this.casint[i][j]=3;
                        }
                    }
                    k++;
                }
                
            }
        }

        else if (this.mode.getMode()==Mode.MUR_B){
            int k=0;
            for (int i = 0; i < this.casint.length; i++) {
                for (int j = 0; j < this.casint.length; j++) {
                    if (this.tabnel[k]==this.sele){
                        if (this.casint[i][j]==0){
                            this.casint[i][j]=1;
                        }
                        else if (this.casint[i][j]==1){
                            this.casint[i][j]=0;
                        }
                    }
                    k++;
                }
                
            }
        }
        Changements ch = new Changements();
        ch.changer(this.casint, this.tabnel, this.fenetre);
    }
}
