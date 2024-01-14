package Vue.Background;

import Vue.Game.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class BackgroundTile {

    private BufferedImage tile;
    private GamePanel gamePanel;

    public BackgroundTile(GamePanel gamePanel){
        this.gamePanel = gamePanel;
        initValue();
    }

    public void initValue(){
        getBackgroundImage();
    }

    public void draw(Graphics2D g2){
        for (int i=-5;i<5;i++){
            for (int j=-5;j<5;j++){
                int worldX = i * 512;
                int worldY = j * 512;

                int screenX = worldX - gamePanel.getCamera().getWorldX() + gamePanel.getCamera().getScreenX();
                int screenY = worldY - gamePanel.getCamera().getWorldY() + gamePanel.getCamera().getScreenY();

                g2.drawImage(tile, screenX, screenY, 512, 512, null);
            }
        }
    }

    public void getBackgroundImage(){
        try {
            tile = ImageIO.read(getClass().getResourceAsStream("/background.png"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
