import java.rmi.*;

public class Servidor {

    public Servidor(){
        
        try{
            Interfaz proceso = new Implementacion();
            Naming.rebind("rmi://localhost/bancormi", proceso);
        }catch(Exception ex){
            System.out.println(ex);
        }
    
    }
    public static void main(String[] args) {
        new Servidor();
    }
}
