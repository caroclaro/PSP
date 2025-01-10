package ejercicio2;


import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {


	    public static void main(String[] args) {
	        int port = 6001;


	        try (ServerSocket server = new ServerSocket(port)) {

	        	 while (true) {
	        		 Hilo hilo = new Hilo(server);
	        		 hilo.start();
	       }
	            
	        } catch (Exception e) {
	            System.err.println("Error al iniciar el servidor: " + e.getMessage());
	        }
	    }
	}
