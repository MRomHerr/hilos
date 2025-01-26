package servidores.ejercicio3_9;

/*
Usando sockets UDP realiza un programa servidor que espere un datagrama de un
cliente. El cliente le envía un objeto Persona que previamente había inicializado. El
servidor modifica los datos del objeto Persona y lo envía de vuelta al cliente.
Visualiza los datos del objeto Persona tanto en el programa cliente cuando los
envía y los recibe como en el programa servidor cuando los recibe y los envía
modificados.
 */
import java.io.*;
import java.net.*;

public class Ejercicio3_9_Client {
    public static void main(String[] args) {
        String serverName = "localhost";
        int port = 6000;

        try (DatagramSocket socket = new DatagramSocket()) {
            InetAddress address = InetAddress.getByName(serverName);

            Persona persona = new Persona("Juan", 30);
            System.out.println("Enviando: " + persona);

            ByteArrayOutputStream byteOutStream = new ByteArrayOutputStream();
            ObjectOutputStream out = new ObjectOutputStream(byteOutStream);
            out.writeObject(persona);

            byte[] sendData = byteOutStream.toByteArray();
            DatagramPacket packet = new DatagramPacket(sendData, sendData.length, address, port);
            socket.send(packet);

            byte[] buffer = new byte[1024];
            DatagramPacket responsePacket = new DatagramPacket(buffer, buffer.length);
            socket.receive(responsePacket);

            ByteArrayInputStream byteStream = new ByteArrayInputStream(responsePacket.getData(), 0, responsePacket.getLength());
            ObjectInputStream in = new ObjectInputStream(byteStream);
            Persona receivedPersona = (Persona) in.readObject();

            System.out.println("Recibido: " + receivedPersona);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

