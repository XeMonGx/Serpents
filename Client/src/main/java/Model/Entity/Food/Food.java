package Model.Entity.Food;

import java.awt.*;
import java.io.Serializable;
import java.util.Random;

/**
 * La classe Food représente la nourriture dans le jeu.
 */
public class Food implements Serializable {

    /**
     * La position de la nourriture dans le monde.
     */
    private Point position;

    /**
     * La taille de la nourriture.
     */
    private int size;

    /**
     * La couleur de la nourriture.
     */
    private Color color;

    /**
     * Constructeur par défaut qui initialise une nouvelle instance de Food.
     */
    public Food() {
        init();
    }

    /**
     * Constructeur qui initialise une nouvelle instance de Food avec une position spécifiée.
     *
     * @param position La position initiale de la nourriture.
     */
    public Food(Point position) {
        init();
        this.position = position;
    }

    /**
     * Méthode d'initialisation appelée lors de la création d'une nouvelle instance de Food.
     */
    private void init() {
        // La taille de la nourriture est définie aléatoirement entre 5 et 19.
        this.size = new Random().nextInt(15) + 5;

        // Les coordonnées x et y sont définies aléatoirement, avec une chance de devenir négatives.
        int x = new Random().nextInt(2560);
        int y = new Random().nextInt(2560);
        if (new Random().nextInt(2) == 0) {
            x = -x;
        }
        if (new Random().nextInt(2) == 0) {
            y = -y;
        }
        this.position = new Point(x, y);

        // La couleur de la nourriture est générée de manière aléatoire.
        this.color = genererCouleurAleatoire();
    }

    /**
     * Méthode pour générer une couleur aléatoire.
     *
     * @return Une couleur aléatoire.
     */
    private Color genererCouleurAleatoire() {
        Random random = new Random();
        return new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
    }

    /**
     * Méthode pour obtenir la couleur de la nourriture.
     *
     * @return La couleur de la nourriture.
     */
    public Color getColor() {
        return color;
    }

    /**
     * Méthode pour obtenir la taille de la nourriture.
     *
     * @return La taille de la nourriture.
     */
    public int getSize() {
        return size;
    }

    /**
     * Méthode pour obtenir la position de la nourriture.
     *
     * @return La position de la nourriture.
     */
    public Point getPosition() {
        return position;
    }
}
