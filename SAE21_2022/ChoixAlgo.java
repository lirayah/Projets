import javax.swing.*;

/**
 * La classe <code>ChoixAlgo</code> permet de demander à l'utilisateur l'algorithme qu'il veut pour résoudre le labyrinthe
 * @author Mathieu Proal et Lionel Morin
 * @version 1.3
 */
public class ChoixAlgo {
    private int[][] casint;
    private JFrame fenetre;
    private JPanel[] tabnel;
    private boolean sortie;

    /**
     * Le constructeur permet de recevoir les tableaux qui représentent la grille et la fenetre
     * @param tab le tableau représentant la grille 
     * @param fen la fenetre
     * @param tab2 le tableau de JPanel représentant graphiquement la grille
     */
    public ChoixAlgo(int[][] tab, JFrame fen, JPanel[] tab2){
        this.casint=tab;
        this.fenetre=fen;
        this.tabnel=tab2;
        this.sortie=false;
    }


    /**
     * La méthode anneHidalgo permet  ̷d̷'̷é̷n̷e̷r̷v̷e̷r̷ ̷l̷e̷s̷ ̷p̷a̷r̷i̷s̷i̷e̷n̷s̷  de choisir l'algorithme que l'on va utiliser pour la suite
     */
    public void anneHidalgo(){
        Object[] choix={"Aléatoire","Déterministe"};
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            System.err.println("Problème de dodo?");
        }
        int question = JOptionPane.showOptionDialog(null, "Voulez-vous utiliser l'algorithme aléatoire ou le déterministe ?", null,
        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, choix, null);
        Object[] choix2={"Automatique","Manuel"};
        int question2 = JOptionPane.showOptionDialog(null, "Voulez-vous utiliser l'algorithme "+choix[question]+" en mode automatique ou manuel ?", null,
        JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, choix2, null);
        if (question==0){
            AlgoBourre msieurlagent=new AlgoBourre(this.casint, this.fenetre, this.tabnel);
            if (question2==0){
                msieurlagent.jsuisPasBourre();
            }
            else {
                msieurlagent.jsuisTotalementBourre();
            }
        }
        else {
            AlgoIntel msieurlprof=new AlgoIntel(this.casint, this.fenetre, this.tabnel);
            if (question2==0){
                int mode=0;
                while(!sortie)
                    sortie = msieurlprof.imSmart(sortie,mode);
                JOptionPane.showMessageDialog(null,"L'algorithme déterministe est sorti en "+msieurlprof.getEtapes()+" étapes");
            }
            else {
                int mode=1;
                AlgoIntelKey key=new AlgoIntelKey(sortie,msieurlprof,mode);
                this.fenetre.addKeyListener(key);
            }
        }
    }
}