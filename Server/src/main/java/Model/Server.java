package Model;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    private ServerSocket serverSocket;

    public Server(ServerSocket serverSocket){
        this.serverSocket = serverSocket;
    }

    public void startServer(){
        try{
            while(!serverSocket.isClosed()){
                Socket socket = serverSocket.accept();
                System.out.println("new player is connected");
                ClientHandler clientHandler = new ClientHandler(socket);
                Thread thread = new Thread(clientHandler);
                thread.start();
                Scanner scanner = new Scanner(System.in);
                if(scanner.nextLine().equals("close")){
                    closeServerSocket();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void closeServerSocket(){
        try{
            if(serverSocket == null){
                serverSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
