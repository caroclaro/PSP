package BOOm;

public class Artificiero extends Thread {

	public void cuentaAtras()  {
		System.out.println("El artificiero empieza a desactivar la bomba !!!!!");
		int num = (int) ((Math.random()*10500) +9500);
			try {
				Thread.sleep((long) num);

			} catch (InterruptedException e) {

				System.out.println("El artificiero ha muerto");
				return;
			}
			System.out.println("El artificiero ha desactivado la bomba");
		}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		this.cuentaAtras();
	}
}
