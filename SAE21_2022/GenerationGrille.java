import java.util.*;

/**
 * La classe <code>GenerationGrille</code> permet de génerer une grille aléatoire
 * @author Lionel Morin et Mathieu Proal
 * @version 1.19.4
 */
public class GenerationGrille {
    private int size;
    private Mode mode;
    private int[][] casint;
    public GenerationGrille(int taille,Mode mo){
        this.size=taille;
        this.mode=mo;
        casint=new int[taille][taille];
    }

    /**
     * Le constructeur génère une grille aléatoire que l'on pourra ensuite modifier
     */
    public void GenererGrille(){
        //int[][] casint = new int[this.size][this.size];
        int blanc=this.size*this.size;
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                double rand;
                rand=Math.random();
                if (rand>0.65 && blanc>2){
                    this.casint[j][i]=1;
                    blanc--;
                } else {
                    this.casint[j][i]=0;
                }
            }
        }

        int[] pos = new int[2];
        pos[0]=-1;
        pos[1]=-1;
        Random rando=new Random(); 
        int randu;
        Random rando2=new Random(); 
        int randu2;
        int k;
        while (pos[0]==-1 || pos[1]==-1){
            k=0;
            randu=rando.nextInt(this.size*this.size);
            randu2=rando2.nextInt(this.size*this.size);
            for (int i = 0; i < this.casint.length; i++) {
                for (int j = 0; j < this.casint.length; j++) {
                    if (pos[0]==-1 && randu==k && this.casint[i][j]!=1 && pos[1]!=k){
                        pos[0]=k;
                        this.casint[j][i]=2;
                    }
                    if (pos[1]==-1 && randu2==k && this.casint[i][j]!=1 && pos[0]!=k){
                        pos[1]=k;
                        this.casint[j][i]=3;
                    }
                    k++;
                }
            }
        }

        Affichage aff= new Affichage(this.mode);
        aff.afficher(this.casint);
    }

    /**
     * La méthode getTab permet de récupérer le tableau généré lors de l'utilisation de GenererGrille
     * @return le tableau contenant les paramètres de la grille
     */
    public int[][] getTab() {
        return this.casint;
    }
}