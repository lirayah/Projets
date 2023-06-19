import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class RetrieveTexte implements ActionListener{
    private FenetreMenu fen;
    private RecupNombre recup;

    public RetrieveTexte(RecupNombre recuperateur,FenetreMenu frame){
        this.recup=recuperateur;
        this.fen=frame;
        frame.ajoutActionListener(this);
    }

    public void actionPerformed(ActionEvent event) {
        String txt=fen.recupTextField();
        try {
            int nombre = Integer.parseInt(txt);
            recup.setNombre(nombre);
        } catch (Exception e) {
            System.err.println("Bah frérot? On sait pas appuyer sur les bonnes touches?");
        }
    }
}
