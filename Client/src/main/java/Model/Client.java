package Model;

import Controller.Entity.Food.Food;
import Controller.Entity.Snake.Snake;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

/**
 * La classe Client représente un client qui se connecte au serveur du jeu.
 * Elle gère la communication avec le serveur en envoyant et recevant des données sur le réseau.
 */
public class Client {

    private Socket socket; // La socket du client pour la communication avec le serveur.
    private ObjectInputStream ois; // Flux d'entrée pour la réception d'objets depuis le serveur.
    private ObjectOutputStream oos; // Flux de sortie pour l'envoi d'objets vers le serveur.
    private Snake snake; // Le serpent du client.
    private ArrayList<Snake> snakeArrayList; // Liste des serpents provenant du serveur.
    private ArrayList<Food> foodArrayList; // Liste des nourritures provenant du serveur.

    /**
     * Constructeur de la classe Client.
     *
     * @param socket La socket du client pour la communication avec le serveur.
     * @param snake  Le serpent du client.
     */
    public Client(Socket socket, Snake snake) {
        try {
            this.socket = socket;
            this.oos = new ObjectOutputStream(socket.getOutputStream());
            this.ois = new ObjectInputStream(socket.getInputStream());
            this.snake = snake;
        } catch (IOException e) {
            closeEverything(socket, ois, oos);
        }
    }

    /**
     * Envoie les données du serpent vers le serveur.
     */
    public void sendData() {
        try {
            oos.writeObject(snake);
            oos.flush();
        } catch (IOException e) {
            closeEverything(socket, ois, oos);
        }
    }

    /**
     * Reçoit les données des serpents et des nourritures provenant du serveur en continu.
     */
    @SuppressWarnings("unchecked")
    public void receiveData() {
        new Thread(() -> {
            while (socket.isConnected()) {
                try {
                    Object receivedObject = ois.readObject();

                    if (receivedObject instanceof ArrayList<?>) {
                        ArrayList<?> receivedList = (ArrayList<?>) receivedObject;

                        if (!receivedList.isEmpty()) {
                            Object firstElement = receivedList.get(0);

                            if (firstElement instanceof Snake) {
                                snakeArrayList = (ArrayList<Snake>) receivedList;
                            } else if (firstElement instanceof Food) {
                                foodArrayList = (ArrayList<Food>) receivedList;
                            }
                        }
                    }
                } catch (IOException | ClassNotFoundException e) {
                    closeEverything(socket, ois, oos);
                    break;
                }
            }
        }).start();
    }

    /**
     * Ferme toutes les ressources associées à la communication réseau.
     *
     * @param socket La socket du client.
     * @param ois    Flux d'entrée d'objets.
     * @param oos    Flux de sortie d'objets.
     */
    public void closeEverything(Socket socket, ObjectInputStream ois, ObjectOutputStream oos) {
        try {
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
            if (ois != null) {
                ois.close();
            }
            if (oos != null) {
                oos.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Renvoie la liste des nourritures provenant du serveur.
     *
     * @return Liste des nourritures.
     */
    public ArrayList<Food> getFoodArrayList() {
        return foodArrayList;
    }

    /**
     * Renvoie la liste des serpents provenant du serveur.
     *
     * @return Liste des serpents.
     */
    public ArrayList<Snake> getSnakeArrayList() {
        return snakeArrayList;
    }
}
