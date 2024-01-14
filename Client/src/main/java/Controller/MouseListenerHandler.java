package Controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.Serializable;

public class MouseListenerHandler implements MouseListener, Serializable {

    private boolean pressed;

    public MouseListenerHandler(){
        pressed = false;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        pressed = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        pressed = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    public boolean getPressed(){
        return pressed;
    }
}
