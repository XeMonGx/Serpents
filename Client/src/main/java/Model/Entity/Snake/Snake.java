package Model.Entity.Snake;

import Model.Entity.Food.Food;
import Controller.MouseListenerHandler;
import Controller.MouseMotionHandler;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * La classe Snake représente le serpent dans le jeu.
 */
public class Snake implements Serializable {

    private List<Segment> snake; // Liste des segments constituant le serpent.
    private final String username; // Nom d'utilisateur du joueur.
    private int exp; // Expérience du serpent.
    private int size; // Taille initiale des segments du serpent.
    private int speed; // Vitesse du serpent.
    private int length; // Longueur du serpent.
    private final Color color; // Couleur du serpent.
    private int screenX; // Position x de l'écran du jeu.
    private int screenY; // Position y de l'écran du jeu.
    private MouseListenerHandler mouseListenerHandler; // Gestionnaire des événements de la souris.
    private MouseMotionHandler mouseMotionHandler; // Gestionnaire des mouvements de la souris.
    private ArrayList<Food> foodArrayList; // Liste des nourritures dans le jeu.
    private ArrayList<Snake> snakeArrayList; // Liste des serpents dans le jeu.

    /**
     * Constructeur de la classe Snake.
     *
     * @param username             Nom d'utilisateur du joueur.
     * @param screenX              Position x de l'écran du jeu.
     * @param screenY              Position y de l'écran du jeu.
     * @param mouseListenerHandler Gestionnaire des événements de la souris.
     * @param mouseMotionHandler   Gestionnaire des mouvements de la souris.
     * @param foodArrayList        Liste des objets de nourriture dans le jeu.
     * @param snakeArrayList       Liste des serpents dans le jeu.
     */
    public Snake(String username, int screenX, int screenY, MouseListenerHandler mouseListenerHandler, MouseMotionHandler mouseMotionHandler, ArrayList<Food> foodArrayList, ArrayList<Snake> snakeArrayList) {
        this.username = username;
        this.snake = new ArrayList<>();
        this.color = genererCouleurAleatoire();
        this.mouseListenerHandler = mouseListenerHandler;
        this.mouseMotionHandler = mouseMotionHandler;
        this.foodArrayList = foodArrayList;
        this.snakeArrayList = snakeArrayList;
        this.screenX = screenX;
        this.screenY = screenY;
        this.init();
    }

    /**
     * Méthode d'initialisation du serpent.
     */
    private void init() {
        this.snake.clear();
        this.exp = 0;
        this.size = 32;
        this.speed = 2;
        this.length = 1;

        Random random = new Random();
        int posX = random.nextInt(1200);
        int posY = random.nextInt(800);

        Point pos = new Point(posX, posY);

        this.snake.add(new SnakeHead(pos, size, speed, color));
    }

    /**
     * Méthode de mise à jour du serpent.
     */
    public void update() {
        Point tmp = new Point();
        for (int i = 0; i < snake.size(); i++) {
            if (mouseListenerHandler.isPressed()) { // Acceleration du serpent
                speed = 5;
                snake.get(i).setSpeed(5);
            } else {
                speed = 2;
                snake.get(i).setSpeed(2);
            }
            if (snake.get(i) instanceof SnakeHead) {
                snake.get(i).copy(tmp);
                snake.get(i).move(mouseMotionHandler.getMousePos(), new Point(screenX, screenY));
            } else {
                Point tmp2 = new Point();
                snake.get(i).copy(tmp2);
                snake.get(i).move(tmp, null);
                tmp = tmp2;
            }
        }

        dead();
        eatFood();
        grow(tmp);
    }

