package sistemasdistribuidoscodigos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author yamilka
 */
public class UDPcliente {
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        DatagramSocket clientSocket = new DatagramSocket();
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        
        InetAddress IPAddress = InetAddress.getByName("127.0.0.1");
        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];
        
        System.out.print("ENVÍE UN DATO AL SERVIDOR: ");
        String sentence = inFromUser.readLine();
        sendData = sentence.getBytes();
        
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);  
        clientSocket.send(sendPacket);
        System.out.println("MESSAGE SENT");
        
        //Receive
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);  
        clientSocket.receive(receivePacket);
        String modifiedSentence = new String(receivePacket.getData());
        System.out.println(" - FROM SERVER: " +modifiedSentence);
        clientSocket.close();
        
        
    }
    
}
