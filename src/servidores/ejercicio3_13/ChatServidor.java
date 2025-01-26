package servidores.ejercicio3_13;

import java.io.*;
import java.net.*;

// Clase principal del servidor de chat TCP.
public class ChatServidor {
    public static void main(String[] args) {
        int port = 11223; // Puerto en el que el servidor escucha.

        // Inicializar el servidor en el puerto especificado.
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Servidor TCP escuchando en el puerto " + port);

            while (true) {
                // Esperar a que un cliente se conecte.
                Socket clientSocket = serverSocket.accept();
                System.out.println("Nuevo cliente conectado.");
                // Crear un nuevo hilo para manejar al cliente conectado.
                Thread clientThread = new Thread(new ManejadorCliente(clientSocket));
                clientThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

