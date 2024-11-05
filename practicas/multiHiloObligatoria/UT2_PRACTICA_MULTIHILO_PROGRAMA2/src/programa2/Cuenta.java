package programa2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Cuenta {
	
	double saldo;  //sincronizar y escrinir en ficheros
	String ruta;
	
	public Cuenta(double saldo, String ruta) {
		super();
		this.saldo = saldo;
		this.ruta = ruta;
	}
	
	ArrayList<String> transferencias = new ArrayList<>();
	int cont=0;
	String rutaOriginal;
	
	BufferedWriter externas;
	BufferedWriter internas;
	BufferedWriter sinSaldo;
	
	public void creaciónFicheros() {
		try {
			externas = new BufferedWriter( new FileWriter (ruta + "transferenciasExt.txt"));
			internas = new BufferedWriter( new FileWriter (ruta + "transferenciasInt.txt"));
			sinSaldo = new BufferedWriter( new FileWriter (ruta + "transferenciasSinSaldo.txt"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	//Como un contador que utilicen todos los hilos para que una vez una cuenta haya sido leido no la vuelva a leer otro
	public String obtenerTransferencia() {
        synchronized (this) {
            if (cont < transferencias.size()) {
                return transferencias.get(cont++);
            }
        }
        return null;
    }
	
	
	public void rellenarArray() {
		
		try (BufferedReader br = new BufferedReader(new FileReader(rutaOriginal));){
			String leer;

			while ((leer = br.readLine()) != null) {
				transferencias.add(leer);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public  double escribirFicheros() {
		//coge la transferencia que sea equivalente al contador
		String transferencia ;
		double totalTransferidoPorHilo = 0.0;
		
		while((transferencia = obtenerTransferencia()) != null){
		    String[] partes = transferencia.split(";");
		    int id = Integer.parseInt(partes[0]);
		    double gasto = Double.parseDouble(partes[1]);
		        
		    String id2 = String.valueOf(id); 
	        int primerNumero = Integer.parseInt(String.valueOf(id2.charAt(0)));  
	        double sumatorio=0;
	        
	        synchronized (this) {
	            if (saldo < gasto) {
	                System.out.println("No hay saldo para la siguiente transferencia de " + gasto);
	                try (FileWriter fw = new FileWriter(ruta + "transferenciasSinSaldo.txt", true)) {
	                    fw.write(id + ";" + gasto + "\n");
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	                continue;  // Si no hay pa que seguir 
	            }
				else{
					  saldo = saldo- gasto;
				}

	        }
	         if(primerNumero == 1) {
	        	System.out.println("Cuenta: " + id + " - Actualizamos el saldo de la cuenta con el importe: "+ gasto + " $");
	        	try {
	                Thread.sleep(1000); 
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	        	try (FileWriter fw = new FileWriter(ruta + "transferenciasInt.txt" , true);){
	    				fw.write(id+ ";" + gasto + "\n");

	    		} catch (IOException e) {
	    			// TODO Auto-generated catch block
	    			e.printStackTrace();
	    		}
		    System.out.println("Grabamos transferencia interna. Cuenta "+ id);
		    sumatorio = sumatorio + gasto;
		}
	        else if(primerNumero == 2) {
	        	System.out.println("Cuenta: " + id + " - Actualizamos el saldo de la cuenta con el importe: "+ gasto + " $");
	        	try (FileWriter fw = new FileWriter(ruta + "transferenciasExt.txt", true);){
	    				fw.write(id+ ";" + gasto + "\n");

	    		} catch (IOException e) {
	    			// TODO Auto-generated catch block
	    			e.printStackTrace();
	    		}
		    System.out.println("Grabamos transferencia externa. Cuenta "+ id);
		    sumatorio = sumatorio + gasto;
		}
	        
	        totalTransferidoPorHilo += sumatorio;
		}

		return totalTransferidoPorHilo;
	}
	

	public void seAcabo() {
		System.out.println("Quedan " + saldo + " en la cuenta");
		System.out.println("Fin del proceso");
	}
	
	// Para poder tener en esta cluse la ruta del fichero original
	public void dameRUTA (String ruta) {
		rutaOriginal = ruta;
	}
	
	public void cerrarFicheros() {
		try {
			if (internas != null) {
				internas.close();
			}
			if (externas != null) {
				externas.close();
			}
			if (sinSaldo != null) {
				sinSaldo.close();
			}
			
		}catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
}
