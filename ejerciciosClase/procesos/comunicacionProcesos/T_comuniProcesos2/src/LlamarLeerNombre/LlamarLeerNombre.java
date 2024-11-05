package LlamarLeerNombre;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.*;

public class LlamarLeerNombre {
	public static void main(String[] args) throws IOException {
		
		System.out.println("ESCRIBE EL NOMBRE:");
		Scanner sc = new Scanner(System.in);
		String nombre = sc.nextLine();
		
		File directorio = new File("C:\\Users\\vespertino\\eclipse-workspace\\T_comuniProcesos1\\bin"); //ruta del archivo
		ProcessBuilder pb = new ProcessBuilder("java", "comunicacionProcesos.LeerNombre");     // paquete.proceso    el otro pq es donde está el proceso
		pb.directory(directorio);  //hace el proceso en el directorio
		Process p = pb.start();   //comienza el proyecto pb
		OutputStream os = p.getOutputStream();
		os.write(nombre.getBytes());
		os.close();

		int exitVal = -1;

		try {
			exitVal = p.waitFor();
			//System.out.println("VALOR DE SALIDA:" + exitVal);   //SE IMPRIME SI O SI, NO DEBERIA, TIENES QUE ARREGLARLO esto sucedería en el caso de que hubiese algún error
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (exitVal == 0) {  //por otro lado si está correctamente

			InputStream is = p.getInputStream();  //coge lo que manda el proceso p
			InputStreamReader isr = new InputStreamReader(is);   //lo lee
			BufferedReader br = new BufferedReader(isr);   //lo lee x2
			String salidaNombre = br.readLine();     //lo que lea lo pasa a string
			System.out.println(salidaNombre);        //y ya imprime el nombre

			is.close();
		}
		sc.close();
	}

}




