package ejercicioPiedraPapelTijera;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class serviservi {

    public static void main(String[] args) {
        int port = 6000;
        int jugamientos = 0;
        int ganaORd = 0;
        int ganaPer = 0; 

        try (ServerSocket server = new ServerSocket(port)) {

                try (
                    Socket client = server.accept(); 
                    InputStream input = client.getInputStream();
                    DataInputStream inputflow = new DataInputStream(input);
                    OutputStream output = client.getOutputStream();
                    DataOutputStream outFlow = new DataOutputStream(output)
                ) {
                    while (jugamientos < 5) {
                    int num = (int) (Math.random() * 3) + 1;
                    String eleccion;
                    if (num == 1) {
                        eleccion = "tijera";
                    } else if (num == 2) {
                        eleccion = "piedra";
                    } else {
                        eleccion = "papel";
                    }

                    String clientData = inputflow.readUTF();
                    System.out.println("El servidor eligió " + eleccion);
                    System.out.println("El cliente eligió " + clientData);

                    String resultado;
                    if ((eleccion.equals("tijera") && clientData.equals("papel")) || 
                        (eleccion.equals("piedra") && clientData.equals("tijera")) ||
                        (eleccion.equals("papel") && clientData.equals("piedra"))) {
                        resultado = "Ganó la máquina.";
                        ganaORd++;
                    } else if ((clientData.equals("tijera") && eleccion.equals("papel")) || 
                               (clientData.equals("piedra") && eleccion.equals("tijera")) ||
                               (clientData.equals("papel") && eleccion.equals("piedra"))) {
                        resultado = "¡¡¡ Ganaste !!!";
                        ganaPer++;
                    } else if (clientData.equals(eleccion)) {
                        resultado = "Hubo un empate.";
                    } else {
                        resultado = "Perdiste por no elegir una opción válida para este juego >:( ";
                        ganaORd++;  
                    }

                    outFlow.writeUTF(resultado);

                    jugamientos++;
                }
                    outFlow.writeUTF("SE ACABÓ: " + "Cliente: " + ganaPer + " victorias" +" Servidor: " + ganaORd + " victorias");
                    } catch (Exception e) {
                    System.err.println("Error en la conexión con el cliente: " + e.getMessage());
                }
            
        } catch (Exception e) {
            System.err.println("Error al iniciar el servidor: " + e.getMessage());
        }
    }
}
