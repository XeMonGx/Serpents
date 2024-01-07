package Controller.Entity.Snake;

import java.awt.*;

public class SnakeHead extends Segment{
    
    public SnakeHead(Point position, int size, int speed, Color color){
        super(position, size, speed, color, false);
    }

    @Override
    public void move(Point mousePos, Point windowDim) {

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
            // if (newPosX <= 10) {
            //     newPosX = 1269;
            // } else if (newPosX >= 1270) {
            //     newPosX = 11;
            // }
            // if (newPosY <= 10) {
            //     newPosY = 709;
            // } else if (newPosY >= 710) {
            //     newPosY = 11;
            // }
            if (newPosX < 0) {
                newPosX += 1280;
            } else if (newPosX >= 1280) {
                newPosX -= 1280;
            }
            if (newPosY < 0) {
                newPosY += 720;
            } else if (newPosY >= 720) {
                newPosY -= 720;
            }
            super.setPosXforIA(newPosX + (int) Math.round(fractionX));
            super.setPosYforIA(newPosY + (int) Math.round(fractionY));
            this.setPosition(newPosX, newPosY);
        }
        // Si la distance est nulle, le serpent est déjà à la position de la souris, aucune mise à jour nécessaire

    }

}
