import java.io.*;
import java.rmi.*;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {

        try {

            Interfaz interfaz = (Interfaz) Naming.lookup("rmi://localhost/bancormi");
            int ejecutar;
            System.out.println("=======================");
            System.out.println("TRANSACCIONES BANCARIAS");
            System.out.println("=======================");

            do {
                
                System.out.println("Ingrese el tipo de transación que desea realizar:");
                System.out.println("1. Depósito");
                System.out.println("2. Retiro");
                System.out.print("- Selección: ");
                Scanner trans = new Scanner(new InputStreamReader(System.in));
                int seleccion = trans.nextInt();

                if (seleccion == 1 || seleccion == 2){
                    if (seleccion == 1) {
                        System.out.println("---------------------------------------------");
                        System.out.print("Ingrese la cantidad que desea depositar: ");
                        Scanner dep = new Scanner(new InputStreamReader(System.in));
                        Float cantidad = dep.nextFloat();
                        System.out.println("---------------------------------------------");
                        System.out.println(interfaz.deposito(cantidad));
                        System.out.println("---------------------------------------------");
                    } else if (seleccion == 2) {
                        System.out.println("---------------------------------------------");
                        System.out.print("Ingrese la cantidad que desea retirar: ");
                        Scanner ret = new Scanner(new InputStreamReader(System.in));
                        Float cantidad = ret.nextFloat();
                        System.out.println("---------------------------------------------");
                        System.out.println(interfaz.retiro(cantidad));
                        System.out.println("---------------------------------------------");
                    } 
                } else {
                    System.out.println("---------------------------------------------");
                    System.out.println("Acción no valida");
                    System.out.println("---------------------------------------------");
                }

                System.out.print("\n~ ¿Desea continuar realizando transacciones (Sí = 3)?: ");
                Scanner scanner3 = new Scanner(new InputStreamReader(System.in));
                ejecutar = scanner3.nextInt();
                System.out.println("\n");

            } while (ejecutar == 3);

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}