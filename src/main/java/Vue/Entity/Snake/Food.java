package Vue.Entity.Snake;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Food {

    private int nb_food;
    private List<Point> food;
    private final int nbImage = 10;
    private int size;

    public Food(int nb_food){
        this.nb_food = nb_food;
        this.food = new ArrayList<>();
        this.init();
    }

    public void init(){
        this.size = 15;
        for (int i=0;i<nb_food;i++){
            int x = new Random().nextInt(400);
            int y = new Random().nextInt(600);

            this.food.add(new Point(x, y));
        }
    }

    public void draw(Graphics2D g2){
        for (Point f : food) {
            Color couleur = Color.BLUE;
            g2.setColor(couleur);

            // Générer des positions aléatoires pour les cercles
            int x = f.x;
            int y = f.y;

            // Générer un rayon aléatoire pour les cercles
            int rayon = size;

            // Dessiner le cercle
            g2.fillOval(x, y, rayon, rayon);
        }
    }

}
