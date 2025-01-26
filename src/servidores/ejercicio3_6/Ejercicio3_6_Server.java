package servidores.ejercicio3_6;

import java.io.*;
import java.net.*;

public class Ejercicio3_6_Server {
    public static void main(String[] args) {
        int port = 6000;
        byte[] buffer = new byte[1024];

        try (DatagramSocket socket = new DatagramSocket(port)) {
            System.out.println("Servidor UDP listo para recibir cadenas");

            while (true) {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);
                String received = new String(packet.getData(), 0, packet.getLength());

                if (received.equals("*")) {
                    break;
                }
                System.out.println("Recibido: " + received);
                String response = received.toUpperCase();

                DatagramPacket responsePacket = new DatagramPacket(response.getBytes(), response.length(),
                        packet.getAddress(), packet.getPort());
                socket.send(responsePacket);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
