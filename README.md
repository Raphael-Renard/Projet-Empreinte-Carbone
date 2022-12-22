# Projet-Empreinte-Carbone

Votre projet devra également contenir un chier ReadMe présentant succinctement votre projet et détaillant les instructions à réaliser pour le compiler, l’exécuter, puis l’utiliser.

Le projet implémente un calculateur d'empreinte carbone. Il est contenu dans 2 package : consoCarbone et users. Le premiers package contient les classes détaillant les différentes consommations possibles, le second contient les classes utilisants les premières pour créer un utilisateur avec plusieurs consommations et gérer celles-ci.


Pour la compilation du projet utiliser éclipse et exécuter le code directement ou compiler avec la commande :
	javac ./Projet-Empreinte-Carbone
Pour exécuter le programme on exécute le fichier Main.java du package users avec éclipse ou avec la commande
	java ./Projet-Empreinte-Carbone/users/Main.java
Poue exécuter les Test Junits il faut soit exécute sur éclipse avec run as JUnits Test ou exécuter la commande : 
	java org.junit.runner.JUnitCore LogementTest BienConsoTest
	
Pour utiliser le programme il faut suivre les instructions qui s'affichent sur la console. 

Pour créer un utilisateur à partir d'un fichier il  faut que le fichier soit de la forme : 

taux de repas à base de boeuf (entre 0 et 1)

taux de repas végétarien (entre 0 et 1)

produits de saison ? (Y/n)

produits locaux ? (Y/n)

kg de nourriture gaspillée par an

courses en vrac ? (Y/n)

courses dans des e-commerces ? (Y/n)

dépenses annuelles

nombre d'appartements

superficie

classe énergétique

[répéter autant de fois qu'il y a de logements]

nombre de voitures

taille de la voiture

nb de km parcourus par an

durée de conservation du véhicule

émissions nécessaires à la fabrication de la voiture

[répéter autant de fois qu'il y a de voitures]


Par exemple le fichier test.txt créer un utilisateur avec 1 Logement et 2 voitures. Le fichier test.txt se trouve avec le chemin ./Projet-Empreinte-Carbone/test.txt