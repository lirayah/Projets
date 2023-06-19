
/**
 * La classe <code>CreationGrille</code> initialise la grille pour permettre à l'utilisateur de créer la grille par la suite
 * @author Mathieu Proal
 * @version 1.0
 */
public class CreationGrille {
    private int size;
    private Mode mode;
    private int[][] casint;
    
    /**
     * Le constructeur récupère la taille de la grille et l'objet Mode dont on aura besoin par la suite
     * @param taille La taille de la grille
     * @param mo L'objet Mode
     */
    public CreationGrille(int taille, Mode mo){
        this.size=taille;
        this.mode=mo;
        casint=new int[taille][taille];
    }

    /**
     * La méthode creerGrille initialise la grille avec l'entrée et la sortie situées aux extrémités
     */
    public void creerGrille(){
        int xthe=0;
        int ythe=0;
        int xarr=this.size-1;
        int yarr=this.size-1;
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                if (j==ythe && i==xthe){
                    this.casint[i][j]=2;
                } else if (j==yarr && i==xarr){
                    this.casint[i][j]=3;
                } else {
                    this.casint[i][j]=0;
                }
            }
        }
        Affichage aff= new Affichage(this.mode);
        aff.afficher(this.casint);
    }

    /**
     * La méthode getTab() permet de récupérer le tableau d'int 
     * @return le nouveau tableau d'int
     */
    public int[][] getTab(){
        return this.casint;
    }
}
