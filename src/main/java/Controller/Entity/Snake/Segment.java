package Controller.Entity.Snake;

import java.awt.*;
import java.io.Serializable;

public abstract class Segment implements Serializable {

    private Point position;
    private int size;
    private int speed;
    private boolean collision;
    private int posXforIA,posYforIA;

    private Color color;
    private final int gap = 10;

    public Segment(Point position, int size, int speed, Color color, boolean collision){
        this.position = position;
        this.size = size;
        this.speed = speed;
        this.color = color;
        this.collision = collision;
    }

    public abstract void move(Point mousePos, Point windowDim);

    public int getSpeed() {
        return speed;
    }

    public int getSize() {
        return size;
    }

    public Color getColor() {
        return color;
    }

    public Point getPosition() {
        return position;
    }

    public int getGap() {
        return gap;
    }

    public boolean getCollision(){
        return collision;
    }

    public void setPosition(int x, int y) {
        this.position.x = x;
        this.position.y = y;
    }

    public void setSize() {
        this.size += 1;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public void copy(Point tmp){
        tmp.x = position.x;
        tmp.y = position.y;
    }

    public void setPosXforIA(int posXforIA) {
        this.posXforIA = posXforIA;
    }

    public void setPosYforIA(int posYforIA) {
        this.posYforIA = posYforIA;
    }

    public int getPosXforIA() {
        return posXforIA;
    }

    public int getPosYforIA() {
        return posYforIA;
    }

    public boolean comparePoint(Point point){
        return point.x == position.x && point.y == position.y;
    }
}
