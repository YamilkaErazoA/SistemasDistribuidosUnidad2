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
public class Servidor {

    private static ServerSocket server;
    private static int port = 5000;
    
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        server = new ServerSocket(port);
        while(true){
            System.out.println("Waiting for Client Request");
            Socket socket = server.accept();
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            String message = (String)ois.readObject();
            ois.close();
            socket.close();
            System.out.println("Finishing Request\n");
        }
    }
}
