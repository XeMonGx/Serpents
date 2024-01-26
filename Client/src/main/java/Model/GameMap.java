package Model;

import Model.Entity.Food.Food;
import Model.Entity.Snake.Snake;

import java.util.ArrayList;

public class GameMap {

    private final int width = 5120;
    private final int height = 5120;
    private ArrayList<Food> foodArrayList = new ArrayList<>();
    private ArrayList<Snake> snakeArrayList = new ArrayList<>();

    public GameMap() {

    }

    public void init() {
        this.foodArrayList.clear();
        this.snakeArrayList.clear();
    }

    public void update() {
        for (Snake snake : this.snakeArrayList) {
            snake.update();
        }
    }


    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public ArrayList<Food> getFoodArrayList() {
        return this.foodArrayList;
    }

    public ArrayList<Snake> getSnakeArrayList() {
        return this.snakeArrayList;
    }

}
