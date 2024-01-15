package Controller.Entity.Snake;

import java.awt.*;
import java.io.Serializable;

/**
 * La classe abstraite Segment représente un segment du serpent dans le jeu.
 */
public abstract class Segment implements Serializable {

    private Point position; // La position du segment dans le monde.
    private int size; // La taille du segment.
    private int speed; // La vitesse du segment.
    private boolean collision; // Indique si le segment est en collision avec quelque chose.
    private int posXforIA, posYforIA; // Les coordonnées pour l'IA.

    private Color color; // La couleur du segment.
    private final int gap = 10; // L'écart par défaut entre les segments du serpent.

    /**
     * Constructeur de la classe Segment.
     *
     * @param position  La position initiale du segment.
     * @param size      La taille du segment.
     * @param speed     La vitesse du segment.
     * @param color     La couleur du segment.
     * @param collision Indique si le segment est en collision avec quelque chose.
     */
    public Segment(Point position, int size, int speed, Color color, boolean collision) {
        this.position = position;
        this.size = size;
        this.speed = speed;
        this.color = color;
        this.collision = collision;
    }

    /**
     * Méthode abstraite pour déplacer le segment.
     *
     * @param mousePos   Position de la souris (pour les segments contrôlés par l'utilisateur).
     * @param windowDim  Dimensions de la fenêtre du jeu.
     */
    public abstract void move(Point mousePos, Point windowDim);

    /**
     * Méthode pour obtenir la vitesse du segment.
     *
     * @return La vitesse du segment.
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * Méthode pour obtenir la taille du segment.
     *
     * @return La taille du segment.
     */
    public int getSize() {
        return size;
    }

    /**
     * Méthode pour obtenir la couleur du segment.
     *
     * @return La couleur du segment.
     */
    public Color getColor() {
        return color;
    }

    /**
     * Méthode pour obtenir la position du segment.
     *
     * @return La position du segment.
     */
    public Point getPosition() {
        return position;
    }

    /**
     * Méthode pour obtenir l'écart par défaut entre les segments du serpent.
     *
     * @return L'écart entre les segments.
     */
    public int getGap() {
        return gap;
    }

    /**
     * Méthode pour obtenir l'état de collision du segment.
     *
     * @return True si le segment est en collision, sinon false.
     */
    public boolean getCollision() {
        return collision;
    }

    /**
     * Méthode pour définir la position du segment.
     *
     * @param x Nouvelle coordonnée x.
     * @param y Nouvelle coordonnée y.
     */
    public void setPosition(int x, int y) {
        this.position.x = x;
        this.position.y = y;
    }

    /**
     * Méthode pour augmenter la taille du segment.
     */
    public void setSize() {
        this.size += 1;
    }

    /**
     * Méthode pour définir la vitesse du segment.
     *
     * @param speed Nouvelle vitesse du segment.
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }

    /**
     * Méthode pour copier la position du segment dans un objet Point spécifié.
     *
     * @param tmp Point dans lequel copier la position.
     */
    public void copy(Point tmp) {
        tmp.x = position.x;
        tmp.y = position.y;
    }

    /**
     * Méthode pour définir la coordonnée x pour l'IA.
     *
     * @param posXforIA Nouvelle coordonnée x pour l'IA.
     */
    public void setPosXforIA(int posXforIA) {
        this.posXforIA = posXforIA;
    }

    /**
     * Méthode pour définir la coordonnée y pour l'IA.
     *
     * @param posYforIA Nouvelle coordonnée y pour l'IA.
     */
    public void setPosYforIA(int posYforIA) {
        this.posYforIA = posYforIA;
    }

    /**
     * Méthode pour obtenir la coordonnée x pour l'IA.
     *
     * @return La coordonnée x pour l'IA.
     */
    public int getPosXforIA() {
        return posXforIA;
    }

    /**
     * Méthode pour obtenir la coordonnée y pour l'IA.
     *
     * @return La coordonnée y pour l'IA.
     */
    public int getPosYforIA() {
        return posYforIA;
    }

    /**
     * Méthode pour comparer la position du segment avec un point spécifié.
     *
     * @param point Point à comparer.
     * @return True si les coordonnées du point sont égales à celles du segment, sinon false.
     */
    public boolean comparePoint(Point point) {
        return point.x == position.x && point.y == position.y;
    }
}
