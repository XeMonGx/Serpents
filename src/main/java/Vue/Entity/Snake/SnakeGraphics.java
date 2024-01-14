package Vue.Entity.Snake;

import Controller.Entity.Snake.Segment;
import Controller.Entity.Snake.Snake;
import Model.AISnake;
import Vue.Game.GamePanel;
import java.awt.*;

public class SnakeGraphics {

    private Snake snake;
    private GamePanel gamePanel;

    public SnakeGraphics(Snake snake){
        this.gamePanel = snake.getGamePanel();
        this.snake = snake;
    }

    public void update(){
        if (snake instanceof AISnake){
            snake.update();
        }
    }

    public void draw(Graphics2D g2){
        for (int i = snake.getSnake().size()-1; i >= 0; i--){
            // Générer des positions aléatoires pour les cercles
            int worldX = snake.getSnake().get(i).getPosition().x;
            int worldY = snake.getSnake().get(i).getPosition().y;

            int screenX = worldX - gamePanel.getCamera().getWorldX() + gamePanel.getCamera().getScreenX()-(snake.getSnake().get(i).getSize()/2);
            int screenY = worldY - gamePanel.getCamera().getWorldY() + gamePanel.getCamera().getScreenY()-(snake.getSnake().get(i).getSize()/2);

            // Générer un rayon aléatoire pour les cercles
            int rayon = snake.getSnake().get(i).getSize();

            g2.setColor(Color.black);
            g2.fillOval(screenX, screenY, rayon, rayon);

            // Dessiner le cercle
            g2.setColor(snake.getSnake().get(i).getColor());
            g2.fillOval(screenX+3, screenY+3, rayon-6, rayon-6);
        }
    }

    public Snake getSnake() {
        return snake;
    }
}
