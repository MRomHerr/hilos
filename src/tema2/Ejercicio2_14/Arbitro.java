package tema2.Ejercicio2_14;

import java.util.Random;

public class Arbitro {
    private final int numeroAdivinar;
    private int turno = 0;
    private final int totalJugadores;
    private boolean juegoTerminado = false;

    public Arbitro(int totalJugadores) {
        this.totalJugadores = totalJugadores;
        this.numeroAdivinar = new Random().nextInt(10) + 1; //numero entre 1 y 10
        System.out.println("Número a adivinar: " + numeroAdivinar);
    }

    public synchronized boolean comprobarJugada(int jugadorId, int numero) {
        if (juegoTerminado) return true;

        if (jugadorId == turno) {
            System.out.println("Jugador " + jugadorId + " juega: " + numero);

            if (numero == numeroAdivinar) {
                System.out.println("¡Jugador " + jugadorId + " ha acertado el número!");
                juegoTerminado = true;
            } else {
                turno = (turno + 1) % totalJugadores; //cambia al siguiente turno
            }
            notifyAll();
        } else {
            try {
                wait(); //espera su turno
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        return juegoTerminado;
    }

    public boolean isJuegoTerminado() {
        return juegoTerminado;
    }
}
