package Controller.Entity.Snake;

import java.io.Serializable;
import java.util.ArrayList;

public class SnakeHandler implements Serializable {

    private ArrayList<Snake> snakeArrayList;

    public SnakeHandler(){
        snakeArrayList = new ArrayList<>();
    }

    public void add(Snake snake){
        snakeArrayList.add(snake);
    }

    public ArrayList<Snake> getSnakeArrayList() {
        return snakeArrayList;
    }
}
