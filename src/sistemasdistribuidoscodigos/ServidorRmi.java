package sistemasdistribuidoscodigos;

import java.lang.Exception;
import java.rmi.Naming;

/**
 *
 * @author yamilka
 */

public class ServidorRmi {
    public ServidorRmi(){
        try{
          InterfazRmi servidor = new ImplementacionRmi();
          Naming.rebind("rmi://localhost/saludo", servidor);
        }catch(Exception ex){  
        }
    }
    public static void main(String[] args){
        new ServidorRmi();
    }
}
