package Vue.Game;

import Model.Entity.Snake.Variation.AISnake;
import Model.Entity.Snake.Snake;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 * La classe Counter est utilisée pour décrémenter un compteur pour les serpents de type AISnake.
 */
public class Counter extends Thread {
    private ArrayList<Snake> snakeArrayList;

    /**
     * Constructeur de la classe Counter.
     *
     * @param snakeArrayList La liste des serpents à surveiller.
     */
    public Counter(ArrayList<Snake> snakeArrayList) {
        super();
        this.snakeArrayList = snakeArrayList;
    }

    /**
     * Méthode exécutée lors du démarrage du thread.
     */
    @Override
    public void run() {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            /**
             * La méthode run est appelée périodiquement à intervalles réguliers.
             */
            public void run() {
                // Parcourir la liste des serpents
                for (Snake snake : snakeArrayList) {
                    // Vérifier si le serpent est une instance de AISnake
                    if (snake instanceof AISnake) {
                        // Convertir le serpent en AISnake
                        AISnake aiSnake = (AISnake) snake;
                        // Décrémenter le compteur
                        aiSnake.decreaserCompteur();
                    }
                }
            }
        };
        // Planifier la tâche à intervalles réguliers
        timer.scheduleAtFixedRate(task, 0, 1000);
    }
}
