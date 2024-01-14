package Vue.Entity.Food;

import Controller.Camera;
import Controller.Entity.Food.Food;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class FoodsGraphics {

    private ArrayList<Food> foodArrayList;
    private Camera camera;

    public FoodsGraphics(ArrayList<Food> foodArrayList, Camera camera){
        this.foodArrayList = foodArrayList;
        this.camera = camera;
    }

    public void draw(Graphics2D g2){
        for (Food f : foodArrayList){
            g2.setColor(f.getColor());

            // Générer des positions aléatoires pour les cercles
            int worldX = f.getPos().x;
            int worldY = f.getPos().y;

            int screenX = worldX - camera.getWorldX() + camera.getScreenX();
            int screenY = worldY - camera.getWorldY() + camera.getScreenY();

            // Générer un rayon aléatoire pour les cercles
            int rayon = f.getSize();

            // Dessiner le cercle
            g2.fillOval(screenX, screenY, rayon, rayon);
        }
    }
}
