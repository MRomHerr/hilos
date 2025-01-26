package servidores.ejercicio3_1;

import java.io.*;
import java.net.*;

public class Ejercicio3_1_Client {
    public static void main(String[] args) {
        String serverName = "localhost";
        int port = 6000;

        try (Socket socket = new Socket(serverName, port)) {
            int localPort = socket.getLocalPort();
            int remotePort = socket.getPort();
            InetAddress remoteAddress = socket.getInetAddress();

            System.out.println("Conectado al servidor.");
            System.out.println("Puerto local: " + localPort);
            System.out.println("Puerto remoto: " + remotePort);
            System.out.println("Dirección IP remota: " + remoteAddress.getHostAddress());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

