import java.io.File;

/**
 * La classe <code>ChargementGrille</code> est utilisée pour créer la grille qui contiendra les positions des murs,
 * la position de Thésée et la postion de l'arrivée
 * 
 * @version 42.0
 * @author Lionel Morin et Mathieu Proal
 */
public class ChargementGrille {
    /**
     * Objet qui contient le fichier passé en argument dans le constructeur
     */
    private File fichier;

    /**
     * Variable qui contient la taille de la grille
     */
    private int size;

    /**
     * Variable qui contient la position x de Thésée
     */
    private int xthe;

    /**
     * Variable qui contient la position y de Thésée
     */
    private int ythe;

    /**
     * Variable qui contient la position x de l'arrivée
     */
    private int xarr;

    /**
     * Variable qui contient la position y de l'arrivée
     */
    private int yarr;

    /**
     * Objet Mode qui contient le mode de départ 
     */
    private Mode mode;

    /**
     * Contructeur destiné à recevoir le fichier d'accès à la grille
     * 
     * @param f le fichier qui stocke les informations de la grille
     * @param mo le mode initial
     */
    public ChargementGrille(File f, Mode mo) {
        this.fichier = f;
        this.mode = mo;
    }

    /**
     * Méthode qui créé le tableau de valeur contenant la composition de la grille(taille, positions de Thésée et d'arrivée et la disposition des murs)
     */
    public void ChargerGrille() {
        Parametres parametres = new Parametres();
        Ouverture o = new Ouverture(parametres);
        /**
         * On récupère les paramètres de la grille (taille et positions)
         */
        o.recupParametres(this.fichier);
        this.size = parametres.getSize();
        this.xthe = parametres.getxThe();
        this.ythe = parametres.getyThe();
        this.xarr = parametres.getxArr();
        this.yarr = parametres.getyArr();
        /**
         *  On récupère les positions des cases vides et des murs
         */
        boolean[][] tabByte = o.recupByte(this.size, this.fichier);
        int[][] tabInt = new int[this.size][this.size];
        for (int i = 0; i < tabInt.length; i++) {
            for (int j = 0; j < tabInt.length; j++) {
                /**
                 * On place les cases vides et les murs
                 */
                if (tabByte[i][j] == false) {
                    tabInt[j][i] = 0;
                } else {
                    tabInt[j][i] = 1;
                }
            }
        }
        /**
         *  On place les positions de Thésée et de l'arrivée
         */
        tabInt[xthe][ythe] = 2;
        tabInt[xarr][yarr] = 3;

        /**
         * On passe à l'étape suivante
         */
        Affichage aff = new Affichage(this.mode);
        aff.afficher(tabInt);
    }
}
