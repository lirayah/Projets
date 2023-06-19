/**
 * La classe <code>MainClass</code> est la classe appellant la méthode principale
 * @author Lionel Morin et Mathieu Proal
 */
public class MainClass {
    /**
     * La méthode main appelle la méthode manu() pour pouvoir commencer le programme
     * @param args
     */
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.manu();
    }
}