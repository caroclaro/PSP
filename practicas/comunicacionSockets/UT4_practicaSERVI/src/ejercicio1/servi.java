 package ejercicio1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class servi {


    public static void main(String[] args) {
        int port = 6000;
        int gana2 = 0;
        int gana1 = 0; 

        try (ServerSocket server = new ServerSocket(port)) {

                try (
                    Socket client = server.accept(); 
                    InputStream input = client.getInputStream();
                    DataInputStream inputflow = new DataInputStream(input);
                    OutputStream output = client.getOutputStream();
                    DataOutputStream outFlow = new DataOutputStream(output);
                		
                		Socket client2 = server.accept(); 
                        InputStream input2 = client2.getInputStream();
                        DataInputStream inputflow2 = new DataInputStream(input2);
                        OutputStream output2 = client2.getOutputStream();
                        DataOutputStream outFlow2 = new DataOutputStream(output2)
                ) {
                	
                	while ((gana1 < 3) && (gana2 < 3)) {


                    String cliente1 = inputflow.readUTF();
                    String cliente2 = inputflow2.readUTF();
                    System.out.println("El jugador 2 eligió " + cliente2);
                    System.out.println("El jugador 1 eligió " + cliente1);

                    String resultado;
                    if ((cliente2.equals("tijera") && cliente1.equals("papel")) || 
                        (cliente2.equals("piedra") && cliente1.equals("tijera")) ||
                        (cliente2.equals("papel") && cliente1.equals("piedra"))) {
                        resultado = "¡Ganó el jugador 2!";
                        gana2++;
                    } else if ((cliente1.equals("tijera") && cliente2.equals("papel")) || 
                               (cliente1.equals("piedra") && cliente2.equals("tijera")) ||
                               (cliente1.equals("papel") && cliente2.equals("piedra"))) {
                        resultado = "¡Ganó el jugador 1!";
                        gana1++;
                    } else if (cliente1.equals(cliente2)) {
                        resultado = "Hubo un empate.";
                    } else {
                        resultado = "Alguno de vostros puso mal la opción así que nadie gana ";  
                    }

                    outFlow.writeUTF(resultado);
                    outFlow2.writeUTF(resultado);

                }
                	outFlow.writeUTF("SE ACABÓ: " + "JUgador 1: " + gana1 + " victorias" +" Jugador 2: " + gana2 + " victorias");
                	outFlow2.writeUTF("SE ACABÓ: " + "JUgador 1: " + gana1 + " victorias" +" Jugador 2: " + gana2 + " victorias");
                    } catch (Exception e) {
                    System.err.println("Error en la conexión con el cliente: " + e.getMessage());
                }
            
        } catch (Exception e) {
            System.err.println("Error al iniciar el servidor: " + e.getMessage());
        }
    }
}
