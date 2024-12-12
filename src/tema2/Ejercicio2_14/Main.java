package tema2.Ejercicio2_14;

public class Main {
    public static void main(String[] args) {
        int totalJugadores = 3; //numero de jugadores
        Arbitro arbitro = new Arbitro(totalJugadores);

        Jugador[] jugadores = new Jugador[totalJugadores];

        //crear e iniciar los hilos de jugadores
        for (int i = 0; i < totalJugadores; i++) {
            jugadores[i] = new Jugador(i, arbitro);
            jugadores[i].start();
        }

        //esperar a que todos los jugadores terminen
        for (Jugador jugador : jugadores) {
            try {
                jugador.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        System.out.println("El juego ha terminado.");
    }
}
