#include <stdio.h>
#include <stdlib.h>
#include <graph.h>
#include "cheat.h"

int cheat(char affichage[50],int tab[40], int sauv_pos[80], int im_x, int im_y){
    int x,n,pos_x,pos_y;
	int i, oui;
    while(n<1){
        x=0;
        for (pos_y=10;pos_y<=370;pos_y=pos_y+90){
			for (pos_x=10;pos_x<=640;pos_x=pos_x+90){
				if (tab[x]==-1){
					pos_x=650;
					pos_y=1000;
                }
                snprintf(affichage,50,"Images/image%d.png",(tab[x]+1));
				ChargerImage(affichage,pos_x,pos_y,0,0,80,80);
				x++;
            }
        }
		if(ToucheEnAttente() && Touche()==XK_t){
			x=0;
			for (pos_y=10;pos_y<=370;pos_y=pos_y+90){
			    for (pos_x=10;pos_x<=640;pos_x=pos_x+90){
				    if (tab[x]==-1){
						pos_x=650;
						pos_y=1000;
                    }									
					oui=0;
					for (i=0;i<80;i=i+2){
						if ((sauv_pos[i]==pos_x && sauv_pos[i+1]==pos_y) || (im_x==pos_x && im_y==pos_y)){
							oui=1;
						}
					}					

					if (oui==0){
						ChargerImage("Images/image0.png",pos_x,pos_y,0,0,80,80);
					}
					x++;
                }
            }
            n=1;
		}
	}
    return n;
}