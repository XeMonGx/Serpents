package Controller.Entity.Snake;

import Controller.Entity.Food.Food;
import Controller.MouseListenerHandler;
import Controller.MouseMotionHandler;
import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Snake implements Serializable {

    private List<Segment> snake;
    private final String username;
    private int exp;
    private int size;
    private int speed;
    private int length;
    private final Color color;
    private int screenX;
    private int screenY;
    private MouseListenerHandler mouseListenerHandler;
    private MouseMotionHandler mouseMotionHandler;
    private ArrayList<Food> foodArrayList;
    private SnakeHandler snakeHandler;

    public Snake(String username, int screenX, int screenY, MouseListenerHandler mouseListenerHandler, MouseMotionHandler mouseMotionHandler, ArrayList<Food> foodArrayList, SnakeHandler snakeHandler){
        this.username = username;
        this.snake = new ArrayList<>();
        this.color = genererCouleurAleatoire();
        this.mouseListenerHandler = mouseListenerHandler;
        this.mouseMotionHandler = mouseMotionHandler;
        this.foodArrayList = foodArrayList;
        this.snakeHandler = snakeHandler;
        this.screenX = screenX;
        this.screenY = screenY;
        this.init();
    }

    private void init(){
        this.snake.clear();
        this.exp = 0;
        this.size = 32;
        this.speed = 2;
        this.length = 1;

        Random random = new Random();
        int posX = random.nextInt(1200);
        int posY = random.nextInt(800);

        Point pos = new Point(posX,posY);

        this.snake.add(new SnakeHead(pos, size, speed, color));
    }

    public void update(){
        Point tmp = new Point();
        for (int i=0;i<snake.size();i++){
            if (mouseListenerHandler.getPressed() == true){
                speed = 5;
                snake.get(i).setSpeed(5);
            }else {
                speed = 2;
                snake.get(i).setSpeed(2);
            }
            if(snake.get(i) instanceof SnakeHead){
                snake.get(i).copy(tmp);
                snake.get(i).move(mouseMotionHandler.getMousePos(), new Point(screenX, screenY));
            }else{
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
     * Fonction eatFood qui vérifie dans le ListArray des positions de la nourriture si la tête du serpent (en prennent
     * en compte la taille de la tête du serpent) est à la même coordonner que celui de la nourriture. Si oui elle ajout
     * un nombre d'expériences au serpent et retire cette nourriture pour qu'il soit replacer ailleurs.
     */
    public void eatFood(){
        for (int i=0;i<foodArrayList.size();i++){

            Food food = foodArrayList.get(i);

            int headX = snake.get(0).getPosition().x;
            int headY = snake.get(0).getPosition().y;
            int foodX = food.getPos().x;
            int foodY = food.getPos().y;

            if(headX < foodX + (size) && headX > foodX - (size/2) && headY < foodY + (size) && headY > foodY - (size/2)){
                exp += food.getSize();
                foodArrayList.get(i).newPos();
            }
        }
    }

    public void grow(Point pos){
        if (exp > 10) {
            exp = 0;
            Point startPos = new Point(pos.x, pos.y);
            length++;
            if (length > 3) {
                length = 0;
                for (Segment segment : snake){
                    segment.setSize();
                }
                size+=1;
            }
            snake.add(new SnakeBody(startPos, size, speed, color)); 
        }
    }

    public boolean isCol(Segment segment){
        int headPosX = snake.get(0).getPosition().x;
        int headPosY = snake.get(0).getPosition().y;
        if(segment.getCollision()){
            return segment.getPosition().x + size/2 > headPosX && segment.getPosition().x - size < headPosX
                    && segment.getPosition().y + size/2 > headPosY && segment.getPosition().y - size < headPosY;
        }
        return false;
    }

    public void dead(){
        for(Snake snake : snakeHandler.getSnakeArrayList()){
            int headPosX = this.snake.get(0).getPosition().x;
            int headPosY = this.snake.get(0).getPosition().y;
            int segPosX = snake.getSnake().get(0).getPosition().x;
            int segPosY = snake.getSnake().get(0).getPosition().y;
            Point direction = new Point(segPosX-headPosX, segPosY-headPosY);
            double distance = Math.sqrt(direction.x * direction.x + direction.y * direction.y);
            if(distance < 500 && distance != 0){
                for (Segment segment : snake.getSnake()){
                    if (isCol(segment)) {
                        for (Segment seg : this.snake){
                            foodArrayList.add(new Food(seg.getPosition()));
                        }
                        init();
                    }
                }
            }
        }
    }

    private Color genererCouleurAleatoire() {
        Random random = new Random();
        return new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
    }

    public List<Segment> getSnake() {
        return snake;
    }

    public ArrayList<Food> getFoodArrayList() {
        return foodArrayList;
    }

    public SnakeHandler getSnakeHandler() {
        return snakeHandler;
    }

    public int getScreenX() {
        return screenX;
    }

    public int getScreenY() {
        return screenY;
    }
}
