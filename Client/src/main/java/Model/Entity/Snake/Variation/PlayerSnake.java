package Model.Entity.Snake.Variation;

import Model.Entity.Food.Food;
import Model.Entity.Snake.Snake;
import Controller.MouseListenerHandler;
import Controller.MouseMotionHandler;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * La classe PlayerSnake représente le serpent contrôlé par le joueur dans le jeu.
 * Elle étend la classe de base Snake avec des fonctionnalités spécifiques au joueur.
 */
public class PlayerSnake extends Snake implements Serializable {

    /**
     * Constructeur de la classe PlayerSnake.
     *
     * @param builder Constructeur de la classe de base Snake.
     */
    public PlayerSnake(SnakeBuilder builder) {
        super(builder);
        // Ajoutez ici des initialisations spécifiques à PlayerSnake si nécessaire.
    }
}
