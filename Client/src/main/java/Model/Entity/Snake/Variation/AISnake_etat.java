package Model.Entity.Snake.Variation;

import java.io.Serializable;

/**
 * L'énumération AISnake_etat représente les états possibles pour le comportement de l'IA Snake.
 */
public enum AISnake_etat implements Serializable {
    /**
     * État de chasse où l'IA Snake poursuit un serpent ennemi.
     */
    CHASSE,

    /**
     * État de fuite où l'IA Snake essaie d'éviter une menace.
     */
    FUIR,

    /**
     * État de manger où l'IA Snake se dirige vers la nourriture pour la consommer.
     */
    MANGER
}
