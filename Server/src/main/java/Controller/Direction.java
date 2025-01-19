package Controller;

import java.io.Serializable;

/**
 * L'énumération Direction représente les différentes directions possibles dans le jeu.
 * Elle est utilisée pour indiquer le mouvement d'un objet dans une direction particulière.
 */
public enum Direction implements Serializable {
    UP,    // Direction vers le haut
    DOWN,  // Direction vers le bas
    LEFT,  // Direction vers la gauche
    RIGHT  // Direction vers la droite
}

