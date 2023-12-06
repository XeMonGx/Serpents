package Vue.Entity.Snake;

import Controller.Entity.Food.FoodGenerate;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Foods {

    private List<FoodGenerate> food;
    private int nb_food;

    public Foods(){
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
            int x = f.getPos().x;
            int y = f.getPos().y;

            // Générer un rayon aléatoire pour les cercles
            int rayon = f.getSize();

            // Dessiner le cercle
            g2.fillOval(x, y, rayon, rayon);
        }
    }

    public void addFood(int i){
        food.get(i).setPos();
    }

    public List<FoodGenerate> getFood() {
        return food;
    }
}
