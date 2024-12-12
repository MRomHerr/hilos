package tema2.EjemploHilo2;

import java.util.ArrayList;

public class Buffer {
    private final ArrayList<Integer> buffer = new ArrayList<>();
    private final int capacidad = 10; // capacidad máxima del buffer

    // metodo sincronizado para agregar un número al buffer
    public synchronized void agregar(int numero) {
        while (buffer.size() >= capacidad) {
            try {
                System.out.println("Buffer lleno. Esperando espacio...");
                wait(); // Espera hasta que haya espacio
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Hilo interrumpido mientras esperaba.");
            }
        }
        buffer.add(numero);
        System.out.println(Thread.currentThread().getName() + " agregó: " + numero);
        notifyAll(); //notifica a otros hilos que pueden continuar
    }

    // metodo sincronizado para eliminar un número del buffer
    public synchronized int eliminar() {
        while (buffer.isEmpty()) {
            try {
                System.out.println("Buffer vacío. Esperando elementos...");
                wait(); // Espera hasta que haya un elemento disponible
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("Hilo interrumpido mientras esperaba.");
            }
        }
        int numero = buffer.remove(0);
        System.out.println(Thread.currentThread().getName() + " eliminó: " + numero);
        notifyAll(); //notifica a otros hilos que pueden continuar
        return numero;
    }

    // Metodo para imprimir el contenido del buffer
    public synchronized void imprimirBuffer() {
        System.out.println("Contenido del buffer: " + buffer);
    }
}
