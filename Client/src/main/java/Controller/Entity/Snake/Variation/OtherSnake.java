package Controller.Entity.Snake.Variation;

import Controller.Entity.Food.Food;
import Controller.Entity.Snake.Snake;
import Controller.MouseListenerHandler;
import Controller.MouseMotionHandler;

import java.io.Serializable;
import java.util.ArrayList;

public class OtherSnake extends Snake implements Serializable {
    public OtherSnake(String username, int screenX, int screenY, MouseListenerHandler mouseListenerHandler, MouseMotionHandler mouseMotionHandler, ArrayList<Food> foodArrayList, ArrayList<Snake> snakeArrayList) {
        super(username,screenX, screenY, mouseListenerHandler, mouseMotionHandler, foodArrayList, snakeArrayList);
    }
}
