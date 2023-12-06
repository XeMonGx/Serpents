package Controller.Entity.Snake;

import Vue.Game.GamePanel;

import java.awt.*;

public abstract class Segment {

    private Point position;
    private int size;
    private int speed;

    private Color color;
    private final int gap = 10;

    public Segment(Point position, int size, int speed, Color color){
        this.position = position;
        this.size = size;
        this.speed = speed;
        this.color = color;
    }

    public abstract void move(Point mousePos);

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

    public void setPosition(int x, int y) {
        this.position.x = x;
        this.position.y = y;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
