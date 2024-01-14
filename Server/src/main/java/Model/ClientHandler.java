package Model;

import Controller.Entity.Food.Food;
import Controller.Entity.Snake.Snake;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class ClientHandler implements Runnable{

    private static ArrayList<ClientHandler> clientHandlerArrayList = new ArrayList<>();
    private Socket socket;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    private Snake snake;
    private static ArrayList<Snake> snakeArrayList = new ArrayList<>();
    private static ArrayList<Food> foodArrayList = new ArrayList<>();

    public ClientHandler(Socket socket) {
        try {
            this.socket = socket;
            this.ois = new ObjectInputStream(socket.getInputStream());
            this.oos = new ObjectOutputStream(socket.getOutputStream());
            this.snake = (Snake) ois.readObject();
            snakeArrayList.add(snake);
            for (int i=0; i<1000; i++){
                foodArrayList.add(new Food());
            }
            clientHandlerArrayList.add(this);
        } catch (IOException | ClassNotFoundException e) {
            closeEverything(socket, ois, oos);
        }
    }

    @Override
    public void run() {
        while(socket.isConnected()){
            try {
                broadcast((Snake) ois.readObject());
            } catch (IOException | ClassNotFoundException e){
                closeEverything(socket, ois, oos);
            }
        }
    }

    public void broadcast(Snake snake){
        for (ClientHandler clientHandler : clientHandlerArrayList){
            try {
                if(clientHandler.snake.getUsername().equals(snake.getUsername())){
                    this.snake = snake;
                    clientHandler.oos.writeObject(snakeArrayList);
                    clientHandler.oos.flush();
                    clientHandler.oos.writeObject(foodArrayList);
                    clientHandler.oos.flush();
                }
            } catch (IOException e) {
                closeEverything(socket, ois, oos);
            }
        }
    }

    public void removeClientHandler(){
        clientHandlerArrayList.remove(this);
    }

    public void closeEverything(Socket socket, ObjectInputStream ois, ObjectOutputStream oos){
        removeClientHandler();
        try {
            if (socket == null) socket.close();
            if (ois == null) ois.close();
            if (oos == null) oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
