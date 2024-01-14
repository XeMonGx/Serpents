package Model;

import Controller.Entity.Food.Food;
import Controller.Entity.Snake.Snake;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class Client {

    private Socket socket;
    private ObjectInputStream ois;
    private ObjectOutputStream oos;
    private Snake snake;
    private ArrayList<Snake> snakeArrayList;
    private ArrayList<Food> foodArrayList;

    public Client(Socket socket, Snake snake){
        try {
            this.socket = socket;
            this.ois = new ObjectInputStream(socket.getInputStream());
            this.oos = new ObjectOutputStream(socket.getOutputStream());
            this.snake = snake;
        } catch (IOException e) {
            closeEverything(socket, ois, oos);
        }
    }

    public void sendData(){
        try {
            oos.writeObject(snake);
            oos.flush();
        } catch (IOException e) {
            closeEverything(socket, ois, oos);
        }
    }

    public void receiveData(){
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (socket.isConnected()){
                    try {
                        snakeArrayList = (ArrayList<Snake>) ois.readObject();
                        foodArrayList = (ArrayList<Food>) ois.readObject();
                    } catch (IOException | ClassNotFoundException e) {
                        closeEverything(socket, ois, oos);
                    }
                }
            }
        });
    }


    public void closeEverything(Socket socket, ObjectInputStream ois, ObjectOutputStream oos){
        try {
            if (socket == null) socket.close();
            if (ois == null) ois.close();
            if (oos == null) oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Food> getFoodArrayList() {
        return foodArrayList;
    }

    public ArrayList<Snake> getSnakeArrayList() {
        return snakeArrayList;
    }
}
