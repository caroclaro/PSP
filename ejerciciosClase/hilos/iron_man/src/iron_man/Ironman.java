package iron_man;

public class Ironman  extends Thread{

	String nombre;
	double vcorrer, vbici, vnadando;
	
	public Ironman(String nombre, double vcorrer, double vbici, double vnadando) {
		super();
		this.nombre = nombre;
		this.vcorrer = vcorrer;
		this.vbici = vbici;
		this.vnadando = vnadando;
	}

	public void bici () {
		int km = 180;
		double horas = km/vbici;
		System.out.println(nombre+ " empieza a biciclear.");
		try {
			Thread.sleep((long) horas * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(nombre+ " ha acabado de biciclear.");
	}
	
	public void marathon() {
		int km=42;
		double horas = km/vcorrer;
		System.out.println(nombre+ " empieza a correr.");
		try {
			Thread.sleep((long) horas * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(nombre+ " ha acabado de correr.");
	}
	
	public void nadar() {
		int m=4000;	
		double horas = m/vnadando;
		System.out.println(nombre+ " empieza a nadar.");
		try {
			Thread.sleep((long) horas * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(nombre+ " ha acabado de nadar.");
	}
	
	public void carrera (){
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(nombre + " comenzó el ironman");
		
		bici();
		marathon();
		nadar();
		
		System.out.println("¡¡¡ "+nombre + " terminó el ironman !!!");
	}
	
	public void run() {
		this.carrera();
	}
	
}
