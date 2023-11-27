package Controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import static Controller.Direction.*;

public class MouseMotionHandler implements MouseMotionListener {

    private Direction directionX;
    private Direction directionY;

    public MouseMotionHandler(){
        init();
    }

    public void init(){
        directionX = LEFT;
        directionY = DOWN;
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        if ((e.getX()-600) < 0){
            directionX = LEFT;
        }else{
            directionX = RIGHT;
        }
        if ((e.getY() - 400) < 0){
            directionY = DOWN;
        }else{
            directionY = UP;
        }
    }

    public Direction getDirectionX() {
        return directionX;
    }

    public Direction getDirectionY() {
        return directionY;
    }
}
