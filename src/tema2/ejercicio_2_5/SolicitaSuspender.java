package tema2.ejercicio_2_5;

public class SolicitaSuspender {
	private boolean suspender;
	
	synchronized void set (boolean b) {
		suspender = b; //Cambio de estado sobre el objeto
		notifyAll();
	}
	public synchronized void esperandoParaReanudar() throws InterruptedException{
		while(suspender==true)
			wait(); //suspender el hilo hasta recibir notify() o notifyAll()
	}
	public boolean getSuspender() {
		return suspender;
	}
}
	