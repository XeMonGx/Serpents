# Project Serpent

Ce si est un projet sur le jeu Slither.io.
On a réussi à faire :
 - Le déplacement du serpent avec la souris.
 - Une IA qui sait manger la nourriture et d'esquiver un ennemi.
 - La gestion de la mort, s'il meurt, il apparait à nouveau sur la map à un endroit aléatoire et génère de la nourriture en fonction de ses segments.
 - Il augmente en langueur et en diametre en fonction de la nourriture qu'il mange.
 - Le serpent est au centre de la fenêtre.
 - On a un terrain sens bordure à chaque fois qui traverse la bordure, il se téléporte a l'autre bous de la map (L'affichage n'est pas fluide).
 - Version en ligne non finie, mais commencer avec la partie client et server.
 - Les classes utilisé pour envoyer entre serveur et clients sont serialisé

### Build command :
```http
  gradle build
```
### Run client command :
```http
  java -cp Client/build/libs/Client.jar Main
```
### Run server command :
```http
  java -cp Server/build/libs/Server.jar Main
```
Github : https://github.com/XeMonGx/Serpents.git

