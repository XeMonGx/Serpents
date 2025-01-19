package Vue.Menu;

import Vue.Game.GameLauncher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

/**
 * La classe HomePanel représente le panneau d'accueil de l'application.
 */
public class HomePanel extends JPanel {

    // Dimensions de l'écran
    private int screenWidth = 1200;
    private int screenHeight = 800;

    // Référence vers la fenêtre principale
    private Home home;

    /**
     * Constructeur de la classe HomePanel.
     *
     * @param home La référence vers la fenêtre principale.
     */
    public HomePanel(Home home) {
        this.home = home;
        init(); // Initialisation du panneau
    }

    /**
     * Initialise le panneau d'accueil.
     */
    private void init() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setLayout(new BorderLayout());
        this.setFocusable(true);

        // Création des panneaux pour chaque côté et le centre
        JPanel center = new JPanel();
        JPanel left = new JPanel();
        JPanel right = new JPanel();
        JPanel up = new JPanel();
        JPanel down = new JPanel();

        // Définition des dimensions des panneaux latéraux
        left.setPreferredSize(new Dimension(400, 0));
        right.setPreferredSize(new Dimension(400, 0));
        up.setPreferredSize(new Dimension(0, 360));
        down.setPreferredSize(new Dimension(0, 360));

        // Définition des couleurs de fond pour chaque panneau
        center.setBackground(new Color(12, 13, 16));
        left.setBackground(new Color(12, 13, 16));
        right.setBackground(new Color(12, 13, 16));
        up.setBackground(new Color(12, 13, 16));
        down.setBackground(new Color(12, 13, 16));

        // Création et configuration du titre
        JLabel title = new JLabel("Slither.no");
        title.setFont(new Font("Arial", Font.PLAIN, 50));
        title.setForeground(Color.white);

        // Configuration du panneau du haut (contenant le titre)
        up.setLayout(new FlowLayout(FlowLayout.CENTER));
        up.add(title);

        // Création du bouton "Jouer"
        JButton button = new JButton("Jouer");
        button.setBackground(Color.black);
        button.setForeground(Color.black);
        button.setOpaque(true);

        // Création de la zone de texte pour le nom d'utilisateur
        JTextArea textArea = new JTextArea("username");
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setAlignmentX(Component.CENTER_ALIGNMENT);
        textArea.setAlignmentY(Component.CENTER_ALIGNMENT);

        // Création d'un espace entre la zone de texte et le bouton
        JPanel space = new JPanel();
        space.setBackground(new Color(12, 13, 16));

        // Configuration du panneau central
        center.setLayout(new GridLayout(3, 1));
        center.add(textArea);
        center.add(space);
        center.add(button);

        // Ajout des panneaux au panneau principal avec des positions spécifiques
        this.add(center, BorderLayout.CENTER);
        this.add(left, BorderLayout.WEST);
        this.add(right, BorderLayout.EAST);
        this.add(up, BorderLayout.NORTH);
        this.add(down, BorderLayout.SOUTH);

        // Action à effectuer lors du clic sur le bouton "Jouer"
        button.addActionListener(e -> {
            home.setVisible(false);
            new GameLauncher(textArea.getText());
        });

        // Événement lorsqu'il y a le focus sur la zone de texte
        textArea.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                textArea.setText("");
            }
        });
    }
}
