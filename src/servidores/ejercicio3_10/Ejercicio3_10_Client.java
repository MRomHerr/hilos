package servidores.ejercicio3_10;

/*

Realiza el ejercicio 3.8 con sockets UDP
 */
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Ejercicio3_10_Client {
    public static void main(String[] args) {
        String serverName = "localhost";
        int port = 6000;

        try (DatagramSocket socket = new DatagramSocket()) {
            InetAddress address = InetAddress.getByName(serverName);
            Scanner scanner = new Scanner(System.in);

            while (true) {
                System.out.print("Introduce un número entero (<= 0 para salir): ");
                int numero = scanner.nextInt();

                Numeros numeros = new Numeros(numero);
                ByteArrayOutputStream byteOutStream = new ByteArrayOutputStream();
                ObjectOutputStream out = new ObjectOutputStream(byteOutStream);
                out.writeObject(numeros);

                byte[] sendData = byteOutStream.toByteArray();
                DatagramPacket packet = new DatagramPacket(sendData, sendData.length, address, port);
                socket.send(packet);

                if (numero <= 0) {
                    break;
                }

                byte[] buffer = new byte[1024];
                DatagramPacket responsePacket = new DatagramPacket(buffer, buffer.length);
                socket.receive(responsePacket);

                ByteArrayInputStream byteStream = new ByteArrayInputStream(responsePacket.getData(), 0, responsePacket.getLength());
                ObjectInputStream in = new ObjectInputStream(byteStream);
                Numeros receivedNumeros = (Numeros) in.readObject();

                System.out.println("Cuadrado: " + receivedNumeros.getCuadrado() + ", Cubo: " + receivedNumeros.getCubo());
            }
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
