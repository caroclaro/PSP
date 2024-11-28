 
public class barcas extends Thread {

	int capacidad;
	 public static int idauto = 0;
	 playa playita;
	int id;
	public static int jeje = 0;

	public barcas(playa playita) {
		super();
		idauto++;
		this.id = idauto;
		setCapacidad();
		this.playita = playita;

	}

	public int getCapacidad() {
		return capacidad;
	}

	public void setCapacidad() {
		if (id==1) {
		this.capacidad = (int) ((Math.random()*20)+20);
		}
		else if (id ==2) {
			this.capacidad = (int) ((Math.random()*20)+30);
		}else if (id ==3) {
			this.capacidad = (int) ((Math.random()*20)+40);
		}else{
			System.out.println("No hay más barcas");
		}
	
	
}
	boolean aunQuedan = true;

	public void run() {
		Thread.yield();
		System.out.println("la balsa actual es "+ id + " y tiene  " + capacidad + " plazas");
		System.out.println();
		while(aunQuedan) {
			try {
                Thread.sleep(100); // Por que si no entraban siempre las mismas dos
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
			if (!playita.pasar(this.id, capacidad)) {
                aunQuedan = false; 
            }
	}
		int num = playita.cuantosRescate(id);
		System.out.println();
		System.out.println("Ya no quedan naúfragos y la Balsa " + id + " está volviendo a su lugar. Ha rescatado  " + num + " naufragos en total");
	
		jeje++;
		if(jeje == 3) {  //no sabia como hacer que se ejecutase solo una vez si no, pq el awaitTermination no se usarlo
			playita.termine();
			
		}
		
	
	}}
