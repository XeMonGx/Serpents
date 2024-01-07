package Model;

import Controller.Entity.Snake.Snake;
import Controller.Entity.Snake.SnakeHead;
import Vue.Game.GamePanel;

import java.awt.*;
import java.util.Random;

public class AISnake extends Snake {

    private Point pos;
    private AISnake_etat etat;
    private Snake ennemi;
    private int compteur = 0;

    public AISnake(GamePanel gamePanel) {
        super(gamePanel);
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
                getSnake().get(i).move(pos, new Point(getGamePanel().getCamera().getScreenX(), getGamePanel().getCamera().getScreenY()));
                Random rand = new Random();
                if (rand.nextInt(100) == 1){
                    randomPoint();

                getSnake().get(i).move(pos);
                if(getSnake().get(i).comparePoint(pos) || compteur <= 0){
                    this.etat = null;
                }else if(etat == AISnake_etat.CHASSE){
                    this.pos.x = this.ennemi.getSnake().get(0).getPosXforIA();
                    this.pos.y = this.ennemi.getSnake().get(0).getPosYforIA();
                }

            }else{
                Point tmp2 = new Point();
                getSnake().get(i).copy(tmp2);
                getSnake().get(i).move(tmp, new Point(getGamePanel().getCamera().getScreenX(), getGamePanel().getCamera().getScreenY()));
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
            //System.out.println(getSnake().get(0).getPosition().x + " " + getSnake().get(0).getPosition().y + " " + this.pos.x + " " + this.pos.y);

            Random random = new Random();
            int r = random.nextInt(this.getGamePanel().getFood().getFood().size());
            this.pos.x = this.getGamePanel().getFood().getFood().get(r).getPos().x;
            this.pos.y = this.getGamePanel().getFood().getFood().get(r).getPos().y;

        }else if(this.etat == AISnake_etat.CHASSE){
            Random random = new Random();
            int r = random.nextInt(this.getGamePanel().getList_snake().size());
            this.ennemi = this.getGamePanel().getList_snake().get(r).getSnake();
            while(this == ennemi){
                r = random.nextInt(this.getGamePanel().getList_snake().size());
                this.ennemi = this.getGamePanel().getList_snake().get(r).getSnake();
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
