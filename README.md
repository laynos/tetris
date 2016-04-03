Team : Souhel Bemat , Jerome Wan, Hassan Gull

Builder et lancer le programme avec la commande mvn clean install && java -jar *.jar

Features de notre tetris : 
7 types de tetriminos qu'on peux deplacer vers la droite et la gauche et qu'on peut tourner
Le score actuel
Interface graphique
Suppression derniere ligne
Fin de jeu

Comment jouer avec votre Tetris : 
Flèche haut pour tourner une pièce
Flèche bas pour descendre la pièce d'un cran
Flèche droite pour déplacer la pièce vers la droite
Flèche gauche pour déplacer la pièce vers la gauche

Notre architecture est une architecture MVC (Modele - Vue - Controleur).
Le modele : cette partie est censer gerer les donnees. Pour notre Tetris, nous y trouvons donc
la majorite de nos classes car le jeu est basee sur un stockage constant des donnees que nous exploitons pour que le fait de jouer est un sens (record, defi a relever avec le temps,...).
Des classes comme BestScores.Java, Score.Java ou encore Timer.Java sont prÃ©sente dans ce package.
Vue: cette partie est censer gerer l'affichage. Pour notre Tetris, nous y trouvons les classes BoardPanel.java , Score Panel.java et View.java qui gerent l'enssemble de l'affichage
Controleur : cette partie est censer gerer la logique du code qui prend des decisions. Dans ce package nous avons qu'une seule classe nommee Controller.java qui Ã  donc pour but de prendre des decisions sur l'instant t+1 du jeux. 

Design Pattern 

Singleton	Utilise sur le tetrimino pour s'assurer qu'une seule instance de la classe existe.

Listener : KeyListener afin d'écouter les évènement utilisateur.

Facade	Utilise pour masquer le controleur dans le main. 


