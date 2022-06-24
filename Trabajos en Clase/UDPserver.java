package sistemasdistribuidoscodigos;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.SocketException;

/**
 *
 * @author yamilka
 */
public class UDPserver {
    
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        
        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];
        DatagramSocket serverSocket = new DatagramSocket(9876);  
        while(true){
            System.out.println("SERVER ACTIVE");
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);
            String sentence = new String(receivePacket.getData());
            
            //Enviar Mensaje
            InetAddress IPAddress = receivePacket.getAddress();
            int port = receivePacket.getPort();
            
            String capitalizedSentene = sentence.toUpperCase();
            sendData = capitalizedSentene.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
            serverSocket.send(sendPacket);
            
            System.out.println(" - MESSAGE: " +sentence);
            System.out.println("SERVER OUT\n");
        }
    }
}
