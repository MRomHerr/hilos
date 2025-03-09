package tema2.ejercicio2_14_2;

import java.util.Random;

// Clase Arbitro que controla el juego
class Arbitro {
    private int numeroAdivinar; // Número que los jugadores deben adivinar
    private int turno; // Turno del jugador actual
    private int totalJugadores; // Número total de jugadores
    private boolean juegoTerminado; // Indica si el juego ha terminado

    // Constructor que recibe el número total de jugadores
    public Arbitro(int totalJugadores) {
        this.totalJugadores = totalJugadores;
        this.turno = 1; // El primer jugador comienza
        this.juegoTerminado = false;
        this.numeroAdivinar = new Random().nextInt(10) + 1; // Número aleatorio entre 1 y 10
        System.out.println("El número a adivinar es: " + numeroAdivinar); // Para depuración
    }

    // Método sincronizado para comprobar la jugada de un jugador
    public synchronized boolean comprobarJugada(int idJugador, int numeroPropuesto) {
        // Verifica si es el turno del jugador y si el juego no ha terminado
        if (idJugador == turno && !juegoTerminado) {
            if (numeroPropuesto == numeroAdivinar) {
                juegoTerminado = true; // El juego termina si el número es correcto
                System.out.println("¡Jugador " + idJugador + " ha adivinado el número!");
                return true;
            } else {
                System.out.println("Jugador " + idJugador + " propuso: " + numeroPropuesto + " (Incorrecto)");
                turno = (turno % totalJugadores) + 1; // Pasa el turno al siguiente jugador
                return false;
            }
        }
        return false; // Si no es el turno del jugador, no hace nada
    }

    // Método para verificar si el juego ha terminado
    public synchronized boolean isJuegoTerminado() {
        return juegoTerminado;
    }
}
