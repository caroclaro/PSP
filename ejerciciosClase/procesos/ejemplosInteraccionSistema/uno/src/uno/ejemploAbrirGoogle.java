package uno;

import java.io.File;
import java.io.IOException;

public class ejemploAbrirGoogle {

	static int retorno = -2;

	public static void main (String []args) throws IOException, InterruptedException{
	        
	    	ProcessBuilder pb = new ProcessBuilder("C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe\"", 
	    			"https://www.google.com/webhp?hl=es&sa=X&ved=0ahUKEwij14bU1s-IAxX6BdsEHZ42IrQQPAgI");
	    	//File directorio = new File("");
	    	//pb.directory();
	    	
	    	Process p = pb.start();
	    	
	    	retorno = p.waitFor();
	    	
	    	System.out.println("Llegamos aquí cuando la ejecución del proceso finaliza");
	    	System.out.println("La ejecución devuelve: " + retorno);
	    	
	    }

}
