package Model.Online.Client;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.net.Socket;

public class Client {

    Socket client;
    InputStream in;
    ObjectInputStream ois;

    public Client(String ip){
        try {
            this.client = new Socket(ip, 9606);
            this.in = client.getInputStream();
            this.ois = new ObjectInputStream(in);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }



}
