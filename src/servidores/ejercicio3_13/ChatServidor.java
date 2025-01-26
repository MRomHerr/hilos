package servidores.ejercicio3_13;

import java.io.*;
import java.net.*;

public class ChatServidor {
    public static void main(String[] args) {
        int port = 11223;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Servidor TCP escuchando en el puerto " + port);

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Nuevo cliente conectado.");
                Thread clientThread = new Thread(new ManejadorCliente(clientSocket));
                clientThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

