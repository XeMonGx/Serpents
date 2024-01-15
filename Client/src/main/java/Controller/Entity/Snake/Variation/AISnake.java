package Controller.Entity.Snake.Variation;

import Controller.Entity.Food.Food;
import Controller.Entity.Snake.Snake;
import Controller.Entity.Snake.SnakeHead;
import Controller.MouseListenerHandler;
import Controller.MouseMotionHandler;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

/**
 * La classe AISnake représente une variante de serpent contrôlée par l'IA dans le jeu.
 */
public class AISnake extends Snake implements Serializable {

    private Point position; // Position actuelle de l'IA Snake.
    private AISnake_etat etat; // État actuel de l'IA Snake.
    private Snake ennemi; // Référence à un serpent ennemi.
    private int compteur = 0; // Compteur pour décider du comportement de l'IA Snake.

    /**
     * Constructeur de la classe AISnake.
     *
     * @param username             Nom d'utilisateur de l'IA Snake.
     * @param screenX              Position x de l'écran du jeu.
     * @param screenY              Position y de l'écran du jeu.
     * @param mouseListenerHandler Gestionnaire des événements de la souris.
     * @param mouseMotionHandler   Gestionnaire des mouvements de la souris.
     * @param foodArrayList        Liste des objets de nourriture dans le jeu.
     * @param snakeArrayList       Liste des serpents dans le jeu.
     */
    public AISnake(String username, int screenX, int screenY, MouseListenerHandler mouseListenerHandler, MouseMotionHandler mouseMotionHandler, ArrayList<Food> foodArrayList, ArrayList<Snake> snakeArrayList) {
        super(username, screenX, screenY, mouseListenerHandler, mouseMotionHandler, foodArrayList, snakeArrayList);
        this.position = new Point();
        randomPoint();
    }

    /**
     * Méthode pour mettre à jour l'état et le comportement de l'IASnake.
     */
    @Override
    public void update() {
        Point tmp = new Point();
        if (this.etat == null || this.compteur <= 0) {
            getDecision();
            makeDecision();
        }
        for (int i = 0; i < getSnake().size(); i++) {
            if (getSnake().get(i) instanceof SnakeHead) {
                getSnake().get(i).copy(tmp);
                getSnake().get(i).move(position, new Point(getScreenX(), getScreenY()));
                if (getSnake().get(i).comparePoint(position) || compteur <= 0) {
                    this.etat = null;
                } else if (etat == AISnake_etat.CHASSE) {
                    this.position.x = this.ennemi.getSnake().get(0).getPosXforIA();
                    this.position.y = this.ennemi.getSnake().get(0).getPosYforIA();
                }
            } else {
                Point tmp2 = new Point();
                getSnake().get(i).copy(tmp2);
                getSnake().get(i).move(tmp, new Point(getScreenX(), getScreenY()));
                tmp = tmp2;
            }
        }
        dead();
        eatFood();
        grow(tmp);
    }

    /**
     * Méthode pour générer une position de manière aléatoire pour l'IA Snake.
     */
    private void randomPoint() {
        Random random = new Random();
        this.position.x = random.nextInt(getScreenX());
        this.position.y = random.nextInt(getScreenY());
    }

    /**
     * Méthode pour obtenir une décision aléatoire pour le comportement de l'IA Snake.
     */
    private void getDecision() {
        Random random = new Random();
        int x = random.nextInt(100);
        if (x < 20) {
            this.etat = AISnake_etat.FUIR;
        } else if (x > 80) {
            this.etat = AISnake_etat.CHASSE;
        } else {
            this.etat = AISnake_etat.MANGER;
        }
        this.compteur = 10;
    }

    /**
     * Méthode pour mettre en œuvre la décision prise par l'IA Snake.
     */
    private void makeDecision() {
        if (this.etat == AISnake_etat.MANGER) {
            Random random = new Random();
            int r = random.nextInt(getFoodArrayList().size());
            this.position.x = getFoodArrayList().get(r).getPosition().x;
            this.position.y = getFoodArrayList().get(r).getPosition().y;

        } else if (this.etat == AISnake_etat.CHASSE) {
            Random random = new Random();
            int r = random.nextInt(getSnakeArrayList().size());
            this.ennemi = getSnakeArrayList().get(r);
            while (this == ennemi) {
                r = random.nextInt(getSnakeArrayList().size());
                this.ennemi = getSnakeArrayList().get(r);
            }
            this.position.x = this.ennemi.getSnake().get(0).getPosXforIA();
            this.position.y = this.ennemi.getSnake().get(0).getPosYforIA();
        } else {
            randomPoint();
        }
    }

    /**
     * Méthode pour décrémenter le compteur de l'IA Snake.
     */
    public void decreaserCompteur() {
        this.compteur--;
    }
}
