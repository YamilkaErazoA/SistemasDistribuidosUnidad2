package sistemasdistribuidoscodigos;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author yamilka
 */

public class ImplementacionRmi extends UnicastRemoteObject implements InterfazRmi{
    public ImplementacionRmi() throws RemoteException{
        super();
    }
    
    public String saludar(String msj) throws RemoteException{
        return "Hola " + msj;
    } 
}
