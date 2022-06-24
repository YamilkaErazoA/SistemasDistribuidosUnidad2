import java.rmi.*;

public interface Interfaz extends Remote{
    public String retiro (Float dinero) throws RemoteException;
    public String deposito(Float dinero) throws RemoteException;
}
