package Vue.Game;

import javax.swing.*;
import java.awt.*;

public class GameLauncher extends JFrame {


    public GameLauncher(String username){
        init(username);
    }

    private void init(String username){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setTitle("Serpents");

        GamePanel gamePanel = new GamePanel(username);
        this.add(gamePanel);

        this.pack();

        this.setLocationRelativeTo(null);
        this.setVisible(true);

        gamePanel.startGame();
    }

}
