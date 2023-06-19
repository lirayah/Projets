import javax.swing.JOptionPane;
import java.io.*;

/**
 * La classe <code>Menu</code> créée un menu pour l'utilisateur
 * @author Lionel Morin
 * @version 2.0
 */
public class Menu {
    private File fifi;
    private int taille;
    private int[][] casint;

    /**
     * Le constructeur initialise la taille et le chemin du fichier qui peut être sélectionné
     */
    public Menu(){
        this.fifi=null;
        this.taille=0;
    }

    /**
     * La méthode manu() créé le menu et demande différents paramètres à l'utilisateur
     */
    public void manu() {
        Mode mode=new Mode();
        ChoixFichier fic=new ChoixFichier();
        int i=0;
        Object[] choix={"Oui","Non"};
        int reponse = JOptionPane.showOptionDialog(null, "Voulez vous ouvrir une grille déjà existante?", 
        "Menu", JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, choix, null);
        if(reponse==0){
            this.fifi=fic.getOpenFichier();
            ChargementGrille charger=new ChargementGrille(this.fifi,mode);
            charger.ChargerGrille();
        }
        else{
            RecupNombre nombre=new RecupNombre();
            FenetreMenu fenetre = new FenetreMenu();
            RetrieveTexte recup = new RetrieveTexte(nombre, fenetre);
            while(!nombre.nombreEnvoye()){
                try {
                    Thread.sleep(100);
                } catch (Exception e) {
                    System.err.println("ça a pas supermarché");
                }
            }
            fenetre.dispose();
            this.taille=nombre.getNombre();
            int reponse2= JOptionPane.showOptionDialog(null, "Voulez-vous remplir la grille aléatoirement?", "Menu",
            JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, choix, null);
            if(reponse2==0){
                GenerationGrille gen = new GenerationGrille(this.taille,mode);
                gen.GenererGrille();
                this.casint=gen.getTab();
            }
            else{
                CreationGrille crea=new CreationGrille(this.taille,mode);
                crea.creerGrille();
                this.casint=crea.getTab();
            }
            while(mode.getMode()!=Mode.FINI){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.err.println("ça n'a pas supermarché Carrefour");
                }
            }
            int reponse3 = JOptionPane.showOptionDialog(null, "Voulez-vous sauvegarder la grille nouvellement créée?", "Menu",
            JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, choix, null);
            if(reponse3==0){
                this.fifi=fic.getSaveFichier();
                EcritureFichier ecriture=new EcritureFichier(this.fifi);
                ecriture.EcrireFichier(taille, casint);
            }
        }
    }
}
