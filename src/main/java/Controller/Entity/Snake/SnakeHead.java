package Controller.Entity.Snake;

import java.awt.*;

public class SnakeHead extends Segment{


    public SnakeHead(Point position, int size, int speed, Color color){
        super(position, size, speed, color);
    }

    @Override
    public void move(Point mousePos) {

        // Calculer les déplacements horizontaux et verticaux nécessaires
        int deltaX = mousePos.x - this.getPosition().x;
        int deltaY = mousePos.y - this.getPosition().y;

        // Calculer la distance totale
        double distance = Math.sqrt(deltaX * deltaX + deltaY * deltaY);

        // Calculer les déplacements fractionnaires nécessaires pour atteindre la vitesse constante
        double fractionX =  deltaX / distance;
        double fractionY =  deltaY / distance;

        // Mettre à jour la position du serpent avec les déplacements fractionnaires
        int newPosX = (int) Math.round(this.getPosition().x + getSpeed() * fractionX);
        int newPosY = (int) Math.round(this.getPosition().y + getSpeed() * fractionY);

        this.setPosition(newPosX, newPosY);
    }
}
