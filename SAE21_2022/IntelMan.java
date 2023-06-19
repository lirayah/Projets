import javax.swing.*;

/**
 * La classe <code>IntelMan</code> appelle la méthode imSmart() pour effectuer une itération de l'algorithme déterministe 
 * @author Lionel Morin
 * @version 42.0
 */
public class IntelMan {
    private AlgoIntel intel;
    private boolean sortie;

    /**
     * Le constructeur récupère la valeur de sortie et l'objet AlgoIntel pour pouvoir appeler la méthode imSmart()
     * @param i L'objet AlgoIntel
     * @param s La valeur de sortie
     */
    public IntelMan(AlgoIntel i,boolean s){
        this.intel=i;
        this.sortie=s;
    }

    /**
     * La méthode manuel(int mode) appelle la méthode imSmart() pour en faire une itération 
     * @param mode La valeur du mode manuel 
     */
    public void manuel(int mode) {
        sortie = this.intel.imSmart(this.sortie,mode);
        if(sortie){
            JOptionPane.showMessageDialog(null,"l'algorithme déterministe est sortie en "+intel.getEtapes()+" coups !");
        }
    }
}