package relevos;

public class Equipos  extends Thread {

	Corredor[] jugantes = new Corredor[4];
	String nombreEquipo;
	
	public Equipos(Corredor[] jugantes, String nombreEquipo) {
		super();
		this.jugantes = jugantes;
		this.nombreEquipo = nombreEquipo;
	}
	

	
	public void run() {
		for (Corredor c : jugantes) {
			try {
				c.start();
				c.join();
			}catch(InterruptedException e) {
				
			}
	}
		System.out.println("Fin de la carrera de "+ nombreEquipo);
	}




	
	
//	public void carrera(Equipos equipo1) throws InterruptedException {
//		equipo1.jugantes[0].start();
//		//equipo2.jugantes[0].start();
//
//		equipo1.jugantes[0].join();
//		equipo1.jugantes[1].start();
//		equipo1.jugantes[1].join();
//		equipo1.jugantes[2].start();
//		equipo1.jugantes[2].join();
//		equipo1.jugantes[3].start();
//		equipo1.jugantes[3].join();
//		System.out.println("FINAL DE PROGRAMA - " + equipo1.nombreEquipo);
//		
//		
//		equipo2.jugantes[0].join();
//		equipo2.jugantes[1].start();
//		equipo2.jugantes[1].join();
//		equipo2.jugantes[2].start();
//		equipo2.jugantes[2].join();
//		equipo2.jugantes[3].start();
//		equipo2.jugantes[3].join();
//		System.out.println("FINAL DE PROGRAMA - " + equipo2.nombreEquipo);
	}
	
