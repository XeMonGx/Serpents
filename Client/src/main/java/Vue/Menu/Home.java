package Vue.Menu;

import Vue.Game.GameLauncher;
import Vue.Game.GamePanel;

import javax.swing.*;
import java.awt.*;

/**
 * La classe Home représente la fenêtre d'accueil de l'application.
 */
public class Home extends JFrame {

    // Le panneau d'accueil de l'application
    private HomePanel homePanel;

    /**
     * Constructeur de la classe Home.
     */
    public Home() {
        init(); // Initialisation de la fenêtre
    }

    /**
     * Initialise la fenêtre d'accueil.
     */
    private void init() {
        // Configuration de la fenêtre
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fermer l'application lorsque la fenêtre est fermée
        this.setResizable(false); // Empêcher le redimensionnement de la fenêtre
        this.setTitle("Serpents"); // Définir le titre de la fenêtre

        // Création du panneau d'accueil
        this.homePanel = new HomePanel(this);
        this.add(homePanel); // Ajout du panneau d'accueil à la fenêtre

        this.pack(); // Ajuster automatiquement la taille de la fenêtre en fonction du contenu

        this.setLocationRelativeTo(null); // Centrer la fenêtre sur l'écran
        this.setVisible(true); // Rendre la fenêtre visible
    }
}
