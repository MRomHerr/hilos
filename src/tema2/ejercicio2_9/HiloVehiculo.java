package tema2.ejercicio2_9;

// Clase HiloVehiculo que extiende Thread y simula el comportamiento de un vehículo
class HiloVehiculo extends Thread {
    private Vehiculo vehiculo;
    private Puente puente;

    // Constructor que recibe el vehículo y el puente
    public HiloVehiculo(Vehiculo vehiculo, Puente puente) {
        this.vehiculo = vehiculo;
        this.puente = puente;
    }

    // Método run() que ejecuta el hilo
    @Override
    public void run() {
        puente.cruzarPuente(vehiculo); // El vehículo intenta cruzar el puente
    }
}
