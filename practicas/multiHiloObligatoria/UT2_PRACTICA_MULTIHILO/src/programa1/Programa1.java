package programa1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Programa1 {		

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
//		El programa generará un número aleatorio entre 0 y 100.
		int num = (int) (Math.random() *100);

//		Si el número generado es menor que 30, saldrá sin hacer nada acabando el
//		programa como erróneo.
		if(num<30) {
			System.exit(-2);
			return;
		}
		
//		Si el programa continúa, recogerá del stream de entrada el path del fichero,
//		el nombre del fichero y el número de transferencias a generar.
		String nombre, ruta;
		int cantidad;
		
		nombre= sc.nextLine();
		ruta = sc.nextLine();
		cantidad = sc.nextInt();
		
//		Por que aunque la ruta no existiese nunca salia error
		File directorio = new File(ruta);
		if (!directorio.exists() || !directorio.isDirectory()) {
			System.exit(-1); // Salir con código -1 si la ruta no es válida
		}
		
		File nombreFichero = new File(ruta, nombre);
		
		try (FileWriter fw = new FileWriter(nombreFichero);){
			for (int i = 0; i< cantidad; i++) {
				
//				Cuenta del empleado: será un número aleatorio de 9 cifras que
//				SIEMPRE debe empezar por 1 o por 2 (será aleatorio que empiece
//				por 1 o por 2)
				int inicioCuenta = (int) (Math.random() * 2) + 1;
				int restoCuenta = (int) (Math.random() * 99999999) + 10000000;
				String numCuenta = (inicioCuenta + ""+ restoCuenta);
				
//				Importe nómina: será un aleatorio entre 1.500 y 3.000, decimal con 2
//				 decimales.
				double nomina = (double) (Math.random() * 3000) + 1500;
				nomina = Math.round(nomina * 100.0) / 100.0;
				
				fw.write(numCuenta+ ";" + nomina + "\n");
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	

}
