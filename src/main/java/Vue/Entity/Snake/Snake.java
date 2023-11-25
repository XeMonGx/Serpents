package Vue.Entity.Snake;

import Vue.Game.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Snake{

    private BufferedImage head;
    private int x, y;
    private int speed;
    private GamePanel gamePanel;

    public Snake(GamePanel gamePanel){
        this.gamePanel = gamePanel;
        initValue();
    }

    public void initValue(){
        getHeadImage();
        this.speed = 2;
        this.x = gamePanel.getScreenWidth()/2;
        this.y = gamePanel.getScreenHeight()/2;
    }

    public void update(){
        /*
        switch (gamePanel.getMouseHandler().getDirection()){
            case "up" :
                this.x -= speed;
                break;
            case "down" :
                this.x += speed;
                break;
            case "left" :
                this.y -= speed;
                break;
            case "rigth" :
                this.y += speed;
                break;
        }
        System.out.println(x);

         */
        x = gamePanel.getMouseMotionHandler().posX;
        y = gamePanel.getMouseMotionHandler().posY;
    }

    public void draw(Graphics2D g2){
        g2.drawImage(head, x, y, 32, 32, null);
    }

    public void getHeadImage(){
        try {
            head = ImageIO.read(getClass().getResourceAsStream("/Snake/circle.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
