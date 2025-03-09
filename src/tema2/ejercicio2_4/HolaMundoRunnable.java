package tema2.ejercicio2_4;

// Clase que implementa la interfaz Runnable
class HolaMundoRunnable implements Runnable {
    private String mensaje;
    private long idHilo;

    // Constructor que recibe una cadena
    public HolaMundoRunnable(String mensaje) {
        this.mensaje = mensaje;
    }

    // Método run() que se ejecuta cuando el hilo comienza
    @Override
    public void run() {
        // Obtenemos el ID del hilo actual
        idHilo = Thread.currentThread().getId();

        // Esperamos un tiempo proporcional al ID del hilo
        try {
            Thread.sleep(idHilo * 100); // Multiplicamos por 100 para hacer la espera más notable
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Mostramos el mensaje con el ID del hilo
        System.out.println("Hola mundo " + mensaje + " (ID del hilo: " + idHilo + ")");
    }
}