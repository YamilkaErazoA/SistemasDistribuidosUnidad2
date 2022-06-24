package sistemasdistribuidoscodigos;

import java.rmi.Naming;
import java.io.InputStreamReader;
import java.util.Scanner;

/*
 *
 * @author yamilka
 */

public class ClienteRmi {
    public static void main(String[] args){
        try{
            InterfazRmi interfaz = (InterfazRmi)Naming.lookup("rmi://localhost/saludo");
            System.out.println("¿Cómo te llamas?"); 
            Scanner entrada = new Scanner(new InputStreamReader(System.in));
            System.out.println(interfaz.saludar(entrada.next()));
       }catch(Exception ex){}
    }
}
