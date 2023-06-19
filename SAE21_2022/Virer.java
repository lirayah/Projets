import javax.swing.*;

public class Virer {
    private Touche t;
    private int i;
    private JFrame fenetre;

    public Virer(JFrame fen, Mode mode, int[][] casint, JPanel[] tabnel){
        this.fenetre=fen;
        this.t=new Touche(mode, casint, this.fenetre, tabnel);        
    }

    public int vire(){
        this.fenetre.addKeyListener(this.t);
        i = t.co();
        return i;
    }
}
