package servidores.ejercicio3_4;

import java.io.*;
import java.net.*;

public class Ejercicio3_4_Server {
    public static void main(String[] args) {
        int port = 6000;
        int maxClients = 3; // Cambiar este valor para ajustar el número de clientes

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Servidor listo para atender a " + maxClients + " clientes.");

            for (int i = 1; i <= maxClients; i++) {
                Socket clientSocket = serverSocket.accept();
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                String message = "Eres el cliente número " + i;
                out.println(message);
                System.out.println("Cliente " + i + " atendido.");

                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
