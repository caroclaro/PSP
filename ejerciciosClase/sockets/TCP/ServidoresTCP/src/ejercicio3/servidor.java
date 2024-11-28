package ejercicio3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class servidor {

		
		public static void main(String[] args) {
			int port1 = 6007;
			int port2= 6006;
			
			System.out.println("INICIANDO SERVER");
			
			try (ServerSocket server = new ServerSocket(port1);
					Socket client = server.accept();
					InputStream input = client.getInputStream();
					DataInputStream inputflow = new DataInputStream(input);
					OutputStream output = client.getOutputStream();
					DataOutputStream outFlow = new DataOutputStream(output)
					) {
				   
				String clientData= inputflow.readUTF();
				clientData = clientData.toUpperCase();
				outFlow.writeUTF(clientData);
				
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			try (ServerSocket server = new ServerSocket(port2);
					Socket client = server.accept();
					InputStream input = client.getInputStream();
					DataInputStream inputflow = new DataInputStream(input);
					OutputStream output = client.getOutputStream();
					DataOutputStream outFlow = new DataOutputStream(output)
					) {
				
				String clientData= inputflow.readUTF();
				clientData = clientData.toLowerCase();
				outFlow.writeUTF(clientData);
				
			} catch (Exception e) {
				// TODO: handle exception
			}
		

	}
}
