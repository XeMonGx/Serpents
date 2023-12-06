package Controller.Entity.Food;

import java.awt.*;
import java.util.Random;

public class FoodGenerate {

    private Point pos;
    private int size;
    private Color color;

    public FoodGenerate(){
        init();
    }

    public void init(){
        this.size = new Random().nextInt(15) + 5;
        int x = new Random().nextInt(1200);
        int y = new Random().nextInt(800);
        this.pos = new Point(x, y);
        this.color = genererCouleurAleatoire();
    }

    private Color genererCouleurAleatoire() {
        Random random = new Random();
        return new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
    }

    public void setPos(){
        pos.x = new Random().nextInt(1200);
        pos.y = new Random().nextInt(800);
    }

    public Color getColor() {
        return color;
    }

    public int getSize() {
        return size;
    }

    public Point getPos() {
        return pos;
    }
}
