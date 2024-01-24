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
     * @param username             Nom d'utilisateur du serpent.
     * @param screenX              Position x de l'écran du jeu.
     * @param screenY              Position y de l'écran du jeu.
     * @param mouseListenerHandler Gestionnaire des événements de la souris.
     * @param mouseMotionHandler   Gestionnaire des mouvements de la souris.
     * @param foodArrayList        Liste des objets de nourriture dans le jeu.
     * @param snakeArrayList       Liste des serpents dans le jeu.
     */
    public OtherSnake(String username, int screenX, int screenY, MouseListenerHandler mouseListenerHandler, MouseMotionHandler mouseMotionHandler, ArrayList<Food> foodArrayList, ArrayList<Snake> snakeArrayList) {
        super(username, screenX, screenY, mouseListenerHandler, mouseMotionHandler, foodArrayList, snakeArrayList);
        // Ajoutez ici des initialisations spécifiques à OtherSnake si nécessaire.
    }
}
