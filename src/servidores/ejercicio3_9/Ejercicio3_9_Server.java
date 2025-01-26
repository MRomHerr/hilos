package servidores.ejercicio3_9;

import java.io.*;
import java.net.*;

public class Ejercicio3_9_Server {
    public static void main(String[] args) {
        int port = 6000;
        byte[] buffer = new byte[1024];

        try (DatagramSocket socket = new DatagramSocket(port)) {
            System.out.println("Servidor UDP listo para recibir objetos Persona");

            while (true) {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);
                ByteArrayInputStream byteStream = new ByteArrayInputStream(packet.getData(), 0, packet.getLength());
                ObjectInputStream in = new ObjectInputStream(byteStream);
                Persona persona = (Persona) in.readObject();

                System.out.println("Recibido: " + persona);

                // Modificar datos de la Persona
                persona.setEdad(persona.getEdad() + 1);
                persona.setNombre(persona.getNombre() + " Modificado");

                System.out.println("Enviando: " + persona);
                ByteArrayOutputStream byteOutStream = new ByteArrayOutputStream();
                ObjectOutputStream out = new ObjectOutputStream(byteOutStream);
                out.writeObject(persona);

                byte[] sendData = byteOutStream.toByteArray();
                DatagramPacket sendPacket = new DatagramPacket(
                        sendData, sendData.length, packet.getAddress(), packet.getPort());
                socket.send(sendPacket);
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
