package programa2;

public class Hilo extends Thread {

Cuenta cuenta;
	
	public Hilo(Cuenta contador) {
		super();
		this.cuenta = contador;
	}


	public void transferenciar() {
		double sumatorio = cuenta.escribirFicheros();
		System.out.println("En este hilo: " +  getName() + " ha hecho transferencias por valor de: "+ sumatorio);
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		this.transferenciar();
	}
	
}
