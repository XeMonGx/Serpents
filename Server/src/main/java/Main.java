import Model.Server;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12345);
        Server server = new Server(serverSocket);
        server.startServer();
    }


}