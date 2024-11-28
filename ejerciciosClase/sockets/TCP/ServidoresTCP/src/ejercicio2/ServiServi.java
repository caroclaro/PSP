package ejercicio2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServiServi {

	
	public static void main(String[] args) {
		int port = 6007;
		
		System.out.println("INICIANDO SERVER");
		try (ServerSocket server = new ServerSocket(port);
				Socket client = server.accept();
				InputStream input = client.getInputStream();
				DataInputStream inputflow = new DataInputStream(input);
				OutputStream output = client.getOutputStream();
				DataOutputStream outFlow = new DataOutputStream(output)
				) {
			
			int numerito = inputflow.read();
			numerito = (int) Math.pow(numerito, 2);
			outFlow.write(numerito);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
