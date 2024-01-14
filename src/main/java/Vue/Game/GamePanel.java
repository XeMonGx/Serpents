package Vue.Game;

import Controller.Entity.Food.Food;
import Controller.Entity.Snake.Snake;
import Controller.Entity.Snake.SnakeHandler;
import Controller.Entity.Snake.Variation.AISnake;
import Controller.Entity.Snake.Variation.PlayerSnake;
import Controller.KeyHandler;
import Controller.MouseListenerHandler;
import Controller.MouseMotionHandler;
import Vue.Background.BackgroundTile;
import Controller.Camera;
import Vue.Entity.Food.FoodsGraphics;
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

    private ArrayList<SnakeGraphics> snakeGraphicsArrayList = new ArrayList<>();
    private SnakeHandler snakeHandler = new SnakeHandler();
    private PlayerSnake playerSnake;
    private SnakeGraphics playerSnakeGraphics;
    private Camera camera;

    private ArrayList<Food> foodArrayList = new ArrayList<>();
    private FoodsGraphics foodsGraphics;

    private Counter counter;

    private MouseMotionHandler mouseMotionHandler = new MouseMotionHandler();
    private MouseListenerHandler mouseListenerHandler = new MouseListenerHandler();
    private KeyHandler keyHandler = new KeyHandler();

    public GamePanel(String username){
        init(username);
    }

    private void init(String username){
        this.setBackground(Color.WHITE);
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setDoubleBuffered(true);
        this.addKeyListener(keyHandler);
        this.addMouseMotionListener(mouseMotionHandler);
        this.addMouseListener(mouseListenerHandler);
        this.setFocusable(true);

        this.playerSnake = new PlayerSnake(username, screenWidth /2, screenHeight/2, mouseListenerHandler, mouseMotionHandler, foodArrayList, snakeHandler);
        this.camera = new Camera(playerSnake, screenWidth, screenHeight);
        this.backgroundTile = new BackgroundTile(camera);
        for (int i=0; i<1000; i++){
            foodArrayList.add(new Food());
        }
        foodsGraphics = new FoodsGraphics(foodArrayList, camera);

        this.snakeHandler.add(playerSnake);
        for (int i=0;i<20; i++){
            this.snakeHandler.add(new AISnake("", screenWidth /2, screenHeight/2, mouseListenerHandler, mouseMotionHandler, foodArrayList, snakeHandler));
        }
        this.playerSnakeGraphics = new SnakeGraphics(playerSnake, camera);
        this.snakeGraphicsArrayList.add(this.playerSnakeGraphics);
        for (Snake snake : snakeHandler.getSnakeArrayList()){
            snakeGraphicsArrayList.add(new SnakeGraphics(snake, camera));
        }
        this.counter = new Counter(snakeHandler);
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

    private void update(){
        for (SnakeGraphics snake : snakeGraphicsArrayList){
            snake.update();
        }
        playerSnake.update();
    }

    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        backgroundTile.draw(g2);
        foodsGraphics.draw(g2);
        for (SnakeGraphics snake : snakeGraphicsArrayList){
            snake.draw(g2);
        }
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

    public ArrayList<SnakeGraphics> getSnakeGraphicsArrayList() {
        return snakeGraphicsArrayList;
    }

    public FoodsGraphics getFoodsGraphics() {
        return foodsGraphics;
    }

    public Camera getCamera() {
        return camera;
    }

    public MouseListenerHandler getMouseListenerHandler() {
        return mouseListenerHandler;
    }
}
