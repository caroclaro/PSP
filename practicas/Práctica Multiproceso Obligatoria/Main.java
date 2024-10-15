import java.io.File;
import java.io.IOException;

public class Main {

	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		File f1 = new File("D:\\segundo\\juli\\UNIO\\PO_generarNum\\bin");
		ProcessBuilder pb1 = new ProcessBuilder("java", "generarNum.GenerarNum");

		pb1.directory(f1);
		String nombre= "impares.txt";
		File output = new File(nombre);
		pb1.redirectOutput(output);

		Process p = pb1.start();
		try {
			p.waitFor();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // pa que espere a que acabe de ejecutarse el primer proceso

		
		File f2 = new File("D:\\segundo\\juli\\UNIO\\PO_ordenarNum\\bin");
		ProcessBuilder pb2 = new ProcessBuilder("java", "ordenarNum.ordenarNum");
		pb2.directory(f2);
		File output2 = new File("orden.txt");
		pb2.redirectInput(output);
		pb2.redirectOutput(output2);

		Process p2 = pb2.start();
		try {
			p2.waitFor();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
