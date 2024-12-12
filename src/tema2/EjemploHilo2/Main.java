package tema2.EjemploHilo2;

public class Main {
    public static void main(String[] args) {
        Buffer buffer = new Buffer();

        // Crear e iniciar hilos
        ControlHilos2 hilo1 = new ControlHilos2(buffer, "Hilo-1");
        ControlHilos2 hilo2 = new ControlHilos2(buffer, "Hilo-2");

        hilo1.start();
        hilo2.start();

        // Esperar a que los hilos terminen
        try {
            hilo1.join();
            hilo2.join();
        } catch (InterruptedException e) {
            System.out.println("Hilo principal interrumpido.");
        }

        // Imprimir contenido del buffer después de que todos los hilos hayan terminado
        System.out.println("Todos los hilos han terminado.");
        buffer.imprimirBuffer();
    }
}
