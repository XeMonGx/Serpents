package Vue.Game;

import javax.swing.*;
import java.awt.*;

public class GameLauncher extends JFrame {

    private GamePanel gamePanel;

    public GameLauncher(){
        this.gamePanel = new GamePanel();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setTitle("Serpents");

        this.setLayout(new BorderLayout());
        this.add(gamePanel, BorderLayout.CENTER);
        this.setSize(600,400);
    }

}
