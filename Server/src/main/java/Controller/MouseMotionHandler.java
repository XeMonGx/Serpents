package Controller;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.io.Serializable;

/**
 * La classe MouseMotionHandler gère les mouvements de la souris dans le jeu.
 * Elle implémente l'interface MouseMotionListener pour détecter les mouvements de la souris.
 */
public class MouseMotionHandler implements MouseMotionListener, Serializable {

    private Point mousePos; // La position actuelle de la souris.

    /**
     * Constructeur de la classe MouseMotionHandler.
     * Initialise la position de la souris à (0, 0).
     */
    public MouseMotionHandler() {
        this.mousePos = new Point();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // Non utilisé dans cette classe.
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // Met à jour la position de la souris lors des mouvements.
        this.mousePos.x = e.getX();
        this.mousePos.y = e.getY();
    }

    /**
     * Renvoie la position actuelle de la souris.
     *
     * @return Objet Point représentant la position de la souris.
     */
    public Point getMousePos() {
        return mousePos;
    }
}
