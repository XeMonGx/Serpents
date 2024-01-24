package Vue.Background;

import Controller.Camera;
import Vue.Game.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * La classe BackgroundTile représente une tuile d'arrière-plan dans le jeu.
 */
public class BackgroundTile {

    private BufferedImage tile; // L'image de la tuile d'arrière-plan.
    private final Camera camera; // La caméra utilisée pour suivre le déplacement dans le monde.

    /**
     * Constructeur de la classe BackgroundTile.
     *
     * @param camera La caméra utilisée pour suivre le déplacement dans le monde.
     */
    public BackgroundTile(Camera camera) {
        this.camera = camera;
        initValue();
    }

    /**
     * Initialise les valeurs, notamment l'image de la tuile d'arrière-plan.
     */
    public void initValue() {
        getBackgroundImage();
    }

    /**
     * Dessine la tuile d'arrière-plan sur le panneau de jeu.
     *
     * @param g2 Le contexte graphique 2D utilisé pour dessiner.
     */
    public void draw(Graphics2D g2) {
        for (int i = -6; i < 6; i++) {
            for (int j = -6; j < 6; j++) {
                int worldX = i * 512;
                int worldY = j * 512;

                int screenX = worldX - camera.getWorldX() + camera.getScreenX();
                int screenY = worldY - camera.getWorldY() + camera.getScreenY();

                // Dessiner la tuile d'arrière-plan avec les dimensions spécifiées.
                g2.drawImage(tile, screenX, screenY, 512, 512, null);
            }
        }
    }

    /**
     * Charge l'image de la tuile d'arrière-plan depuis un fichier.
     */
    private void getBackgroundImage() {
        try {
            // Charger l'image depuis le fichier resources/background.png.
            tile = ImageIO.read(getClass().getResourceAsStream("/background.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
