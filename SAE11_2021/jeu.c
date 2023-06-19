#include <stdio.h>
#include <stdlib.h>
#include <graph.h>
#include <time.h>
#include "images.h"
#include "jeu.h"
#include <unistd.h>
#include "cheat.h"
#include "rejouer.h"

int jeu(int position[20][4], int nb_paires,int tab[40]){
    int score=0,score2,repet;
	int pos_x,pos_y,oui;
	int i,j,g,l=0,n=0,x=0,stock_g_1,stock_g_2,sauv_pos[80];
	int repet2, nb_images;
	int a;
	int clic_x,clic_y,im_x, im_x_1, im_x_2, im_y, im_y_1, im_y_2,xpos,ypos;
	unsigned long temps=0, temps2=Microsecondes(),temps3=1;
	char tempstab[50],affichage[50],scoretab[50];
	couleur c=CouleurParComposante(0,0,0);
    ChargerImage("./Images/score.png",760,200,0,0,224,63);
    nb_images=nb_paires*2;
    score=0;
	c=CouleurParComposante(255,255,255);	
	ChoisirCouleurDessin(c);
	RemplirRectangle(850,270,50,50);
	snprintf(scoretab,50,"%d",score);
	c=CouleurParComposante(0,0,0);
	ChoisirCouleurDessin(c);
	EcrireTexte(865,310,scoretab,2);
	ChargerImage("./Images/X.png",950,15,0,0,62,63);
	for (i=0;i<80;i++){
		sauv_pos[i]=0;
	}

    while(score<nb_paires){
        temps=(Microsecondes()-temps2)/1000000;
		if(temps!=temps3){
			snprintf(tempstab,50,"%ld secondes ecoulees",temps);
			c=CouleurParComposante(0,0,0);
			ChoisirCouleurDessin(c);
			RemplirRectangle(863,100,120,20);
			c=CouleurParComposante(255,255,255);
			ChoisirCouleurDessin(c);
			EcrireTexte(867,117,tempstab,0);
		}
		temps3=temps;
        repet=0;
		im_x=0;
        im_x_1=0;
		im_x_2=0;
		im_y=0;
		im_y_1=0;
		im_y_2=0;
		while (repet<2){
			xpos=0;
			ypos=0;
			temps=(Microsecondes()-temps2)/1000000;
			if(temps!=temps3){
				snprintf(tempstab,50,"%ld secondes ecoulees",temps);
				c=CouleurParComposante(0,0,0);
				ChoisirCouleurDessin(c);
				RemplirRectangle(863,100,120,20);
				c=CouleurParComposante(255,255,255);
				ChoisirCouleurDessin(c);
				EcrireTexte(867,117,tempstab,0);
			}
			temps3=temps;

			/*Triche*/
			if(ToucheEnAttente() && Touche()==XK_t){
				n=cheat(affichage,tab, sauv_pos, im_x, im_y);
			}

			/*Clic de la souris*/
			if (SourisCliquee()==1){
				clic_x=_X;
				clic_y=_Y;
				xpos=_X;
				ypos=_Y;
				im_x=0;
				im_y=0;

				/*Pour fermer le jeu avec le bouton X*/
				if((xpos>=950 && xpos<=1002) && (ypos>=15 && ypos<=78)){
					FermerGraphique();
					return EXIT_SUCCESS;
				}
				/*Détection des coordonées x et y du clic de la souris*/
				for (pos_y=370;pos_y>=10;pos_y=pos_y-90){
					if (clic_y>=pos_y){
						if (clic_y<=pos_y+80){
							im_y=pos_y;
							if (repet==0){
								im_y_1=pos_y;
							}
							else{
								im_y_2=pos_y;
							}
							break;
						}
					}
				}
				for (pos_x=640;pos_x>=10;pos_x=pos_x-90){
					if (clic_x>=pos_x){
						if (clic_x<=pos_x+80){
							im_x=pos_x;
							if (repet==0){
								im_x_1=pos_x;
							}
							else{
								im_x_2=pos_x;
							}
							break;
						}
					}
				}
				
				/*Si les coordoonées correspondent à une image, et une image différente pour le 2e cilc*/
				if (im_x!=0 && im_y!=0 && (im_x_1!=im_x_2 || im_y_1!=im_y_2)){
					for (i=0;i<20;i++){
						for (j=0;j<2;j++){
							if (position[i][(j*2)]==im_x && position[i][(j*2+1)]==im_y){
								g=i+1;
								if (repet==0){
									stock_g_1=g;
								}
								else{
									stock_g_2=g;
								}
								snprintf(affichage,50,"Images/image%d.png",g);
								ChargerImage(affichage,im_x,im_y,0,0,80,80);
                                repet++;
							}
						}
					}
				}             
			}
		}
        
		/*Si les deux images forment une paire*/
		if (stock_g_1==stock_g_2){
			sauv_pos[l]=position[stock_g_1-1][0];
			sauv_pos[l+1]=position[stock_g_1-1][1];
			sauv_pos[l+2]=position[stock_g_1-1][2];
			sauv_pos[l+3]=position[stock_g_1-1][3];
			
			position[stock_g_1-1][0]=0;
			position[stock_g_1-1][1]=0;
			position[stock_g_1-1][2]=0;
			position[stock_g_1-1][3]=0;
			score++;
			l=l+4;
		}

		/*réaffichage des images*/
        repet2=0;
		if (score!=nb_paires){
			sleep(1);
			for (pos_y=10;pos_y<=370;pos_y=pos_y+90){
				for (pos_x=10;pos_x<=640;pos_x=pos_x+90){
					oui=0;
					for (i=0;i<l;i=i+2){
						if (sauv_pos[i]==pos_x && sauv_pos[i+1]==pos_y){
							oui=1;							
						}
					}					

					if (oui==0){
						ChargerImage("Images/image0.png",pos_x,pos_y,0,0,80,80);
					}
                    repet2++;
                    if (repet2==nb_images){
                        pos_x=750;
                        pos_y=380;
                    }
				}	
			}
		}
		if(score2!=score){
			c=CouleurParComposante(255,255,255);
			ChoisirCouleurDessin(c);
			RemplirRectangle(850,270,50,50);
			snprintf(scoretab,50,"%d",score);
			c=CouleurParComposante(0,0,0);
			ChoisirCouleurDessin(c);
			EcrireTexte(865,310,scoretab,2);
		}
		score2=score;
    }
	ChargerImage("./Images/FIN.png",250,460,0,0,399,87);
	ChargerImage("./Images/rejouer.png",760,460,0,0,226,44);
	while(1){
		if(SourisCliquee()==1){
			xpos=_X;
			ypos=_Y;
			if((xpos>=760 && xpos<=986) && (ypos>=460 && ypos<=504)){
				a=rejouer();
			}
			if((xpos>=950 && xpos<=1002) && (ypos>=15 && ypos<=78)){
				FermerGraphique();
				return EXIT_SUCCESS;
			}
		}
	}
    FermerGraphique();
	return EXIT_SUCCESS;
}