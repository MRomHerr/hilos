package tema2.ejercicio2_14_2;

// Clase principal que inicia el juego
public class Main {
    public static void main(String[] args) {
        int totalJugadores = 3; // Número total de jugadores
        Arbitro arbitro = new Arbitro(totalJugadores); // Crea el árbitro

        // Crea los jugadores
        Jugador jugador1 = new Jugador(1, arbitro);
        Jugador jugador2 = new Jugador(2, arbitro);
        Jugador jugador3 = new Jugador(3, arbitro);

        // Inicia los hilos de los jugadores
        jugador1.start();
        jugador2.start();
        jugador3.start();

        // Espera a que todos los jugadores terminen
        try {
            jugador1.join();
            jugador2.join();
            jugador3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("El juego ha terminado.");
    }
}