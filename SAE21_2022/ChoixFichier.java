import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.awt.HeadlessException;

/**
 * La classe <code>ChoixFichier</code> est utilisée pour permettre à l'utilisateur de selectionner un fichier
 * suivant s'il souhaite en ouvrir un ou sauvegarder la grille dedans.
 * 
 * @version 1.42
 * @author Lionel Morin
 */
public class ChoixFichier {

    /**
     * Méthode qui permet à l'utilisateur de choisir le fichier à ouvrir et renvoie le fichier sélectionné
     * 
     * @return le fichier sélectionné (chemin du fichier)
     */
    public File getOpenFichier(){
        JFileChooser jfc = new JFileChooser("./");
        File fic=null;
        try {
            int returnValue = jfc.showOpenDialog(null);
            if(returnValue == JFileChooser.APPROVE_OPTION){
                fic = jfc.getSelectedFile();
            }
            else if(returnValue == JFileChooser.CANCEL_OPTION){
                try {
                    JOptionPane.showMessageDialog(null, "Relancez le programme et choisissez un fichier");
                } catch (HeadlessException e) {
                    System.err.println("Lancez ce programme dans un environnement graphique");
                }
            }
            else if(returnValue == JFileChooser.ERROR_OPTION){
                try {
                    JOptionPane.showMessageDialog(null, "Une erreur est survenue lors du choix du fichier");
                } catch (HeadlessException e) { 
                    System.err.println("Lancez ce programme dans un environnement graphique");
                }
            }
        } catch (HeadlessException e) {
            System.err.println("Lancez ce programme dans un environnement graphique");
        }
        return fic;
    }

    /**
     * Méthode qui permet à l'utilisateur de choisir le fichier dans lequel sauvegarder la grille et renvoie le fichier sélectionné
     * 
     * @return le fichier sélectionné (chemin du fichier)
     */
    public File getSaveFichier() {
        JFileChooser jfc = new JFileChooser("./");
        File fic=null;
        try{
            int returnValue = jfc.showSaveDialog(null);
            if(returnValue == JFileChooser.APPROVE_OPTION){
                fic = jfc.getSelectedFile();
            }
            else if(returnValue == JFileChooser.CANCEL_OPTION){
                try {
                    JOptionPane.showMessageDialog(null, "Relancez le programme et choisissez un fichier");
                } catch (HeadlessException e) {
                    System.err.println("Lancez ce programme dans un environnement graphique");
                }
            }
            else if(returnValue == JFileChooser.ERROR_OPTION){
                try {
                    JOptionPane.showMessageDialog(null, "Une erreur est survenue lors du choix du fichier");
                } catch (HeadlessException e) { 
                    System.err.println("Lancez ce programme dans un environnement graphique");
                }
            }
        } catch (HeadlessException e){
            System.err.println("Lancez ce programme dans un environnement graphique");
        }
        return fic;
    }
}