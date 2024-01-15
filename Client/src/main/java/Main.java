import Vue.Menu.Home;

public class Main {

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            // Utilisation de invokeLater pour assurer l'exécution sur l'Event Dispatch Thread (EDT)
            createAndShowGUI();
        });
    }

    private static void createAndShowGUI() {
        Home home = new Home();
        home.setVisible(true);
    }
}
