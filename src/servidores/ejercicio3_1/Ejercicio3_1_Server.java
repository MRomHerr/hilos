package servidores.ejercicio3_1;

import java.io.*;
import java.net.*;

public class Ejercicio3_1_Server {
    public static void main(String[] args) {
        int port = 6000;

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Servidor TCP escuchando en el puerto " + port);

            for (int i = 1; i <= 2; i++) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Cliente " + i + " conectado.");

                int localPort = clientSocket.getLocalPort();
                int remotePort = clientSocket.getPort();
                InetAddress remoteAddress = clientSocket.getInetAddress();

                System.out.println("Cliente " + i + " - Puerto local: " + localPort);
                System.out.println("Cliente " + i + " - Puerto remoto: " + remotePort);
                System.out.println("Cliente " + i + " - Dirección IP remota: " + remoteAddress.getHostAddress());

                clientSocket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
