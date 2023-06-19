import java.util.*;
import javax.swing.*;


/**
 * La classe <code>AlgoBourre</code> sert à utiliser l'algorithme aleatoire
 * @version 123.4
 * @author Mathieu Proal et Lionel Morin
 */
public class AlgoBourre {
    private int[][] casint;
    private JFrame fenetre;
    private JPanel[] tabnel;

    /**
     * Constructeur destiné à recevoir le tableau de la composition de la grille, le tableau de JPanel et la fenetre dans laquelle on se trouve
     * 
     * @param tab Le tableau contenant les informations de la grille
     * @param fen La fenetre
     * @param tab2 Le tableau de JPanel
     */
    public AlgoBourre(int[][] tab, JFrame fen, JPanel[] tab2){
        this.casint=tab;
        this.fenetre=fen;
        this.tabnel=tab2;
    }

    /**
     * Méthode qui effectue l'algorithme aléatoire en mode automatique
     */
    public void jsuisPasBourre(){
        this.fenetre.setVisible(false);
        int total=0;
        int[] max = new int[2];
        int[] min = new int[2];
        min[0]=999;
        min[1]=0;
        max[1]=0;
        max[1]=0;
        for (int repet=0;repet<100;repet++){
            int xpos=0;
            int ypos=0;
            for (int i = 0; i < this.casint.length; i++) {
                for (int j = 0; j < this.casint.length; j++) {
                    if (this.casint[j][i]==2){
                        xpos=i;
                        ypos=j;
                    }
                }
            }

            boolean sortie=false;
            Random rando = new Random();
            int randu;
            int nb_try=0;

            while (!sortie){
                randu=rando.nextInt(4);

                if (randu==Direction.HAUT && ypos!=0){
                    if (this.casint[ypos-1][xpos]!=1){
                        ypos--;
                    }
                    nb_try++;
                    if (this.casint[ypos][xpos]==3){
                        if (nb_try>max[0]){
                            max[0]=nb_try;
                            max[1]=repet;
                        }
                        else if (nb_try<min[0]){
                            min[0]=nb_try;
                            min[1]=repet;
                        }
                        total+=nb_try;
                        sortie=true;
                    }
                }

                else if (randu==Direction.DROITE && xpos!=casint.length-1){
                    if (this.casint[ypos][xpos+1]!=1){
                        xpos++;
                    }
                    nb_try++;
                    if (this.casint[ypos][xpos]==3){
                        if (nb_try>max[0]){
                            max[0]=nb_try;
                            max[1]=repet;
                        }
                        else if (nb_try<min[0]){
                            min[0]=nb_try;
                            min[1]=repet;
                        }
                        total+=nb_try;
                        sortie=true;
                    }
                }

                else if (randu==Direction.BAS && ypos!=casint.length-1){
                    if (this.casint[ypos+1][xpos]!=1){
                        ypos++;
                    }
                    nb_try++;
                    if (this.casint[ypos][xpos]==3){
                        if (nb_try>max[0]){
                            max[0]=nb_try;
                            max[1]=repet;
                        }
                        else if (nb_try<min[0]){
                            min[0]=nb_try;
                            min[1]=repet;
                        }
                        total+=nb_try;
                        sortie=true;
                    }
                }

                else if (randu==Direction.GAUCHE && xpos!=0){
                    if (this.casint[ypos][xpos-1]!=1){
                        xpos--;
                    }
                    nb_try++;
                    if (this.casint[ypos][xpos]==3){
                        if (nb_try>max[0]){
                            max[0]=nb_try;
                            max[1]=repet;
                        }
                        else if (nb_try<min[0]){
                            min[0]=nb_try;
                            min[1]=repet;
                        }
                        total+=nb_try;
                        sortie=true;
                    }                    
                }
            }
        }
        double moyenne=total/100;
        JOptionPane.showMessageDialog(null,"Moyenne de coups: "+moyenne+System.getProperty("line.separator")+
        "Le plus petit nombre de coups est: "+min[0]+", survenu à la répétition numéro "+min[1]+System.getProperty("line.separator")+
        "Le plus grand nombre de coups est: "+max[0]+", survenu à la répétition numéro "+max[1]);
    }


    /**
     * Méthode qui effectue l'algorithme aléatoire en mode manuel
     */
    public void jsuisTotalementBourre(){
        Positions po = new Positions();
        Try t = new Try();

        for (int i = 0; i < this.casint.length; i++) {
            for (int j = 0; j < this.casint.length; j++) {
                if (this.casint[j][i]==2){
                    po.setPos(i, j);
                    this.casint[j][i]=0;
                }
            }
        }
        
        AlgoBourreMan man = new AlgoBourreMan(this.fenetre, this.casint, po, this.tabnel, t);
        man.manuel();
    }
}