import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class salvacion {

	
public static void main(String[] args) {
	Semaphore Semaforo  = new Semaphore(2);
	ExecutorService ejecutador = Executors.newFixedThreadPool(3);
	playa playita = new playa(Semaforo);
	
	
	
	for(int i=0; i<3; i++ ) {
		  ejecutador.submit(new barcas(playita));
	}
	

}
}
