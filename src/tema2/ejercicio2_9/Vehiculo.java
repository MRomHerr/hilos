package tema2.ejercicio2_9;


// Clase Vehículo que representa un vehículo con un ID y un tiempo de cruce estimado
class Vehiculo {
    private int id;
    private int tiempoCruce; // Tiempo estimado para cruzar el puente

    // Constructor que recibe el ID y el tiempo de cruce
    public Vehiculo(int id, int tiempoCruce) {
        this.id = id;
        this.tiempoCruce = tiempoCruce;
    }

    // Método para obtener el ID del vehículo
    public int getId() {
        return id;
    }

    // Método para obtener el tiempo de cruce
    public int getTiempoCruce() {
        return tiempoCruce;
    }
}