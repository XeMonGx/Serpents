import Model.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.Scanner;

import java.io.IOException;
import java.net.ServerSocket;

/**
 * La classe Main est la classe principale qui lance le serveur.
 */
public class Main {

    /**
     * Méthode principale qui initialise et lance le serveur.
     *
     * @param args Les arguments de la ligne de commande (non utilisés dans cet exemple).
     * @throws IOException Si une erreur d'entrée/sortie survient lors de la création du ServerSocket.
     */
    public static void main(String[] args) throws IOException {
        // Création d'un ServerSocket écoutant sur le port 12345
        ServerSocket serverSocket = new ServerSocket(12345);

        // Création de l'instance du serveur avec le ServerSocket créé
        Server server = new Server(serverSocket);

        // Démarrage du serveur
        server.startServer();
    }
}
