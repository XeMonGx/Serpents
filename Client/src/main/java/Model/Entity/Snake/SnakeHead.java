package Model.Entity.Snake;

import java.awt.*;
import java.io.Serializable;

/**
 * La classe SnakeHead représente la tête du serpent dans le jeu.
 */
public class SnakeHead extends Segment implements Serializable {

    /**
     * Constructeur de la classe SnakeHead.
     *
     * @param position Position initiale de la tête du serpent.
     * @param size     Taille de la tête du serpent.
     * @param speed    Vitesse de déplacement de la tête du serpent.
     * @param color    Couleur de la tête du serpent.
     */
    public SnakeHead(Point position, int size, int speed, Color color) {
        super(position, size, speed, color, false);
    }

    /**
     * Méthode pour déplacer la tête du serpent vers la position de la souris.
     *
     * @param mousePos   Position de la souris.
     * @param windowDim  Dimensions de la fenêtre du jeu.
     */
    @Override
    public void move(Point mousePos, Point windowDim) {

        // Convertir la position de la souris en coordonnées du monde (compte tenu de la fenêtre du jeu)
        int worldPosX = mousePos.x - windowDim.x + this.getPosition().x;
        int worldPosY = mousePos.y - windowDim.y + this.getPosition().y;

        // Calculer les déplacements horizontaux et verticaux nécessaires
        int deltaX = worldPosX - this.getPosition().x;
        int deltaY = worldPosY - this.getPosition().y;

        // Calculer la distance totale
        double distance = Math.sqrt(deltaX * deltaX + deltaY * deltaY);

        // Vérifier si la distance totale est non nulle
        if (distance != 0) {
            // Calculer les déplacements fractionnaires nécessaires pour atteindre la vitesse constante
            double fractionX = deltaX / distance;
            double fractionY = deltaY / distance;

            // Mettre à jour la position du serpent avec les déplacements fractionnaires
            int newPosX = (int) Math.round(this.getPosition().x + getSpeed() * fractionX);
            int newPosY = (int) Math.round(this.getPosition().y + getSpeed() * fractionY);

            // Assurez-vous que la nouvelle position reste dans les limites de la fenêtre du jeu.
            if (newPosX >= 2048 || newPosX <= -2048) {
                newPosX = -newPosX;
            }
            if (newPosY >= 2048 || newPosY <= -2048) {
                newPosY = -newPosY;
            }

            // Mettre à jour les coordonnées x et y pour l'IA
            super.setPosXforIA(newPosX + (int) Math.round(fractionX));
            super.setPosYforIA(newPosY + (int) Math.round(fractionY));

            // Mettre à jour la position de la tête du serpent
            this.setPosition(newPosX, newPosY);
        }
        // Si la distance est nulle, le serpent est déjà à la position de la souris, aucune mise à jour nécessaire
    }
}
