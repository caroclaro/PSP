package ejercicio2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Hilo  extends Thread  {
	
	private static int contador = 0;
	private int numero;
	ServerSocket server;
	
	
	public Hilo(ServerSocket server) {
	    super();
		this.server = server;
	    setNumero(++contador);  
	}

	private void setNumero(int numero) {
	    this.numero = numero;
	}

	
	public void jugar(ServerSocket server) {     
        int ganaORd = 0;
        int ganaPer = 0; 
		try (
            Socket client = server.accept(); 
            InputStream input = client.getInputStream();
            DataInputStream inputflow = new DataInputStream(input);
            OutputStream output = client.getOutputStream();
            DataOutputStream outFlow = new DataOutputStream(output)
        ) {
			
			String bienvenida = "BIENVENIDO ERES EL JUGADOR " + contador;
			
			 outFlow.writeUTF(bienvenida);
		
        	while ((ganaORd < 3) && (ganaPer < 3)) {
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
                resultado = "Escribe bien >:( ";
               
            }

            outFlow.writeUTF(resultado);

        }
            outFlow.writeUTF("SE ACABÓ: " + "Cliente: " + ganaPer + " victorias" +" Servidor: " + ganaORd + " victorias");
            } catch (Exception e) {
            System.err.println("Error en la conexión con el cliente: " + e.getMessage());
        }



        
    }
	
	
	public void run() {
		this.jugar(server);
	}
	

}