    /**
     * Méthode pour détecter les collisions entre la tête du serpent et un segment spécifique.
     *
     * @param segment Segment à vérifier la collision.
     * @return True si collision, sinon false.
     */
    public boolean isCollision(Segment segment) {
        int headPosX = snake.get(0).getPosition().x;
        int headPosY = snake.get(0).getPosition().y;
        if (segment.getCollision()) {
            return segment.getPosition().x + size / 2 > headPosX && segment.getPosition().x - size < headPosX
                    && segment.getPosition().y + size / 2 > headPosY && segment.getPosition().y - size < headPosY;
        }
        return false;
    }

    /**
     * Méthode pour détecter s'il y a des serpents autour de la tête du serpent.
     *
     * @param snake Serpent à vérifier s'il est autour.
     * @return True si collision, sinon false.
     */
    public boolean isAround(Snake snake){
        int headPosX = this.snake.get(0).getPosition().x;
        int headPosY = this.snake.get(0).getPosition().y;
        int segPosX = snake.getSnake().get(0).getPosition().x;
        int segPosY = snake.getSnake().get(0).getPosition().y;
        Point direction = new Point(segPosX - headPosX, segPosY - headPosY);
        double distance = Math.sqrt(direction.x * direction.x + direction.y * direction.y);
        return distance < 500 && distance != 0;
    }

    /**
     * Méthode pour détecter les collisions entre la tête du serpent et les segments du serpent.
     */
    public void dead() {
        for (Snake snake : snakeArrayList) {
            if (isAround(snake)) {
                for (Segment segment : snake.getSnake()) {
                    if (isCollision(segment)) {
                        for (Segment seg : this.snake) {
                            Random r = new Random();
                            if(r.nextInt(2) == 0 && foodArrayList.size() < 1200) {
                                foodArrayList.add(new Food(seg.getPosition()));
                            }
                        }
                        init();
                    }
                }
            }
        }
    }

    /**
     * Méthode pour manger de la nourriture.
     */
    public void eatFood() {
        for (int i = 0; i < foodArrayList.size(); i++) {

            Food food = foodArrayList.get(i);

            int headX = snake.get(0).getPosition().x;
            int headY = snake.get(0).getPosition().y;
            int foodX = food.getPosition().x;
            int foodY = food.getPosition().y;

            if (headX < foodX + size && headX > foodX - (size / 2) && headY < foodY + size && headY > foodY - (size / 2)) {
                exp += food.getSize();
                foodArrayList.remove(i);
                foodArrayList.add(new Food());
            }
        }
    }

    /**
     * Méthode pour faire grandir le serpent.
     *
     * @param pos Position du dernier segment du serpent.
     */
    public void grow(Point pos) {
        if (exp > 10) {
            exp = 0;
            Point startPos = new Point(pos.x, pos.y);
            length++;
            if (length > 3) {
                length = 0;
                for (Segment segment : snake) {
                    segment.setSize();
                }
                size += 1;
            }
            snake.add(new SnakeBody(startPos, size, speed, color));
        }
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
     * Méthode pour obtenir la liste des segments du serpent.
     *
     * @return Liste des segments du serpent.
     */
    public List<Segment> getSnake() {
        return snake;
    }

    /**
     * Méthode pour obtenir la liste des objets de nourriture dans le jeu.
     *
     * @return Liste des objets de nourriture.
     */
    public ArrayList<Food> getFoodArrayList() {
        return foodArrayList;
    }

    /**
     * Méthode pour obtenir la liste des serpents dans le jeu.
     *
     * @return Liste des serpents.
     */
    public ArrayList<Snake> getSnakeArrayList() {
        return snakeArrayList;
    }

    /**
     * Méthode pour obtenir la position x de l'écran du jeu.
     *
     * @return Position x de l'écran.
     */
    public int getScreenX() {
        return screenX;
    }

    /**
     * Méthode pour obtenir la position y de l'écran du jeu.
     *
     * @return Position y de l'écran.
     */
    public int getScreenY() {
        return screenY;
    }

    /**
     * Méthode pour obtenir le nom d'utilisateur du joueur.
     *
     * @return Nom d'utilisateur.
     */
    public String getUsername() {
        return username;
    }
}
