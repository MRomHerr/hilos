package tema2.ejercicio2_13;

// Clase Cola que actúa como buffer compartido entre el productor y los consumidores
class Cola {
    private char caracter;
    private boolean disponible = false; // Indica si hay un carácter disponible en la cola

    // Método sincronizado para poner un carácter en la cola
    public synchronized void put(char valor) {
        while (disponible) {
            try {
                wait(); // Espera si la cola está llena
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        caracter = valor; // Coloca el carácter en la cola
        disponible = true; // Marca la cola como llena
        notifyAll(); // Notifica a los consumidores que hay un nuevo carácter
    }

    // Método sincronizado para obtener un carácter de la cola
    public synchronized char get() {
        while (!disponible) {
            try {
                wait(); // Espera si la cola está vacía
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        disponible = false; // Marca la cola como vacía
        notifyAll(); // Notifica al productor que la cola está vacía
        return caracter; // Devuelve el carácter
    }

    // Método para indicar que el productor ha terminado
    public synchronized void finalizar() {
        disponible = true; // Marca la cola como llena para evitar que los consumidores esperen indefinidamente
        notifyAll(); // Notifica a todos los consumidores
    }
}
