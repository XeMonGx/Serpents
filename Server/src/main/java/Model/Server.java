package Model;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * La classe Server représente un serveur qui accepte les connexions de clients.
 */
public class Server {

    private ServerSocket serverSocket;

    /**
     * Constructeur de la classe Server.
     *
     * @param serverSocket Le socket du serveur.
     */
    public Server(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    /**
     * Démarre le serveur, accepte les connexions des clients et crée des gestionnaires de clients.
     */
    public void startServer() {
        try {
            while (!serverSocket.isClosed()) {
                Socket socket = serverSocket.accept();
                System.out.println("Nouveau joueur connecté");
                ClientHandler clientHandler = new ClientHandler(socket);
                Thread thread = new Thread(clientHandler);
                thread.start();

                // Attendre la commande pour fermer le serveur
                waitForServerClosureCommand();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Attend la commande sur la console pour fermer le serveur.
     */
    private void waitForServerClosureCommand() {
        try (Scanner scanner = new Scanner(System.in)) {
            if (scanner.nextLine().equals("close")) {
                closeServerSocket();
            }
        }
    }

    /**
     * Ferme le socket du serveur.
     */
    public void closeServerSocket() {
        try {
            if (serverSocket != null && !serverSocket.isClosed()) {
                serverSocket.close();
                System.out.println("Le serveur est fermé.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
