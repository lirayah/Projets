import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * La classe <code>FenetreMenu</code> sert à ouvrir une fenêtre pour demander à l'utilisateur la taille de la grille souhaité
 * @author Lionel Morin
 * @version 1.1
 */
public class FenetreMenu extends JFrame{
    private JTextField nombre;
    private JButton ok;

    /**
     * Le constructeur définit les éléments qui sont dans la fenêtre
     */
    public FenetreMenu(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.setSize(200,150);
        Dimension d= java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        int y =(int)d.getHeight()/2;
        int x = (int) d.getWidth()/2;
        this.setLocation(x,y);

        JLabel texte = new JLabel("Taille de la grille: ");
        this.add(texte);

        this.nombre = new JTextField(10);
        this.add(nombre);

        this.ok = new JButton("Envoyer");
        this.add(ok);

        this.setVisible(true);
    }

    /**
     * La méthode recupTextField récupère la chaine de caractère donnée par l'utilisateur dans le JTextField
     * @return La chaine de caractère donnée par l'utilisateur dans le JTextField
     */
    public String recupTextField(){
        return this.nombre.getText();
    }

    /**
     * La méthode ajoutActionListener ajoute un actionListener sur le bouton "Envoyer"
     * @param l un ActionListener
     */
    public void ajoutActionListener(ActionListener l){
        this.ok.addActionListener(l);
    }
    
}
