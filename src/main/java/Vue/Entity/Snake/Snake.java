package Vue.Entity.Snake;

import Vue.Game.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Snake{

    private BufferedImage head;
    private int worldX, worldY;
    private final int screenX, screenY;
    private int speed;
    private GamePanel gamePanel;

    public Snake(GamePanel gamePanel){
        this.gamePanel = gamePanel;
        this.screenX = gamePanel.getScreenWidth()/2;
        this.screenY = gamePanel.getScreenHeight()/2;
        initValue();
    }

    public void initValue(){
        getHeadImage();
        this.speed = 2;
        this.worldX = 0;
        this.worldY = 0;
    }

    public void update(){

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
    }

    public void draw(Graphics2D g2){
        g2.drawImage(head, screenX, screenY, 32, 32, null);
    }

    public void getHeadImage(){
        try {
            head = ImageIO.read(getClass().getResourceAsStream("/Snake/circle.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public int getScreenX() {
        return screenX;
    }

    public int getScreenY() {
        return screenY;
    }

    public int getWorldX() {
        return worldX;
    }

    public int getWorldY() {
        return worldY;
    }
}
