package servidores.ejercicio3_7;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class MulticastClient {
    public static void main(String[] args) {
        int port = 5000; // Puerto para el grupo multicast
        String multicastGroup = "225.0.0.1"; // Dirección del grupo multicast

        try (MulticastSocket socket = new MulticastSocket(port)) {
            InetAddress group = InetAddress.getByName(multicastGroup);
            socket.joinGroup(group);

            System.out.println("Cliente Multicast unido al grupo. Esperando mensajes...");

            byte[] buffer = new byte[1024];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            while (true) {
                socket.receive(packet);
                String message = new String(packet.getData(), 0, packet.getLength());

                if (message.equalsIgnoreCase("salir")) {
                    System.out.println("Servidor ha finalizado la sesión.");
                    break;
                }

                System.out.println("Mensaje recibido: " + message);
            }

            socket.leaveGroup(group);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

