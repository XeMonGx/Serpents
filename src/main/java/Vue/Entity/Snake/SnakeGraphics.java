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
        for (Segment segment : snake.getSnake()){
            g2.setColor(segment.getColor());

            // Générer des positions aléatoires pour les cercles
            int worldX = segment.getPosition().x;
            int worldY = segment.getPosition().y;

            int screenX = worldX - gamePanel.getCamera().getWorldX() + gamePanel.getCamera().getScreenX();
            int screenY = worldY - gamePanel.getCamera().getWorldY() + gamePanel.getCamera().getScreenY();
            if (screenX < 0) {
                screenX += 1280;
            } else if (screenX >= 1280) {
                screenX -= 1280;
            }
            if (screenY < 0) {
                screenY += 720;
            } else if (screenY >= 720) {
                screenY -= 720;
            }
            // Générer un rayon aléatoire pour les cercles
            int rayon = segment.getSize();

            // Dessiner le cercle
            g2.fillOval(screenX, screenY, rayon, rayon);
        }
    }

    public Snake getSnake() {
        return snake;
    }
}
