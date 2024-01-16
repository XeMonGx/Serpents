package Vue.Entity.Snake;

import Controller.Camera;
import Model.Entity.Snake.Snake;
import Model.Entity.Snake.Variation.AISnake;

import java.awt.*;

/**
 * La classe SnakeGraphics est responsable du dessin d'un serpent sur l'écran.
 */
public class SnakeGraphics {

    private Snake snake; // Le serpent à dessiner.
    private final Camera camera; // La caméra utilisée pour suivre le déplacement dans le monde.

    /**
     * Constructeur de la classe SnakeGraphics.
     *
     * @param snake  Le serpent à dessiner.
     * @param camera La caméra utilisée pour suivre le déplacement dans le monde.
     */
    public SnakeGraphics(Snake snake, Camera camera) {
        this.snake = snake;
        this.camera = camera;
    }

    /**
     * Met à jour l'état du serpent.
     */
    public void update() {
        if (snake instanceof AISnake) {
            snake.update();
        }
    }

    /**
     * Dessine le serpent sur l'écran en utilisant le contexte graphique spécifié.
     *
     * @param g2 Le contexte graphique 2D utilisé pour dessiner.
     */
    public void draw(Graphics2D g2) {
        for (int i = snake.getSnake().size() - 1; i >= 0; i--) {
            // Convertir les coordonnées mondiales en coordonnées d'écran.
            int screenX = snake.getSnake().get(i).getPosition().x - camera.getWorldX() + camera.getScreenX() - (snake.getSnake().get(i).getSize() / 2);
            int screenY = snake.getSnake().get(i).getPosition().y - camera.getWorldY() + camera.getScreenY() - (snake.getSnake().get(i).getSize() / 2);

            // Dessiner le cercle extérieur du serpent.
            g2.setColor(Color.white);
            g2.fillOval(screenX, screenY, snake.getSnake().get(i).getSize(), snake.getSnake().get(i).getSize());

            // Dessiner le cercle intérieur du serpent.
            g2.setColor(snake.getSnake().get(i).getColor());
            g2.fillOval(screenX + 3, screenY + 3, snake.getSnake().get(i).getSize() - 6, snake.getSnake().get(i).getSize() - 6);
        }
    }
}
