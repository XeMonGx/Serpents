package Vue.Entity.Snake;

import Controller.FoodGenerate;
import Vue.Game.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Snake{

    private List<Point> snakeBody;
    private BufferedImage headImage;
    private Point worldPos;
    private int headSize;
    private int speed;
    private int exp;
    private GamePanel gamePanel;

    public Snake(GamePanel gamePanel){
        this.snakeBody = new ArrayList<>();
        this.gamePanel = gamePanel;
        initValue();
    }

    public void initValue(){
        getHeadImage();
        snakeBody.clear();
        worldPos = new Point(0, 0);
        snakeBody.add(new Point(worldPos.x / 2, worldPos.y / 2));
        this.headSize = 32;
        this.speed = 2;
        this.exp = 1;
    }

    public void update(){

        int mouseX = gamePanel.getMouseMotionHandler().getX();
        int mouseY = gamePanel.getMouseMotionHandler().getY();

        // Calculer les déplacements horizontaux et verticaux nécessaires
        int deltaX = mouseX - worldPos.x;
        int deltaY = mouseY - worldPos.y;

        // Calculer la distance totale
        double distance = Math.sqrt(deltaX * deltaX + deltaY * deltaY);

        // Calculer les déplacements fractionnaires nécessaires pour atteindre la vitesse constante
        double fractionX =  deltaX / distance;
        double fractionY =  deltaY / distance;

        // Mettre à jour la position du serpent avec les déplacements fractionnaires
        worldPos.x += speed * fractionX;
        worldPos.y += speed * fractionY;

        snakeBody.set(0, worldPos);

        for (int i=0;i<gamePanel.getFood().getFood().size();i++){
            FoodGenerate f = gamePanel.getFood().getFood().get(i);
            int headX = worldPos.x;
            int headY = worldPos.y;
            int foodX = f.getPos().x;
            int foodY = f.getPos().y;

            if(headX < foodX + 30 && headX + 30 > foodX && headY < foodY + 30 && headY + 30 > foodY){
                exp += f.getSize();
                gamePanel.getFood().addFood(i);
            }
        }

        if (exp % 10 == 0){
            exp = 1;
            Point startPos = new Point(
                    (int) fractionX * -1 * headSize + worldPos.x + 10,
                    (int) fractionY * -1 * headSize + worldPos.y
            );
            snakeBody.add(startPos);
        }

        // Mettez à jour la position du reste du corps
        double gap = 10;

        for (int i = 1; i < snakeBody.size(); i++) {
            Point current = snakeBody.get(i);
            Point prev = snakeBody.get(i - 1);

            double distanceX = prev.getX() - current.getX();
            double distanceY = prev.getY() - current.getY();

            double vec = Math.sqrt(distanceX * distanceX + distanceY * distanceY);

            if (vec > gap) {
                double movementX = distanceX / vec;
                double movementY = distanceY / vec;

                current.x = (int) (current.getX() + movementX * (vec - gap));
                current.y = (int) (current.getY() + movementY * (vec - gap));
            }
        }

        /**
        /// pour le clavier

        switch (gamePanel.getMouseMotionHandler().getDirectionX()){
            case RIGHT :
                this.worldX += speed;
                break;
            case LEFT :
                this.worldX -= speed;
                break;
        }

        switch (gamePanel.getMouseMotionHandler().getDirectionY()){
            case DOWN :
                this.worldY -= speed;
                break;
            case UP :
                this.worldY += speed;
                break;
        }
         */
    }

    public void draw(Graphics2D g2){
        for (Point segment : snakeBody) {
            g2.drawImage(headImage, segment.x, segment.y, headSize, headSize, null);
        }
    }

    public void getHeadImage(){
        try {
            headImage = ImageIO.read(getClass().getResourceAsStream("/Snake/circle.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
