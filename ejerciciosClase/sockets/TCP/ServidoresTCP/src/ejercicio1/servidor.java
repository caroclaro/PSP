package ejercicio1;

import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class servidor {

	public static void main(String[] args) {
		int port = 6006;
		
		System.out.println("INICIANDO SERVER ");
		try(ServerSocket server = new ServerSocket(port);
				Socket client = server.accept();
				InputStream input = client.getInputStream();
				DataInputStream inputflow = new DataInputStream(input);
				OutputStream output = client.getOutputStream();
				DataOutputStream outoutFlow = new DataOutputStream(output)
		){
			String clientData= inputflow.readUTF();
			clientData = clientData.toUpperCase();
			//System.out.println("Lo que me dice el cliente es " + clientData);
			outoutFlow.writeUTF(clientData);
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
}
