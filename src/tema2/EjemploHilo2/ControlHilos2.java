package tema2.EjemploHilo2;


public class ControlHilos2 extends Thread {
    private final Buffer buffer;
    private boolean ejecutar = true;
    private int iteraciones = 0;

    // Constructor que acepta un Buffer y un nombre para el hilo
    public ControlHilos2(Buffer buffer, String nombre) {
        super(nombre); // Llama al constructor de Thread con el nombre del hilo
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (ejecutar) {
            buffer.agregar(iteraciones);
            iteraciones++;
            if (iteraciones >= 5) {
                ejecutar = false;
            }
            try {
                Thread.sleep(500); // Simula el trabajo del hilo
            } catch (InterruptedException e) {
                System.out.println(getName() + " fue interrumpido.");
            }
        }
        System.out.println(getName() + " ha terminado su ejecución.");
    }
}
