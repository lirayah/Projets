#include<stdlib.h>
#include<graph.h>
#include<stdio.h>
#include "menu.h"
/*nombre de paire min = 4*/

int menu(void){
    int xpos;
    int ypos;
    int i=10,j=3;
    char choix[50];
    couleur c=CouleurParComposante(255,255,255);
    ChoisirCouleurDessin(c);
	ChargerImage("Images/background.png",0,0,0,0,1024,576);
    ChargerImage("Images/Menu1.png",276,19,0,0,476,63);
    ChargerImage("Images/Menu2.png",323,250,0,0,383,44);
    ChargerImage("Images/Fleche1.png",290,253,0,0,33,39);
    ChargerImage("Images/Fleche2.png",710,253,0,0,34,39);
    ChargerImage("Images/Start.png",375,400,0,0,280,79);
    c=CouleurParComposante(255,255,255);
    ChoisirCouleurDessin(c);
    RemplirRectangle(495,320,40,40);
    while(1){
        if(i!=j){
            snprintf(choix,50,"%d",i);
            c=CouleurParComposante(255,255,255);
            ChoisirCouleurDessin(c);
            RemplirRectangle(495,320,40,40);
            c=CouleurParComposante(0,0,0);
            ChoisirCouleurDessin(c);
            EcrireTexte(500,350,choix,2);
        }
        j=i;
        if(SourisCliquee()==1){
            xpos=_X;
            ypos=_Y;
            if((xpos>=291 && xpos<=320) && (ypos>=256 && ypos<=287)){
                i--;
                if (i==0){
                    i=20;
                }
            }
            if((xpos>=714 && xpos<=739) && (ypos>=256 && ypos<=287)){
                i++;
                if(i==21){
                    i=1;
                }
            }
            if((xpos>=380 && xpos<=650) && (ypos>=402 && ypos<=473)){
                return i;
            }
        }
    }
}