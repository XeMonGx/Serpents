package Vue.Game;

import Controller.Entity.Snake.Snake;
import Controller.KeyHandler;
import Controller.MouseMotionHandler;
import Model.AISnake;
import Vue.Background.BackgroundTile;
import Vue.Entity.Snake.Camera;
import Vue.Entity.Snake.Foods;
import Vue.Entity.Snake.SnakeGraphics;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GamePanel extends JPanel implements Runnable {

    private final int FPS = 60;
    private int screenWidth = 1200;
    private int screenHeight = 800;
    private Thread thread;
    private BackgroundTile backgroundTile;
    private ArrayList<SnakeGraphics> list_snake = new ArrayList<>();
    private SnakeGraphics player;
    private Camera camera;
    private MouseMotionHandler mouseMotionHandler = new MouseMotionHandler(this);
    private KeyHandler keyHandler = new KeyHandler();
    private Foods food = new Foods(this);
    private Counter counter;
    public GamePanel(){
        this.setBackground(Color.black);
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandler);
        this.addMouseMotionListener(mouseMotionHandler);
        this.setFocusable(true);

        this.backgroundTile = new BackgroundTile(this);
        this.player = new SnakeGraphics(new Snake(this));
        this.camera = new Camera(player.getSnake());
        this.list_snake.add(this.player);
        for (int i = 0; i < 5; i++) {
            this.list_snake.add(new SnakeGraphics(new AISnake(this)));
        }
        this.counter = new Counter(list_snake);
    }

    public void startGame(){
        this.thread = new Thread(this);
        thread.start();
        counter.start();
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
        for (SnakeGraphics snake : list_snake){
            snake.update();
        }
        camera.update();
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        backgroundTile.draw(g2);
        for (SnakeGraphics snake : list_snake){
            snake.draw(g2);
        }
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

    public ArrayList<SnakeGraphics> getList_snake() {
        return list_snake;
    }

    public Foods getFood() {
        return food;
    }

    public Camera getCamera() {
        return camera;
    }
}
