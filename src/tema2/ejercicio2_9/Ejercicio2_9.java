package tema2.ejercicio2_9;

// Clase principal que simula el tráfico en el puente
public class Ejercicio2_9 {
    public static void main(String[] args) {
        // Capacidad máxima del puente (número de vehículos que pueden cruzarlo a la vez)
        int capacidadMaxima = 2;

        // Crear el puente con la capacidad máxima
        Puente puente = new Puente(capacidadMaxima);

        // Crear varios vehículos con tiempos de cruce aleatorios
        for (int i = 1; i <= 5; i++) {
            Vehiculo vehiculo = new Vehiculo(i, (int) (Math.random() * 5000)); // Tiempo de cruce aleatorio entre 0 y 5 segundos
            HiloVehiculo hilo = new HiloVehiculo(vehiculo, puente);
            hilo.start(); // Iniciar el hilo del vehículo
        }
    }
}
