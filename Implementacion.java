import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;

public class Implementacion extends UnicastRemoteObject implements Interfaz{
    public Implementacion() throws RemoteException{
        super();
    }

    public String deposito(Float dinero) throws RemoteException{
        return "Su depósito es de " + dinero + "$";
    }

    public String retiro(Float dinero) throws RemoteException{
        return "Su retiro es de " + dinero + "$";
    }   
}