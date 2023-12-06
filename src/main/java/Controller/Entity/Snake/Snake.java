package Controller.Entity.Snake;

import Controller.Entity.Food.FoodGenerate;
import Vue.Game.GamePanel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Snake {


    private List<Segment> snake;
    private GamePanel gamePanel;
    private int exp;
    private int size;
    private int speed;
    private Color color;

    public Snake(GamePanel gamePanel){
        this.snake = new ArrayList<>();
        this.gamePanel = gamePanel;
        this.init();
    }

    private void init(){
        this.snake.clear();
        this.exp = 0;
        this.color = genererCouleurAleatoire();
        this.size = 32;
        this.speed = 2;

        Random random = new Random();
        int posX = random.nextInt(1200);
        int posY = random.nextInt(800);

        Point pos = new Point(posX,posY);

        this.snake.add(new SnakeHead(pos, size, speed, color));

    }

    public void update(){
        for (int i=0;i<snake.size();i++){
            if(snake.get(i) instanceof SnakeHead){
                snake.get(i).move(gamePanel.getMouseMotionHandler().getMousePos());
            }else{
                snake.get(i).move(snake.get(i-1).getPosition());
            }
        }

        eatFood();
        grow();
    }

    /**
     * Fonction eatFood qui vérifie dans le ListArray des positions de la nourriture si la tête du serpent (en prennent
     * en compte la taille de la tête du serpent) est à la même coordonner que celui de la nourriture. Si oui elle ajout
     * un nombre d'expériences au serpent et retire cette nourriture pour qu'il soit replacer ailleurs.
     */
    public void eatFood(){
        for (int i=0;i<gamePanel.getFood().getFood().size();i++){

            FoodGenerate food = gamePanel.getFood().getFood().get(i);

            int headX = snake.get(0).getPosition().x;
            int headY = snake.get(0).getPosition().y;
            int foodX = food.getPos().x;
            int foodY = food.getPos().y;

            if(headX < foodX + 30 && headX + 30 > foodX && headY < foodY + 30 && headY + 30 > foodY){
                exp += food.getSize();
                gamePanel.getFood().addFood(i);
            }
        }
    }

    public void grow(){
        if (exp > 10) {
            exp = 0;
            Point startPos = new Point(snake.get(snake.size()-1).getPosition());
            snake.add(new SnakeBody(startPos, size, speed, color));
        }
    }

    private Color genererCouleurAleatoire() {
        Random random = new Random();
        return new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
    }

    public List<Segment> getSnake() {
        return snake;
    }
}
