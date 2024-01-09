package Model.Online.Server;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    ServerSocket serverSocket;
    Socket client;
    OutputStream out;
    ObjectOutputStream oos;

    public Server(){
        try {
            serverSocket = new ServerSocket(9606);
            client = serverSocket.accept();
            out = client.getOutputStream();
            oos = new ObjectOutputStream(out);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
