package tema2.ejercicio2_12;

// Clase Consumidor que obtiene las cadenas de la cola y las visualiza
class Consumidor extends Thread {
    private Cola cola;

    // Constructor que recibe la cola
    public Consumidor(Cola cola) {
        this.cola = cola;
    }

    // Método run() que obtiene y visualiza las cadenas de la cola
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) { // Consume 10 mensajes
            String valor = cola.get(); // Obtiene el mensaje de la cola
            System.out.print(valor + " "); // Visualiza el mensaje
        }
    }
}