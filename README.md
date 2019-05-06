# RobotFleet

## Objectifs d’apprentissage : 
Maîtriser le mécanisme de communication par événements, et s’initieraux interfaces graphiques.

## Problème proposé.
L’objectif est de programmer un logiciel permettant la gestion d’une flotte de robots en réutilisant les notions vues en cours (interface, modèle à évènement…). Une flotte de robots est composée par plusieurs robots différents. Les robots peuvent être placés dans une arène, une surface qui pourrait être apparentée à un tablier d’échec. Ils peuvent évoluer sur cette surface, et communiquer, en suivant certaines contraintes.

## Travail demandé
Trois niveaux sont proposés pour ce sujet, correspondant à trois versions du système – « à l’essentiel », « fonctionnelle », « étendue ».

## Milestone 1 : « à l’essentiel »
Dans la version « à l’essentiel », le système gère des robots relativement simples, qui peuventcommuniquer et évoluer dans leur environnement. La classe Robot permettant la représentation des robots qui possède un nom, ainsi qu’une position dans l’arène. Ajoutez des méthodes leur permettant de se déplacer, ainsi que d’envoyer des messages aux autres robots se trouvant dans l’arène. Chaque robot possède une interface graphique à partir de laquelle il est possible de changer de position, envoyer des messages vers d’autres robots, et afficher les messages reçus. La classe Flotte permet la gestion d’une flotte : l’ajout et la suppression des robots. Elle joue aussi un rôle dans la communication, car tous les messages passent par cette classe Flotte. Elle a aussi une interface graphique, qui affiche tous les robots disponibles, avec leur position. Elle permet d’afficher les communications échangées : lors de la réception d’un message de la part d’un robot, ce message est retransmis aux autres robots.

## Milestone 2 : « fonctionnelle »
Dans cette version nous enrichissons la version précédente avec les fonctionnalités suivantes :
 Les robots ne peuvent pas se déplacer dans une case déjà occupée.
 Il y a un affichage graphique de l’arène et des positions des robots dans l’arène
 Les robots peuvent se différencier dans leurs capacités : par exemple à chaque déplacement il y a un nombre déterminé de cases qu’ils peuvent avancer ; ils peuvent ou pas éviter des obstacles, etc. On peut ajouter une notion de dimension et/ou forme, ou la place occupée dans l’arène est plus ou moins importante. 

## Milestone 3 : « étendue »
Dans cette version les capacités de communication des robots limitent les messages envoyés aux
robots « compatibles » soit à cause de leur proximité soit à cause de leurs capacités particulières.
Changer le mode de communication qui ne passe plus par la flotte, mais plutôt par découverte :
chaque robot peut envoyer un message « directement » à l’ensemble des robots compatibles. Laissez
libre place à votre imagination, et rajoutez de nouvelles fonctionnalités.
Contraintes générales
L’échange de message doit être fait en utilisant le modelé à évènement.
Séparer le plus possible la parte « logique de l’application » de la partie interface graphique. 
