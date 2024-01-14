package Vue.Menu;

import Vue.Game.GameLauncher;
import Vue.Game.GamePanel;

import javax.swing.*;
import java.awt.*;

public class Home extends JFrame {

    private HomePanel homePanel;
    public Home(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setTitle("Serpents");

        this.homePanel = new HomePanel(this);
        this.add(homePanel);

        this.pack();

        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

}
