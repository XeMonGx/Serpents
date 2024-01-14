package Controller.Entity.Snake.Variation;

import Controller.Entity.Food.Food;
import Controller.Entity.Snake.Snake;
import Controller.Entity.Snake.SnakeHandler;
import Controller.Entity.Snake.SnakeHead;
import Controller.MouseListenerHandler;
import Controller.MouseMotionHandler;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class AISnake extends Snake implements Serializable {

    private Point pos;
    private AISnake_etat etat;
    private Snake ennemi;
    private int compteur = 0;

    public AISnake(String username, int screenX, int screenY, MouseListenerHandler mouseListenerHandler, MouseMotionHandler mouseMotionHandler, ArrayList<Food> foodArrayList, SnakeHandler snakeHandler) {
        super(username,screenX, screenY, mouseListenerHandler, mouseMotionHandler, foodArrayList, snakeHandler);
        this.pos = new Point();
        randomPoint();
    }

    @Override
    public void update(){
        Point tmp = new Point();
        if (this.etat == null || this.compteur <= 0) {
            getDecision();
            makeDecision();
        }
        for (int i=0;i<getSnake().size();i++){

            if(getSnake().get(i) instanceof SnakeHead){
                getSnake().get(i).copy(tmp);
                getSnake().get(i).move(pos, new Point(getScreenX(), getScreenY()));
                if(getSnake().get(i).comparePoint(pos) || compteur <= 0){
                    this.etat = null;
                }else if(etat == AISnake_etat.CHASSE){
                    this.pos.x = this.ennemi.getSnake().get(0).getPosXforIA();
                    this.pos.y = this.ennemi.getSnake().get(0).getPosYforIA();
                }
            }else{
                Point tmp2 = new Point();
                getSnake().get(i).copy(tmp2);
                getSnake().get(i).move(tmp, new Point(getScreenX(), getScreenY()));
                tmp = tmp2;
            }
        }
        dead();
        eatFood();
        grow(tmp);
    }

    private void randomPoint(){
        Random random = new Random();
        this.pos.x = random.nextInt(getScreenX());
        this.pos.y = random.nextInt(getScreenY());
    }

    private void getDecision(){
        Random random = new Random();
        int x = random.nextInt(100);
        if(x < 20){
            this.etat = AISnake_etat.FUIR;
        }else if(x > 80){
            this.etat = AISnake_etat.CHASSE;
        }else{
            this.etat = AISnake_etat.MANGER;
        }
        //this.etat = AISnake_etat.CHASSE;
        this.compteur = 10;
        //makeDecision();
    }

    private void makeDecision(){
        if(this.etat == AISnake_etat.MANGER){
            Random random = new Random();
            int r = random.nextInt(getFoodArrayList().size());
            this.pos.x = getFoodArrayList().get(r).getPos().x;
            this.pos.y = getFoodArrayList().get(r).getPos().y;

        }else if(this.etat == AISnake_etat.CHASSE){
            Random random = new Random();
            int r = random.nextInt(getSnakeHandler().getSnakeArrayList().size());
            this.ennemi = getSnakeHandler().getSnakeArrayList().get(r);
            while(this == ennemi){
                r = random.nextInt(getSnakeHandler().getSnakeArrayList().size());
                this.ennemi = getSnakeHandler().getSnakeArrayList().get(r);
            }
            this.pos.x = this.ennemi.getSnake().get(0).getPosXforIA();
            this.pos.y = this.ennemi.getSnake().get(0).getPosYforIA();
        }else{
            randomPoint();
        }
    }

    public void decreaserCompteur(){
        this.compteur--;
    }
}
