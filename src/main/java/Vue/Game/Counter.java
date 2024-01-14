package Vue.Game;

import java.util.Timer;
import java.util.TimerTask;

import Controller.Entity.Snake.SnakeHandler;
import Controller.Entity.Snake.Variation.AISnake;
import Controller.Entity.Snake.Snake;

public class Counter extends Thread {
    private SnakeHandler snakeHandler;

    public Counter(SnakeHandler snakeHandler) {
        super();
        this.snakeHandler = snakeHandler;
    }

    @Override
    public void run() {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            public void run() {
                for (Snake snake : snakeHandler.getSnakeArrayList()) {
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
