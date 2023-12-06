package Vue.Entity.Snake;

import Controller.Entity.Snake.Segment;
import Controller.Entity.Snake.Snake;
import Vue.Game.GamePanel;
import java.awt.*;

public class SnakeGraphics {

    private Snake snake;

    public SnakeGraphics(GamePanel gamePanel){
        this.snake = new Snake(gamePanel);
    }

    public void update(){
        snake.update();
    }

    public void draw(Graphics2D g2){
        for (Segment segment : snake.getSnake()){
            g2.setColor(segment.getColor());

            // Générer des positions aléatoires pour les cercles
            int x = segment.getPosition().x;
            int y = segment.getPosition().y;

            // Générer un rayon aléatoire pour les cercles
            int rayon = segment.getSize();

            // Dessiner le cercle
            g2.fillOval(x, y, rayon, rayon);
        }
    }
}
