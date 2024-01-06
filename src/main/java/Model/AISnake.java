package Model;

import Controller.Entity.Snake.Snake;
import Controller.Entity.Snake.SnakeHead;
import Vue.Game.GamePanel;

import java.awt.*;
import java.util.Random;

public class AISnake extends Snake {

    private Point pos;

    public AISnake(GamePanel gamePanel) {
        super(gamePanel);
        this.pos = new Point();
        randomPoint();
    }

    @Override
    public void update(){
        Point tmp = new Point();
        for (int i=0;i<getSnake().size();i++){
            if(getSnake().get(i) instanceof SnakeHead){
                getSnake().get(i).copy(tmp);
                getSnake().get(i).move(pos);
                Random rand = new Random();
                if (rand.nextInt(100) == 1){
                    randomPoint();
                }
            }else{
                Point tmp2 = new Point();
                getSnake().get(i).copy(tmp2);
                getSnake().get(i).move(tmp);
                tmp = tmp2;
            }
        }
        dead();
        eatFood();
        grow(tmp);
    }

    private void randomPoint(){
        Random random = new Random();
        this.pos.x = random.nextInt(getGamePanel().getScreenWidth());
        this.pos.y = random.nextInt(getGamePanel().getScreenHeight());
    }

}
