package servidores.ejercicio3_10;

import java.io.*;
import java.net.*;

public class Ejercicio3_10_Server {
    public static void main(String[] args) {
        int port = 6000;
        byte[] buffer = new byte[1024];

        try (DatagramSocket socket = new DatagramSocket(port)) {
            System.out.println("Servidor UDP listo para calcular cuadrado y cubo");

            while (true) {
                DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
                socket.receive(packet);
                ByteArrayInputStream byteStream = new ByteArrayInputStream(packet.getData(), 0, packet.getLength());
                ObjectInputStream in = new ObjectInputStream(byteStream);
                Numeros numeros = (Numeros) in.readObject();

                if (numeros.getNumero() <= 0) {
                    System.out.println("Número recibido <= 0. Finalizando servidor.");
                    break;
                }

                int numero = numeros.getNumero();
                numeros.setCuadrado((long) numero * numero);
                numeros.setCubo((long) numero * numero * numero);

                ByteArrayOutputStream byteOutStream = new ByteArrayOutputStream();
                ObjectOutputStream out = new ObjectOutputStream(byteOutStream);
                out.writeObject(numeros);

                byte[] sendData = byteOutStream.toByteArray();
                DatagramPacket sendPacket = new DatagramPacket(
                        sendData, sendData.length, packet.getAddress(), packet.getPort());
                socket.send(sendPacket);
                System.out.println("Procesado: número = " + numero + ", cuadrado = " + numeros.getCuadrado() + ", cubo = " + numeros.getCubo());
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

