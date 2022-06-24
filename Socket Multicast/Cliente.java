import java.io.*;
import java.net.*;

public class Cliente {
    static String host = "230.0.0.30";
    static int port = 6000;
    
    public static void main(String[] args)throws IOException, ClassNotFoundException, InterruptedException {
        
        int dato = 0;
        DatagramSocket socket = new DatagramSocket();
        InetAddress address = InetAddress.getByName(host);
        int id = 30801;
        System.out.println("==================");
        System.out.println("DISPOSITIVO: " + id);
        System.out.println("==================\n");
        while (true) {
            String enviado = "El dispositivo " + id + " ha enviado el número: " + dato;
            byte[] message = enviado.getBytes();
            DatagramPacket packet = new DatagramPacket(message, message.length, address, port);
            socket.send(packet);
            System.out.println("Número recibido: " + dato);
            dato++;
            Thread.sleep(500);
        }
        
    }
}
