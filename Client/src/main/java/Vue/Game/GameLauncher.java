package Vue.Game;

import javax.swing.*;
import java.awt.*;

/**
 * La classe GameLauncher représente la fenêtre de lancement du jeu de serpents.
 */
public class GameLauncher extends JFrame {

    /**
     * Constructeur de la classe GameLauncher.
     *
     * @param username Le nom d'utilisateur du joueur.
     */
    public GameLauncher(String username) {
        init(username);
    }

    /**
     * Initialise la fenêtre de jeu.
     *
     * @param username Le nom d'utilisateur du joueur.
     */
    private void init(String username) {
        // Configuration de la fenêtre
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setTitle("Serpents");

        // Création du panneau de jeu
        GamePanel gamePanel = new GamePanel(username);
        this.add(gamePanel);

        // Ajustement de la taille de la fenêtre
        this.pack();

        // Centrage de la fenêtre sur l'écran
        this.setLocationRelativeTo(null);

        // Rend la fenêtre visible
        this.setVisible(true);

        // Démarre le jeu sur le panneau de jeu
        gamePanel.startGame();
    }
}
