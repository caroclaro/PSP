package ejercicioPiedraPapelTijera;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {

    public static void main(String[] args) throws UnknownHostException, IOException {

        int jugadas = 0;
        int port = 6000;
        String Host = "localhost";

        try (Socket cliente = new Socket(Host, port);
             DataOutputStream flujoSalida = new DataOutputStream(cliente.getOutputStream());
             DataInputStream flujoEntrada = new DataInputStream(cliente.getInputStream());
             Scanner sc = new Scanner(System.in)) {

            System.out.println("PIEDRA, PAPEL O TIJERA");
            System.out.println("Tienes 5 intentos.");

            while (jugadas < 5) {
                System.out.println("¿Cuál es tu elección? (piedra, papel, tijera):");
                String cuerda = sc.nextLine().toLowerCase();


                flujoSalida.writeUTF(cuerda);

                String serverResponse = flujoEntrada.readUTF();
                System.out.println(serverResponse);

                jugadas++;
            }
            
            String serverResponse = flujoEntrada.readUTF();
            System.out.println(serverResponse);

        } catch (IOException e) {
            System.err.println("Error de conexión: " + e.getMessage());
        }
        
    }
}
