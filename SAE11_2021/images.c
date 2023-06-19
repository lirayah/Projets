#include <stdio.h>
#include <stdlib.h>
#include <graph.h>
#include <time.h>
#include "images.h"
#include <unistd.h>
#include "jeu.h"

int tirage_aleatoire(int nb_paires){
	char tirage[50];
	int pos_x, pos_y;
	int i, j;
	int nb,score;
	int tab[40];
	int positions[20][4];
	
	ChargerImage("Images/background.png",0,0,0,0,1024,576);
	
	/*Initialisation des tableaux*/
	for (i=0;i<20;i++){
		for (j=0;j<4;j++){
			positions[i][j]=0;
		}
	}
	for (i=0;i<40;i++){
		tab[i]=-1;
	}
	
	/*Tirage des images*/
	srand(time(NULL));
	for (i=0;i<2;i++){
		for (j=0;j<nb_paires;j++){
			nb=rand()%(nb_paires*2);
			if (tab[nb]!=-1){
				j--;
			}
			else{
				tab[nb]=j;
			}
		}
	}
	
	/*Affichage des images*/
	srand(time(NULL));
	i=0;
	for (pos_y=10;pos_y<=370;pos_y=pos_y+90){
		for (pos_x=10;pos_x<=640;pos_x=pos_x+90){
			if (tab[i]==-1){
				pos_x=650;
				pos_y=1000;
			}
			 if (positions[tab[i]][0]==0){
				positions[tab[i]][0]=pos_x;
				positions[tab[i]][1]=pos_y;
			}
			else{
				positions[tab[i]][2]=pos_x;
				positions[tab[i]][3]=pos_y;
			}
			ChargerImage("Images/image0.png",pos_x,pos_y,0,0,80,80);
			
			i++;
		}
	}
	score=jeu(positions, nb_paires,tab);
}
