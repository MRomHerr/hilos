package tema2.ejercicio2_6;

// Clase principal que crea y ejecuta los hilos
public class Ejercicio2_6 {
    public static void main(String[] args) {
        // Creamos dos objetos DescargaArchivo con nombres de archivos diferentes
        Runnable descarga1 = new DescargaArchivo("archivo1.txt");
        Runnable descarga2 = new DescargaArchivo("archivo2.txt");

        // Creamos dos hilos y les asignamos diferentes prioridades
        Thread hilo1 = new Thread(descarga1, "Hilo 1");
        Thread hilo2 = new Thread(descarga2, "Hilo 2");

        // Asignamos prioridades diferentes a los hilos
        hilo1.setPriority(Thread.MIN_PRIORITY); // Prioridad mínima (1)
        hilo2.setPriority(Thread.MAX_PRIORITY); // Prioridad máxima (10)

        // Iniciamos los hilos en diferentes órdenes
        hilo1.start(); // Iniciamos el hilo con prioridad mínima primero
        hilo2.start(); // Iniciamos el hilo con prioridad máxima después

        // Esperamos a que ambos hilos terminen
        try {
            hilo1.join();
            hilo2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Ambas descargas han finalizado.");
    }
}