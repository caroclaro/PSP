import java.util.concurrent.Semaphore;

public class playa {

	Semaphore miSemaforo;
	int numNaufragos;
	int cont = 0;
	
	int rescatePri, rescateDos, rescateTres;
	
	public playa(Semaphore miSemaforo) {
		super();
		this.miSemaforo = miSemaforo;
		this.numNaufragos = (int) ((Math.random()*200)+800);
	}


	@SuppressWarnings("finally")
	public boolean pasar(int id, int capacidad) {
		
		try {
			this.miSemaforo.acquire();
			System.out.println("La balsa actual es " + id + " y rescatamos a " + capacidad );
				Thread.sleep(1000);
				cont++;
				System.out.println(cont);
				Thread.sleep(1000);
				cont++;
				System.out.println(cont);
				Thread.sleep(1000);
				cont++;
				System.out.println(cont);
			
			restarNaufragos(id, capacidad);

		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if (numNaufragos > 0) {
                this.miSemaforo.release();
                return true; 
            } else {
                this.miSemaforo.release(); 
                return false; 
            }

		
	}
		
}
	
	public synchronized void restarNaufragos (int id, int capacidad) {
		if(numNaufragos > capacidad) {
		numNaufragos = numNaufragos -capacidad;
			if( id ==1) {
				rescatePri= rescatePri+capacidad; 
			}
			else if (id ==2) {
				rescateDos= rescateDos+capacidad;
			}
			else {
				rescateTres= rescateTres+capacidad;
			}
			}
		else {
			if( id ==1) {
				rescatePri= rescatePri+numNaufragos; 
			}
			else if (id ==2) {
				rescateDos= rescateDos+numNaufragos;
			}
			else {
				rescateTres= rescateTres+numNaufragos;
			}
			numNaufragos = 0;
			System.out.println();
			}
		System.out.println();
		System.out.println("Quedan "+ numNaufragos + " naufragos");
		

	}
	
	public int cuantosRescate(int id) {
		if( id ==1) {
			return rescatePri; 
		}
		else if (id ==2) {
			return rescateDos;
		}
		else {
			return rescateTres;
		}
	}
	
	public void termine() {
		System.out.println("contador parado en " + cont);
		System.out.println(" el rescate ha concluido ");
	}
}




