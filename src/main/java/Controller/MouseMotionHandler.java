package Controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import static Controller.Direction.*;

public class MouseMotionHandler implements MouseMotionListener {

    private int x, y;

    public MouseMotionHandler(){
        init();
    }

    public void init(){
        x = 0;
        y = 0;
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        x = e.getX();
        y = e.getY();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
