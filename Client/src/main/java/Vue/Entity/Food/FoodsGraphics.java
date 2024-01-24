package Vue.Entity.Food;

import Controller.Camera;
import Model.Entity.Food.Food;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * La classe FoodsGraphics est responsable du dessin de la nourriture sur l'écran.
 */
public class FoodsGraphics {

    private ArrayList<Food> foodArrayList; // La liste des nourritures à dessiner.
    private final Camera camera; // La caméra utilisée pour suivre le déplacement dans le monde.

    /**
     * Constructeur de la classe FoodsGraphics.
     *
     * @param foodArrayList La liste des objets Food à dessiner.
     * @param camera        La caméra utilisée pour suivre le déplacement dans le monde.
     */
    public FoodsGraphics(ArrayList<Food> foodArrayList, Camera camera) {
        this.foodArrayList = foodArrayList;
        this.camera = camera;
    }

    /**
     * Dessine les objets Food sur l'écran en utilisant le contexte graphique spécifié.
     *
     * @param g2 Le contexte graphique 2D utilisé pour dessiner.
     */
    public void draw(Graphics2D g2) {
        Iterator<Food> iterator = foodArrayList.iterator();
        while (iterator.hasNext()) {
            Food f = iterator.next();
            g2.setColor(f.getColor());

            // Générer des positions aléatoires pour les cercles
            int worldX = f.getPosition().x;
            int worldY = f.getPosition().y;

            int screenX = worldX - camera.getWorldX() + camera.getScreenX();
            int screenY = worldY - camera.getWorldY() + camera.getScreenY();

            // Générer un rayon aléatoire pour les cercles
            int rayon = f.getSize();

            // Dessiner le cercle
            g2.fillOval(screenX, screenY, rayon, rayon);
        }
    }
}
