package ejercicio1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class cliente2 {


    public static void main(String[] args) throws UnknownHostException, IOException {
    	
    	System.out.println("BIENVENIDO ERES EL JUGADOR 2");

        int port = 6000;
        String Host = "localhost";

        try (Socket cliente = new Socket(Host, port);
             DataOutputStream flujoSalida = new DataOutputStream(cliente.getOutputStream());
             DataInputStream flujoEntrada = new DataInputStream(cliente.getInputStream());
             Scanner sc = new Scanner(System.in)) {

            System.out.println("PIEDRA, PAPEL O TIJERA");
            System.out.println("El que llegue primero a 3 gana");
            int victorias = 0;
            int victoriasAjenas=0;

            while ((victorias < 3)&&(victoriasAjenas<3)) {
            	 System.out.println("¿Cuál es tu elección? (piedra, papel, tijera):");
                 String cuerda = sc.nextLine().toLowerCase();


                 flujoSalida.writeUTF(cuerda);

                 String serverResponse = flujoEntrada.readUTF();
                 System.out.println(serverResponse);
                 
                if (serverResponse.contains("Ganó el jugador 2")) {
                    victorias++;
                }
                else   if (serverResponse.contains("Ganó el jugador 1")) {
                    victoriasAjenas++;
                }

            }
            
            String serverResponseGanador = flujoEntrada.readUTF();
            System.out.println(serverResponseGanador);

        } catch (IOException e) {
            System.err.println("Error de conexión: " + e.getMessage());
        }
        
    }

}
