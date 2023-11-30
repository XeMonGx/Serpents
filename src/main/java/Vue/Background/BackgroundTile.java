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

        int worldCol = 0;
        int worldRow = 0;

        for (int i=0;i<4;i++){
            for (int j=0;j<4;j++){

                int worldX = worldCol * 512;
                int worldY = worldRow * 512;

                g2.drawImage(tile, worldX, worldY, 512, 512, null);
                worldCol++;
            }
            worldCol = 0;
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
