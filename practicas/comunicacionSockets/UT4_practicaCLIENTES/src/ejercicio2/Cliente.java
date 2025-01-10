package ejercicio2;



import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {


	    public static void main(String[] args) throws UnknownHostException, IOException {

	        int port = 6001;
	        String Host = "localhost";

	        try (Socket cliente = new Socket(Host, port);
	             DataOutputStream flujoSalida = new DataOutputStream(cliente.getOutputStream());
	             DataInputStream flujoEntrada = new DataInputStream(cliente.getInputStream());
	             Scanner sc = new Scanner(System.in)) {
	        	
	        	 String serverWelcome= flujoEntrada.readUTF();
		         System.out.println(serverWelcome);
		         System.out.println();

	            System.out.println("PIEDRA, PAPEL O TIJERA");
	            System.out.println("El que llegue primero a 3 gana");

	            int victorias = 0;
	            int victoriasAjenas=0;

	            while ((victorias < 3)&&(victoriasAjenas<3))  {
	            	 System.out.println("¿Cuál es tu elección? (piedra, papel, tijera):");
	                 String cuerda = sc.nextLine().toLowerCase();


	                 flujoSalida.writeUTF(cuerda);

	                 String serverResponse = flujoEntrada.readUTF();
	                 System.out.println(serverResponse);
	                 
	                if (serverResponse.contains("¡¡¡ Ganaste !!!")) {
	                    victorias++;
	                }
	                else   if (serverResponse.contains("Ganó la máquina.")) {
	                    victoriasAjenas++;
	                }

	            }
	            
	            String serverResponseGanador = flujoEntrada.readUTF();
	            System.out.println(serverResponseGanador);
	    }
	    }}

	    
	


