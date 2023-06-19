import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
/**
 * La classe <code>Affichage</code> sert à afficher la grille a l'aide du tablau de JPanel
 * @author Mathieu Proal
 * @version 2.0
 */
public class Affichage extends JFrame {
    private Mode mode;

    /**
     * Le tableau de JPanel qui retranscrit les informations du tableau d'int (casint)
     */
    private JPanel[] tabnel;

    /**
     * 
     * @param mo Le mode utilisé plus loin dans le programme
     */
    public Affichage(Mode mo){
        super();
        this.mode=mo;
    }
    
    /**
     * La méthode afficher permet de créer le tableau de JPanel où toutes les cases noires représentent les murs,
     * les cases blanches du vide et les symboles Θ et ∩ l'entrée et la sortie
     * @param casint Le tableau contenant les inbformations de la grille
     */
    public void afficher(int casint[][]){
        int size=casint.length;
        this.tabnel = new JPanel[size*size];
        int kaze=0;
        for (int i=0;i<size;i++){
            for (int j = 0; j < size; j++) {
                this.tabnel[kaze]=new JPanel();
                Border lineborder = BorderFactory.createLineBorder(Color.black, 1); 
                this.tabnel[kaze].setBorder(lineborder);
                if (casint[i][j]==1){                    
                    this.tabnel[kaze].setBackground(Color.BLACK);
                } else {
                    this.tabnel[kaze].setBackground(Color.WHITE);
                }

                if (casint[i][j]==2){
                    JLabel lab = new JLabel("Θ");
                    this.tabnel[kaze].add(lab);
                }
                if (casint[i][j]==3){
                    JLabel lab = new JLabel("∩");
                    this.tabnel[kaze].add(lab);
                }
                kaze++;
            }
        }

        this.setSize(size*60,size*60);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GridLayout gestionnaire = new GridLayout(size,size);
        this.setLayout(gestionnaire);
        
        for (JPanel pan : this.tabnel){
            this.add(pan);
        }

        for (int i = 0; i < casint.length; i++) {
            for (int j = 0; j < casint.length; j++) {
                if (j!=(casint.length-1)){
                    System.out.print(casint[i][j]+" ");
                }
                else {
                    System.out.println(casint[i][j]);
                }
            }
        }
        
        Modif m = new Modif(this.tabnel, this.mode, casint, this);
        m.modifier();
        Virer v = new Virer(this, this.mode, casint, this.tabnel);
        v.vire();

        this.setVisible(true);
    }
}
