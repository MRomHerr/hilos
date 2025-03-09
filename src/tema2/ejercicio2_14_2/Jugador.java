package tema2.ejercicio2_14_2;

import java.util.Random;

// Clase Jugador que representa a un jugador que intenta adivinar el número
class Jugador extends Thread {
    private int idJugador;
    private Arbitro arbitro;

    // Constructor que recibe el ID del jugador y el árbitro
    public Jugador(int idJugador, Arbitro arbitro) {
        this.idJugador = idJugador;
        this.arbitro = arbitro;
    }

    // Método run() que ejecuta el hilo del jugador
    @Override
    public void run() {
        Random random = new Random();
        while (!arbitro.isJuegoTerminado()) {
            int numeroPropuesto = random.nextInt(10) + 1; // Número aleatorio entre 1 y 10
            if (arbitro.comprobarJugada(idJugador, numeroPropuesto)) {
                break; // Si el jugador adivina el número, termina el hilo
            }
            try {
                Thread.sleep(500); // Espera un poco antes de intentar de nuevo
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}