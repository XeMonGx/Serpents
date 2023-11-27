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

        int worldCow = 0;
        int worldRow = 0;

        for (int i=0;i<4;i++){
            for (int j=0;j<4;j++){

                int worldX = worldCow * 512;
                int worldY = worldRow * 512;
                int screenX = worldX - gamePanel.getSnake().getWorldX() + gamePanel.getSnake().getScreenX();
                int screenY = worldY - gamePanel.getSnake().getWorldY() + gamePanel.getSnake().getScreenY();

                g2.drawImage(tile, screenX, screenY, 512, 512, null);
                worldCow++;
            }
            worldCow = 0;
            worldRow++;
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
