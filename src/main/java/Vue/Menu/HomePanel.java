package Vue.Menu;

import Vue.Game.GameLauncher;

import javax.swing.*;
import java.awt.*;

public class HomePanel extends JPanel{

    private int screenWidth = 1200;
    private int screenHeight = 800;

    public HomePanel(Home home){
        this.setBackground(Color.black);
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setLayout(new BorderLayout());
        this.setFocusable(true);

        JPanel center = new JPanel();
        JPanel left = new JPanel();
        JPanel right = new JPanel();
        JPanel up = new JPanel();
        JPanel down = new JPanel();

        left.setPreferredSize(new Dimension(400, 0));
        right.setPreferredSize(new Dimension(400, 0));
        up.setPreferredSize(new Dimension(0, 360));
        down.setPreferredSize(new Dimension(0, 360));

        JButton button = new JButton("Jouer");

        JTextArea textArea = new JTextArea();
        button.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        textArea.setLineWrap(true); // Enable line wrapping
        textArea.setWrapStyleWord(true); // Wrap at word boundaries


        center.setLayout(new GridLayout(2,1));
        center.add(textArea);
        center.add(button);


        this.add(center, BorderLayout.CENTER);
        this.add(left, BorderLayout.WEST);
        this.add(right, BorderLayout.EAST);
        this.add(up, BorderLayout.NORTH);
        this.add(down, BorderLayout.SOUTH);

        button.addActionListener(e -> {
            home.setVisible(false);
            new GameLauncher();
        });

    }
}
