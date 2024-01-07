package Vue.Game;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import Model.AISnake;
import Vue.Entity.Snake.SnakeGraphics;

public class Counter extends Thread {
    private ArrayList<SnakeGraphics> list_snake;

    public Counter(ArrayList<SnakeGraphics> list_snake) {
        super();
        this.list_snake = list_snake;
    }

    @Override
    public void run() {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            public void run() {
                for (SnakeGraphics snake : list_snake) {
                    if(snake.getSnake() instanceof AISnake){
                        AISnake aiSnake = (AISnake) snake.getSnake();
                        aiSnake.decreaserCompteur();
                    }
                }
            }
        };
        timer.scheduleAtFixedRate(task, 0, 1000);
    }
}
