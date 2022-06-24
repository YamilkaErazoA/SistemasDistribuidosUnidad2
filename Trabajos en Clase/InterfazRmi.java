package sistemasdistribuidoscodigos;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author yamilka
 */
public interface InterfazRmi extends Remote{
    public String saludar(String msj) throws RemoteException;
}
