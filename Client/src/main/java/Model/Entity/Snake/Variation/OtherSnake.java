package Model.Entity.Snake.Variation;

import Model.Entity.Food.Food;
import Model.Entity.Snake.Snake;
import Controller.MouseListenerHandler;
import Controller.MouseMotionHandler;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * La classe OtherSnake représente les autres serpent dans le jeu.
 * Elle étend la classe de base Snake avec des fonctionnalités spécifiques.
 */
public class OtherSnake extends Snake implements Serializable {

    /**
     * Constructeur de la classe OtherSnake.
     *
     * @param builder Constructeur de la classe de base Snake.
     */
    public OtherSnake(SnakeBuilder builder) {
        super(builder);
        // Ajoutez ici des initialisations spécifiques à OtherSnake si nécessaire.
    }
}
