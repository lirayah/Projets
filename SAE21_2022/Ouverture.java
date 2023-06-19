import java.io.*;
/**
 * La classe <code>Ouverture</code> est utilisée pour ouvrir la grille contenue dans le fichier donné par l'utilisateur
 * 
 * @version 2.0
 * @author Lionel Morin et Mathieu Proal
 * @since 2023
 */
public class Ouverture {
    /**
     * Objet de la classe Parametres utilisés pour mettre en place les parametres de la grille
     */
    private Parametres parametres;
    
    /**
     * Constructeur destiné à récupérer l'objet de la classe Parametres 
     * @param p L'objet de la classe Parametres
     */
    public Ouverture(Parametres p){
        this.parametres=p;
    }


    /**
     * Méthode qui lit les 5 premiers octets du fichier pour récupérer les paramètres de la grille(taille, position de Thésée et de la sortie)
     * @param fic Le fichier à lire
     */
    public void recupParametres(File fic){

        try {
            // On ouvre le flux
            FileInputStream fis = new FileInputStream(fic);
            DataInputStream dis = new DataInputStream(fis);
            try {
                // On lit le premier octet et on met à jour la taille de la grille
                int taille=dis.readUnsignedByte();
                this.parametres.setSize(taille);
                try {
                    // On lit le deuxième octet
                    int x=dis.readUnsignedByte();
                    try {
                        // On lit le 3e octet et on met à jour la position x et y de Thésée
                        int y=dis.readUnsignedByte();
                        this.parametres.setThesee(x, y);
                        try {
                            // On lit le 4e octet
                            x=dis.readUnsignedByte();
                            try {
                                // On lit le 5e octet et on met à jour la position x et y de la sortie
                                y=dis.readUnsignedByte();
                                this.parametres.setArrivee(x, y);
                            } catch (IOException e) {
                                System.err.println("Erreur lors de la lecture de la position y de l'arrivée");
                            }
                        } catch (IOException e) {
                            System.err.println("Erreur lors de la lecture de la position x de l'arrivée");
                        }
                    } catch (IOException e) {
                        System.err.println("Erreur lors de la lecture de la position y de Thésée");
                    }
                } catch (IOException e) {
                    System.err.println("Erreur lors de la lecture de la position x de Thésée");
                }
            } catch (IOException e) {
                System.err.println("Erreur lors de la lecture de la taille");
            }
            try {
                // On ferme le flux
                dis.close();
            } catch (IOException e) {
                System.err.println("Erreur lors de la fermeture");
            }
        } catch (FileNotFoundException e) {
            System.err.println("Impossible d'ouvrir le fichier, le fichier n'a pas été trouvé");
        } catch (SecurityException e) {
            System.err.println("Impossible d'ouvrir le fichier (accès refusé)");
        }
    }

    /**
     * Méthode qui lit le fichier et stocke la composition de la grille dans un tableau de booléen
     * @param taille La taille de la grille
     * @param fichier Le fichier où lire les informations
     * @return Un tableau de booléen qui contient la composition de la grille(true si mur, false si vide)
     */    
    public boolean[][] recupByte(int taille, File fichier) {
        boolean[][] tabBits=new boolean[taille][taille];
        try{
            // On ouvre le flux
            FileInputStream fis = new FileInputStream(fichier);
            DataInputStream dis = new DataInputStream(fis);
            try{
                for (int i = 0; i < 5; i++) {
                    // On lit les 5 premiers octets qui sont les paramètres de la grille et ne servent donc pas pour la création du tableau de booléen
                    dis.readUnsignedByte();
                }
                try {
                    int compteur=8;
                    // On lit le 1e octet contenant la composition de la grille
                    int nombretemp=dis.readByte();
                    int nombre=0;
                    // On inverse les bits de cet octet
                    for (int i = 0; i < 7; i++) {
                        nombre=nombre+(nombretemp&1);
                        nombretemp=nombretemp>>>1;
                        nombre=nombre<<1;
                    }
                    for (int i = 0; i < taille; i++) {
                        for (int j = 0; j < taille; j++) {
                            /**
                             * Si le compteur est arrivé à 0 alors on a finit de stocker les informations contenues dans l'octet, on remet à 0 le nombre et lit alors le suivant
                             */
                            if(compteur==0){
                                nombre=0;
                                try {
                                    nombretemp=dis.readUnsignedByte();
                                    for (int i2 = 0; i2 < 8; i2++) {
                                        // On inverse le bits de l'octet qui vient d'être lu
                                        nombre=nombre<<1;
                                        nombre=nombre+(nombretemp&1);
                                        nombretemp=nombretemp>>>1;
                                    }
                                    // On reset le compteur
                                    compteur=8;
                                } catch (IOException e) {
                                    System.err.println("Erreur de lecture des octets de la composition de la grille");
                                }
                            }
                            /** 
                             * On effectue un et bit à bit sur nombre si la comparaison et fausse alors la case est vide, on stocke donc false dans le tableau
                             */
                            if((nombre&1)==0){
                                tabBits[i][j]=false;
                            }
                            /**
                             * Sinon on met false car le bit de poids faible que l'on vient de lire est à 1, donc la case est un mur
                             */
                            else{
                                tabBits[i][j]=true;
                            }
                            nombre=nombre>>1;
                            compteur--;
                        }
                    }
                } catch (IOException e) {
                    System.err.println("Erreur de lecture du 1e octet de la composition de la grill");
                }
            } catch(IOException e) {
                System.err.println("Erreur de lecture A");
            }
            try {
                dis.close();
            } catch(IOException e) {
                System.err.println("Erreur de fermeture");
            }
        } catch(FileNotFoundException e) {
            System.err.println("Impossible de lire le fichier");
        }
        return tabBits;
    }
}