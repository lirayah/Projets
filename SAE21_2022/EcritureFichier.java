import java.io.*;

/**
 * La classe <code>EcritureFichier</code> est utilisée pour écrire la grille dans un fichier
 * 
 * @version 1.0
 * @author Lionel Morin et Mathieu Proal
 * @since 2023
 */

public class EcritureFichier {
    private File fichier;

    private boolean entree;
    
    private boolean sortie;

    /**
     * Constructeur qui initialise les booléens servant pour les boucles
     * 
     * @param fifi le fichier dans lequel on va écrire
     */
    public EcritureFichier(File fifi){
        this.fichier=fifi;
        this.entree=false;
        this.sortie=false;
    }

    /**
     * Méthode qui écrit le tableau dans le fichier
     * 
     * @param taille la taille de la grille
     * @param tab le tableau de valeur représentant la grille (0 pour une case vide, 1 pour un mur, 2 pour l'entrée et 3 pour la sortie)
     */
    public void EcrireFichier(int taille, int[][] tab){
        try {
            FileOutputStream fos = new FileOutputStream(fichier);
            DataOutputStream dos = new DataOutputStream(fos);
            try {
                /**
                 * Ecriture de la taille de la grille dans le fichier
                 */
                dos.writeByte((byte)taille);
                while(!entree){
                    for (int i = 0; i < tab.length; i++) {
                        for (int j = 0; j < tab.length; j++) {
                            if(tab[i][j]==2){
                                try {
                                    /**
                                     * Ecriture de la première coordonnée de l'entrée
                                     */
                                    dos.writeByte((byte)i);
                                    try {
                                        /**
                                         * Ecriture de la deuxième coordonnée de l'entrée
                                         */
                                        dos.writeByte((byte)j);
                                        /**
                                         * On remet la case de l'entrée à 0 pour pouvoir écrire ensuite dans le fichier les valeurs des cases (mur ou non)
                                         */
                                        tab[i][j]=0;
                                        entree=true;
                                    } catch (IOException e) {
                                    System.err.println("Erreur d'écriture de la position y de l'entrée");
                                    }
                                } catch (IOException e) {
                                    System.err.println("Erreur d'écriture de la position x de l'entrée");
                                }
                            }
                        }
                    }
                }
                while(!sortie){
                    for (int i = 0; i < tab.length; i++) {
                        for (int j = 0; j < tab.length; j++) {
                            if(tab[i][j]==3){
                                try {
                                    /**
                                     * Ecriture de la première coordonnée de la sortie
                                     */
                                    dos.writeByte((byte)i);
                                    try {
                                        /**
                                         * Ecriture de la deuxième coordonnée de la sortie
                                         */
                                        dos.writeByte((byte)j);    
                                        /**
                                         * On remet la case de la sortie à 0 pour pouvoir écrire ensuite dans le fichier les valeurs des cases (mur ou non)
                                         */
                                        tab[i][j]=0;
                                        sortie=true;
                                    } catch (IOException e) {
                                        System.err.println("Erreur d'écriture de la position y de la sortie");
                                    }
                                } catch (IOException e) {
                                    System.err.println("Erreur d'écriture de la position x de la sortie");
                                }
                            }
                        }
                    }
                }

                int somme=0;
                int compteur=0;
                for (int i = 0; i < tab.length; i++) {
                    for (int j = 0; j < tab.length; j++) {
                        if(compteur==8){ 
                            /**
                             * Si le compteur est arrivé à 8 alors on écrire la valeur de la somme dans le fichier (car un byte est un octet)
                             */
                            compteur=0;
                            try {
                                dos.writeByte((byte)somme);     //transtypage de somme en byte car un int est codé sur 4 octets     
                                somme=0;                        //on réinitialise somme pour la suite
                            } catch (IOException e) {
                                System.err.println("Erreur lors de l'écriture des cases");
                            }
                        }
                        if(tab[j][i]==1){ 
                            /** si la case du tableau est égale à 1, cela signifie que la case est un mur et Thésée na peut pas passer dessus,
                            * alors on effectue un décalage vers la gauche de somme ce qui a comme conséquence de rajouter un 0 à la fin 
                            * de la suite de 8 bits 0 que l'on modifie en 1 pour signifier la présence d'un mur */
                            somme=somme<<1;
                            somme++;
                        }
                        else if(tab[j][i]==0){
                            /**
                             * Si la case du tableau est égale à 0, cela signifie que Thésée peut aller dessus, on effectue alors juste un décalage
                             * vers la gauche de somme pour ajouter un 0 à la fin de l'octet pour signifier la non présence de mur.
                             */
                            somme=somme<<1;
                        }
                        compteur++;
                    }
                }
                if(compteur>0){
                    /**
                     * On entre dans cette condition si et seulement si le compteur est supérieur à 0, c'est a dire qu'on est arrivé à la fin du tableau
                     * et que l'on a pas pu écrire les dernières cases de la grille, on décale alors le nombre de fois qu'il faut pour arriver à un octet complet
                     * et on écrit cet octet dans le fichier
                     */
                    for(int c=compteur;c<8;c++){
                        somme=somme<<1;
                    }
                    try {
                        dos.writeByte((byte)somme);
                    } catch (IOException e) {
                        System.err.println("Erreur lors de l'écriture des cases");
                    }
                }
                try {
                    dos.close(); //Fermeture du fichier
                } catch (IOException e) {
                    System.err.println("Erreur de fermeture du fichier");
                }
            } catch (IOException e) {
                System.err.println("Erreur d'écriture pour la taille de la grille");
            }
        } catch (FileNotFoundException e) {
            System.err.println("Impossible d'ouvrir le fichier, le fichier n'a pas été trouvé");
        } catch(SecurityException s){
            System.err.println("Impossible d'ouvrir le fichier (accès refusé)");
        }
    }
}