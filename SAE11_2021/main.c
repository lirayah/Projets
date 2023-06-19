#include<stdio.h>
#include<stdlib.h>
#include<graph.h>
#include "images.h"
#include "menu.h"
#include "main.h"
/*faire les includes des autres parties du programme*/


int main(void){
    InitialiserGraphique();
    CreerFenetre(0,0,1024,576);
    int nb_paires=menu();
    tirage_aleatoire(nb_paires);
}