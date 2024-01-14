package Vue.Entity.Snake;

import Controller.Entity.Food.FoodGenerate;
import Vue.Game.GamePanel;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Foods {

    private List<FoodGenerate> food;
    private final int nb_food;
    private GamePanel gamePanel;

    public Foods(GamePanel gamePanel){
        this.gamePanel = gamePanel;
        nb_food = 1000;
        init();
    }

    public void init(){
        food = new ArrayList<>();
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

            // Générer un rayon aléatoire pour les cercles
            int rayon = f.getSize();

            // Dessiner le cercle
            g2.fillOval(screenX, screenY, rayon, rayon);
        }
    }

    public void newFood(int i){
        food.get(i).newPos();
    }
    public void addFood(Point pos){
        food.add(new FoodGenerate(pos));
    }

    public List<FoodGenerate> getFood() {
        return food;
    }
}
