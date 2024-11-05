package programa2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.*;

public class Programa2 {

	public static void main(String[] args) throws IOException {
		
//		Le preguntará al usuario el path del fichero, nombre del fichero y número de transferencias a generar, Le enviará los datos por stream al programa 1.
		Scanner sc = new Scanner (System.in);
		
		//File f1 = new File("C:\\Users\\Vespertino\\Desktop\\WS HILOS\\UT2_PRACTICA_MULTIHILO\\bin");
		File f1 = new File("G:\\segundo\\juli\\UT2_PRACTICA_MULTIHILO\\bin");
		ProcessBuilder pb1 = new ProcessBuilder("java", "programa1.Programa1");
		pb1.directory(f1);
		
		Process p = pb1.start();

//		Le preguntará al usuario el path del fichero, nombre del fichero y número de transferencias a generar
		System.out.println("Dime el nombre del fichero a generar");
		String nombre = sc.nextLine() + "\n";
		System.out.println("Dime la ruta donde lo guardo (acábalo en barra)");
		String ruta = sc.nextLine();
		String ruta2 = ruta + "\n";
		System.out.println("Dime el número de transferencias a generar");
		int num = sc.nextInt();
		
		OutputStream os = p.getOutputStream();
		os.write(nombre.getBytes());
		os.write(ruta2.getBytes());
		os.write((num + " \n").getBytes());
		os.flush();
		
	
		
//		Controlará la salida, distinguiendo un error del caso de que “no haya llegado fichero”
		int exitVal = -1;
		
		try {
			exitVal = p.waitFor();
		} catch (InterruptedException e) {
		}

		if (exitVal == -2) {
			System.out.println("Valor de Salida: " + exitVal);
			System.out.println("ERROR, no ha llegado el fichero de transferencia");
			sc.close();
			return;
		}
		else if (exitVal == 0){
			System.out.println("Valor de Salida: " + exitVal);
		}
		else {
			System.out.println("Valor de Salida: " + exitVal);
			System.out.println("ERROR al generar el fichero");
			sc.close();
			return;
		}
		
//		leer el fichero
		String ficheroCompleto = ruta2.trim() + nombre.trim();   //porque si solo ponia la ruta me decía que no existia
		ArrayList<String> transferencias = new ArrayList<>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(ficheroCompleto));){
			String leer;

			while ((leer = br.readLine()) != null) {
				transferencias.add(leer);
				// System.out.println(leer);  Para comprobar que los guarda bien
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
			
		
//		Se simulará un valor para el saldo de la cuenta. Este saldo debe ser un número aleatorio entre 2000 y 3000 (decimal con 2 decimales) y
//		se multiplicará por el número de transferencias9
		double saldo = (double) (Math.random() * 3000) + 1500;
		saldo = Math.round(saldo * 100.0) / 100.0;
		saldo = saldo * num;
		
		Cuenta cuenta = new Cuenta (saldo, ruta);
		
// 		Para separar los id de cuenta del gasto en dos arrays diferentes
		double ImporteTotal=0;
		ArrayList<Integer> ids = new ArrayList<>();
		ArrayList<Double> gastos = new ArrayList<>();
		for (String transferencia : transferencias) {
           String[] partes = transferencia.split(";");
            ids.add(Integer.parseInt(partes[0])); 
            double gasto = Double.parseDouble(partes[1]);
            gastos.add(gasto);
            ImporteTotal += gasto;
      }
		
	   
//		
		System.out.println("Importe total de transferencias = " + ImporteTotal);
		System.out.println("El saldo de la cuenta es: "+ saldo);
		
		cuenta.creaciónFicheros(); // necesario para que no se queden datos de anteriores ejecuciones
	
		
//		Habrá 3 hilos que procesarán el fichero en paralelo.
		Hilo hilo1 = new Hilo(cuenta);
		Hilo hilo2 = new Hilo(cuenta);
		Hilo hilo3 = new Hilo(cuenta);

		cuenta.dameRUTA(ficheroCompleto);
		cuenta.rellenarArray();
	
		hilo1.start();
		hilo2.start();
		hilo3.start();
		
		//para que no se imprima antes de que se acaben
		try {
            hilo1.join();
            hilo2.join();
            hilo3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Mostrar saldo final y cerrar los ficheros
        cuenta.seAcabo();
		cuenta.cerrarFicheros();
		os.close();
		sc.close();
}
	
}

//G:\segundo\juli\UT2_PRACTICA_MULTIHILO_PROGRAMA2\
