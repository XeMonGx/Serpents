package Controller;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import Vue.Game.GamePanel;

import static Controller.Direction.*;

public class MouseMotionHandler implements MouseMotionListener {

    private Point mousePos;
    private GamePanel gp;
    public MouseMotionHandler(GamePanel gp){
        this.mousePos = new Point();
        this.gp = gp;
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
