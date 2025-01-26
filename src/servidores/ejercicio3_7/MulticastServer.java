package servidores.ejercicio3_7;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class MulticastServer {
    public static void main(String[] args) {
        int port = 5000; // Puerto para el grupo multicast
        String multicastGroup = "225.0.0.1"; // Dirección del grupo multicast

        try (MulticastSocket socket = new MulticastSocket()) {
            InetAddress group = InetAddress.getByName(multicastGroup);

            Scanner scanner = new Scanner(System.in);
            System.out.println("Servidor Multicast listo. Escriba mensajes para enviar:");

            while (true) {
                System.out.print("Mensaje: ");
                String message = scanner.nextLine();

                if (message.equalsIgnoreCase("salir")) {
                    break;
                }

                DatagramPacket packet = new DatagramPacket(
                        message.getBytes(),
                        message.length(),
                        group,
                        port
                );

                socket.send(packet);
                System.out.println("Mensaje enviado: " + message);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
