import java.io.*;
import java.net.*;

public class Servidor{
    static String host = "230.0.0.30";
    static int port = 6000;

    public static void main(String args[])throws IOException, ClassNotFoundException{
        byte[] buffer = new byte[1024];
        MulticastSocket multicastSocket = new MulticastSocket(port);
        InetAddress address = InetAddress.getByName(host);
        multicastSocket.joinGroup(address);
        
        while(true){
            DatagramPacket messagePacket = new DatagramPacket(buffer, buffer.length);
            multicastSocket.receive(messagePacket);
            String message = new String(messagePacket.getData(), messagePacket.getOffset(), messagePacket.getLength());
            System.out.println("Mensaje recibido por el cliente - " + message);
        }
    }
}