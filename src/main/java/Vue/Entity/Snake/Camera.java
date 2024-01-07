package Vue.Entity.Snake;

import Controller.Entity.Snake.Segment;
import Vue.Game.GamePanel;
import Controller.Entity.Snake.Snake;

import java.awt.*;

public class Camera {

    private GamePanel gamePanel;
    private Snake snake;
    private final int screenX;
    private final int screenY;

    public Camera(Snake snake){
        this.snake = snake;
        this.gamePanel = snake.getGamePanel();
        this.screenX = gamePanel.getScreenWidth() / 2;
        this.screenY = gamePanel.getScreenHeight() / 2;
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
