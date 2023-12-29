package Controller.Entity.Snake;

import java.awt.*;
import java.util.List;

public class SnakeBody extends Segment{

    private List<Point> snakeBody;

    public SnakeBody(Point position, int size, int speed, Color color){
        super(position, size, speed, color);
    }

    @Override
    public void move(Point previous) {

        double distanceX = previous.getX() - this.getPosition().x;
        double distanceY = previous.getY() - this.getPosition().y;

        double vec = Math.sqrt(distanceX * distanceX + distanceY * distanceY);

        if (vec > this.getGap()) {
            double movementX = distanceX / vec;
            double movementY = distanceY / vec;

            int newPosX = (int) Math.round(this.getPosition().x + movementX * (vec - this.getGap()));
            int newPosY = (int) Math.round(this.getPosition().y + movementY * (vec - this.getGap()));

            this.setPosition(newPosX, newPosY);
        }
    }
}
