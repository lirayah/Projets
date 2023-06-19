/**
 * La classe <code>Positions</code> sert à stocker les coordonnées x et y de la case courante
 * @author Mathieu Proal
 * @version 1.0
 */
public class Positions {
    public int[] tab;

    /**
     * Le constructeur initialise un tableau
     */
    public Positions() {
        tab = new int[2];
    }

    /**
     * La méthode getPos sert à récupérer les composantes x et y de la case courante
     * @param i Si on veut le x ou le y
     * @return L
     */
    public int getPos(int i) {
        return this.tab[i];
    }

    /**
     * 
     * @return
     */
    public int[] getTab() {
        return this.tab;
    }

    public void setPos(int posx, int posy) {
        this.tab[0] = posx;
        this.tab[1] = posy;
    }
}
