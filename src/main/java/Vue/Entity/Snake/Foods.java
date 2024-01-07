package Vue.Entity.Snake;

import Controller.Entity.Food.FoodGenerate;
import Vue.Game.GamePanel;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Foods {

    private List<FoodGenerate> food;
    private int nb_food;
    private GamePanel gamePanel;

    public Foods(GamePanel gamePanel){
        this.gamePanel = gamePanel;
        init();
    }

    public void init(){
        food = new ArrayList<>();
        nb_food = 50;
        for (int i=0;i<nb_food;i++){
            food.add(new FoodGenerate());
        }
    }

    public void draw(Graphics2D g2){
        for (FoodGenerate f : food){
            g2.setColor(f.getColor());

            // Générer des positions aléatoires pour les cercles
            int worldX = f.getPos().x;
            int worldY = f.getPos().y;

            int screenX = worldX - gamePanel.getCamera().getWorldX() + gamePanel.getCamera().getScreenX();
            int screenY = worldY - gamePanel.getCamera().getWorldY() + gamePanel.getCamera().getScreenY();
            if (screenX < 0) {
                screenX += 1280;
            } else if (screenX >= 1280) {
                screenX -= 1280;
            }
            if (screenY < 0) {
                screenY += 720;
            } else if (screenY >= 720) {
                screenY -= 720;
            }
            // Générer un rayon aléatoire pour les cercles
            int rayon = f.getSize();

            // Dessiner le cercle
            g2.fillOval(screenX, screenY, rayon, rayon);
        }
    }

    public void addFood(int i){
        food.get(i).setPos();
    }

    public List<FoodGenerate> getFood() {
        return food;
    }
}
