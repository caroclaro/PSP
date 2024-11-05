package relevos;

public class Corredor extends Thread {

	String pais, nombre;
	double velocidad;
	
	public Corredor(String pais, String nombre) {
		super();
		this.pais = pais;
		this.nombre = nombre;
		this.velocidad = (Math.random() * 100 + 950);
	}
	
	public void relevo() {
		 int distancia = 100; // 100 metros
	     double tarda = (distancia / 10) * velocidad; // Tiempo total en ms
		System.out.println(pais + ": " + nombre+ ", comienza su relevo.");
		try {
			Thread.sleep((long) tarda);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		System.out.println(pais + ": " + nombre+ ", ha acabado su relevo - Ha tardado: " + tarda/1000 + " segundos" );
	}
	
	public void run() {
		this.relevo();
	}
	
	
	
}


// ^-^    ^o^    ^3^   ^W^   ^~^    ^0^   ^·^  ^¬^   ^O^   ^.^    ^_^ 