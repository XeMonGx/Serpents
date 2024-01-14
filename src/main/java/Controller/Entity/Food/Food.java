package Controller.Entity.Food;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class Food implements Serializable {

    private Point pos;
    private int size;
    private Color color;

    public Food(){
        init();
    }
    public Food(Point position){
        init();
        this.pos = position;
    }

    private void init(){
        this.size = new Random().nextInt(15) + 5;
        int x = new Random().nextInt(2560);
        int y = new Random().nextInt(2560);
        if (new Random().nextInt(2) == 0){
            x = -x;
        }
        if (new Random().nextInt(2) == 0){
            y = -y;
        }
        this.pos = new Point(x, y);
        this.color = genererCouleurAleatoire();
    }

    private Color genererCouleurAleatoire() {
        Random random = new Random();
        return new Color(random.nextInt(256), random.nextInt(256), random.nextInt(256));
    }

    public void newPos(){
        pos.x = new Random().nextInt(2560);
        pos.y = new Random().nextInt(2560);
        if (new Random().nextInt(2) == 0){
            pos.x = -pos.x;
        }
        if (new Random().nextInt(2) == 0){
            pos.y = -pos.y;
        }
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
