package Vue.Entity.Food;

import Controller.Camera;
import Controller.Entity.Food.Food;

import java.awt.*;
import java.util.ArrayList;

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
        for (Food f : foodArrayList) {
            g2.setColor(f.getColor());

            // Convertir les coordonnées mondiales en coordonnées d'écran.
            int screenX = f.getPos().x - camera.getWorldX() + camera.getScreenX();
            int screenY = f.getPos().y - camera.getWorldY() + camera.getScreenY();

            // Dessiner le cercle représentant la nourriture.
            g2.fillOval(screenX, screenY, f.getSize(), f.getSize());
        }
    }
}
