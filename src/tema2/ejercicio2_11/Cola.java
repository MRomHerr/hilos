package tema2.ejercicio2_11;

// Clase Cola que actúa como buffer compartido entre el productor y los consumidores
class Cola {
    private int numero;
    private boolean disponible = false; // Indica si hay un número disponible en la cola

    // Método sincronizado para poner un número en la cola
    public synchronized void put(int valor) {
        while (disponible) {
            try {
                wait(); // Espera si la cola está llena
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        numero = valor; // Coloca el valor en la cola
        disponible = true; // Marca la cola como llena
        notifyAll(); // Notifica a los consumidores que hay un nuevo número
    }

    // Método sincronizado para obtener un número de la cola
    public synchronized int get() {
        while (!disponible) {
            try {
                wait(); // Espera si la cola está vacía
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        disponible = false; // Marca la cola como vacía
        notifyAll(); // Notifica a los productores que la cola está vacía
        return numero; // Devuelve el número
    }
}
