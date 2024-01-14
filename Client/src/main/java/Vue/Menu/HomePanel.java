package Vue.Menu;

import Vue.Game.GameLauncher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class HomePanel extends JPanel{

    private int screenWidth = 1200;
    private int screenHeight = 800;
    private Home home;

    public HomePanel(Home home){
        this.home = home;
        init();
    }

    private void init(){
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

        center.setBackground(new Color(12,13,16));
        left.setBackground(new Color(12,13,16));
        right.setBackground(new Color(12,13,16));
        up.setBackground(new Color(12,13,16));
        down.setBackground(new Color(12,13,16));

        JLabel title = new JLabel("Slither.no");
        title.setFont(new Font("Arial", Font.PLAIN, 50));
        title.setForeground(Color.white);

        up.setLayout(new FlowLayout(FlowLayout.CENTER));
        up.add(title);

        JButton button = new JButton("Jouer");
        button.setBackground(Color.black);
        button.setForeground(Color.black);
        button.setOpaque(true);

        JTextArea textArea = new JTextArea("username");
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setAlignmentX(Component.CENTER_ALIGNMENT);
        textArea.setAlignmentY(Component.CENTER_ALIGNMENT);

        JPanel space = new JPanel();
        space.setBackground(new Color(12,13,16));

        center.setLayout(new GridLayout(3,1));
        center.add(textArea);
        center.add(space);
        center.add(button);


        this.add(center, BorderLayout.CENTER);
        this.add(left, BorderLayout.WEST);
        this.add(right, BorderLayout.EAST);
        this.add(up, BorderLayout.NORTH);
        this.add(down, BorderLayout.SOUTH);

        button.addActionListener(e -> {
            home.setVisible(false);
            new GameLauncher(textArea.getText());
        });

        textArea.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                textArea.setText("");
            }
        });
    }
}
