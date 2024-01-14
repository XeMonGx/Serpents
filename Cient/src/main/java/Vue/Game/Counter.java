package Vue.Game;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import Controller.Entity.Snake.Variation.AISnake;
import Controller.Entity.Snake.Snake;

public class Counter extends Thread {
    private ArrayList<Snake> snakeArrayList;

    public Counter(ArrayList<Snake> snakeArrayList) {
        super();
        this.snakeArrayList = snakeArrayList;
    }

    @Override
    public void run() {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            public void run() {
                for (Snake snake : snakeArrayList) {
                    if(snake instanceof AISnake){
                        AISnake aiSnake = (AISnake) snake;
                        aiSnake.decreaserCompteur();
                    }
                }
            }
        };
        timer.scheduleAtFixedRate(task, 0, 1000);
    }
}
