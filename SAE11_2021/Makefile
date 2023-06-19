CC=gcc
CFLAGS= -Wall -c -lgraph
LDFLAGS= -Wall -lgraph
EXEC=menu

jeu: main.o images.o menu.o jeu.o cheat.o rejouer.o
	$(CC) -o jeu main.o images.o menu.o jeu.o cheat.o rejouer.o $(LDFLAGS)
main.o: main.c images.h menu.h main.h
	$(CC) main.c $(CFLAGS)
images.o: images.c images.h jeu.h
	$(CC) images.c $(CFLAGS)
menu.o: menu.c menu.h
	$(CC) menu.c $(CFLAGS)
jeu.o: jeu.c jeu.h images.h cheat.h rejouer.h
	$(CC) jeu.c $(CFLAGS)
cheat.o: cheat.c cheat.h
	$(CC) cheat.c $(CFLAGS)
rejouer.o: rejouer.c rejouer.h images.h menu.h
	$(CC) rejouer.c $(CFLAGS)
run:
	./jeu