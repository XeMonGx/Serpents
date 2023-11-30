package Vue.Entity.Snake;

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

        if (gamePanel.getKeyHandler().count % 5 == 0){
            gamePanel.getKeyHandler().count = 1;
            Point startPos = new Point((int) fractionX * -1 * headSize + worldPos.x + 10, (int) fractionY * -1 * headSize + worldPos.y );
            snakeBody.add(startPos);
        }

        // Mettez à jour la position du reste du corps
        for (int i = snakeBody.size() - 1; i > 0; i--) {
            Point currentSegment = snakeBody.get(i);
            Point previousSegment = snakeBody.get(i - 1);

            // Déplacez chaque segment avec un espace entre les segments
            currentSegment.setLocation(previousSegment.x, previousSegment.y);
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
