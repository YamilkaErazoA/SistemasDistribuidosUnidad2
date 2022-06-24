package sistemasdistribuidoscodigos;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectInput;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author yamilka
 */
public class Cliente {
    
    private static String host = "127.0.0.1";
    private static int port = 5000;
    
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        for (int i = 0; i < 20; i++) {
            System.out.println("Iniciando el Socket para Comunicarnos");
            Socket socket = new Socket(host, port);
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject("Mi primera vez");
            socket.close();
        }   
    }
}
