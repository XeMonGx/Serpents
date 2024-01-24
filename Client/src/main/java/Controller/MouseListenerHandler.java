package Controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.Serializable;

/**
 * La classe MouseListenerHandler gère les événements de la souris dans le jeu.
 * Elle implémente l'interface MouseListener pour détecter les actions de la souris.
 */
public class MouseListenerHandler implements MouseListener, Serializable {

    private boolean pressed; // Indique si le bouton de la souris est enfoncé.

    /**
     * Constructeur de la classe MouseListenerHandler.
     * Initialise l'état du bouton de la souris à "non enfoncé".
     */
    public MouseListenerHandler() {
        pressed = false;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // Non utilisé dans cette classe.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // Met à jour l'état du bouton de la souris lorsqu'il est enfoncé.
        pressed = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // Met à jour l'état du bouton de la souris lorsqu'il est relâché.
        pressed = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // Non utilisé dans cette classe.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // Non utilisé dans cette classe.
    }

    /**
     * Renvoie l'état du bouton de la souris.
     *
     * @return true si le bouton est enfoncé, false sinon.
     */
    public boolean isPressed() {
        return pressed;
    }
}
