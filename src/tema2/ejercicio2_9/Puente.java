package tema2.ejercicio2_9;

import java.util.concurrent.Semaphore;

// Clase Puente que controla el acceso al puente usando un Semaphore
class Puente {
    private Semaphore semaforo;

    // Constructor que recibe la capacidad máxima del puente
    public Puente(int capacidadMaxima) {
        this.semaforo = new Semaphore(capacidadMaxima, true); // Semaphore con capacidad máxima
    }

    // Método para cruzar el puente
    public void cruzarPuente(Vehiculo vehiculo) {
        try {
            System.out.println("Vehículo " + vehiculo.getId() + " intentando cruzar el puente.");
            semaforo.acquire(); // Adquiere un permiso para cruzar el puente
            System.out.println("Vehículo " + vehiculo.getId() + " está cruzando el puente.");

            // Simula el tiempo de cruce
            Thread.sleep(vehiculo.getTiempoCruce());

            System.out.println("Vehículo " + vehiculo.getId() + " ha cruzado el puente.");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaforo.release(); // Libera el permiso después de cruzar
        }
    }
}