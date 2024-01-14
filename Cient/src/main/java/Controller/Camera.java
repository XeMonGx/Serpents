package Controller;

import Controller.Entity.Snake.Snake;

import java.io.Serializable;

public class Camera implements Serializable {

    private Snake snake;
    private final int screenX;
    private final int screenY;

    public Camera(Snake snake, int screenWidth, int screenHeight){
        this.snake = snake;
        this.screenX = screenWidth / 2;
        this.screenY = screenHeight / 2;
    }

    public void update(){
        this.snake.update();
    }

    public int getScreenY() {
        return screenY;
    }

    public int getScreenX() {
        return screenX;
    }

    public int getWorldX(){
        return snake.getSnake().get(0).getPosition().x;
    }

    public int getWorldY(){
        return snake.getSnake().get(0).getPosition().y;
    }

}
