package tema2.ejercicio2_12;

// Clase Cola que actúa como buffer compartido entre el productor y el consumidor
class Cola {
    private String mensaje;
    private boolean disponible = false; // Indica si hay un mensaje disponible en la cola

    // Método sincronizado para poner un mensaje en la cola
    public synchronized void put(String valor) {
        while (disponible) {
            try {
                wait(); // Espera si la cola está llena
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        mensaje = valor; // Coloca el mensaje en la cola
        disponible = true; // Marca la cola como llena
        notifyAll(); // Notifica al consumidor que hay un nuevo mensaje
    }

    // Método sincronizado para obtener un mensaje de la cola
    public synchronized String get() {
        while (!disponible) {
            try {
                wait(); // Espera si la cola está vacía
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        disponible = false; // Marca la cola como vacía
        notifyAll(); // Notifica al productor que la cola está vacía
        return mensaje; // Devuelve el mensaje
    }
}
