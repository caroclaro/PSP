package padre;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.ArrayList;

public class Padre {

	public static void main(String[] args) throws IOException {

		ArrayList<Integer> numeros = new ArrayList<>();

		System.out.println("Pintando la salida del programa de la generación de impares");
		
		File f = new File("D:\\segundo\\juli\\UNIO\\PO_generarNum\\bin");
		ProcessBuilder pb = new ProcessBuilder("java", "generarNum.GenerarNum");
		pb.directory(f);
		Process p = pb.start();

		int exitVal = -1;

		try {
			exitVal = p.waitFor();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Valor de Salida programa 1: " + exitVal);
		System.out.println("Pintando la salida del programa de la generación de impares");

		if (exitVal == 0) {
			try (InputStream is = p.getInputStream();
					InputStreamReader isr = new InputStreamReader(is);
					BufferedReader br = new BufferedReader(isr)) {

				String leer;

				while ((leer = br.readLine()) != null) {
					numeros.add(Integer.parseInt(leer));
					System.out.println(leer);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		System.out.println("Fin de la salida del programa de generación de impares");

		System.out.println("Salida ordenada del segundo programa");
		File f2 = new File("D:\\segundo\\juli\\UNIO\\PO_ordenarNum\\bin");
		ProcessBuilder pb2 = new ProcessBuilder("java", "ordenarNum.ordenarNum");
		pb2.directory(f2);
		Process p2 = pb2.start();
		OutputStream os = p2.getOutputStream();

		for (int i = 0; i < numeros.size(); i++) {
			int num = numeros.get(i);
			os.write((num + "\n").getBytes());
			os.flush();

		}

		os.close();

		int exitVal2 = -1;

		try {
			exitVal2 = p2.waitFor();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("Valor de Salida programa 2: " + exitVal2);
		System.out.println("Salida ordenada del segundo programa");

		if (exitVal2 == 0) {
			try (InputStream is = p2.getInputStream();
					InputStreamReader isr = new InputStreamReader(is);
					BufferedReader br = new BufferedReader(isr)) {

				String leer;

				while ((leer = br.readLine()) != null) {
					System.out.println(leer);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		
		System.out.println("Fin ordenada del segundo programa");

	}
}

//Escribe un tercer programa Java que llama al primer programa, conecta la salida del primer
//programa con el del segundo programa y escribe en la salida los 10 números generados por
//el primer programa ordenados por el segundo programa.