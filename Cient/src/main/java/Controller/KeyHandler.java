package Controller;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.Serializable;

public class KeyHandler implements KeyListener, Serializable {

    public int count = 1;

    @Override
    public void keyTyped(KeyEvent e) {
        count++;
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
