package servidor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class Servidor {

	public static void main(String[] args) {
		
	int port =2012;
	int intentos=0;
	
	System.out.println("Servidor Esperando Datagrama . . . . . . .:");
	
	int numSecreto = (int) (Math.random()*100);
	
	int ganador=0;

	try (ServerSocket server = new ServerSocket(port);
			Socket client = server.accept();
			InputStream input = client.getInputStream();
			DataInputStream inputflow = new DataInputStream(input);
			OutputStream output = client.getOutputStream();
			DataOutputStream outFlow = new DataOutputStream(output)
			) {
		while(intentos<5) {
		int numerito = inputflow.read();
		
		if(numerito<numSecreto) {
		outFlow.writeUTF("El numero secreto es mayor que el número escrito");
		}
		else if(numerito>numSecreto) {
			outFlow.writeUTF("El numero secreto es menor que el número escrito");
		}else {
			outFlow.writeUTF("Acertaste :D");
			ganador= 1;
			break;
		}
		
		intentos++;
		}
		
		if(ganador==0) {
			outFlow.writeUTF("Se acabaron los intentos. Perdiste, el número era "+ numSecreto);

		}else {
			outFlow.writeUTF("Acertaste :D");
		}
	} catch (Exception e) {
		// TODO: handle exception
	}}
}
