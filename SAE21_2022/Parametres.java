/**
 * La classe <code>Parametres</code> récupère les paramètres de la grille tels que la taille et les positions de départ et d'arrivée
 * @author Lionel Morin
 * @version 1.3
 */
public class Parametres {
    private int taille;
    private int xThe;
    private int yThe;
    private int xArr;
    private int yArr;

    /**
     * La méthode setSize définit la taille de la grille
     * @param size La taille de la grille
     */
    public void setSize(int size){
        this.taille=size;
    }

    /**
     * La méthode setThesee définit la position de départ
     * @param x Composante x de la position de départ
     * @param y Composante y de la position de départ
     */
    public void setThesee(int x,int y) {
        this.xThe=x;
        this.yThe=y;
    }

    /**
     * La méthode setArrivee définir la position d'arrivée
     * @param x Composante x de la position d'arrivée
     * @param y Composante x de la position d'arrivée
     */
    public void setArrivee(int x, int y) {
        this.xArr=x;
        this.yArr=y;
    }

    /**
     * La méthode getSize retourne la taille de la grille
     * @return La taille de la grille
     */
    public int getSize() {
        return this.taille;
    }

    /**
     * La méthode getxThe retourne la composante x de Thésée
     * @return La composante x de Thésée
     */
    public int getxThe() {
        return this.xThe;
    }

    /**
     * La méthode getyThe retourne la composante y de Thésée
     * @return La composante y de Thésée
     */
    public int getyThe() {
        return this.yThe;
    }

    /**
     * La méthode getxArr retourne la composante x de l'arrivée
     * @return La composante x de l'arrivée
     */
    public int getxArr(){
        return this.xArr;
    }
    
    /**
     * La méthode getyArr retourne la composante y de l'arrivée
     * @return La composante y de l'arrivée
     */
    public int getyArr() {
        return this.yArr;
    }
}
