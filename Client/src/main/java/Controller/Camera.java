package Controller;

import Model.Entity.Snake.Snake;

import java.io.Serializable;

/**
 * La classe Camera représente la caméra qui suit le serpent dans le jeu.
 * Elle permet de définir la portion de l'écran à afficher en fonction de la position du serpent.
 */
public class Camera implements Serializable {

    private Snake snake; // Le serpent suivi par la caméra.
    private final int screenX; // La moitié de la largeur de l'écran.
    private final int screenY; // La moitié de la hauteur de l'écran.

    /**
     * Constructeur de la classe Camera.
     *
     * @param snake      Le serpent à suivre.
     * @param screenWidth  Largeur de l'écran du jeu.
     * @param screenHeight Hauteur de l'écran du jeu.
     */
    public Camera(Snake snake, int screenWidth, int screenHeight) {
        this.snake = snake;
        this.screenX = screenWidth / 2;
        this.screenY = screenHeight / 2;
    }

    /**
     * Renvoie la moitié de la hauteur de l'écran.
     *
     * @return La moitié de la hauteur de l'écran.
     */
    public int getScreenY() {
        return screenY;
    }

    /**
     * Renvoie la moitié de la largeur de l'écran.
     *
     * @return La moitié de la largeur de l'écran.
     */
    public int getScreenX() {
        return screenX;
    }

    /**
     * Renvoie la position x du serpent suivi par la caméra.
     *
     * @return La position x du serpent.
     */
    public int getWorldX() {
        return snake.getSnake().get(0).getPosition().x;
    }

    /**
     * Renvoie la position y du serpent suivi par la caméra.
     *
     * @return La position y du serpent.
     */
    public int getWorldY() {
        return snake.getSnake().get(0).getPosition().y;
    }
}
