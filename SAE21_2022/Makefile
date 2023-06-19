### VARIABLES ###
JC = javac
JCFLAGS = -encoding UTF-8 -implicit:none
JVM = java
JVMFLAGS = 

### RULES COMPILATION ###
MainClass.class : MainClass.java Menu.class
	${JC} ${JCFLAGS} MainClass.java

Ouverture.class : Ouverture.java Parametres.class
	${JC} ${JCFLAGS} Ouverture.java

ChoixFichier.class : ChoixFichier.java
	${JC} ${JCFLAGS} ChoixFichier.java

ChargementGrille.class : ChargementGrille.java Ouverture.class Affichage.class Parametres.class
	${JC} ${JCFLAGS} ChargementGrille.java

Affichage.class : Affichage.java Mode.class Modif.class Virer.class
	${JC} ${JCFLAGS} Affichage.java

ChoixAlgo.class : ChoixAlgo.java AlgoBourre.class AlgoIntel.class AlgoIntelKey.class
	${JC} ${JCFLAGS} ChoixAlgo.java

AlgoBourre.class : AlgoBourre.java Positions.class Try.class AlgoBourreMan.class
	${JC} ${JCFLAGS} AlgoBourre.java

AlgoBourreKey.class : AlgoBourreKey.java AlgoBourreManAction.class
	${JC} ${JCFLAGS} AlgoBourreKey.java

AlgoBourreMan.class : AlgoBourreMan.java AlgoBourreKey.class
	${JC} ${JCFLAGS} AlgoBourreMan.java

AlgoBourreManAction.class : AlgoBourreManAction.java Positions.class Try.class Avancee.class
	${JC} ${JCFLAGS} AlgoBourreManAction.java

Try.class : Try.java
	${JC} ${JCFLAGS} Try.java

Positions.class : Positions.java
	${JC} ${JCFLAGS} Positions.java

AlgoIntel.class : AlgoIntel.java Avancee.class
	${JC} ${JCFLAGS} AlgoIntel.java

AlgoIntelKey.class : AlgoIntelKey.java IntelMan.class
	${JC} ${JCFLAGS} AlgoIntelKey.java

IntelMan.class : IntelMan.java AlgoIntel.class
	${JC} ${JCFLAGS} IntelMan.java

Avancee.class : Avancee.java
	${JC} ${JCFLAGS} Avancee.java

Mode.class : Mode.java
	${JC} ${JCFLAGS} Mode.java

CreationGrille.class : CreationGrille.java Affichage.class
	${JC} ${JCFLAGS} CreationGrille.java

GenerationGrille.class : GenerationGrille.java Affichage.class
	${JC} ${JCFLAGS} GenerationGrille.java 

Virer.class : Virer.java Touche.class ChoixAlgo.class
	${JC} ${JCFLAGS} Virer.java 

Touche.class : Touche.java
	${JC} ${JCFLAGS} Touche.java 

Modif.class : Modif.java Detect.class
	${JC} ${JCFLAGS} Modif.java

Detect.class : Detect.java GestionClic.class
	${JC} ${JCFLAGS} Detect.java

GestionClic.class : GestionClic.java Changements.class
	${JC} ${JCFLAGS} GestionClic.java

Changements.class : Changements.java
	${JC} ${JCFLAGS} Changements.java
	
Parametres.class : Parametres.java
	${JC} ${JCFLAGS} Parametres.java

Menu.class : Menu.java RecupNombre.class FenetreMenu.class RetrieveTexte.class GenerationGrille.class ChargementGrille.class CreationGrille.class ChoixFichier.class EcritureFichier.class
	${JC} ${JCFLAGS} Menu.java

FenetreMenu.class : FenetreMenu.java
	${JC} ${JCFLAGS} FenetreMenu.java

RecupNombre.class : RecupNombre.java
	${JC} ${JCFLAGS} RecupNombre.java

RetrieveTexte.class : RetrieveTexte.java RecupNombre.class FenetreMenu.class
	${JC} ${JCFLAGS} RetrieveTexte.java

EcritureFichier.class : EcritureFichier.java
	${JC} ${JCFLAGS} EcritureFichier.java

### RULES EXECUTION ###
run : MainClass.class
	${JVM} ${JVMFLAGS} MainClass

clean :
	-rm -f *.class

mrproper : clean MainClass.class

### BUTS FACTICES ###
.PHONY : run clean mrproper

### FIN ###