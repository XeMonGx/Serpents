package Vue.Game;

import Controller.KeyHandler;
import Controller.MouseMotionHandler;
import Vue.Background.BackgroundTile;
import Vue.Entity.Snake.Foods;
import Vue.Entity.Snake.SnakeGraphics;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable {

    private final int FPS = 60;
    private int screenWidth = 1200;
    private int screenHeight = 800;
    private Thread thread;
    private BackgroundTile backgroundTile;
    private SnakeGraphics snake;
    private MouseMotionHandler mouseMotionHandler = new MouseMotionHandler(this);
    private KeyHandler keyHandler = new KeyHandler();
    private Foods food = new Foods();

    public GamePanel(){
        this.setBackground(Color.black);
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandler);
        this.addMouseMotionListener(mouseMotionHandler);
        this.setFocusable(true);

        this.backgroundTile = new BackgroundTile(this);
        this.snake = new SnakeGraphics(this);
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

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        backgroundTile.draw(g2);
        snake.draw(g2);
        food.draw(g2);
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

    public KeyHandler getKeyHandler() {
        return keyHandler;
    }

    public SnakeGraphics getSnake() {
        return snake;
    }

    public Foods getFood() {
        return food;
    }
}
