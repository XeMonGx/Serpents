package Vue.Game;

import javax.swing.*;
import java.awt.*;

public class GameLauncher extends JFrame {

    private GamePanel gamePanel;

    public GameLauncher(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setResizable(false);
        this.setTitle("Serpents");

        this.gamePanel = new GamePanel();
        this.add(gamePanel);

        this.pack();

        this.setLocationRelativeTo(null);
        this.setVisible(true);

        this.gamePanel.startGame();
    }

}
