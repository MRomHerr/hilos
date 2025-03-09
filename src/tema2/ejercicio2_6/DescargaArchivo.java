package tema2.ejercicio2_6;

// Clase que implementa la interfaz Runnable para simular la descarga de un archivo
class DescargaArchivo implements Runnable {
    private String nombreArchivo;

    // Constructor que recibe el nombre del archivo
    public DescargaArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }

    // Método run() que simula la descarga del archivo
    @Override
    public void run() {
        System.out.println("Iniciando descarga de " + nombreArchivo + " en el hilo: " + Thread.currentThread().getName());

        // Simulamos el tiempo de descarga con Thread.sleep()
        try {
            Thread.sleep(5000); // 5 segundos de descarga
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Descarga de " + nombreArchivo + " completada en el hilo: " + Thread.currentThread().getName());
    }
}