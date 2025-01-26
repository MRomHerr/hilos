package servidores.ejercicio3_6;

/*
Crea un programa cliente usando sockets UDP que envíe el texto escrito desde la
entrada estándar al servidor. El servidor le devolverá la cadena en mayúsculas. El
proceso de entrada de datos finalizará cuando el cliente introduzca un asterisco. Crea un
programa servidor que reciba cadenas de caracteres, las muestre en pantalla y se las
envíe al emisor en mayúscula.
Establece un tiempo de espera de 5000 milisegundos con el método
setSoTimeout(4000) para hacer que el método receive() del programa cliente se
bloquee. Pasado ese tiempo controlar si no se reciben datos lanzando la excepción
InterruptedIOException, en cuyo caso se visualiza un mensaje indicando que el
paquete se ha perdido. Para probarlo ejecuta el programa cliente sin ejecutar el servidor.
Puedes ejecutar varios programas clientes a la vez.
 */
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Ejercicio3_6_Client {
    public static void main(String[] args) {
        String serverName = "localhost";
        int port = 6000;
        byte[] buffer = new byte[1024];

        try (DatagramSocket socket = new DatagramSocket()) {
            socket.setSoTimeout(5000);
            InetAddress address = InetAddress.getByName(serverName);
            Scanner scanner = new Scanner(System.in);

            System.out.println("Introduce cadenas de texto (introduce * para salir):");
            while (true) {
                String input = scanner.nextLine();
                DatagramPacket packet = new DatagramPacket(input.getBytes(), input.length(), address, port);
                socket.send(packet);

                if (input.equals("*")) {
                    break;
                }

                DatagramPacket responsePacket = new DatagramPacket(buffer, buffer.length);
                try {
                    socket.receive(responsePacket);
                    String response = new String(responsePacket.getData(), 0, responsePacket.getLength());
                    System.out.println("Respuesta del servidor: " + response);
                } catch (SocketTimeoutException e) {
                    System.out.println("El paquete se ha perdido.");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
