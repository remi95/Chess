# Chess

Mon premier projet Android : créer un jeu qui reprend le principe des échecs, mais avec de nouveaux pions. 

## Principe de jeu

La différence de jeu fondamentale se retrouve dans le fait qu'à chaque tour, le joueur peut effectuer un déplacement et une attaque (si celle-ci est possible).   
Chaque pion a donc une portée de déplacement et d'attaque qui lui est propre.   
Durant la partie, le joueur est obligé d'effectuer une action (mouvement ou attaque) durant son tour. Si aucune attaque n'est possible, le tour sera passé automatiquement après le mouvement. Si elle est possible et qu'un mouvement a été effectué, Rien ne vous oblige a attaquer et vous pouvez passer votre tour. Attention cependant, si votre seule action est une attaque, alors vous ne pourrez pas vous déplacer par la suite, le tour sera passé automatiquement.         
Une option d'annulation du dernier mouvement est présente. Elle est possible durant le tour du joueur, si celui-ci à bougé et peut attaquer, mais décide de faire machine arrière. Attention, si aucune attaque n'est possible, le tour passe automatiquement, et il n'est alors pas possible de profiter de cette annulation de mouvement.   
Il n'y a pas de limite de temps, mais un menu de Pause est présent, offrant la possibilité de recommencer la partie ou bien de revenir au menu.    
A tout moment, vous pourrez voir combien de pions de chaque type il vous reste.

## Comment jouer 

C'est très simple. Un indicateur sous forme de ligne verte indique quel joueur doit jouer. Celui-ci n'a plus qu'a cliquer sur le pion qu'il veut, dévoilant ainsi les déplacements possibles (en vert), et les attaques possibles (en rouge). Cliquez ensuite sur ces cases de couleurs pour effectuer l'action désirée.    
Comme expliqué précédemment, utilisez les options pour annuler le dernier mouvement et passer votre tour !     
Les caractéristiques de chaque pion sont disponibles dans la partie Tutoriel accessible depuis le Menu.

## Personnalisation

Une page de Paramètres vous offre la possibilité de choisir les couleurs du plateau, mais aussi d'activer ou non l'annulation du dernier mouvement.    
Chaque joueur peut choisir un nom avant de commencer la partie.   
