package Vue.Game;

import Controller.MouseMotionHandler;
import Vue.Entity.Snake.Snake;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class GamePanel extends JPanel implements Runnable {

    private final int FPS = 60;
    private int screenWidth = 1200;
    private int screenHeight = 800;
    private Thread thread;
    private Snake snake;
    private MouseMotionHandler mouseMotionHandler = new MouseMotionHandler();

    public GamePanel(){
        this.setBackground(Color.black);
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setDoubleBuffered(true);
        this.addMouseMotionListener(mouseMotionHandler);
        this.setFocusable(true);

        this.snake = new Snake(this);
    }

    public void startGame(){
        this.thread = new Thread(this);
        thread.start();
    }

    @Override
    public void run() {
        double drawInterval = 1000000000 / FPS;
        double delta = 0;
        long lastTime = System.nanoTime(); // Dernière Timer
        long currentTime; // Timer Actuelle

        while (thread != null) {

            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;

            lastTime = currentTime;

            if (delta >= 1) {
                update();
                repaint();
                delta--;
            }
        }
    }

    public void update(){
        snake.update();
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        snake.draw(g2);

        g2.dispose();
    }

    public int getScreenHeight() {
        return screenHeight;
    }

    public int getScreenWidth() {
        return screenWidth;
    }

    public MouseMotionHandler getMouseMotionHandler() {
        return mouseMotionHandler;
    }
}
