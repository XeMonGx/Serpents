package Controller;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.Serializable;

public class MouseMotionHandler implements MouseMotionListener, Serializable {

    private Point mousePos;

    public MouseMotionHandler(){
        this.mousePos = new Point();
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        this.mousePos.x = e.getX();
        this.mousePos.y = e.getY();
        
    }

    public Point getMousePos() {
        return mousePos;
    }

}
