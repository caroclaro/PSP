package cliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {

	public static void main(String[] args) {

    int port = 2012;
    String Host = "localhost";

    try (Socket cliente = new Socket(Host, port);
         DataOutputStream flujoSalida = new DataOutputStream(cliente.getOutputStream());
         DataInputStream flujoEntrada = new DataInputStream(cliente.getInputStream());
         Scanner sc = new Scanner(System.in)) {

        int intentos = 0;

         while(intentos<5) {
        	 System.out.print("Introduce un número: Intento nº :  "+ (intentos+1) + "   ");
     		int num = sc.nextInt();
    		flujoSalida.write(num);

            String serverResponse = flujoEntrada.readUTF();
            
            if (serverResponse.contains("Acertaste :D")) {
                break;
            }

            System.out.println(serverResponse);

            intentos++;
        }
        
        String serverResponseGanador = flujoEntrada.readUTF();
        System.out.println(serverResponseGanador);

    } catch (IOException e) {
        System.err.println("Error de conexión: " + e.getMessage());
    }
    



}
}
