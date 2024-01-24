package Model.Entity.Snake;

import java.awt.*;
import java.io.Serializable;

/**
 * La classe SnakeBody représente un segment du corps du serpent dans le jeu.
 */
public class SnakeBody extends Segment implements Serializable {

    /**
     * Constructeur de la classe SnakeBody.
     *
     * @param position Position initiale du segment.
     * @param size     Taille du segment.
     * @param speed    Vitesse du segment.
     * @param color    Couleur du segment.
     */
    public SnakeBody(Point position, int size, int speed, Color color) {
        super(position, size, speed, color, true);
    }

    /**
     * Méthode pour déplacer le segment du corps du serpent.
     *
     * @param previous Position du segment précédent.
     * @param windowDis Dimensions de la fenêtre du jeu.
     */
    @Override
    public void move(Point previous, Point windowDis) {
        double distanceX = previous.getX() - this.getPosition().x;
        double distanceY = previous.getY() - this.getPosition().y;

        double vec = Math.sqrt(distanceX * distanceX + distanceY * distanceY);

        if (vec > this.getGap()) {
            double movementX = distanceX / vec;
            double movementY = distanceY / vec;

            int newPosX = (int) Math.round(this.getPosition().x + movementX * (vec - this.getGap()));
            int newPosY = (int) Math.round(this.getPosition().y + movementY * (vec - this.getGap()));

            // Assurez-vous que la nouvelle position reste dans les limites du monde sinon il se téléporte.
            if (newPosX >= 2048 || newPosX <= -2048) {
                newPosX = -newPosX;
            }
            if (newPosY >= 2048 || newPosY <= -2048) {
                newPosY = -newPosY;
            }

            this.setPosition(newPosX, newPosY);
        }
    }
}
