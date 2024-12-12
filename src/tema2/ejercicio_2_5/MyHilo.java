package tema2.ejercicio_2_5;

public class MyHilo extends Thread{
	private SolicitaSuspender suspender = new SolicitaSuspender();
	private int contador=0;
	private boolean stopHilo=false;
	
	public void pararHilo() {
		stopHilo=true;
	}
	
	//metodo que suspende el hilo
	public void suspende() {
		suspender.set(true);
	}
	
	//metodo que reanuda el hilo
	public void reanuda() {
		suspender.set(false);
	}
	
	public void run() {
		try {
			while(stopHilo==false) {
				contador++;
				System.out.println("Contador: " + contador);
				Thread.sleep(1000);
				suspender.esperandoParaReanudar(); //comprobacion
			}
		} catch (InterruptedException exception) {
			System.out.println("Contador final: " + valorContador());
		}
	}//run
	
	public int valorContador() {
		return contador;
	}
	
}//MyHilo
